package br.com.layonvsg.servico;

import java.io.File;
import java.text.MessageFormat;
import java.util.List;

import javax.ejb.Stateless;
import javax.enterprise.context.Dependent;
import javax.inject.Inject;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import br.com.layonvsg.modelo.extrator.negocios.NegocioConverter;
import br.com.layonvsg.modelo.extrator.negocios.NegociosXML;
import br.com.temasistemas.derivativos.modelo.negocio.Negocio;
import br.com.temasistemas.derivativos.modelo.repositorio.RepositorioNegocio;
import br.com.temasistemas.log.LogBuilder;
import br.com.temasistemas.log.Logger;

@Stateless( name = ServicoImportadorNegocio.NOME_EJB )
@Dependent
public class ServicoImportadorNegociosBean
	implements ServicoImportadorNegocio
{

	private final static Log LOG = LogFactory.getLog( ServicoImportadorNegociosBean.class );

	@Inject
	private Logger logger;

	@Inject
	private LogBuilder logBuilder;

	@Inject
	private RepositorioNegocio repositorioNegocio;

	@Override
	public void importarFrom(
		final File localizacao )
	{
		if ( localizacao != null )
		{
			try
			{
				String msg = "Iniciando a importa��o de neg�cios. Localiza��o: \'";
					msg.concat( localizacao.getCanonicalPath() ).concat( "\'." );
				getLogger().log(
					new br.com.temasistemas.log.Log( msg ) );

				msg = "Iniciando a Limpeza dos neg�cios.";
				getLogger().log(
					new br.com.temasistemas.log.Log( msg ) );

				getRepositorioNegocio().excluirTodos();

				msg = "Limpeza dos neg�cios efetuada.";
				getLogger().log(
					new br.com.temasistemas.log.Log( msg ) );

				if ( localizacao.isHidden() || !localizacao.isFile() )
				{
					msg = MessageFormat.format(
						"Importa��o n�o efetuada. Localiza��o: \' {0} \', � oculta ou n�o � um arquivo .xml v�lido.",
						localizacao );
					getLogger().log(
						new br.com.temasistemas.log.Log( msg ) );
					return;
				}

				if ( !localizacao.canRead() )
				{
					getLogger().log(
						new br.com.temasistemas.log.Log( MessageFormat.format(
							"N�o foi possivel ler a partir da localiza��o informada: \' {0} \'",
							localizacao ) ) );
					return;
				}

				final JAXBContext jaxbContext = JAXBContext.newInstance( NegociosXML.class );
				final NegociosXML negocios = ( NegociosXML ) jaxbContext.createUnmarshaller().unmarshal(
					localizacao );

				final List<Negocio> listaNegocios = NegocioConverter.convertFrom( negocios.getNegocios() );

				msg = "Iniciando a Persist�ncia dos neg�cios. Quantidade: " + ( listaNegocios != null ? listaNegocios.size() : 0 );
				getLogger().log(
					new br.com.temasistemas.log.Log( msg ) );

				for ( final Negocio negocio : listaNegocios )
				{
					getRepositorioNegocio().salvar(
						negocio );
				}

				getRepositorioNegocio().flush();
				msg = "Persist�ncia dos neg�cios efetuada.";
				getLogger().log(
					new br.com.temasistemas.log.Log( msg ) );

				msg =
					"Negocios Importados com sucesso! Localiza��o: \'"
						+ localizacao.getCanonicalPath().toString()
						+ "\'.";
				getLogger().log(
					new br.com.temasistemas.log.Log( msg ) );
			}
			catch ( final JAXBException e )
			{
				LOG.warn( "Houveram erros durante a convers�o de neg�cios ( .xml > java ). Detalhes no log da aplica��o." );
				getLogger().log(
					getLogBuilder().criarLog(
						e ) );
			}
			catch ( final Exception e )
			{
				LOG.error( "Houveram erros durante a importa��o de neg�cios. Detalhes no log da aplica��o." );
				getLogger().log(
					getLogBuilder().criarLog(
						e ) );
			}
		}
	}

	public Logger getLogger()
	{
		return logger;
	}

	public void setLogger(
		final Logger logger )
	{
		this.logger = logger;
	}

	public LogBuilder getLogBuilder()
	{
		return logBuilder;
	}

	public void setLogBuilder(
		final LogBuilder logBuilder )
	{
		this.logBuilder = logBuilder;
	}

	public RepositorioNegocio getRepositorioNegocio()
	{
		return repositorioNegocio;
	}

	public void setRepositorioNegocio(
		final RepositorioNegocio repositorioNegocio )
	{
		this.repositorioNegocio = repositorioNegocio;
	}

}

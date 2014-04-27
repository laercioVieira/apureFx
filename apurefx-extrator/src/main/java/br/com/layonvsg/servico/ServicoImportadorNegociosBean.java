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
				String msg = "Iniciando a importação de negócios. Localização: \'";
					msg.concat( localizacao.getCanonicalPath() ).concat( "\'." );
				getLogger().log(
					new br.com.temasistemas.log.Log( msg ) );

				msg = "Iniciando a Limpeza dos negócios.";
				getLogger().log(
					new br.com.temasistemas.log.Log( msg ) );

				getRepositorioNegocio().excluirTodos();

				msg = "Limpeza dos negócios efetuada.";
				getLogger().log(
					new br.com.temasistemas.log.Log( msg ) );

				if ( localizacao.isHidden() || !localizacao.isFile() )
				{
					msg = MessageFormat.format(
						"Importação não efetuada. Localização: \' {0} \', é oculta ou não é um arquivo .xml válido.",
						localizacao );
					getLogger().log(
						new br.com.temasistemas.log.Log( msg ) );
					return;
				}

				if ( !localizacao.canRead() )
				{
					getLogger().log(
						new br.com.temasistemas.log.Log( MessageFormat.format(
							"Não foi possivel ler a partir da localização informada: \' {0} \'",
							localizacao ) ) );
					return;
				}

				final JAXBContext jaxbContext = JAXBContext.newInstance( NegociosXML.class );
				final NegociosXML negocios = ( NegociosXML ) jaxbContext.createUnmarshaller().unmarshal(
					localizacao );

				final List<Negocio> listaNegocios = NegocioConverter.convertFrom( negocios.getNegocios() );

				msg = "Iniciando a Persistência dos negócios. Quantidade: " + ( listaNegocios != null ? listaNegocios.size() : 0 );
				getLogger().log(
					new br.com.temasistemas.log.Log( msg ) );

				for ( final Negocio negocio : listaNegocios )
				{
					getRepositorioNegocio().salvar(
						negocio );
				}

				getRepositorioNegocio().flush();
				msg = "Persistência dos negócios efetuada.";
				getLogger().log(
					new br.com.temasistemas.log.Log( msg ) );

				msg =
					"Negocios Importados com sucesso! Localização: \'"
						+ localizacao.getCanonicalPath().toString()
						+ "\'.";
				getLogger().log(
					new br.com.temasistemas.log.Log( msg ) );
			}
			catch ( final JAXBException e )
			{
				LOG.warn( "Houveram erros durante a conversão de negócios ( .xml > java ). Detalhes no log da aplicação." );
				getLogger().log(
					getLogBuilder().criarLog(
						e ) );
			}
			catch ( final Exception e )
			{
				LOG.error( "Houveram erros durante a importação de negócios. Detalhes no log da aplicação." );
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

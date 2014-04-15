package br.com.layonvsg.servico;

import java.io.File;
import java.io.IOException;
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
				if ( !localizacao.isHidden() && localizacao.isFile() )
				{
					LOG.info( "Iniciando a importa��o de neg�cios" );
					LOG.trace( "Iniciando a importa��o de neg�cios" );

					if ( localizacao.canRead() )
					{
						getLogger().log(
							new br.com.temasistemas.log.Log( MessageFormat.format(
								"N�o foi possivel ler a partir da localiza��o informada: [ {0} ]",
								localizacao ) ) );
						return;
					}

					final JAXBContext jaxbContext = JAXBContext.newInstance( NegociosXML.class );
					final NegociosXML negocios = ( NegociosXML ) jaxbContext.createUnmarshaller().unmarshal(
						localizacao );

					final List<Negocio> listaNegocios = NegocioConverter.convertFrom( negocios.getNegocios() );
					for ( final Negocio negocio : listaNegocios )
					{
						getRepositorioNegocio().salvar(
							negocio );
					}

					getRepositorioNegocio().flush();
					LOG.info( "Negocios Importados com sucesso!" );
					LOG.trace( "Localiza��o: " + localizacao.getCanonicalPath().toString() );
				}
			}
			catch ( final JAXBException e )
			{
				LOG.info( "Houveram erros durante a importa��o de neg�cios. Detalhes no log da aplica��o." );

				getLogger().log(
					getLogBuilder().criarLog(
						e ) );
			}
			catch ( final IOException e )
			{
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

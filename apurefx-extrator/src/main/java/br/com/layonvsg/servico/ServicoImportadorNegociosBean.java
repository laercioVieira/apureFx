package br.com.layonvsg.servico;

import java.io.File;
import java.io.IOException;

import javax.ejb.Stateless;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import br.com.layonvsg.modelo.extrator.negocios.NegocioXML;
import br.com.layonvsg.modelo.extrator.negocios.NegociosXML;
import br.com.temasistemas.log.LogBuilder;
import br.com.temasistemas.log.Logger;

@Stateless( name = ServicoImportadorNegocio.NOME_EJB )
@RequestScoped
public class ServicoImportadorNegociosBean
	implements ServicoImportadorNegocio
{

	@Inject
	private Logger logger;

	@Inject
	private LogBuilder logBuilder;

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
					
					final Log log =  LogFactory.getLog( ServicoImportadorNegociosBean.class );
					log.info( "Iniciando a importação de negócios" );
					log.trace( "Iniciando a importação de negócios" );
					
					final JAXBContext jaxbContext = JAXBContext.newInstance( NegociosXML.class );

					final NegociosXML negocios = ( NegociosXML ) jaxbContext.createUnmarshaller().unmarshal(
						localizacao );

					for ( final NegocioXML negocioXML2 : negocios.getNegocios() )
					{

					}

					System.out.println( "\n\nNegocios Importados com sucesso!." );
					System.out.println( "Localização: " + localizacao.getCanonicalPath().toString() );

				}
			}
			catch ( final JAXBException e )
			{
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

}

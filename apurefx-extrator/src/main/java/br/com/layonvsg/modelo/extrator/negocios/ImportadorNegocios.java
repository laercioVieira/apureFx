package br.com.layonvsg.modelo.extrator.negocios;

import java.io.File;
import java.io.IOException;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;

import br.com.temasistemas.derivativos.modelo.negocio.Negocio;

public class ImportadorNegocios
{

	private static final Long CODIGO_SDEFAULT = 1000L;
	private static final String LOCALIZACAO_NEGOCIOS_PADRAO =   "../\\apurefx-extrator\\src\\main\\resources\\negocios.xml";

	// private Log log;

	public static void main(
		final String[] args )
	{
		
		try
		{
			final JAXBContext jaxbContext = JAXBContext.newInstance( NegociosXML.class );

/*			final List<NegocioXML> lista = new ArrayList<NegocioXML>();
			NegocioXML negocioXML;
			final NegociosXML negociosXML = new NegociosXML();

			for ( int contador = 0; contador < 10; contador++ )
			{
				final double numGerado = Math.random() * 100 - contador;
				negocioXML = new NegocioXML();
				negocioXML.setClienteId(  CODIGO_SDEFAULT );
				negocioXML.setCorretoraId( CODIGO_SDEFAULT  );
				negocioXML.setInstituicaoId( CODIGO_SDEFAULT );
				negocioXML.setContratoId( new Long( ( long ) numGerado ) );
				negocioXML.setPreco( numGerado );
				negocioXML.setQuantidade( (int) numGerado );
				negocioXML.setId( contador+1 );
				negocioXML.setTarifacao( new TarifacaoXML( numGerado, contador, numGerado, contador ) );
				negocioXML.setMercado( Mercado.FUTURO );
				final Calendar calendar = Calendar.getInstance();
				calendar.set( 1900, Calendar.JANUARY, 01, 22, 05 );
				negocioXML.setHoraNegociacao( calendar.getTime() );
				negocioXML.setNaturezaNegociacao( NaturezaNegociacaoXML.COMPRA );
				lista.add( negocioXML );
			}
			
			negociosXML.setNegocios( lista );
			final File file = new File( LOCALIZACAO_NEGOCIOS_PADRAO );
			
			jaxbContext.createMarshaller().marshal(
				negociosXML,
				file );
			
			System.out.println( "Negocios gerados com sucesso!.");
			System.out.println( "Localização: " + file.getCanonicalPath().toString() );
			*/
			
			final File file = new File( LOCALIZACAO_NEGOCIOS_PADRAO );
			
			final NegociosXML negocios = ( NegociosXML ) jaxbContext.createUnmarshaller().unmarshal( file );

			for ( final NegocioXML negocioXML2 : negocios.getNegocios() )
			{
				System.out.println( negocioXML2 );		
			}
			System.out.println( "\n\nNegocios Importados com sucesso!.");
			System.out.println( "Localização: " + file.getCanonicalPath().toString() );
		
			
			for ( final Negocio n : NegocioConverter.convertFrom( negocios.getNegocios() ) )
			{
				System.out.println( n );
			}
		}
		catch ( final JAXBException e )
		{
			System.err.println( "Houve um erro durante a geração dos negócios" );
			e.printStackTrace();

		}
		catch ( final IOException e )
		{
			System.err.println( "Houve um erro de manipulação de arquivo durante a geração dos negócios" );
			e.printStackTrace();
		}

	}

}

package br.com.layonvsg.modelo.extrator.negocios;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.enterprise.context.Dependent;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;

import br.com.temasistemas.derivativos.infra.dao.JpaNegocioDao;
import br.com.temasistemas.derivativos.modelo.negocio.Negocio;
import br.com.temasistemas.derivativos.modelo.repositorio.RepositorioNegocio;

@Dependent
public class ImportadorNegocios
{

	private static final Long CODIGO_SDEFAULT = 1000L;

	private static final String LOCALIZACAO_NEGOCIOS_PADRAO =
		"../\\apurefx-extrator\\src\\main\\resources\\negociosFromBD.xml";

	private static RepositorioNegocio repositorioNegocio;

	public ImportadorNegocios()
	{
		super();
		repositorioNegocio = new JpaNegocioDao() ;
	}

	public static void main(
		final String[] args )
	{

		try
		{
			
			final JAXBContext jaxbContext = JAXBContext.newInstance( NegociosXML.class );
			 
//			   final List<NegocioXML> lista = new ArrayList<NegocioXML>(); NegocioXML negocioXML;
//			   final NegociosXML negociosXML = new NegociosXML(); 
//			   for ( int contador = 0; contador < 10; contador++ )
//			   {
//				   final double numGerado = Math.random()   100 - contador;
//			   		negocioXML = new NegocioXML(); 
//			   		negocioXML.setClienteId( CODIGO_SDEFAULT );
//			   		negocioXML.setCorretoraId( CODIGO_SDEFAULT ); 
//			   		negocioXML.setInstituicaoId( CODIGO_SDEFAULT ); 
//			   		negocioXML.setContratoId( new Long( ( long ) numGerado ) );
//			   		negocioXML.setPreco( numGerado );
//			   		negocioXML.setQuantidade( (int) numGerado );
//			   
//			   		negocioXML.setId( contador+1 );
//			   		negocioXML.setTarifacao( new TarifacaoXML( numGerado,
//			   		contador, numGerado, contador ) );
//			   		negocioXML.setMercado( Mercado.FUTURO ); 
//			   		final Calendar calendar = Calendar.getInstance(); 
//			   		calendar.set( 1900, Calendar.JANUARY, 01, 22, 05 );
//			   		negocioXML.setHoraNegociacao( calendar.getTime() );
//			   		negocioXML.setNaturezaNegociacao( NaturezaNegociacaoXML.COMPRA ); 
//			   		lista.add( negocioXML ); 
//			   } 
//			   negociosXML.setNegocios( lista ); 
//			   final File file = new File(LOCALIZACAO_NEGOCIOS_PADRAO ); 
//			   jaxbContext.createMarshaller().marshal( negociosXML, file ); 
//			   System.out.println( "Negocios gerados com sucesso!."); 
//			   System.out.println( "Localização: " + file.getCanonicalPath().toString() );
//
//			final File file = new File( LOCALIZACAO_NEGOCIOS_PADRAO );
//
//			final NegociosXML negocios = ( NegociosXML ) jaxbContext.createUnmarshaller().unmarshal(
//				file );
//
//			final List<Negocio> listaNegocios = new ArrayList<Negocio>();
			
			repositorioNegocio = ( repositorioNegocio == null ) ? new JpaNegocioDao() : repositorioNegocio;
			final List<Negocio> todosNegocios = repositorioNegocio.obterTodas();
			final File file = new File( LOCALIZACAO_NEGOCIOS_PADRAO );
			
			jaxbContext.createMarshaller().marshal( NegocioConverter.convertFrom( todosNegocios ), file );
			
			System.out.println( "\n\nNegocios Importados com sucesso!." );
			System.out.println( "Localização: " + file.getCanonicalPath().toString() );

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

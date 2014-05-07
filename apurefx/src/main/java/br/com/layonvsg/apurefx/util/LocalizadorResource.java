package br.com.layonvsg.apurefx.util;

import java.io.InputStream;
import java.net.URL;
import java.text.MessageFormat;


public class LocalizadorResource
{

	private static final String PATH_CSS_DEFAULT = "css/";
	private static final String PATH_IMAGES_DEFAULT = "images/";
	private static final String PATH_FXML_DEFAULT = "fxml/";
	private static LocalizadorResource instance;
	
	private LocalizadorResource()
	{
		super();
	}

	
	public static LocalizadorResource getInstance()
	{
		if ( instance == null )
		{
			instance = new LocalizadorResource();
		}
		
		return instance;
	}
	
	public URL getFXML( final String nomeArquivo )
	{
		if( nomeArquivo == null )
		{
			return null;
		}
		
		final URL location = Thread.currentThread().getContextClassLoader().getResource( 
			MessageFormat.format( PATH_FXML_DEFAULT + "{0}",
				nomeArquivo ));
		
		return location;
	}
	
	public URL getImage( final String nomeArquivo )
	{
		if( nomeArquivo == null )
		{
			return null;
		}
		
		final URL location = Thread.currentThread().getContextClassLoader().getResource( 
			MessageFormat.format( PATH_IMAGES_DEFAULT + "{0}",
				nomeArquivo ));
		
		return location;
	}
	
	public InputStream getImageAsStream( final String nomeArquivo )
	{
		if( nomeArquivo == null )
		{
			return null;
		}
		
		final InputStream input = Thread.currentThread().getContextClassLoader().getResourceAsStream( 
			MessageFormat.format( PATH_IMAGES_DEFAULT + "{0}",
				nomeArquivo ) );
		
		return input;
	}
	
	
	public URL getCSS( final String nomeArquivo )
	{
		if( nomeArquivo == null )
		{
			return null;
		}
		
		final URL location = Thread.currentThread().getContextClassLoader().getResource( 
			MessageFormat.format( PATH_CSS_DEFAULT + "{0}",
				nomeArquivo ));
		
		return location;
	}
	
	public URL getResource( final String nomeArquivo )
	{
		if( nomeArquivo == null )
		{
			return null;
		}
		
		final URL location = Thread.currentThread().getContextClassLoader().getResource( 
			MessageFormat.format( "{0}",
				nomeArquivo ));
		
		return location;
	}
	
}

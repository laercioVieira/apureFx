package br.com.layonvsg.apurefx.dto;

import java.io.Serializable;
import java.net.URL;

import org.apache.commons.io.FileUtils;

import br.com.layonvsg.apurefx.util.LocalizadorResource;
public class PersonalConfig
	implements Serializable
{
	private static final long serialVersionUID = 6704454810762491174L;

	private String defaultFolder = "C:\\";

	private String defaultLocalizacaoNegocios;
	
	
	public PersonalConfig()
	{
		super();
		definirPastaPadraoNegocios();
	}

	private void definirPastaPadraoNegocios()
	{
		final URL localizacaoNegocios = LocalizadorResource.getInstance().getResource(
			"negocios.xml" );
		if ( localizacaoNegocios != null )
		{
			defaultLocalizacaoNegocios = FileUtils.toFile( localizacaoNegocios ).getParent();
		}
		else
		{
			defaultLocalizacaoNegocios = defaultFolder;
		}
		/*
		 * "D:\\Documents\\GitHub\\apureFx\\apurefx-extrator\\src\\main\\resources";
		 */
	}

	public String getDefaultFolder()
	{
		return defaultFolder;
	}

	
	public void setDefaultFolder(
		final String defaultFolder )
	{
		this.defaultFolder = defaultFolder;
	}


	
	public String getDefaultLocalizacaoNegocios()
	{
		return defaultLocalizacaoNegocios;
	}


	
	public void setDefaultLocalizacaoNegocios(
		final String defaultLocalizacaoNegocios )
	{
		this.defaultLocalizacaoNegocios = defaultLocalizacaoNegocios;
	}

}

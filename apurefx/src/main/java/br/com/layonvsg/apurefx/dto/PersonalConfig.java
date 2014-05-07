package br.com.layonvsg.apurefx.dto;

import java.io.Serializable;


public class PersonalConfig
	implements Serializable
{
	private static final long serialVersionUID = 6704454810762491174L;

	private String defaultFolder = "C:\\";

	private String defaultLocalizacaoNegocios =
					"D:\\Documents\\GitHub\\apureFx\\apurefx-extrator\\src\\main\\resources";
	
	
	public PersonalConfig()
	{
		super();
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

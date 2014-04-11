package br.com.layonvsg.apurefx.dto;

import java.io.Serializable;


public class PersonalConfig
	implements Serializable
{
	private static final long serialVersionUID = 6704454810762491174L;

	private String defaultFolder = "C:\\";

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

}

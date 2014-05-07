package br.com.layonvsg.apurefx.dto;

import java.io.Serializable;

import br.com.temasistemas.java.lang.ext.validation.Precondition;

public class ConfigInfo
	implements Serializable
{

	private static final long serialVersionUID = 7454550702139001639L;

	private String host;

	private String porta;	
	
	private String defaultLocalizacaoNegocios =
					"D:\\Documents\\GitHub\\apureFx\\apurefx-extrator\\src\\main\\resources\\negocios.xml";
	
	public ConfigInfo()
	{
		super();
	}

	public ConfigInfo(
		final String host,
		final String porta )
	{
		super();
		setHost( host );
		setPorta( porta );
	}

	public ConfigInfo(
		final String host,
		final String porta,
		final String defaultFolderNegoc )
	{
		super();
		setHost( host );
		setPorta( porta );
		setDefaultLocalizacaoNegocios( defaultFolderNegoc );
		
	}

	
	public String getHost()
	{
		return host;
	}

	public void setHost(
		final String host )
	{
		Precondition.checkNotNullAndNotBlank( host, "host" );
		this.host = host;
	}

	public String getPorta()
	{
		return porta;
	}

	public void setPorta(
		final String porta )
	{
		Precondition.checkNotNullAndNotBlank( porta, "porta" );
		this.porta = porta;
	}

	
	public String getDefaultLocalizacaoNegocios()
	{
		return defaultLocalizacaoNegocios;
	}

	
	public void setDefaultLocalizacaoNegocios(
		final String defaultLocalizacaoNegocios )
	{
		Precondition.checkNotNullAndNotBlank( defaultLocalizacaoNegocios, "defaultLocalizacaoNegocios" );
		this.defaultLocalizacaoNegocios = defaultLocalizacaoNegocios;
	}

}

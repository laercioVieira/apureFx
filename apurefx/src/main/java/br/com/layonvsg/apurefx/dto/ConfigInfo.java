package br.com.layonvsg.apurefx.dto;

import java.io.Serializable;

import br.com.temasistemas.java.lang.ext.validation.Precondition;

public class ConfigInfo
	implements Serializable
{

	private static final long serialVersionUID = 7454550702139001639L;

	private String host;

	private String porta;

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

}

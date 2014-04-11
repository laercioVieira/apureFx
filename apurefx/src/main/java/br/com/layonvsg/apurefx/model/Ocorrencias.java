package br.com.layonvsg.apurefx.model;

import java.io.Serializable;


public class Ocorrencias
	implements Serializable
{

	private static final long serialVersionUID = 1599851920230995598L;

	private final String mensagem;
	
	private final String stackTrace;
	
	public Ocorrencias(final String mensagem, final String stackTrace)
	{
		super();
		this.mensagem = mensagem;
		this.stackTrace = stackTrace;
	}

	
	public String getMensagem()
	{
		return mensagem;
	}

	
	public String getStackTrace()
	{
		return stackTrace;
	}

}

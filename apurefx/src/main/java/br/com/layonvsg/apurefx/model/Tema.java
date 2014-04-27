package br.com.layonvsg.apurefx.model;

import java.net.URL;

public enum Tema
{
	BASIC( 1, "Basic Application" )
	{
		@Override
		public URL getURL()
		{
			return ClassLoader.getSystemResource( "css/themeBasicApplication.css" );
		}
		
	}, DARK_BLUE( 2, "Dark Blue" )
	{
		@Override
		public URL getURL()
		{
			return ClassLoader.getSystemResource( "css/themeDarkBlue.css" );
		}
	};

	private int codigo;

	private String descricao;

	private Tema(
		final int codigo,
		final String descricao )
	{
		this.codigo = codigo;
		this.descricao = descricao;
	}

	public int getCodigo()
	{
		return codigo;
	}

	public String getDescricao()
	{
		return descricao;
	}
	
	public abstract URL getURL();

	
}

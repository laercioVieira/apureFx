package br.com.layonvsg.apurefx.model;

import java.util.Date;

public class DataApuracao implements Comparable<DataApuracao>
{

	private Date data;
	
	private Date dataAnterior;

	private Status status;

	public DataApuracao(
		final Date data,
		final Status status,
		final Date dataAnterior)
	{
		super();
		this.data = data;
		this.status = status;
		this.dataAnterior = dataAnterior;
	}

	public Date getData()
	{
		return data;
	}

	public void setData(
		final Date data )
	{
		this.data = data;
	}

	public Status getStatus()
	{
		return status;
	}

	public void setStatus(
		final Status status )
	{
		this.status = status;
	}

	@Override
	public boolean equals(
		final Object obj )
	{
		if ( obj instanceof DataApuracao ){
			final DataApuracao other = (DataApuracao)obj;
			return getData().equals( other.getData() );
		}
		return false;
	}
	
	@Override
	public int hashCode()
	{
		return getData().hashCode();
	}

	
	public Date getDataAnterior()
	{
		return dataAnterior;
	}

	
	public void setDataAnterior(
		final Date dataAnterior )
	{
		this.dataAnterior = dataAnterior;
	}

	@Override
	public int compareTo(
		final DataApuracao o )
	{
		return o.getData().compareTo( getData() );
	}
}

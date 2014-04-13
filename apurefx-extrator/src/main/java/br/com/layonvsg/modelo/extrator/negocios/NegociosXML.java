package br.com.layonvsg.modelo.extrator.negocios;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement( name = "negocios" )
@XmlAccessorType( XmlAccessType.FIELD )
public class NegociosXML
{

	@XmlElement(name = "negocio")
	private List<NegocioXML> negocios;

	public NegociosXML()
	{
		super();
	}

	public List<NegocioXML> getNegocios()
	{
		return negocios;
	}

	public void setNegocios(
		final List<NegocioXML> negocios )
	{
		this.negocios = negocios;
	}

}

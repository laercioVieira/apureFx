package br.com.layonvsg.modelo.extrator.negocios;

import java.util.Date;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import br.com.temasistemas.derivativos.modelo.MercadoDerivativo;
import br.com.temasistemas.derivativos.modelo.negocio.ModalidadeNegociacao;
import br.com.temasistemas.derivativos.modelo.negocio.NaturezaNegociacao;

@XmlRootElement( name = "negocio" )
@XmlAccessorType( XmlAccessType.FIELD )
public class NegocioXML
{

	@XmlElement( name = "id", required = true, nillable = false )
	private int id;

	@XmlElement( required = true, nillable = false )
	private double preco;

	@XmlElement( required = true, nillable = false )
	private int quantidade;

	@XmlElement( required = true, nillable = false )
	private Long contratoId;

	@XmlElement( required = true, nillable = false )
	private Long clienteId;

	@XmlElement( required = true, nillable = false )
	private Long corretoraId;

	@XmlElement( required = true, nillable = false )
	private Long instituicaoId;

	@XmlElement( nillable = false )
	private NaturezaNegociacao naturezaNegociacao;

	@XmlElement( nillable = false )
	private ModalidadeNegociacao modalidadeNegociacao;

	@XmlElement( nillable = true )
	private Double valorTaxa;

	@XmlElement( nillable = false )
	private Double precoUltimoNegocio;

	@XmlElement( nillable = false )
	private Long agenteCompensacaoId;

	@XmlElement( nillable = false )
	private int numero;

	@XmlElement( nillable = false )
	private Date data;

	@XmlElement( nillable = false )
	private TarifacaoXML tarifacao;

	@XmlElement( nillable = false )
	private MercadoDerivativo mercado;

	@XmlElement( nillable = true )
	private Date horaNegociacao;

	@XmlElement( nillable = true )
	private Long registroEspecificacaoComitente;

	public NegocioXML()
	{
		super();
	}

	public int getId()
	{
		return id;
	}

	public void setId(
		final int id )
	{
		this.id = id;
	}

	public double getPreco()
	{
		return preco;
	}

	public void setPreco(
		final double preco )
	{
		this.preco = preco;
	}

	public int getQuantidade()
	{
		return quantidade;
	}

	public void setQuantidade(
		final int quantidade )
	{
		this.quantidade = quantidade;
	}

	public Long getContratoId()
	{
		return contratoId;
	}

	public void setContratoId(
		final Long contratoId )
	{
		this.contratoId = contratoId;
	}

	public Long getClienteId()
	{
		return clienteId;
	}

	public void setClienteId(
		final Long clienteId )
	{
		this.clienteId = clienteId;
	}

	public Long getCorretoraId()
	{
		return corretoraId;
	}

	public void setCorretoraId(
		final Long corretoraId )
	{
		this.corretoraId = corretoraId;
	}

	public Long getInstituicaoId()
	{
		return instituicaoId;
	}

	public void setInstituicaoId(
		final Long instituicaoId )
	{
		this.instituicaoId = instituicaoId;
	}

	public NaturezaNegociacao getNaturezaNegociacao()
	{
		return naturezaNegociacao;
	}

	public void setNaturezaNegociacao(
		final NaturezaNegociacao naturezaNegociacao )
	{
		this.naturezaNegociacao = naturezaNegociacao;
	}

	public ModalidadeNegociacao getModalidadeNegociacao()
	{
		return modalidadeNegociacao;
	}

	public void setModalidadeNegociacao(
		final ModalidadeNegociacao modalidadeNegociacao )
	{
		this.modalidadeNegociacao = modalidadeNegociacao;
	}

	public Double getValorTaxa()
	{
		return valorTaxa;
	}

	public void setValorTaxa(
		final Double valorTaxa )
	{
		this.valorTaxa = valorTaxa;
	}

	public Double getPrecoUltimoNegocio()
	{
		return precoUltimoNegocio;
	}

	public void setPrecoUltimoNegocio(
		final Double precoUltimoNegocio )
	{
		this.precoUltimoNegocio = precoUltimoNegocio;
	}

	public Long getAgenteCompensacaoId()
	{
		return agenteCompensacaoId;
	}

	public void setAgenteCompensacaoId(
		final Long agenteCompensacaoId )
	{
		this.agenteCompensacaoId = agenteCompensacaoId;
	}

	public int getNumero()
	{
		return numero;
	}

	public void setNumero(
		final int numero )
	{
		this.numero = numero;
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

	public TarifacaoXML getTarifacao()
	{
		return tarifacao;
	}

	public void setTarifacao(
		final TarifacaoXML tarifacao )
	{
		this.tarifacao = tarifacao;
	}

	public MercadoDerivativo getMercado()
	{
		return mercado;
	}

	public void setMercado(
		final MercadoDerivativo mercado )
	{
		this.mercado = mercado;
	}

	public Date getHoraNegociacao()
	{
		return horaNegociacao;
	}

	public void setHoraNegociacao(
		final Date horaNegociacao )
	{
		this.horaNegociacao = horaNegociacao;
	}

	public Long getRegistroEspecificacaoComitente()
	{
		return registroEspecificacaoComitente;
	}

	public void setRegistroEspecificacaoComitente(
		final Long registroEspecificacaoComitente )
	{
		this.registroEspecificacaoComitente = registroEspecificacaoComitente;
	}

	@Override
	public String toString()
	{
		final StringBuilder builder = new StringBuilder();
		builder.append( "NegocioXML [id=" );
		builder.append( id );
		builder.append( ", preco=" );
		builder.append( preco );
		builder.append( ", quantidade=" );
		builder.append( quantidade );
		builder.append( ", contratoId=" );
		builder.append( contratoId );
		builder.append( ", clienteId=" );
		builder.append( clienteId );
		builder.append( ", corretoraId=" );
		builder.append( corretoraId );
		builder.append( ", instituicaoId=" );
		builder.append( instituicaoId );
		builder.append( ", naturezaNegociacao=" );
		builder.append( naturezaNegociacao );
		builder.append( ", modalidadeNegociacao=" );
		builder.append( modalidadeNegociacao );
		builder.append( ", valorTaxa=" );
		builder.append( valorTaxa );
		builder.append( ", precoUltimoNegocio=" );
		builder.append( precoUltimoNegocio );
		builder.append( ", agenteCompensacaoId=" );
		builder.append( agenteCompensacaoId );
		builder.append( ", numero=" );
		builder.append( numero );
		builder.append( ", data=" );
		builder.append( data );
		builder.append( ", tarifacao=" );
		builder.append( tarifacao );
		builder.append( ", mercado=" );
		builder.append( mercado );
		builder.append( ", horaNegociacao=" );
		builder.append( horaNegociacao );
		builder.append( ", registroEspecificacaoComitente=" );
		builder.append( registroEspecificacaoComitente );
		builder.append( "]" );
		return builder.toString();
	}

}

package br.com.layonvsg.modelo.extrator.negocios;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import br.com.temasistemas.data.Data;
import br.com.temasistemas.data.Tempo;
import br.com.temasistemas.derivativos.modelo.negocio.Negocio;
import br.com.temasistemas.derivativos.modelo.negocio.NegocioBuilder;

public class NegocioConverter
{

	public static List<Negocio> convertFrom(
		final List<NegocioXML> negociosXML )
	{
		final List<Negocio> retorno = new ArrayList<Negocio>();

		for ( final NegocioXML negocioXML : negociosXML )
		{
			final NegocioBuilder builder =
				Negocio.builder()
					// .comId( negocioXML.getId() )
					.naData(
						Data.novaData( negocioXML.getData() ) ).doContrato(
						negocioXML.getContratoId() ).deNaturezaNegociacao(
						negocioXML.getNaturezaNegociacao() ).comQuantidade(
						negocioXML.getQuantidade() ).comPreco(
						negocioXML.getPreco() ).comValorTaxa(
						negocioXML.getValorTaxa() ).comPrecoDoUltimoNegocio(
						negocioXML.getPrecoUltimoNegocio() ).liquidadoFinanceiramentePor(
						negocioXML.getAgenteCompensacaoId() ).comandadoPeloCliente(
						negocioXML.getClienteId() ).realizadoAtravesDaCorretora(
						negocioXML.getCorretoraId() ).pertencenteAoMercado(
						negocioXML.getMercado() ).sobInstituicao(
						negocioXML.getInstituicaoId() ).comModalidadeNegociacao(
						negocioXML.getModalidadeNegociacao() ).deNumero(
						negocioXML.getNumero() ).tarifadoPor(
						negocioXML.getTarifacao().getValorUnitarioTaxaRegistroNormal(),
						negocioXML.getTarifacao().getValorUnitarioTaxaRegistroDayTrade(),
						negocioXML.getTarifacao().getValorUnitarioTaxaNegociacaoNormal(),
						negocioXML.getTarifacao().getValorUnitarioTaxaNegociacaoDayTrade() ).negociadoNaHora(
						Tempo.novoTempoPorMilesegundos( negocioXML.getHoraNegociacao().getTime() ) )
					.comRegistroDeComitenteEspecificado(
						negocioXML.getRegistroEspecificacaoComitente() );

			retorno.add( builder.build() );
		}

		return retorno;
	}

	public static NegociosXML convertFrom(
		final List<Negocio> negocios )
	{

		final List<NegocioXML> listaNegociosXML = new ArrayList<NegocioXML>();
		NegocioXML negocioXML;
		final NegociosXML nodeRootXML = new NegociosXML();

		for ( final Negocio negocio : negocios )
		{
			negocioXML = new NegocioXML();
			// negocioXML.setId( negocio.getId() );

			negocioXML.setClienteId( negocio.getClienteId() );
			negocioXML.setCorretoraId( negocio.getCorretoraId() );
			negocioXML.setInstituicaoId( negocio.getInstituicaoId() );
			negocioXML.setContratoId( negocio.getContratoId() );
			negocioXML.setAgenteCompensacaoId( negocio.getAgenteCompensacaoId() );

			if ( negocio.getPrecoContrato() != null )
			{
				negocioXML.setPreco( negocio.getPrecoContrato().toValue() );
			}

			if ( negocio.getValorTaxa() != null )
			{
				negocioXML.setValorTaxa( negocio.getValorTaxa().toValue() );
			}

			if ( negocio.getPrecoUltimoNegocio() != null )
			{
				negocioXML.setPrecoUltimoNegocio( negocio.getPrecoUltimoNegocio() );
			}

			negocioXML.setQuantidade( negocio.getQuantidadeContratos().getValue() );
			negocioXML.setTarifacao( new TarifacaoXML(
				negocio.getTarifacao().getValorUnitarioTaxaRegistroNormal(),
				negocio.getTarifacao().getValorUnitarioTaxaRegistroDayTrade(),
				negocio.getTarifacao().getValorUnitarioTaxaNegociacaoNormal(),
				negocio.getTarifacao().getValorUnitarioTaxaNegociacaoDayTrade() ) );

			negocioXML.setMercado( negocio.getMercado() );
			final Calendar calendar = Calendar.getInstance();
			calendar.setTimeInMillis( negocio.getHoraNegociacao().toValue().getTime() );
			negocioXML.setHoraNegociacao( calendar.getTime() );
			negocioXML.setData( negocio.getData().toValue() );
			negocioXML.setNaturezaNegociacao( negocio.getNaturezaNegociacao() );
			negocioXML.setModalidadeNegociacao( negocio.getModalidadeNegociacao() );
			negocioXML.setNumero( negocio.getNumero() );
			negocioXML.setRegistroEspecificacaoComitente( negocio.getRegistroEspecificacaoComitente() );
			listaNegociosXML.add( negocioXML );

		}

		nodeRootXML.setNegocios( listaNegociosXML );
		return nodeRootXML;
	}
}

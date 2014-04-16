package br.com.layonvsg.modelo.extrator.negocios;

import java.util.ArrayList;
import java.util.List;

import br.com.temasistemas.data.Data;
import br.com.temasistemas.data.Tempo;
import br.com.temasistemas.derivativos.modelo.negocio.Negocio;
import br.com.temasistemas.derivativos.modelo.negocio.NegocioBuilder;



public class NegocioConverter
{

	
	public static List<Negocio> convertFrom( final List<NegocioXML> negociosXML )
	{
		final List<Negocio> retorno = new ArrayList<Negocio>();
		
		for ( final NegocioXML negocioXML : negociosXML )
		{
			final NegocioBuilder builder = Negocio.builder()
			.naData( Data.novaData( negocioXML.getData() ) )
			.doContrato( negocioXML.getContratoId() )
			.deNaturezaNegociacao( negocioXML.getNaturezaNegociacao() )
			.comQuantidade( negocioXML.getQuantidade() )
			.comPreco( negocioXML.getPreco() )
			.comValorTaxa( negocioXML.getValorTaxa() )
			.comPrecoDoUltimoNegocio( negocioXML.getPrecoUltimoNegocio() )
			.liquidadoFinanceiramentePor( negocioXML.getAgenteCompensacaoId() )
			.comandadoPeloCliente( negocioXML.getClienteId() )
			.realizadoAtravesDaCorretora(negocioXML.getCorretoraId())
			.pertencenteAoMercado( negocioXML.getMercado() )
			.sobInstituicao( negocioXML.getInstituicaoId() )
			.comModalidadeNegociacao( negocioXML.getModalidadeNegociacao() )
			.deNumero( negocioXML.getNumero())
			.tarifadoPor( negocioXML.getTarifacao().getValorUnitarioTaxaRegistroNormal(),
				negocioXML.getTarifacao().getValorUnitarioTaxaRegistroDayTrade(),
				negocioXML.getTarifacao().getValorUnitarioTaxaNegociacaoNormal(),
				negocioXML.getTarifacao().getValorUnitarioTaxaNegociacaoDayTrade() )
			.negociadoNaHora( Tempo.novoTempoPorMilesegundos( negocioXML.getHoraNegociacao().getTime() ) )
			.comRegistroDeComitenteEspecificado( negocioXML.getRegistroEspecificacaoComitente() );
					
			retorno.add( builder.build() );
		}
		
		return retorno;
	}
	
}

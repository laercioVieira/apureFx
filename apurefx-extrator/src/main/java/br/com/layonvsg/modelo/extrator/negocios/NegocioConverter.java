package br.com.layonvsg.modelo.extrator.negocios;

import java.util.ArrayList;
import java.util.List;

import br.com.temasistemas.data.Data;
import br.com.temasistemas.derivativos.modelo.MercadoDerivativo;
import br.com.temasistemas.derivativos.modelo.negocio.ModalidadeNegociacao;
import br.com.temasistemas.derivativos.modelo.negocio.NaturezaNegociacao;
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
			.deNaturezaNegociacao( NaturezaNegociacao.fromValue( negocioXML.getNaturezaNegociacao().getValue() ) )
			.comQuantidade( negocioXML.getQuantidade() )
			.comValorTaxa( negocioXML.getValorTaxa() )
			.comPrecoDoUltimoNegocio( negocioXML.getPrecoUltimoNegocio() )
			.liquidadoFinanceiramentePor( negocioXML.getInstituicaoId() )
			.comandadoPeloCliente( negocioXML.getClienteId() )
			.realizadoAtravesDaCorretora(negocioXML.getCorretoraId())
			.pertencenteAoMercado( MercadoDerivativo.fromValue( negocioXML.getMercado().getValue() ) )
			.sobInstituicao( negocioXML.getInstituicaoId() )
			.comModalidadeNegociacao( ModalidadeNegociacao.fromValue( negocioXML.getModalidadeNegociacao().getValue() ) );
			
			retorno.add( builder.build() );
		}
		
		return retorno;
	}
	
}

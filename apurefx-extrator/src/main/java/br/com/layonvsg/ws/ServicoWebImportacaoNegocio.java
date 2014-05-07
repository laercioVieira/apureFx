package br.com.layonvsg.ws;

import java.util.Date;
import java.util.List;

import javax.ejb.Local;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;

import br.com.temasistemas.log.Log;


@Local
@WebService(endpointInterface = "br.com.layonvsg.ws.ServicoWebImportacaoNegocio")
public interface ServicoWebImportacaoNegocio
{

	static final String NOME_WEBSERVICE="ServicoWebImportacaoNegocio";
	static final String NOME_EJB="ServicoWebImportacaoNegocio";
	
	@WebMethod
	@WebResult(name = "logs")
    List<Log> importarApartirDe(
		@WebParam( name = "localizacao" ) final String localizacao,
		@WebParam( name = "instituicaoId" ) final long instituicaoId,
		@WebParam( name = "dataFim" ) final Date dataFim );
	
}

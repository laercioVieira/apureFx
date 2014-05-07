package br.com.layonvsg.ws;

import java.io.File;
import java.util.Date;
import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.ParameterStyle;
import javax.jws.soap.SOAPBinding.Style;
import javax.jws.soap.SOAPBinding.Use;

import br.com.layonvsg.servico.ServicoImportadorNegocio;
import br.com.temasistemas.data.Data;
import br.com.temasistemas.log.Log;
import br.com.temasistemas.log.Logger;

@Stateless( name = ServicoWebImportacaoNegocio.NOME_EJB)
@WebService( name = ServicoWebImportacaoNegocio.NOME_WEBSERVICE )
@SOAPBinding( parameterStyle = ParameterStyle.WRAPPED, use = Use.LITERAL, style = Style.DOCUMENT )
public class ServicoWebImportacaoNegocioBean
	implements ServicoWebImportacaoNegocio
{

	@Inject
	private ServicoImportadorNegocio servicoImportadorNegocio;

	@Inject
	private Logger logger;

	
	public ServicoWebImportacaoNegocioBean()
	{
		super();
	}
		
	@Override
	public List<Log> importarApartirDe(
		final String localizacao,
		final long instituicaoId,
		final Date dataFim )
	{
		if ( localizacao == null || localizacao.isEmpty() )
		{
			getLogger().log(
				new Log( "Importação não efetuada, localização nula ou vazia." ) );
			return getLogger().getCurrentLogs();
		}

		if( dataFim == null )
		{
			getLogger().log(
				new Log( "Importação não efetuada, dataFim nula." ) );
			return getLogger().getCurrentLogs();
		}
		
		final File file = new File( localizacao );

		final Data data = Data.novaData( dataFim );
		
		getServicoImportadorNegocio().importarFrom(
			file,
			instituicaoId,
			data );

		return getLogger().getCurrentLogs();
	}

	public ServicoImportadorNegocio getServicoImportadorNegocio()
	{
		return servicoImportadorNegocio;
	}

	public void setServicoImportadorNegocio(
		final ServicoImportadorNegocio servicoImportadorNegocio )
	{
		this.servicoImportadorNegocio = servicoImportadorNegocio;
	}

	public Logger getLogger()
	{
		return logger;
	}

	public void setLogger(
		final Logger logger )
	{
		this.logger = logger;
	}

}

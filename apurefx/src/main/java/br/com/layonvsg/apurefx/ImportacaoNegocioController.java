package br.com.layonvsg.apurefx;

import java.io.File;
import java.net.URL;
import java.text.MessageFormat;
import java.util.Calendar;
import java.util.Date;

import javafx.scene.control.TextArea;
import br.com.layonvsg.apurefx.dto.ConfigInfo;
import br.com.layonvsg.ws.Log;
import br.com.layonvsg.ws.ServicoWebImportacaoNegocio;
import br.com.layonvsg.ws.ServicoWebImportacaoNegocioBeanServiceLocator;
import br.com.temasistemas.java.lang.ext.validation.Precondition;

public class ImportacaoNegocioController
{

	private TextArea textArea;

	private static int tentativas;

	public ImportacaoNegocioController()
	{
		super();
	}

	public ImportacaoNegocioController(
		final TextArea textArea )
	{
		super();
		this.textArea = textArea;
	}

	public void importarNegociosApartirDe(
		final ConfigInfo configInfo,
		final File arquivo,
		final long instituicaoId,
		final Date dataFim )
	{
		try
		{
			Precondition.checkNotNull(
				configInfo,
				"configInfo" );
			Precondition.checkNotNull(
				arquivo,
				"arquivo" );
			Precondition.checkNotNegativeOrZero(
				instituicaoId,
				"instituicaoId" );
			Precondition.checkNotNull(
				dataFim,
				"dataFim" );

			final URL localizacaoWS = new URL( MessageFormat.format(
				"http://{0}:{1}/apurefx-extrator/ServicoWebImportacaoNegocio",
				configInfo.getHost(),
				configInfo.getPorta() ) );

			final ServicoWebImportacaoNegocio importacaoNegocio =
				new ServicoWebImportacaoNegocioBeanServiceLocator().getServicoWebImportacaoNegocioPort( localizacaoWS );

			final Calendar dataFimCalendar = Calendar.getInstance();
			dataFimCalendar.setTimeInMillis( dataFim.getTime() );

			final Log[] logs = importacaoNegocio.importarApartirDe(
				arquivo.getCanonicalPath(),
				instituicaoId,
				dataFimCalendar );

			getTextArea().setEditable(
				false );
			getTextArea().setFocusTraversable(
				true );

			if ( logs != null )
			{
				for ( final Log log : logs )
				{
					System.out.println( log.getMensagem() );
					getTextArea().appendText(
						"Tentativa " + ++tentativas + ":\n" );
					getTextArea().appendText(
						log.getMensagem() );
					getTextArea().appendText(
						"\n" );
				}
			}
			else
			{
				getTextArea().appendText(
					"Tentativa " + ++tentativas + ":\n" );
				getTextArea().appendText(
					"Mensagem: Negócios Importados com sucesso!" );
				getTextArea().appendText(
					"\n" );
			}
		}
		catch ( final Exception e )
		{
			e.printStackTrace();
			JanelaMensagem.getInstance().addMessage(
				e ).showAndWait();
			getTextArea().setEditable(
				false );
			getTextArea().setFocusTraversable(
				true );
			getTextArea().appendText(
				"Tentativa " + ++tentativas + ":\n" );
			getTextArea().appendText(
				"Ocorreram erros durante a tentativa de importação dos negócios.\n" );
			getTextArea().appendText(
				"Mensagem: " + e.getMessage() );
			getTextArea().appendText(
				"\nCausa: " + e.getCause() );
			getTextArea().appendText(
				"\n\n" );
		}

	}

	public TextArea getTextArea()
	{
		return textArea;
	}

	public void setTextArea(
		final TextArea textArea )
	{
		this.textArea = textArea;
	}

}

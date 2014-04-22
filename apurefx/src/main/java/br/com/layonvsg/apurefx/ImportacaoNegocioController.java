package br.com.layonvsg.apurefx;

import java.util.List;

import javafx.scene.control.TextArea;
import br.com.layonvsg.ws.Log;
import br.com.layonvsg.ws.ServicoWebImportacaoNegocio;
import br.com.layonvsg.ws.ServicoWebImportacaoNegocioBeanService;

public class ImportacaoNegocioController
{

	private TextArea textArea;
	

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
		final String localizacao )
	{
		try
		{
			if ( localizacao != null )
			{
				final ServicoWebImportacaoNegocio importacaoNegocio =
					new ServicoWebImportacaoNegocioBeanService().getServicoWebImportacaoNegocioPort();
				final List<Log> logs = importacaoNegocio.importarApartirDe( localizacao );

				getTextArea().setEditable( false );
				getTextArea().setFocusTraversable( true );
				getTextArea().setText( "" );
				
				for ( final Log log : logs )
				{
					System.out.println( log.getMensagem() );
					getTextArea().appendText( log.getMensagem() );
					getTextArea().appendText( "\n" );
				}
			}
		}
		catch ( final Exception e )
		{
			e.printStackTrace();
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

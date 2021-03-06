package br.com.layonvsg.apurefx;

import java.io.IOException;
import java.net.URL;
import java.util.Locale;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.stage.WindowEvent;

import org.jboss.logging.Logger;

import br.com.layonvsg.apurefx.model.MessageType;
import br.com.layonvsg.apurefx.util.LocalizadorResource;
import br.com.temasistemas.java.lang.ext.validation.Precondition;

public class JanelaMensagem
{

	@FXML
	private ResourceBundle resources;

	@FXML
	private URL location;

	@FXML
	private static GridPane containerGridPane;

	@FXML
	private Label detailsLabel;

	@FXML
	private ImageView imgIcone;

	@FXML
	private Label messageLabel;

	@FXML
	private Button okButton;

	private static Stage containerPrincipal;

	private static JanelaMensagem instance;

	@FXML
	private static TextArea textAreaMensagem;

	private static final Logger LOGGER = Logger.getLogger( JanelaMensagem.class ); 
	
	@FXML
	private void initialize()
	{
		LOGGER.info( "Inicializando o utilitário 'Janela de Mensagem' [Singleton]" );
		registrarEventosBotaoOK();
	}

	private void registrarEventosBotaoOK()
	{
		if( okButton != null && okButton.onActionProperty() != null )
		{
			okButton.setOnAction( new EventHandler<ActionEvent>()
			{

				@Override
				public void handle(
					final ActionEvent arg0 )
				{
					if( containerPrincipal != null )
					{
						textAreaMensagem.clear();
						containerPrincipal.getScene().getWindow().hide();
					}
				}
				
			} );
		}
	}

	public JanelaMensagem()
	{
		super();
	}

	public static JanelaMensagem getInstance()
	{
		try
		{
			if ( instance == null )
			{
				instance = new JanelaMensagem();
			}

			if ( containerPrincipal == null )
			{
				final FXMLLoader fxmlLoader = instanciarArquivoFXML();
				instance = fxmlLoader.getController();
				setUpContainerPrincipal();
				registrarEventos();
			}
		}
		catch ( final Exception e )
		{
			LOGGER.error( e.getMessage(), e );
		}
		
		return instance;
	}

	private static void registrarEventos()
	{
		containerPrincipal.setOnCloseRequest( limpaMensagensNoFechamento() );
		containerPrincipal.setOnHiding( limpaMensagensNoFechamento() );
	}

	private static void setUpContainerPrincipal()
	{
		containerPrincipal = new Stage( StageStyle.UTILITY );
		containerPrincipal.setScene( new Scene( containerGridPane ) );
		containerPrincipal.setTitle( "Mensagens do Processo" );
		containerPrincipal.initModality( Modality.APPLICATION_MODAL );
	}

	private static FXMLLoader instanciarArquivoFXML()
		throws IOException
	{
		final URL location = LocalizadorResource.getInstance().getFXML( "JanelaMensagem.fxml" );

		final FXMLLoader fxmlLoader = new FXMLLoader( location, ResourceBundle.getBundle(
			"fxml/BasicApplication",
			Locale.getDefault() ) );

		containerGridPane = ( GridPane ) fxmlLoader.load();

		return fxmlLoader;
	}

	private static EventHandler<WindowEvent> limpaMensagensNoFechamento()
	{
		final EventHandler<WindowEvent> eventClearTextArea = new EventHandler<WindowEvent>()
		{

			@Override
			public void handle(
				final WindowEvent arg0 )
			{
				if ( textAreaMensagem != null )
				{
					textAreaMensagem.clear();
				}
			}

		};
		
		return eventClearTextArea;
	}

	public JanelaMensagem addMessage(
		final MessageType tipoMensagem,
		final String msg )
	{
		Precondition.checkNotNull(
			tipoMensagem,
			"tipoMensagem" );
		
		Precondition.checkNotNull(
			msg,
			"mensagem" );
		
		imgIcone.setImage( tipoMensagem.getImage() );
		textAreaMensagem.appendText( msg + "\n" );

		return this;
	}

	public JanelaMensagem addMessage(
		final Exception exception )
	{

		addMessage(
			MessageType.ERRO,
			"Mensagem: " + exception.getMessage() );

		
		if ( exception.getCause() != null )
		{
			addMessage(
				MessageType.ERRO,
				"Causa: " + exception.getCause() );
		}
		return this;
	}

	public JanelaMensagem limparTodasMensagens()
	{
		if ( textAreaMensagem != null )
		{
			textAreaMensagem.clear();
		}

		return this;
	}

	public JanelaMensagem showAndWait()
	{
		containerPrincipal.showAndWait();
		return this;
	}

	public void closeWindow()
	{
		containerPrincipal.getScene().getWindow().fireEvent(
			new Event( WindowEvent.WINDOW_CLOSE_REQUEST ) );
	}

	public boolean temMensagens()
	{
		return textAreaMensagem.getText().isEmpty();
	}

}

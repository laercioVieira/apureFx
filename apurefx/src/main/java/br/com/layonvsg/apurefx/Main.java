package br.com.layonvsg.apurefx;

import java.io.IOException;
import java.net.URL;
import java.util.Locale;
import java.util.ResourceBundle;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import org.jboss.logging.Logger;

import br.com.layonvsg.apurefx.model.Tema;
import br.com.layonvsg.apurefx.util.LocalizadorResource;

public class Main
	extends Application
{

	private static final Logger LOGGER = Logger.getLogger( BasicApplicationController.class );

	public Main()
	{
		super();

	}

	public static void main(
		final String[] args )
	{
		try
		{
			Application.launch(
				Main.class,
				( String[] ) null );
		}
		catch ( final Exception e )
		{
			LOGGER.error( "Não foi possível iniciar a aplicação. Detalhes no LOG.", e);
			JanelaMensagem.getInstance().addMessage(
				e ).showAndWait();
		}

	}

	@Override
	public void start(
		final Stage primaryStage )
		throws Exception
	{
		final VBox page = createFromFXML();
		setUpMainContainer(
			primaryStage,
			page );
		primaryStage.show();
	}

	private void setUpMainContainer(
		final Stage primaryStage,
		final VBox page )
	{
		final Scene scene = new Scene( page );

		if ( Tema.BASIC.getURL() != null )
		{
			scene.getStylesheets().clear();
			scene.getStylesheets().add(
				Tema.BASIC.getURL().toExternalForm() );
		}
		primaryStage.setScene( scene );
		primaryStage.setTitle( "ApureFX - Uma Solução para integração JavaFX." );
	}

	private VBox createFromFXML()
		throws IOException
	{
		final URL location = LocalizadorResource.getInstance().getFXML(
			"BasicApplication.fxml" );

		final ResourceBundle resource = ResourceBundle.getBundle(
			"fxml/BasicApplication",
			Locale.getDefault(),
			ClassLoader.getSystemClassLoader() );

		final VBox page = ( VBox ) FXMLLoader.load(
			location,
			resource );

		return page;
	}
}

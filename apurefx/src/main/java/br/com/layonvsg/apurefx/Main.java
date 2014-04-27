package br.com.layonvsg.apurefx;

import java.net.URL;
import java.util.Locale;
import java.util.ResourceBundle;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import br.com.layonvsg.apurefx.model.Tema;

public class Main
	extends Application
{

	public Main()
	{
		super();

	}

	public static void main(
		final String[] args )
	{
		Application.launch(
			Main.class,
			( String[] ) null );

	}

	@Override
	public void start(
		final Stage primaryStage )
		throws Exception
	{
		final URL location = ClassLoader.getSystemResource( "fxml/BasicApplication.fxml" );
		final ResourceBundle resource = ResourceBundle.getBundle(
			"fxml/BasicApplication",
			Locale.getDefault(),
			ClassLoader.getSystemClassLoader() );
		
		final VBox page = ( VBox ) FXMLLoader.load(
			location,
			resource );

		final Scene scene = new Scene( page );
		
		if( Tema.BASIC.getURL() != null )
		{
			scene.getStylesheets().clear();
			scene.getStylesheets().add( Tema.BASIC.getURL().toExternalForm() );
		}
		primaryStage.setScene( scene );
		primaryStage.setTitle( "ApureFX - Uma Solução para integração JavaFX." );
		primaryStage.show();

	}
}

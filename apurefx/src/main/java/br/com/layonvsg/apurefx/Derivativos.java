package br.com.layonvsg.apurefx;

import java.util.Locale;
import java.util.ResourceBundle;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Derivativos
	extends Application
{

	public Derivativos()
	{
		super();

	}

	public static void main(
		final String[] args )
	{
		Application.launch(
			Derivativos.class,
			( String[] ) null );

	}

	@Override
	public void start(
		final Stage primaryStage )
		throws Exception
	{
		final VBox page = ( VBox ) FXMLLoader.load(
			Thread.currentThread().getContextClassLoader().getResource(
				"fxml/BasicApplication.fxml" ),
			ResourceBundle.getBundle(
				"fxml/BasicApplication",
				Locale.getDefault(),
				ClassLoader.getSystemClassLoader() ) );

		final Scene scene = new Scene( page );
		primaryStage.setScene( scene );
		primaryStage.setTitle( "ApureFX - Uma Solução para integração JavaFX." );
		primaryStage.show();

	}

}

package br.com.layonvsg.apurefx;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
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
		final AnchorPane page =
			( AnchorPane ) FXMLLoader.load( Thread.currentThread().getContextClassLoader().getResource(
				"fxml/Derivativos.fxml" ) );
		final Scene scene = new Scene( page );
		primaryStage.setScene( scene );
		primaryStage.setTitle( "Derivativos - BankPro" );
		primaryStage.show();

	}

}

package br.com.layonvsg.apurefx;

import java.io.IOException;
import java.net.URL;
import java.util.Locale;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckMenuItem;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextArea;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.stage.WindowEvent;
import br.com.layonvsg.apurefx.dao.PersonalConfigDao;
import br.com.layonvsg.apurefx.dto.PersonalConfig;

public class BasicApplicationController
{

	@FXML
	private VBox containerPrincipalApp;

	@FXML
	private ResourceBundle resources;

	@FXML
	private URL location;

	@FXML
	private Button btnApuracao;

	@FXML
	private Button btnImportarNegocio;

	@FXML
	private Button btnMudarEstilo;

	@FXML
	private Button btnSair;

	@FXML
	private CheckMenuItem ckMnIngles;

	@FXML
	private CheckMenuItem ckMnPortugues;

	@FXML
	private Menu mdMudarIdioma;

	@FXML
	private MenuItem mnAbrirApuracao;

	@FXML
	private Menu mnArquivo;

	@FXML
	private Menu mnEditar;

	@FXML
	private MenuItem mnImportarNegocio;

	@FXML
	private MenuItem mnMudarEstilo;

	@FXML
	private MenuItem mnSair;

	@FXML
	private TextArea txtAreaStatus;

	private Stage derivativosStageForm;

	@FXML
	void abrirApuracao(
		final ActionEvent event )
	{
		try
		{
			setUpApuracaoForm();
			getDerivativosForm().showAndWait();

		}
		catch ( final Exception e )
		{
			e.printStackTrace();
		}
	}

	private void setUpApuracaoForm()
		throws IOException
	{
		final AnchorPane derivativosFormPanel = ( AnchorPane ) FXMLLoader.load(
			Thread.currentThread().getContextClassLoader().getResource(
				"fxml/Derivativos.fxml" ),
			ResourceBundle.getBundle(
				"fxml/BasicApplication",
				Locale.getDefault(),
				ClassLoader.getSystemClassLoader() ) );

		setDerivativosForm( new Stage( StageStyle.DECORATED ) );

		getDerivativosForm().setTitle(
			"Derivativos - BankPro" );

		getDerivativosForm().initModality(
			Modality.WINDOW_MODAL );

		getDerivativosForm().setScene(
			new Scene( derivativosFormPanel ) );
	}

	public Stage getDerivativosForm()
	{
		return this.derivativosStageForm;
	}

	public void setDerivativosForm(
		final Stage stage )
	{
		this.derivativosStageForm = stage;
	}

	@FXML
	void fecharAplicacao(
		final ActionEvent event )
	{
		if ( containerPrincipalApp != null )
		{
			containerPrincipalApp.fireEvent( new Event( WindowEvent.WINDOW_CLOSE_REQUEST ) );
		}
	}

	@FXML
	void importarNegocios(
		final ActionEvent event )
	{
		final ImportacaoNegocioController importacaoNegocioController = new ImportacaoNegocioController( txtAreaStatus );

		final PersonalConfigDao personalConfigDao = new PersonalConfigDao();
		PersonalConfig personalConfig = personalConfigDao.getCurrentConfig();

		if ( personalConfig == null || personalConfig.getDefaultLocalizacaoNegocios() == null )
		{
			personalConfig = new PersonalConfig();
			personalConfigDao.save( personalConfig );
		}

		importacaoNegocioController.importarNegociosApartirDe( personalConfig.getDefaultLocalizacaoNegocios() );
	}

	@FXML
	void mudarEstilo(
		final ActionEvent event )
	{

	}

	@FXML
	void mudarIdioma(
		final ActionEvent event )
	{
		try
		{
			if ( event.getSource() instanceof CheckMenuItem )
			{
				final CheckMenuItem checkMenuItem = ( CheckMenuItem ) event.getSource();

				for ( final MenuItem element : checkMenuItem.getParentMenu().getItems() )
				{
					( ( CheckMenuItem ) element ).setSelected( false );
				}

				if ( checkMenuItem.getId() != null && checkMenuItem.getId().trim().equals(
					"ckMnPortugues" ) )
				{
					this.resources = ResourceBundle.getBundle(
						"fxml/BasicApplication",
						Locale.getDefault(),
						ClassLoader.getSystemClassLoader() );
					
					final VBox root = ( VBox ) FXMLLoader.load(
						location,
						resources );
					containerPrincipalApp.getChildren().clear();
					containerPrincipalApp.getChildren().addAll( root.getChildren() );
					checkMenuItem.setSelected( true );
				}
				else if ( checkMenuItem.getId() != null && checkMenuItem.getId().trim().equals(
					"ckMnIngles" ) )
				{
					this.resources = ResourceBundle.getBundle(
						"fxml/BasicApplication",
						Locale.ENGLISH,
						ClassLoader.getSystemClassLoader() );

					final VBox root = ( VBox ) FXMLLoader.load(
						location,
						resources );
					containerPrincipalApp.getChildren().clear();
					containerPrincipalApp.getChildren().addAll( root.getChildren() );

					checkMenuItem.setSelected( true );
				}
			}
			else if ( event.getSource() instanceof Button )
			{

			}
		}
		catch ( final Exception e )
		{
			e.printStackTrace();
		}

	}

	@FXML
	public void initialize()
	{
		assert btnApuracao != null : "fx:id=\"btnApuracao\" was not injected: check your FXML file 'BasicApplication.fxml'.";
		assert btnImportarNegocio != null : "fx:id=\"btnImportarNegocio\" was not injected: check your FXML file 'BasicApplication.fxml'.";
		assert btnMudarEstilo != null : "fx:id=\"btnMudarEstilo\" was not injected: check your FXML file 'BasicApplication.fxml'.";
		assert btnSair != null : "fx:id=\"btnSair\" was not injected: check your FXML file 'BasicApplication.fxml'.";
		assert ckMnIngles != null : "fx:id=\"ckMnIngles\" was not injected: check your FXML file 'BasicApplication.fxml'.";
		assert ckMnPortugues != null : "fx:id=\"ckMnPortugues\" was not injected: check your FXML file 'BasicApplication.fxml'.";
		assert mdMudarIdioma != null : "fx:id=\"mdMudarIdioma\" was not injected: check your FXML file 'BasicApplication.fxml'.";
		assert mnAbrirApuracao != null : "fx:id=\"mnAbrirApuracao\" was not injected: check your FXML file 'BasicApplication.fxml'.";
		assert mnArquivo != null : "fx:id=\"mnArquivo\" was not injected: check your FXML file 'BasicApplication.fxml'.";
		assert mnEditar != null : "fx:id=\"mnEditar\" was not injected: check your FXML file 'BasicApplication.fxml'.";
		assert mnImportarNegocio != null : "fx:id=\"mnImportarNegocio\" was not injected: check your FXML file 'BasicApplication.fxml'.";
		assert mnMudarEstilo != null : "fx:id=\"mnMudarEstilo\" was not injected: check your FXML file 'BasicApplication.fxml'.";
		assert mnSair != null : "fx:id=\"mnSair\" was not injected: check your FXML file 'BasicApplication.fxml'.";
		assert txtAreaStatus != null : "fx:id=\"txtAreaStatus\" was not injected: check your FXML file 'BasicApplication.fxml'.";

	}

	public VBox getContainerPrincipalApp()
	{
		return containerPrincipalApp;
	}

	public void setContainerPrincipalApp(
		final VBox containerPrincipalApp )
	{
		this.containerPrincipalApp = containerPrincipalApp;
	}

}

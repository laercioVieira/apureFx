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
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.stage.WindowEvent;
import br.com.layonvsg.apurefx.dao.PersonalConfigDao;
import br.com.layonvsg.apurefx.dto.PersonalConfig;
import br.com.layonvsg.apurefx.servico.GerenciadorTemas;
import br.com.layonvsg.apurefx.servico.ServicoGerenciadorTemas;

public class BasicApplicationController
{

	private BasicApplicationControllerProduce myProducer;

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

	private Stage apuracaoStageForm;

	@FXML
	private GridPane containerMudarEstilo;

	private Stage stageMudarEstilo;

	private GerenciadorTemas gerenciadorTEmas;

	private EscolherEstiloController escolherEstiloController;

	@FXML
	public void abrirApuracao(
		final ActionEvent event )
	{
		getApuracaoStageForm().showAndWait();
	}

	private void setUpApuracaoForm()
	{
		try
		{
			final URL localizacao = Thread.currentThread().getContextClassLoader().getResource(
				"fxml/Apuracao.fxml" );
			final AnchorPane apuracaoPanel = ( AnchorPane ) FXMLLoader.load(
				localizacao,
				resources );

			setApuracaoStageForm( new Stage( StageStyle.DECORATED ) );

			getApuracaoStageForm().setTitle(
				"Derivativos - BankPro" );

			getApuracaoStageForm().initModality(
				Modality.WINDOW_MODAL );

			getApuracaoStageForm().setScene(
				new Scene( apuracaoPanel ) );

		}
		catch ( final Exception e )
		{
			e.printStackTrace();
		}

	}

	public Stage getApuracaoStageForm()
	{
		return this.apuracaoStageForm;
	}

	public void setApuracaoStageForm(
		final Stage stage )
	{
		this.apuracaoStageForm = stage;
	}

	@FXML
	public void fecharAplicacao(
		final ActionEvent event )
	{
		if ( containerPrincipalApp != null )
		{
			containerMudarEstilo.getScene().getWindow().fireEvent(
				new Event( WindowEvent.WINDOW_CLOSE_REQUEST ) );
			getApuracaoStageForm().getScene().getWindow().fireEvent(
				new Event( WindowEvent.WINDOW_CLOSE_REQUEST ) );
			containerPrincipalApp.getScene().getWindow().fireEvent(
				new Event( WindowEvent.WINDOW_CLOSE_REQUEST ) );
		}
	}

	@FXML
	protected void importarNegocios(
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
	public void abrirDialogoEscolhaEstilo()
	{
		stageMudarEstilo.showAndWait();
	}

	@FXML
	protected void mudarIdioma(
		final ActionEvent event )
	{
		try
		{
			if ( event.getSource() instanceof CheckMenuItem )
			{
				final CheckMenuItem checkMenuItem = ( CheckMenuItem ) event.getSource();

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
					containerPrincipalApp.getChildren().addAll(
						root.getChildren() );
					for ( final MenuItem element : checkMenuItem.getParentMenu().getItems() )
					{
						( ( CheckMenuItem ) element ).setSelected( false );
					}
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
					containerPrincipalApp.getChildren().addAll(
						root.getChildren() );
					for ( final MenuItem element : checkMenuItem.getParentMenu().getItems() )
					{
						( ( CheckMenuItem ) element ).setSelected( false );
					}
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
		checkPreconditions();
		setUpMudarEstiloForm();
		setUpApuracaoForm();
		initMyProducer();
	}

	private void initMyProducer()
	{
		myProducer = new BasicApplicationControllerProduce( this );
		escolherEstiloController.setGerenciadorTemas( new ServicoGerenciadorTemas( this ) );
	}

	private void checkPreconditions()
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

	private void setUpMudarEstiloForm()
	{
		try
		{
			Scene scene;
			if ( containerMudarEstilo == null && stageMudarEstilo == null )
			{
				final FXMLLoader fxmlLoader = new FXMLLoader( 
					Thread.currentThread().getContextClassLoader().getResource(
									"fxml/EscolherEstiloDialog.fxml" ),
								resources );
				
				containerMudarEstilo = ( GridPane ) fxmlLoader.load();
				this.escolherEstiloController = ( EscolherEstiloController ) fxmlLoader.getController();
				
				scene = new Scene( containerMudarEstilo );
				final URL url = ClassLoader.getSystemResource( "css/AlertDialog.css" );
				scene.getStylesheets().clear();
				if ( url != null )
				{
					scene.getStylesheets().add(
						url.toExternalForm() );
				}
				else
				{
					scene.getStylesheets().addAll(
						getContainerPrincipalApp().getScene().getStylesheets() );
				}

				stageMudarEstilo = new Stage( StageStyle.DECORATED );
				stageMudarEstilo.setTitle( "Escolher Estilo" );
				stageMudarEstilo.initModality( Modality.WINDOW_MODAL );
				stageMudarEstilo.setScene( scene );
			}

		}
		catch ( final IOException e )
		{
			e.printStackTrace();
		}

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

	public Stage getStageMudarEstilo()
	{
		return stageMudarEstilo;
	}

	public void setStageMudarEstilo(
		final Stage stageMudarEstilo )
	{
		this.stageMudarEstilo = stageMudarEstilo;
	}

}

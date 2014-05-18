package br.com.layonvsg.apurefx;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.Date;
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
import javafx.stage.FileChooser;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.stage.WindowEvent;
import org.jboss.logging.Logger;
import br.com.layonvsg.apurefx.dao.ConfigDao;
import br.com.layonvsg.apurefx.dao.PersonalConfigDao;
import br.com.layonvsg.apurefx.dto.ConfigInfo;
import br.com.layonvsg.apurefx.dto.PersonalConfig;
import br.com.layonvsg.apurefx.servico.ServicoGerenciadorTemas;
import br.com.layonvsg.apurefx.util.LocalizadorResource;

public class BasicApplicationController
{

	private static final long INSTITUICAO_DEFAULT_1000L = 1000L;

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

	private EscolherEstiloController escolherEstiloController;
	private static final Logger LOGGER = Logger.getLogger( BasicApplicationController.class );

	@FXML
	public void abrirApuracao(
		final ActionEvent event )
	{
		getApuracaoStageForm().showAndWait();
	}

	private void setUpApuracaoForm()
		throws IOException
	{
		final URL localizacao = LocalizadorResource.getInstance().getFXML(
			"Apuracao.fxml" );
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
		try
		{
			final ImportacaoNegocioController importacaoNegocioController =
				new ImportacaoNegocioController( txtAreaStatus );

		final PersonalConfigDao personalConfigDao = new PersonalConfigDao();
		final ConfigDao configDao = new ConfigDao();

		PersonalConfig personalConfig = personalConfigDao.getCurrentConfig();
		if ( personalConfig == null || personalConfig.getDefaultLocalizacaoNegocios() == null )
		{
			personalConfig = new PersonalConfig();
		}

		final FileChooser fileChooser = new FileChooser();
			final FileChooser.ExtensionFilter extFilter =
				new FileChooser.ExtensionFilter( "XML Files (*.xml)", "*.xml" );
		fileChooser.getExtensionFilters().add(
			extFilter );

		fileChooser.setInitialDirectory( new File( personalConfig.getDefaultLocalizacaoNegocios() ) );
		final File file = fileChooser.showOpenDialog( containerPrincipalApp.getScene().getWindow() );

		if ( file != null )
		{
			personalConfig.setDefaultLocalizacaoNegocios( file.getParentFile().getAbsolutePath() );
			personalConfigDao.save( personalConfig );
			final Date dataFim = new Date( System.currentTimeMillis() );
			final ConfigInfo configInfo = configDao.obterConfigInfoVigente();

			importacaoNegocioController.importarNegociosApartirDe(
				configInfo,
				file,
				INSTITUICAO_DEFAULT_1000L,
				dataFim );
			}
		}
		catch ( final Exception exception )
		{
			LOGGER.error( "Ocorreu uma falha na tentativa de importação de negócios.", exception );
			JanelaMensagem.getInstance().addMessage(
				exception ).showAndWait();
		}

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

				for ( final MenuItem element : checkMenuItem.getParentMenu().getItems() )
				{
					if ( !( checkMenuItem.getId() != null && checkMenuItem.getId().trim().equals(
						element.getId() ) ) )
					{
						( ( CheckMenuItem ) element ).setSelected( false );
					}
				}

				if ( checkMenuItem.getId() != null && checkMenuItem.getId().trim().equals(
					"ckMnPortugues" ) && !resources.getLocale().equals(
					Locale.getDefault() ) )
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
					this.ckMnIngles.setSelected( false );
					this.ckMnPortugues.setSelected( true );
				}
				else if ( checkMenuItem.getId() != null && checkMenuItem.getId().trim().equals(
					"ckMnIngles" ) && !resources.getLocale().equals(
					Locale.ENGLISH ) )
				{
					this.resources = ResourceBundle.getBundle(
						"fxml/BasicApplication",
						Locale.ENGLISH,
						ClassLoader.getSystemClassLoader() );

					final FXMLLoader fxmlLoader = new FXMLLoader( location, resources );

					final VBox root = ( VBox ) fxmlLoader.load();

					containerPrincipalApp.getChildren().clear();
					containerPrincipalApp.getChildren().addAll(
						root.getChildren() );
					this.ckMnIngles.setSelected( true );
					this.ckMnPortugues.setSelected( false );

				}
			}

		}
		catch ( final Exception e )
		{
			LOGGER.error( "Não foi possível realizar a operação.", e);
			JanelaMensagem.getInstance().addMessage(
				e ).showAndWait();
		}

	}

	@FXML
	public void initialize()
	{
		try
		{
			checkPreconditions();
			setUpMudarEstiloForm();
			setUpApuracaoForm();
			initGerenciadorTemas();

		}
		catch ( final Exception e )
		{
			LOGGER.error( "Não foi possível iniciar a aplicação.", e);
			JanelaMensagem.getInstance().addMessage(
				e ).showAndWait();
		}
	}

	private void initGerenciadorTemas()
	{
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
		throws IOException
	{
		Scene scene;
		if ( containerMudarEstilo == null && stageMudarEstilo == null )
		{
			final FXMLLoader fxmlLoader = new FXMLLoader( Thread.currentThread().getContextClassLoader().getResource(
				"fxml/EscolherEstiloDialog.fxml" ), resources );

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
			stageMudarEstilo.initModality( Modality.APPLICATION_MODAL );
			stageMudarEstilo.setScene( scene );
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

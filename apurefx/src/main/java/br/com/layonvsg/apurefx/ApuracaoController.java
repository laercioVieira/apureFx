package br.com.layonvsg.apurefx;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.ResourceBundle;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableColumn.CellDataFeatures;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.layout.AnchorPane;
import javafx.stage.FileChooser;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Callback;
import br.com.layonvsg.apurefx.dao.ConfigDao;
import br.com.layonvsg.apurefx.dao.PersonalConfigDao;
import br.com.layonvsg.apurefx.dto.ConfigInfo;
import br.com.layonvsg.apurefx.dto.PersonalConfig;
import br.com.layonvsg.apurefx.importador.ImportadorDataApuracao;
import br.com.layonvsg.apurefx.model.DataApuracao;
import br.com.layonvsg.apurefx.model.Ocorrencias;
import br.com.layonvsg.apurefx.model.Status;
import br.com.layonvsg.apurefx.model.TipoApuracao;

import com.google.common.collect.ImmutableList;

public class ApuracaoController
{

	private static final int INDICE_COLUNA_STATUS_DATA_APURACAO = 1;

	private static final int INDICE_COLUNA_DATA = 0;

	private final Locale localeBrasil = new Locale( "pt", "BR" );

	private ConfigDao configDao = new ConfigDao();
	
	@FXML
	private ResourceBundle resources;
	
	@FXML
	private URL location;

	@FXML
	private Button btnImportar;

	@FXML
	private AnchorPane mainPanel;

	@FXML
	private TableView<DataApuracao> tblDatasApuracao;

	@FXML
	private ChoiceBox<String> cmbTipoApuracao;

	@FXML
	private TextArea txtOcorrencias;

	private Stage relatorioForm;

	private Stage configForm;

	private ObservableList<DataApuracao> datas = FXCollections.emptyObservableList();

	private final List<DataApuracao> datasOriginais = new ArrayList<>( 0 );

	private final PersonalConfigDao personalConfigDao = new PersonalConfigDao();

	private TipoApuracao tipoApuracao;

	private final Map<DataApuracao, List<Ocorrencias>> logs = new HashMap<>( 0 );

	public ApuracaoController()
	{
		super();
	}

	@FXML
	public void initialize()
	{
		try
		{
			configurarTabelaDatasApuracao();
			configurarComboTipoApuracao();
			setUpRelatorioForm();			
			setUpConfigForm();

		}
		catch ( final Exception ex )
		{
			ex.printStackTrace();
		}
	}

	private void configurarComboTipoApuracao()
	{
		final List<String> descricoesTipo = new ArrayList<>( 4 );

		for ( final TipoApuracao tipoApuracao : TipoApuracao.values() )
		{
			descricoesTipo.add( tipoApuracao.getDescricao() );
		}

		getCmbTipoApuracao().setItems( 
			FXCollections.observableArrayList( descricoesTipo ) );
		getCmbTipoApuracao().getSelectionModel().selectedIndexProperty().addListener(
			new ChangeListener<Number>()
			{

				@Override
				public void changed(
					final ObservableValue< ? extends Number> arg0,
					final Number value,
					final Number new_value )
				{
					setTipoApuracao( TipoApuracao.values()[( Integer ) new_value] );
				};
			} );
	}


	private void setUpRelatorioForm()
					throws IOException
	{
		final URL url = ClassLoader.getSystemResource( "fxml/Relatorios.fxml" );
		
		final FXMLLoader fxmlLoader = new FXMLLoader( url, resources );
		final AnchorPane relatorioFormPanel = ( AnchorPane ) fxmlLoader.load();
		setRelatorioForm( new Stage( StageStyle.UTILITY ) );
		getRelatorioForm().initModality(
			Modality.APPLICATION_MODAL );
		getRelatorioForm().setScene(
			new Scene( relatorioFormPanel ) );
	}

	private void setUpConfigForm()
		throws IOException
	{
		final URL location = ClassLoader.getSystemResource( 
			"fxml/ConfigForm.fxml" );
		
		final FXMLLoader fxmlLoader = new FXMLLoader( location, resources );

		final AnchorPane configBdFormPanel = ( AnchorPane ) fxmlLoader.load();
		setConfigForm( new Stage( StageStyle.TRANSPARENT ) );
		getConfigForm().initModality(
			Modality.APPLICATION_MODAL );
		getConfigForm().setScene(
			new Scene( configBdFormPanel ) );
	}

	private void configurarTabelaDatasApuracao()
	{
		getTblDatasApuracao().setItems(
			getDatas() );

		configurarColunaDataApuracao();

		final TableColumn<DataApuracao, String> colunaStatusDataApuracao =
			( TableColumn<DataApuracao, String> ) tblDatasApuracao.getColumns().get(
				INDICE_COLUNA_STATUS_DATA_APURACAO );

		colunaStatusDataApuracao.setCellValueFactory( criarStatusCellValueFactory() );

		final String lineSeparator = System.getProperty( "line.separator" );

		getTblDatasApuracao().getSelectionModel().selectedItemProperty().addListener(
			new ChangeListener<DataApuracao>()
			{

				@Override
				public void changed(
					final ObservableValue< ? extends DataApuracao> observable,
					final DataApuracao oldValue,
					final DataApuracao newValue )
				{
					if ( logs.containsKey( newValue ) )
					{
						final List<Ocorrencias> logsDaApuracao = logs.get( newValue );
						final StringBuilder sb = new StringBuilder( "" );

						for ( final Ocorrencias log : logsDaApuracao )
						{
							sb.append( log.getMensagem() );

							if ( !log.getStackTrace().isEmpty() )
							{
								sb.append( lineSeparator );
								sb.append( log.getStackTrace() );
							}

							sb.append( lineSeparator );
						}

						getTxtOcorrencias().setText(
							sb.toString() );
					}

				}
			} );
	}

	private Callback<CellDataFeatures<DataApuracao, String>, ObservableValue<String>> criarStatusCellValueFactory()
	{
		return new Callback<TableColumn.CellDataFeatures<DataApuracao, String>, ObservableValue<String>>()
		{

			@Override
			public ObservableValue<String> call(
				final CellDataFeatures<DataApuracao, String> cell )
			{
				if ( cell.getValue() == null )
				{
					return new SimpleStringProperty( "" );
				}
				return new SimpleStringProperty( cell.getValue().getStatus().getDescricao() );
			}
		};
	}

	private void configurarColunaDataApuracao()
	{
		final TableColumn<DataApuracao, String> dataApuracao =
			( TableColumn<DataApuracao, String> ) tblDatasApuracao.getColumns().get(
				INDICE_COLUNA_DATA );

		final SimpleDateFormat simpleDateFormat = new SimpleDateFormat( "dd/MM/yyyy", localeBrasil );

		dataApuracao.setCellValueFactory( criarDateCellValueFactory( simpleDateFormat ) );
	}

	private Callback<CellDataFeatures<DataApuracao, String>, ObservableValue<String>> criarDateCellValueFactory(
		final SimpleDateFormat simpleDateFormat )
	{
		return new Callback<TableColumn.CellDataFeatures<DataApuracao, String>, ObservableValue<String>>()
		{

			@Override
			public ObservableValue<String> call(
				final TableColumn.CellDataFeatures<DataApuracao, String> cellData )
			{
				if ( cellData.getTableView() != null )
				{
					final DataApuracao dataApuracao = cellData.getValue();
					return new SimpleStringProperty( simpleDateFormat.format( dataApuracao.getData() ) );
				}
				return new SimpleStringProperty( "" );
			};
		};
	}

	@FXML
	public void apurar(
		final ActionEvent event )
	{
		if ( getTipoApuracao() == null )
		{
			getTxtOcorrencias().setText(
				"Tipo de apuração não definido." );
		}
		else
		{

			apurarDatas();
		}
	}

	private void apurarDatas()
	{
		final ConfigInfo configInfo = getConfigDao().obterConfigInfoVigente();
		
		for ( int i = 0; i < getDatasOriginais().size(); i++ )
		{
			final DataApuracao dataApuracao = getDatasOriginais().get(
				i );
			atualizarDataApuracao(
				i,
				dataApuracao,
				Status.APURANDO );
			try
			{

				final List<Ocorrencias> locaLogs = getTipoApuracao().apurar(
					dataApuracao.getData(),
					dataApuracao.getDataAnterior(),
					1000, configInfo );

				if ( locaLogs.size() > 0 )
				{
					atualizarDataApuracao(
						i,
						dataApuracao,
						Status.APURADO_COM_PROBLEMAS );
				}
				else
				{
					atualizarDataApuracao(
						i,
						dataApuracao,
						Status.APURADO );
				}
				final List<Ocorrencias> iLogs = ImmutableList.<Ocorrencias> copyOf( locaLogs );
				logs.put(
					dataApuracao,
					iLogs );
			}
			catch ( final Exception ex )
			{
				logs.put(
					dataApuracao,
					ImmutableList.<Ocorrencias> of( new Ocorrencias( ex.getMessage(), getStackTrace( ex ) ) ) );
				atualizarDataApuracao(
					i,
					dataApuracao,
					Status.NAO_APURADO );
			}
		}
	}

	private void atualizarDataApuracao(
		final int i,
		final DataApuracao dataApuracao,
		final Status status )
	{
		dataApuracao.setStatus( status );
		getDatas().add(
			i,
			dataApuracao );
	}
	
	@FXML
	public void gerarRelatorios(
		final ActionEvent event )
	{
		getRelatorioForm().showAndWait();
	}

	@FXML
	public void importar(
		final ActionEvent event )
	{
		final FileChooser fileChooser = new FileChooser();
		final FileChooser.ExtensionFilter extFilter =
			new FileChooser.ExtensionFilter( "Excel 2007 Files (*.xlsx)", "*.xlsx" );
		fileChooser.getExtensionFilters().add(
			extFilter );

		PersonalConfig personalConfig = personalConfigDao.getCurrentConfig();

		if ( personalConfig == null )
		{
			personalConfig = new PersonalConfig();
		}

		fileChooser.setInitialDirectory( new File( personalConfig.getDefaultFolder() ) );

		final File file = fileChooser.showOpenDialog( mainPanel.getScene().getWindow() );

		if ( file != null )
		{
			logs.clear();
			personalConfig.setDefaultFolder( file.getParentFile().getAbsolutePath() );
			personalConfigDao.save( personalConfig );
			atualizarTableView( file );
		}
	}

	private void atualizarTableView(
		final File file )
	{
		datasOriginais.clear();
		datas.clear();

		datasOriginais.addAll( new ImportadorDataApuracao().importarDatas( file ) );
		
		Collections.reverse( datasOriginais );
		
		if ( datasOriginais.isEmpty() )
		{
			setDatas( FXCollections.<DataApuracao> emptyObservableList() );
			getTblDatasApuracao().setItems(
				getDatas() );
		}
		else
		{
			final ObservableList<DataApuracao> datasObservaveis =
				FXCollections.observableArrayList( new ArrayList( datasOriginais.size() ) );
			
			datasObservaveis.addAll( datasOriginais );
			setDatas( datasObservaveis );
			getTblDatasApuracao().setItems(
				getDatas() );
		}
	}

	@FXML
	public void configurar(
		final ActionEvent event )
	{
		getConfigForm().showAndWait();
	}

	public Button getBtnImportar()
	{
		return btnImportar;
	}

	public void setBtnImportar(
		final Button btnImportar )
	{
		this.btnImportar = btnImportar;
	}

	public AnchorPane getMainPanel()
	{
		return mainPanel;
	}

	public void setMainPanel(
		final AnchorPane mainPanel )
	{
		this.mainPanel = mainPanel;
	}

	public TableView<DataApuracao> getTblDatasApuracao()
	{
		return tblDatasApuracao;
	}

	public void setTblDatasApuracao(
		final TableView<DataApuracao> tblDatasApuracao )
	{
		this.tblDatasApuracao = tblDatasApuracao;
	}

	public ObservableList<DataApuracao> getDatas()
	{
		return datas;
	}

	public void setDatas(
		final ObservableList<DataApuracao> datas )
	{
		this.datas = datas;
	}

	public Stage getConfigForm()
	{
		return configForm;
	}

	public void setConfigForm(
		final Stage configBdForm )
	{
		this.configForm = configBdForm;
	}

	public List<DataApuracao> getDatasOriginais()
	{
		return datasOriginais;
	}

	public ChoiceBox<String> getCmbTipoApuracao()
	{
		return cmbTipoApuracao;
	}

	public void setCmbTipoApuracao(
		final ChoiceBox<String> cmbTipoApuracao )
	{
		this.cmbTipoApuracao = cmbTipoApuracao;
	}

	public TipoApuracao getTipoApuracao()
	{
		return tipoApuracao;
	}

	public void setTipoApuracao(
		final TipoApuracao tipoApuracao )
	{
		this.tipoApuracao = tipoApuracao;
	}

	public TextArea getTxtOcorrencias()
	{
		return txtOcorrencias;
	}

	public void setTxtOcorrencias(
		final TextArea txtOcorrencias )
	{
		this.txtOcorrencias = txtOcorrencias;
	}

	private String getStackTrace(
		final Exception ex )
	{
		final StringWriter sw = new StringWriter();

		final PrintWriter pw = new PrintWriter( sw );

		ex.printStackTrace( pw );

		return sw.toString();
	}

	public void setRelatorioForm(
		final Stage relatorioForm )
	{
		this.relatorioForm = relatorioForm;
	}
	
	
	public Stage getRelatorioForm()
	{
		return relatorioForm;
	}
	
	public ConfigDao getConfigDao()
	{
		return configDao;
	}

	
	public void setConfigDao(
		final ConfigDao configDao )
	{
		this.configDao = configDao;
	}

	
	public ResourceBundle getResources()
	{
		return resources;
	}

	
	public void setResources(
		final ResourceBundle resources )
	{
		this.resources = resources;
	}

	
	public URL getLocation()
	{
		return location;
	}

	
	public void setLocation(
		final URL location )
	{
		this.location = location;
	}

}

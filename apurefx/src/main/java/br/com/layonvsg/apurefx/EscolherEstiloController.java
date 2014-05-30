package br.com.layonvsg.apurefx;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import br.com.layonvsg.apurefx.model.Tema;
import br.com.layonvsg.apurefx.servico.GerenciadorTemas;

public class EscolherEstiloController
{

	private GerenciadorTemas gerenciadorTemas;
	
	@FXML
	private ResourceBundle resources;

	@FXML
	private URL location;

	@FXML
	private Button btnCancel;

	@FXML
	private Button btnOk;

	@FXML
	private ChoiceBox<String> chBoxTema;

	@FXML
	private HBox containerBotoesControle;

	@FXML
	private GridPane containerMudarEstilo;

	@FXML
	private Label lblDetalhes;

	@FXML
	private Label lblMensagem;

	private Tema temaEscolhido;

	@FXML
	void initialize()
	{
		checkPreconditions();
		configurarComboTemas();
		configurarAcaoBotoesControleMudarTema();

	}

	private void checkPreconditions()
	{
		assert btnCancel != null : "fx:id=\"btnCancel\" was not injected: check your FXML file 'EscolherEstiloDialog.fxml'.";
		assert btnOk != null : "fx:id=\"btnOk\" was not injected: check your FXML file 'EscolherEstiloDialog.fxml'.";
		assert chBoxTema != null : "fx:id=\"chBoxTema\" was not injected: check your FXML file 'EscolherEstiloDialog.fxml'.";
		assert containerBotoesControle != null : "fx:id=\"containerBotoesControle\" was not injected: check your FXML file 'EscolherEstiloDialog.fxml'.";
		assert containerMudarEstilo != null : "fx:id=\"containerMudarEstilo\" was not injected: check your FXML file 'EscolherEstiloDialog.fxml'.";
		assert lblDetalhes != null : "fx:id=\"lblDetalhes\" was not injected: check your FXML file 'EscolherEstiloDialog.fxml'.";
		assert lblMensagem != null : "fx:id=\"lblMensagem\" was not injected: check your FXML file 'EscolherEstiloDialog.fxml'.";
	}

	private void configurarAcaoBotoesControleMudarTema()
	{
		if ( getBtnOk() == null )
		{
			setBtnOk( new Button( resources.getString( "escolherEstilo.button.ok" ) ) );
		}

		if ( getBtnCancel() == null )
		{
			setBtnCancel( new Button( resources.getString( "escolherEstilo.button.cancelar" ) ) );
		}

		getBtnOk().setOnAction(
			new EventHandler<ActionEvent>()
			{

				@Override
				public void handle(
					final ActionEvent arg0 )
				{
					if( gerenciadorTemas != null )
					{
						gerenciadorTemas.aplicarTema( getTemaEscolhido() );
					}
					
					containerMudarEstilo.getScene().getWindow().hide();
					
				};
			} );

		getBtnCancel().setOnAction(
			new EventHandler<ActionEvent>()
			{

				@Override
				public void handle(
					final ActionEvent arg0 )
				{
					containerMudarEstilo.getScene().getWindow().hide();
				}

			} );

	}

	private void configurarComboTemas()
	{

		final List<String> descricoesTema = new ArrayList<String>( 2 );

		for ( final Tema tema : Tema.values() )
		{
			descricoesTema.add( tema.getDescricao() );
		}

		if ( getChBoxTema() == null )
		{
			setChBoxTema( new ChoiceBox<String>() );
		}

		getChBoxTema().setItems(
			FXCollections.observableArrayList( descricoesTema ) );
		getChBoxTema().getSelectionModel().selectFirst();
		
		getChBoxTema().getSelectionModel().selectedIndexProperty().addListener(
			new ChangeListener<Number>()
			{

				@Override
				public void changed(
					final ObservableValue< ? extends Number> arg0,
					final Number value,
					final Number new_value )
				{
					setTemaEscolhido( Tema.values()[( Integer ) new_value] );
				};
			} );
	}

	public Button getBtnCancel()
	{
		return btnCancel;
	}

	public void setBtnCancel(
		final Button btnCancel )
	{
		this.btnCancel = btnCancel;
	}

	public Button getBtnOk()
	{
		return btnOk;
	}

	public void setBtnOk(
		final Button btnOk )
	{
		this.btnOk = btnOk;
	}

	public ChoiceBox<String> getChBoxTema()
	{
		return chBoxTema;
	}

	public void setChBoxTema(
		final ChoiceBox<String> chBoxTema )
	{
		this.chBoxTema = chBoxTema;
	}

	public Tema getTemaEscolhido()
	{
		return temaEscolhido;
	}

	public void setTemaEscolhido(
		final Tema temaEscolhido )
	{
		this.temaEscolhido = temaEscolhido;
	}

	
	public GerenciadorTemas getGerenciadorTemas()
	{
		return gerenciadorTemas;
	}

	
	public void setGerenciadorTemas(
		final GerenciadorTemas gerenciadorTemas )
	{
		this.gerenciadorTemas = gerenciadorTemas;
	}

}

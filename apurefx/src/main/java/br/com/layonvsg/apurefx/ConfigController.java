package br.com.layonvsg.apurefx;

import java.awt.TextField;

import javafx.fxml.FXML;
import javafx.scene.layout.AnchorPane;
import br.com.layonvsg.apurefx.dao.ConfigDao;
import br.com.layonvsg.apurefx.dto.ConfigInfo;

public class ConfigController
{

	private ConfigInfo configInfo = new ConfigInfo();

	private ConfigDao configDao = new ConfigDao();

	@FXML
	private AnchorPane configForm;

	@FXML
	private TextField txtHost;

	@FXML
	private TextField txtPorta;

	public ConfigController()
	{
		super();
	}

	@FXML
	public void initialize()
	{
		setConfigInfo( getConfigDao().obterConfigInfoVigente() );
		getTxtHost().setText(
			getConfigInfo().getHost() );
		getTxtPorta().setText(
			getConfigInfo().getPorta() );
	}

	public void cancelar()
	{
		getConfigForm().getScene().getWindow().hide();
	}

	public void salvar()
	{
		try
		{
			getConfigDao().salvar(
				getConfigInfo() );
			getConfigForm().getScene().getWindow().hide();
		}
		catch ( final Exception ex )
		{
			throw new RuntimeException( ex );
		}

	}

	public ConfigInfo getConfigInfo()
	{
		return configInfo;
	}

	public void setConfigInfo(
		final ConfigInfo dataBaseInfo )
	{
		this.configInfo = dataBaseInfo;
	}

	public AnchorPane getConfigForm()
	{
		return configForm;
	}

	public void setConfigForm(
		final AnchorPane configForm )
	{
		this.configForm = configForm;
	}

	public ConfigDao getConfigDao()
	{
		return configDao;
	}

	public void setConfigDao(
		final ConfigDao configBDDao )
	{
		this.configDao = configBDDao;
	}

	public TextField getTxtHost()
	{
		return txtHost;
	}

	public void setTxtHost(
		final TextField txtHost )
	{
		this.txtHost = txtHost;
	}

	public TextField getTxtPorta()
	{
		return txtPorta;
	}

	public void setTxtPorta(
		final TextField txtPorta )
	{
		this.txtPorta = txtPorta;
	}

}

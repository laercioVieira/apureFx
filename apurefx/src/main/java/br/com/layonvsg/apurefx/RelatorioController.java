package br.com.layonvsg.apurefx;

import java.net.MalformedURLException;
import java.net.URL;
import java.text.MessageFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Locale;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

import org.jboss.logging.Logger;

import br.com.layonvsg.apurefx.dao.ConfigDao;
import br.com.layonvsg.apurefx.dto.ConfigInfo;
import br.com.layonvsg.apurefx.model.MessageType;
import br.com.layonvsg.apurefx.util.LocalizadorResource;
import br.com.temasistemas.java.lang.ext.validation.Precondition;
import br.com.temasistemas.relatorios.ws.adapter.Log;
import br.com.temasistemas.relatorios.ws.adapter.ServicoWebGeracaoRelatorio;
import br.com.temasistemas.relatorios.ws.adapter.ServicoWebGeracaoRelatorioBeanServiceLocator;

public class RelatorioController
{

	@FXML
	private Button btnGerar;

	@FXML
	private Button btnSair;

	@FXML
	private TextField txtDataPregaoFimImportNegoc;

	@FXML
	private TextField txtDataPregaoInicioImportNeg;

	@FXML
	private TextField txtIdClienteImportNeg;

	@FXML
	private TextField txtIdCorretoraImportNeg;

	@FXML
	private TextField txtIdInstituicaoImportNeg;

	private static final Logger LOGGER = Logger.getLogger( RelatorioController.class );

	@FXML
	void gerarRelatorioImportacaoNegociosPorPeriodo(
		final ActionEvent event )
	{
		try
		{
			Precondition.checkNotNullAndNotBlank(
				txtIdClienteImportNeg.getText(),
				"Campo IdCliente" );
			Precondition.checkNotNullAndNotBlank(
				txtIdCorretoraImportNeg.getText(),
				"Campo IdCorretora" );
			Precondition.checkNotNullAndNotBlank(
				txtIdInstituicaoImportNeg.getText(),
				"Campo IdInstituicao" );
			Precondition.checkNotNullAndNotBlank(
				txtDataPregaoInicioImportNeg.getText(),
				"Campo DataPregaoInicio" );
			Precondition.checkNotNullAndNotBlank(
				txtDataPregaoFimImportNegoc.getText(),
				"Campo DataPregaoFim" );

			final Long idCliente = new Long( txtIdClienteImportNeg.getText() );
			final Long idCorretora = new Long( txtIdCorretoraImportNeg.getText() );
			final Long idInstituicao = new Long( txtIdInstituicaoImportNeg.getText() );

			final SimpleDateFormat simpleDateFormat = new SimpleDateFormat( "dd/MM/yyyy", this.localeBrasil );
			final Calendar dataInicio = new GregorianCalendar();
			dataInicio.setTime( simpleDateFormat.parse( txtDataPregaoInicioImportNeg.getText() ) );
			final Calendar dataFim = new GregorianCalendar();
			dataFim.setTime( simpleDateFormat.parse( txtDataPregaoFimImportNegoc.getText() ) );

			final ConfigInfo configInfo = this.getConfigDao().obterConfigInfoVigente();

			final ServicoWebGeracaoRelatorio servico =
				new ServicoWebGeracaoRelatorioBeanServiceLocator()
					.getServicoWebGeracaoRelatorioPort( getURLServico( configInfo ) );

			final Log[] logs = servico.gerarRelatorioNegociosImportados(
				idInstituicao,
				dataInicio,
				dataFim,
				idCorretora,
				idCliente );

			final JanelaMensagem janelaMensagem = JanelaMensagem.getInstance();

			if ( logs != null )
			{
				for ( final Log log : logs )
				{
					janelaMensagem.addMessage(
						MessageType.ERRO,
						"Mensagem: " + log.getMensagem() + "\n" ).addMessage(
						MessageType.ERRO,
						"StackTrace: " + log.getStackTrace() + "\n" );
				}

				if ( janelaMensagem.temMensagens() )
				{
					janelaMensagem.showAndWait();
				}

			}
			else
			{
				janelaMensagem.addMessage(
					MessageType.INFO,
					"PDF exportado com sucesso!" ).showAndWait();
			}

		}
		catch ( final Exception e )
		{
			LOGGER.error(
				e.getMessage(),
				e );
			JanelaMensagem.getInstance().addMessage(
				e ).showAndWait();
		}

	}

	private final Locale localeBrasil = new Locale( "pt", "BR" );

	@FXML
	private URL location;

	@FXML
	private ResourceBundle resource;

	@FXML
	private AnchorPane reportForm;

	@FXML
	private TextField txtDataInicio;

	@FXML
	private TextField txtIdCliente;

	@FXML
	private TextField txtDataPregao;

	@FXML
	private TextField txtIdCorretora;

	@FXML
	private TextField txtIdInstituicao;

	@FXML
	private TextField txtIdCliOperDerivDia;

	@FXML
	private TextField txtDataPregaoInicioTxRegNeg;

	@FXML
	private TextField txtDataPregaoFimTxRegNeg;

	@FXML
	private TextField txtIdCliTxRegNeg;

	@FXML
	private TextField txtUsarIdClienteTxRegNeg;

	@FXML
	private TextField txtIdInstituicaoTxRegNeg;

	@FXML
	private TextField txtInstituicaoIdMovimentoFinanceiro;

	@FXML
	private TextField txtCorretoraIdMovimentoFinanceiro;

	@FXML
	private TextField txtDataLiquidacaoMovimentoFinanceiro;

	@FXML
	private TextField txtClienteMovimentoFinanceiro;

	private ConfigDao configDao = new ConfigDao();

	@FXML
	public void sair()
	{
		this.getReportForm().getScene().getWindow().hide();
	}

	public AnchorPane getReportForm()
	{
		return this.reportForm;
	}

	public void setReportForm(
		final AnchorPane reportForm )
	{
		this.reportForm = reportForm;
	}

	public void gerarRelatorioOperacoesDerivativosRealizadasDia(
		final ActionEvent event )
		throws Exception
	{
		try
		{
			final ConfigInfo configInfo = this.getConfigDao().obterConfigInfoVigente();

			final ServicoWebGeracaoRelatorio servicoWebGeracaoRelatorio =
				new ServicoWebGeracaoRelatorioBeanServiceLocator().getServicoWebGeracaoRelatorioPort( this
					.getURLServico( configInfo ) );

			final SimpleDateFormat simpleDateFormat = new SimpleDateFormat( "dd/MM/yyyy", this.localeBrasil );
			final Calendar dataPregao = new GregorianCalendar();
			dataPregao.setTime( simpleDateFormat.parse( this.txtDataPregao.getText() ) );
			final Double idCliente = new Double( this.txtIdCliOperDerivDia.getText() );
			final Double idCorretora = new Double( this.txtIdCorretora.getText() );
			final Double idInstituicao = new Double( this.txtIdInstituicao.getText() );

			final Log[] logs = servicoWebGeracaoRelatorio.gerarRelatorioOperacoesDerivativosRealizadasDia(
				idInstituicao,
				dataPregao,
				idCorretora,
				idCliente );

			extractMensagemFromLogs( logs );
		}
		catch ( final Exception exception )
		{
			LOGGER.error(
				exception.getMessage(),
				exception );
			JanelaMensagem.getInstance().addMessage(
				exception ).showAndWait();
		}

	}

	protected void extractMensagemFromLogs(
		final Log[] logs )
	{
		if ( logs == null || logs.length == 0 )
		{
			JanelaMensagem
				.getInstance()
				.addMessage(
					MessageType.INFO,
					"Relatório PDF exportado com sucesso! \n"
						+ "Localização: '"
						+ LocalizadorResource.PATH_PDF_GENERATED_DEFAULT
						+ "'" ).showAndWait();
		}
		else
		{
			for ( final Log log : logs )
			{
				JanelaMensagem.getInstance().addMessage(
					MessageType.ERRO,
					"Houveram ocorrências durante a geração do Relatório PDF. \n" + "Mensagem: " + log.getMensagem() )
					.showAndWait();

			}
		}
	}

	public void gerarRelatorioExtratoConsolidadoDeAtivo(
		final ActionEvent event )
		throws Exception
	{
		try
		{
			final ConfigInfo configInfo = this.getConfigDao().obterConfigInfoVigente();

			final ServicoWebGeracaoRelatorio servicoWebGeracaoRelatorio =
				new ServicoWebGeracaoRelatorioBeanServiceLocator().getServicoWebGeracaoRelatorioPort( this
					.getURLServico( configInfo ) );

			final SimpleDateFormat simpleDateFormat = new SimpleDateFormat( "dd/MM/yyyy", this.localeBrasil );
			final Calendar dataInicio = new GregorianCalendar();
			dataInicio.setTime( simpleDateFormat.parse( this.txtDataInicio.getText() ) );
			final Double idCliente = new Double( this.txtIdCliente.getText() );

			final Log[] logs = servicoWebGeracaoRelatorio.gerarRelatorioExtratoConsolidadoDeAtivos(
				idCliente,
				dataInicio );

			extractMensagemFromLogs( logs );
		}
		catch ( final Exception e )
		{
			LOGGER.error(
				e.getMessage(),
				e );
			JanelaMensagem.getInstance().addMessage(
				e ).showAndWait();
		}
	}

	public void gerarRelatorioAtivoDisponivel(
		final ActionEvent event )
	{

		try
		{
			final ConfigInfo configInfo = this.getConfigDao().obterConfigInfoVigente();

			final ServicoWebGeracaoRelatorio servicoWebGeracaoRelatorio =
				new ServicoWebGeracaoRelatorioBeanServiceLocator().getServicoWebGeracaoRelatorioPort( this
					.getURLServico( configInfo ) );

			final Log[] logs = servicoWebGeracaoRelatorio.gerarRelatorioAtivosDisponiveis();

			extractMensagemFromLogs( logs );
		}
		catch ( final Exception e )
		{
			LOGGER.error(
				e.getMessage(),
				e );
			JanelaMensagem.getInstance().addMessage(
				e ).showAndWait();
		}

	}

	public ConfigDao getConfigDao()
	{
		return this.configDao;
	}

	public void setConfigDao(
		final ConfigDao configDao )
	{
		this.configDao = configDao;
	}

	protected URL getURLServico(
		final ConfigInfo configInfo )
		throws MalformedURLException
	{
		return new URL( MessageFormat.format(
			"http://{0}:{1}/relatorio-webservice-adapters/ServicoWebGeracaoRelatorio",
			configInfo.getHost(),
			configInfo.getPorta() ) );
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

	public ResourceBundle getResource()
	{
		return resource;
	}

	public void setResource(
		final ResourceBundle resource )
	{
		this.resource = resource;
	}
}

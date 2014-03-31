package br.com.layonvsg.apurefx;

import java.net.MalformedURLException;
import java.net.URL;
import java.rmi.RemoteException;
import java.text.MessageFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Locale;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

import javax.xml.rpc.ServiceException;

import br.com.temasistemas.derivativos.dao.ConfigDao;
import br.com.temasistemas.derivativos.dto.ConfigInfo;
import br.com.temasistemas.relatorios.ws.adapter.ServicoWebGeracaoRelatorio;
import br.com.temasistemas.relatorios.ws.adapter.ServicoWebGeracaoRelatorioBeanServiceLocator;

public class RelatorioController
{

    private final Locale localeBrasil = new Locale("pt", "BR");

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

    public void sair() {

        this.getReportForm().getScene().getWindow().hide();
    }

    public AnchorPane getReportForm() {

        return this.reportForm;
    }

    public void setReportForm(
            final AnchorPane reportForm) {

        this.reportForm = reportForm;
    }

    public void gerarRelatorioOperacoesDerivativosRealizadasDia(
            final ActionEvent event) throws Exception {

        final ConfigInfo configInfo = this.getConfigDao().obterConfigInfoVigente();
        try {

            final ServicoWebGeracaoRelatorio servicoWebGeracaoRelatorio =
                    new ServicoWebGeracaoRelatorioBeanServiceLocator()
                            .getServicoWebGeracaoRelatorioPort(this.getURLServico(configInfo));

            final SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy",
                    this.localeBrasil);
            final Calendar dataPregao = new GregorianCalendar();
            dataPregao.setTime(simpleDateFormat.parse(this.txtDataPregao.getText()));
            final Double idCliente = new Double(this.txtIdCliOperDerivDia.getText());
            final Double idCorretora = new Double(this.txtIdCorretora.getText());
            final Double idInstituicao = new Double(this.txtIdInstituicao.getText());
            servicoWebGeracaoRelatorio.gerarRelatorioOperacoesDerivativosRealizadasDia(
                    idInstituicao, dataPregao, idCorretora, idCliente);
        } catch (final ServiceException e) {

            throw new RuntimeException(
                    "Ocorreu um erro inesperado na tentativa de uso do ServicoWebGeracaoRelatorio");
        } catch (final RemoteException e) {

            throw new RuntimeException(
                    "Ocorreu um erro inesperado na tentativa de uso do ServicoWebGeracaoRelatorio");
        } catch (final MalformedURLException e) {

            throw new RuntimeException(
                    "Ocorreu um erro inesperado na tentativa de uso do ServicoWebGeracaoRelatorio");
        }
    }

    public void gerarRelatorioExtratoConsolidadoDeAtivo(
            final ActionEvent event) throws Exception
    {
        final ConfigInfo configInfo = this.getConfigDao().obterConfigInfoVigente();
        try {

            final ServicoWebGeracaoRelatorio servicoWebGeracaoRelatorio =
                    new ServicoWebGeracaoRelatorioBeanServiceLocator()
                            .getServicoWebGeracaoRelatorioPort(this.getURLServico(configInfo));

            final SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy",
                    this.localeBrasil);
            final Calendar dataInicio = new GregorianCalendar();
            dataInicio.setTime(simpleDateFormat.parse(this.txtDataInicio.getText()));
            final Double idCliente = new Double(this.txtIdCliente.getText());
            servicoWebGeracaoRelatorio.gerarRelatorioExtratoConsolidadoDeAtivos(idCliente,
                    dataInicio);
        } catch (final ServiceException e) {

            throw new RuntimeException(
                    "Ocorreu um erro inesperado na tentativa de uso do ServicoWebGeracaoRelatorio");
        } catch (final RemoteException e) {

            throw new RuntimeException(
                    "Ocorreu um erro inesperado na tentativa de uso do ServicoWebGeracaoRelatorio");
        } catch (final MalformedURLException e) {

            throw new RuntimeException(
                    "Ocorreu um erro inesperado na tentativa de uso do ServicoWebGeracaoRelatorio");
        }
    }

    public void gerarRelatorioAtivoDisponivel(
            final ActionEvent event)
    {

        final ConfigInfo configInfo = this.getConfigDao().obterConfigInfoVigente();
        try
        {
            final ServicoWebGeracaoRelatorio servicoWebGeracaoRelatorio =
                    new ServicoWebGeracaoRelatorioBeanServiceLocator()
                            .getServicoWebGeracaoRelatorioPort(this.getURLServico(configInfo));

            servicoWebGeracaoRelatorio.gerarRelatorioAtivosDisponiveis();
        } catch (final ServiceException e)
        {
            throw new RuntimeException(
                    "Ocorreu um erro inesperado na tentativa de uso do ServicoWebGeracaoRelatorio");
        } catch (final RemoteException e)
        {
            throw new RuntimeException(
                    "Ocorreu um erro inesperado na tentativa de uso do ServicoWebGeracaoRelatorio");
        } catch (final MalformedURLException e)
        {
            throw new RuntimeException(
                    "Ocorreu um erro inesperado na tentativa de uso do ServicoWebGeracaoRelatorio");
        }
    }

    public void gerarRelatorioTaxasDeNegociacaoERegistroPorPeriodo(
            final ActionEvent event) throws Exception
    {
        final ConfigInfo configInfo = this.getConfigDao().obterConfigInfoVigente();
        try
        {
            final ServicoWebGeracaoRelatorio servicoWebGeracaoRelatorio =
                    new ServicoWebGeracaoRelatorioBeanServiceLocator()
                            .getServicoWebGeracaoRelatorioPort(this.getURLServico(configInfo));

            final SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy",
                    this.localeBrasil);
            final Calendar dataPregaoInicio = new GregorianCalendar();
            final Calendar dataPregaoFim = new GregorianCalendar();
            dataPregaoInicio.setTime(simpleDateFormat.parse(this.txtDataPregaoInicioTxRegNeg
                    .getText()));
            dataPregaoFim.setTime(simpleDateFormat.parse(this.txtDataPregaoFimTxRegNeg.getText()));
            final Double idCliente = new Double(this.txtIdCliTxRegNeg.getText());
            final Byte usarIdCliente = new Byte(this.txtUsarIdClienteTxRegNeg.getText());
            final Double idInstituicao = new Double(this.txtIdInstituicaoTxRegNeg.getText());
            servicoWebGeracaoRelatorio.gerarRelatorioTaxasDeNegociacaoERegistroOperacaoPeriodo(
                    usarIdCliente, idCliente, idInstituicao, dataPregaoInicio, dataPregaoFim);
        } catch (final ServiceException e)
        {
            throw new RuntimeException(
                    "Ocorreu um erro inesperado na tentativa de uso do ServicoWebGeracaoRelatorio");
        } catch (final RemoteException e)
        {
            throw new RuntimeException(
                    "Ocorreu um erro inesperado na tentativa de uso do ServicoWebGeracaoRelatorio");
        } catch (final MalformedURLException e)
        {
            throw new RuntimeException(
                    "Ocorreu um erro inesperado na tentativa de uso do ServicoWebGeracaoRelatorio");
        }
    }

    public void gerarRelatorioMovimentoFinanceiro(
            final ActionEvent event) throws Exception
    {
        final ConfigInfo configInfo = this.getConfigDao().obterConfigInfoVigente();
        try
        {
            final ServicoWebGeracaoRelatorio servicoWebGeracaoRelatorio =
                    new ServicoWebGeracaoRelatorioBeanServiceLocator()
                            .getServicoWebGeracaoRelatorioPort(this.getURLServico(configInfo));

            final SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy",
                    this.localeBrasil);
            final Calendar dataLiquidacao = new GregorianCalendar();

            dataLiquidacao.setTime(simpleDateFormat.parse(this.txtDataLiquidacaoMovimentoFinanceiro
                    .getText()));
            final long clienteId = new Integer(this.txtClienteMovimentoFinanceiro.getText());
            final long corretoraId = new Byte(this.txtCorretoraIdMovimentoFinanceiro.getText());
            final long instituicaoId = new Integer(this.txtClienteMovimentoFinanceiro.getText());
            dataLiquidacao.setTime(simpleDateFormat.parse((this.txtCorretoraIdMovimentoFinanceiro
                    .getText())));

            servicoWebGeracaoRelatorio.gerarRelatorioMovimentoFinanceiro(instituicaoId,
                    corretoraId, clienteId, dataLiquidacao);
        } catch (final ServiceException e)
        {
            throw new RuntimeException(
                    "Ocorreu um erro inesperado na tentativa de uso do ServicoWebGeracaoRelatorio");
        } catch (final RemoteException e)
        {
            throw new RuntimeException(
                    "Ocorreu um erro inesperado na tentativa de uso do ServicoWebGeracaoRelatorio");
        } catch (final MalformedURLException e)
        {
            throw new RuntimeException(
                    "Ocorreu um erro inesperado na tentativa de uso do ServicoWebGeracaoRelatorio");
        }
    }

    public ConfigDao getConfigDao()
    {
        return this.configDao;
    }

    public void setConfigDao(
            final ConfigDao configDao)
    {
        this.configDao = configDao;
    }

    protected URL getURLServico(
            final ConfigInfo configInfo)
            throws MalformedURLException
    {
        return new URL(MessageFormat.format(
                // "http://{0}:{1}/relatorio-webservices-adapters/ServicoWebGeracaoRelatorio",
                "http://{0}:{1}/relatorio-webservice-adapters/ServicoWebGeracaoRelatorio",
                configInfo.getHost(),
                configInfo.getPorta()));
    }
}

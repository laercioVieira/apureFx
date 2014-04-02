package br.com.layonvsg.relatorios.ws.adapter;

public class ServicoWebGeracaoRelatorioProxy implements br.com.layonvsg.relatorios.ws.adapter.ServicoWebGeracaoRelatorio {
  private String _endpoint = null;
  private br.com.layonvsg.relatorios.ws.adapter.ServicoWebGeracaoRelatorio servicoWebGeracaoRelatorio = null;
  
  public ServicoWebGeracaoRelatorioProxy() {
    _initServicoWebGeracaoRelatorioProxy();
  }
  
  public ServicoWebGeracaoRelatorioProxy(String endpoint) {
    _endpoint = endpoint;
    _initServicoWebGeracaoRelatorioProxy();
  }
  
  private void _initServicoWebGeracaoRelatorioProxy() {
    try {
      servicoWebGeracaoRelatorio = (new br.com.layonvsg.relatorios.ws.adapter.ServicoWebGeracaoRelatorioBeanServiceLocator()).getServicoWebGeracaoRelatorioPort();
      if (servicoWebGeracaoRelatorio != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)servicoWebGeracaoRelatorio)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)servicoWebGeracaoRelatorio)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (servicoWebGeracaoRelatorio != null)
      ((javax.xml.rpc.Stub)servicoWebGeracaoRelatorio)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public br.com.layonvsg.relatorios.ws.adapter.ServicoWebGeracaoRelatorio getServicoWebGeracaoRelatorio() {
    if (servicoWebGeracaoRelatorio == null)
      _initServicoWebGeracaoRelatorioProxy();
    return servicoWebGeracaoRelatorio;
  }
  
  public br.com.layonvsg.relatorios.ws.adapter.Log[] gerarRelatorioExtratoConsolidadoDeAtivos(double idCliente, java.util.Calendar dataInicio) throws java.rmi.RemoteException{
    if (servicoWebGeracaoRelatorio == null)
      _initServicoWebGeracaoRelatorioProxy();
    return servicoWebGeracaoRelatorio.gerarRelatorioExtratoConsolidadoDeAtivos(idCliente, dataInicio);
  }
  
  public br.com.layonvsg.relatorios.ws.adapter.Log[] gerarRelatorioMovimentoFinanceiro(long instituicaoId, long corretoraId, long clienteId, java.util.Calendar dataLiquidacao) throws java.rmi.RemoteException{
    if (servicoWebGeracaoRelatorio == null)
      _initServicoWebGeracaoRelatorioProxy();
    return servicoWebGeracaoRelatorio.gerarRelatorioMovimentoFinanceiro(instituicaoId, corretoraId, clienteId, dataLiquidacao);
  }
  
  public br.com.layonvsg.relatorios.ws.adapter.Log[] gerarRelatorioAtivosDisponiveis() throws java.rmi.RemoteException{
    if (servicoWebGeracaoRelatorio == null)
      _initServicoWebGeracaoRelatorioProxy();
    return servicoWebGeracaoRelatorio.gerarRelatorioAtivosDisponiveis();
  }
  
  public br.com.layonvsg.relatorios.ws.adapter.Log[] gerarRelatorioTaxasDeNegociacaoERegistroOperacaoPeriodo(byte usarIdCliente, double idCliente, double idInstituicao, java.util.Calendar dataPregaoInicio, java.util.Calendar dataPregaoFim) throws java.rmi.RemoteException{
    if (servicoWebGeracaoRelatorio == null)
      _initServicoWebGeracaoRelatorioProxy();
    return servicoWebGeracaoRelatorio.gerarRelatorioTaxasDeNegociacaoERegistroOperacaoPeriodo(usarIdCliente, idCliente, idInstituicao, dataPregaoInicio, dataPregaoFim);
  }
  
  public br.com.layonvsg.relatorios.ws.adapter.Log[] gerarRelatorioOperacoesDerivativosRealizadasDia(double idInstituicao, java.util.Calendar dataPregao, double idCorretora, double idCliente) throws java.rmi.RemoteException{
    if (servicoWebGeracaoRelatorio == null)
      _initServicoWebGeracaoRelatorioProxy();
    return servicoWebGeracaoRelatorio.gerarRelatorioOperacoesDerivativosRealizadasDia(idInstituicao, dataPregao, idCorretora, idCliente);
  }
  
  
}
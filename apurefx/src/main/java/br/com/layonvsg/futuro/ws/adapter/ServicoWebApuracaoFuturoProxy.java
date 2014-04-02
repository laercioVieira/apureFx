package br.com.layonvsg.futuro.ws.adapter;

public class ServicoWebApuracaoFuturoProxy implements br.com.layonvsg.futuro.ws.adapter.ServicoWebApuracaoFuturo {
  private String _endpoint = null;
  private br.com.layonvsg.futuro.ws.adapter.ServicoWebApuracaoFuturo servicoWebApuracaoFuturo = null;
  
  public ServicoWebApuracaoFuturoProxy() {
    _initServicoWebApuracaoFuturoProxy();
  }
  
  public ServicoWebApuracaoFuturoProxy(String endpoint) {
    _endpoint = endpoint;
    _initServicoWebApuracaoFuturoProxy();
  }
  
  private void _initServicoWebApuracaoFuturoProxy() {
    try {
      servicoWebApuracaoFuturo = (new br.com.layonvsg.futuro.ws.adapter.ServicoWebApuracaoFuturoBeanServiceLocator()).getServicoWebApuracaoFuturoPort();
      if (servicoWebApuracaoFuturo != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)servicoWebApuracaoFuturo)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)servicoWebApuracaoFuturo)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (servicoWebApuracaoFuturo != null)
      ((javax.xml.rpc.Stub)servicoWebApuracaoFuturo)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public br.com.layonvsg.futuro.ws.adapter.ServicoWebApuracaoFuturo getServicoWebApuracaoFuturo() {
    if (servicoWebApuracaoFuturo == null)
      _initServicoWebApuracaoFuturoProxy();
    return servicoWebApuracaoFuturo;
  }
  
  public br.com.layonvsg.futuro.ws.adapter.Log[] apurar(java.util.Calendar dataAtual, java.util.Calendar dataAnterior, int instituicaoId) throws java.rmi.RemoteException{
    if (servicoWebApuracaoFuturo == null)
      _initServicoWebApuracaoFuturoProxy();
    return servicoWebApuracaoFuturo.apurar(dataAtual, dataAnterior, instituicaoId);
  }
  
  
}
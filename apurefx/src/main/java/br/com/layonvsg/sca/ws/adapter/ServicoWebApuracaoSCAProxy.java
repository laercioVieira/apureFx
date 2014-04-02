package br.com.layonvsg.sca.ws.adapter;

public class ServicoWebApuracaoSCAProxy implements br.com.layonvsg.sca.ws.adapter.ServicoWebApuracaoSCA {
  private String _endpoint = null;
  private br.com.layonvsg.sca.ws.adapter.ServicoWebApuracaoSCA servicoWebApuracaoSCA = null;
  
  public ServicoWebApuracaoSCAProxy() {
    _initServicoWebApuracaoSCAProxy();
  }
  
  public ServicoWebApuracaoSCAProxy(String endpoint) {
    _endpoint = endpoint;
    _initServicoWebApuracaoSCAProxy();
  }
  
  private void _initServicoWebApuracaoSCAProxy() {
    try {
      servicoWebApuracaoSCA = (new br.com.layonvsg.sca.ws.adapter.ServicoWebApuracaoSCABeanServiceLocator()).getServicoWebApuracaoSCAPort();
      if (servicoWebApuracaoSCA != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)servicoWebApuracaoSCA)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)servicoWebApuracaoSCA)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (servicoWebApuracaoSCA != null)
      ((javax.xml.rpc.Stub)servicoWebApuracaoSCA)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public br.com.layonvsg.sca.ws.adapter.ServicoWebApuracaoSCA getServicoWebApuracaoSCA() {
    if (servicoWebApuracaoSCA == null)
      _initServicoWebApuracaoSCAProxy();
    return servicoWebApuracaoSCA;
  }
  
  public br.com.layonvsg.sca.ws.adapter.Log[] apurar(java.util.Calendar dataAtual, java.util.Calendar dataAnterior, int instituicaoId) throws java.rmi.RemoteException{
    if (servicoWebApuracaoSCA == null)
      _initServicoWebApuracaoSCAProxy();
    return servicoWebApuracaoSCA.apurar(dataAtual, dataAnterior, instituicaoId);
  }
  
  
}
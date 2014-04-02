package br.com.layonvsg.estruturada.ws.adapter;

public class ServicoWebApuracaoEstruturadaProxy implements br.com.layonvsg.estruturada.ws.adapter.ServicoWebApuracaoEstruturada {
  private String _endpoint = null;
  private br.com.layonvsg.estruturada.ws.adapter.ServicoWebApuracaoEstruturada servicoWebApuracaoEstruturada = null;
  
  public ServicoWebApuracaoEstruturadaProxy() {
    _initServicoWebApuracaoEstruturadaProxy();
  }
  
  public ServicoWebApuracaoEstruturadaProxy(String endpoint) {
    _endpoint = endpoint;
    _initServicoWebApuracaoEstruturadaProxy();
  }
  
  private void _initServicoWebApuracaoEstruturadaProxy() {
    try {
      servicoWebApuracaoEstruturada = (new br.com.layonvsg.estruturada.ws.adapter.ServicoWebApuracaoEstruturadaBeanServiceLocator()).getServicoWebApuracaoEstruturadaPort();
      if (servicoWebApuracaoEstruturada != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)servicoWebApuracaoEstruturada)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)servicoWebApuracaoEstruturada)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (servicoWebApuracaoEstruturada != null)
      ((javax.xml.rpc.Stub)servicoWebApuracaoEstruturada)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public br.com.layonvsg.estruturada.ws.adapter.ServicoWebApuracaoEstruturada getServicoWebApuracaoEstruturada() {
    if (servicoWebApuracaoEstruturada == null)
      _initServicoWebApuracaoEstruturadaProxy();
    return servicoWebApuracaoEstruturada;
  }
  
  public br.com.layonvsg.estruturada.ws.adapter.Log[] apurar(java.util.Calendar dataAtual, java.util.Calendar dataAnterior, int instituicaoId) throws java.rmi.RemoteException{
    if (servicoWebApuracaoEstruturada == null)
      _initServicoWebApuracaoEstruturadaProxy();
    return servicoWebApuracaoEstruturada.apurar(dataAtual, dataAnterior, instituicaoId);
  }
  
  
}
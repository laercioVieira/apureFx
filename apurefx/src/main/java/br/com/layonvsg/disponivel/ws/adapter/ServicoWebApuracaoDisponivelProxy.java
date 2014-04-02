package br.com.layonvsg.disponivel.ws.adapter;

public class ServicoWebApuracaoDisponivelProxy implements br.com.layonvsg.disponivel.ws.adapter.ServicoWebApuracaoDisponivel {
  private String _endpoint = null;
  private br.com.layonvsg.disponivel.ws.adapter.ServicoWebApuracaoDisponivel servicoWebApuracaoDisponivel = null;
  
  public ServicoWebApuracaoDisponivelProxy() {
    _initServicoWebApuracaoDisponivelProxy();
  }
  
  public ServicoWebApuracaoDisponivelProxy(String endpoint) {
    _endpoint = endpoint;
    _initServicoWebApuracaoDisponivelProxy();
  }
  
  private void _initServicoWebApuracaoDisponivelProxy() {
    try {
      servicoWebApuracaoDisponivel = (new br.com.layonvsg.disponivel.ws.adapter.ServicoWebApuracaoDisponivelBeanServiceLocator()).getServicoWebApuracaoDisponivelPort();
      if (servicoWebApuracaoDisponivel != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)servicoWebApuracaoDisponivel)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)servicoWebApuracaoDisponivel)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (servicoWebApuracaoDisponivel != null)
      ((javax.xml.rpc.Stub)servicoWebApuracaoDisponivel)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public br.com.layonvsg.disponivel.ws.adapter.ServicoWebApuracaoDisponivel getServicoWebApuracaoDisponivel() {
    if (servicoWebApuracaoDisponivel == null)
      _initServicoWebApuracaoDisponivelProxy();
    return servicoWebApuracaoDisponivel;
  }
  
  public br.com.layonvsg.disponivel.ws.adapter.Log[] apurar(java.util.Calendar dataAtual, java.util.Calendar dataAnterior, int instituicaoId) throws java.rmi.RemoteException{
    if (servicoWebApuracaoDisponivel == null)
      _initServicoWebApuracaoDisponivelProxy();
    return servicoWebApuracaoDisponivel.apurar(dataAtual, dataAnterior, instituicaoId);
  }
  
  
}
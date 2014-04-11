package br.com.layonvsg.opcoes.ws.adapter.futuro;

public class ServicoWebApuracaoOpcaoPadronizadaSobreFuturoProxy implements br.com.layonvsg.opcoes.ws.adapter.futuro.ServicoWebApuracaoOpcaoPadronizadaSobreFuturo {
  private String _endpoint = null;
  private br.com.layonvsg.opcoes.ws.adapter.futuro.ServicoWebApuracaoOpcaoPadronizadaSobreFuturo servicoWebApuracaoOpcaoPadronizadaSobreFuturo = null;
  
  public ServicoWebApuracaoOpcaoPadronizadaSobreFuturoProxy() {
    _initServicoWebApuracaoOpcaoPadronizadaSobreFuturoProxy();
  }
  
  public ServicoWebApuracaoOpcaoPadronizadaSobreFuturoProxy(final String endpoint) {
    _endpoint = endpoint;
    _initServicoWebApuracaoOpcaoPadronizadaSobreFuturoProxy();
  }
  
  private void _initServicoWebApuracaoOpcaoPadronizadaSobreFuturoProxy() {
    try {
      servicoWebApuracaoOpcaoPadronizadaSobreFuturo = (new br.com.layonvsg.opcoes.ws.adapter.futuro.ServicoWebApuracaoOpcaoPadronizadaSobreFuturoBeanServiceLocator()).getServicoWebApuracaoOpcaoPadronizadaSobreFuturoPort();
      if (servicoWebApuracaoOpcaoPadronizadaSobreFuturo != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)servicoWebApuracaoOpcaoPadronizadaSobreFuturo)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)servicoWebApuracaoOpcaoPadronizadaSobreFuturo)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (final javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(final String endpoint) {
    _endpoint = endpoint;
    if (servicoWebApuracaoOpcaoPadronizadaSobreFuturo != null)
      ((javax.xml.rpc.Stub)servicoWebApuracaoOpcaoPadronizadaSobreFuturo)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public br.com.layonvsg.opcoes.ws.adapter.futuro.ServicoWebApuracaoOpcaoPadronizadaSobreFuturo getServicoWebApuracaoOpcaoPadronizadaSobreFuturo() {
    if (servicoWebApuracaoOpcaoPadronizadaSobreFuturo == null)
      _initServicoWebApuracaoOpcaoPadronizadaSobreFuturoProxy();
    return servicoWebApuracaoOpcaoPadronizadaSobreFuturo;
  }
  
  @Override
public br.com.layonvsg.opcoes.ws.adapter.futuro.Log[] apurar(final java.util.Calendar dataAtual, final java.util.Calendar dataAnterior, final int instituicaoId) throws java.rmi.RemoteException{
    if (servicoWebApuracaoOpcaoPadronizadaSobreFuturo == null)
      _initServicoWebApuracaoOpcaoPadronizadaSobreFuturoProxy();
    return servicoWebApuracaoOpcaoPadronizadaSobreFuturo.apurar(dataAtual, dataAnterior, instituicaoId);
  }
  
  
}
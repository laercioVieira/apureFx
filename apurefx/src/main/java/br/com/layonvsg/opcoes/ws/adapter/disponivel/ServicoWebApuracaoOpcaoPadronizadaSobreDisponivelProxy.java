package br.com.layonvsg.opcoes.ws.adapter.disponivel;

public class ServicoWebApuracaoOpcaoPadronizadaSobreDisponivelProxy implements br.com.layonvsg.opcoes.ws.adapter.disponivel.ServicoWebApuracaoOpcaoPadronizadaSobreDisponivel {
  private String _endpoint = null;
  private br.com.layonvsg.opcoes.ws.adapter.disponivel.ServicoWebApuracaoOpcaoPadronizadaSobreDisponivel servicoWebApuracaoOpcaoPadronizadaSobreDisponivel = null;
  
  public ServicoWebApuracaoOpcaoPadronizadaSobreDisponivelProxy() {
    _initServicoWebApuracaoOpcaoPadronizadaSobreDisponivelProxy();
  }
  
  public ServicoWebApuracaoOpcaoPadronizadaSobreDisponivelProxy(final String endpoint) {
    _endpoint = endpoint;
    _initServicoWebApuracaoOpcaoPadronizadaSobreDisponivelProxy();
  }
  
  private void _initServicoWebApuracaoOpcaoPadronizadaSobreDisponivelProxy() {
    try {
      servicoWebApuracaoOpcaoPadronizadaSobreDisponivel = (new br.com.layonvsg.opcoes.ws.adapter.disponivel.ServicoWebApuracaoOpcaoPadronizadaSobreDisponivelBeanServiceLocator()).getServicoWebApuracaoOpcaoPadronizadaSobreDisponivelPort();
      if (servicoWebApuracaoOpcaoPadronizadaSobreDisponivel != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)servicoWebApuracaoOpcaoPadronizadaSobreDisponivel)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)servicoWebApuracaoOpcaoPadronizadaSobreDisponivel)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (final javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(final String endpoint) {
    _endpoint = endpoint;
    if (servicoWebApuracaoOpcaoPadronizadaSobreDisponivel != null)
      ((javax.xml.rpc.Stub)servicoWebApuracaoOpcaoPadronizadaSobreDisponivel)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public br.com.layonvsg.opcoes.ws.adapter.disponivel.ServicoWebApuracaoOpcaoPadronizadaSobreDisponivel getServicoWebApuracaoOpcaoPadronizadaSobreDisponivel() {
    if (servicoWebApuracaoOpcaoPadronizadaSobreDisponivel == null)
      _initServicoWebApuracaoOpcaoPadronizadaSobreDisponivelProxy();
    return servicoWebApuracaoOpcaoPadronizadaSobreDisponivel;
  }
  
  @Override
public br.com.layonvsg.opcoes.ws.adapter.disponivel.Log[] apurar(final java.util.Calendar dataAtual, final java.util.Calendar dataAnterior, final int instituicaoId) throws java.rmi.RemoteException{
    if (servicoWebApuracaoOpcaoPadronizadaSobreDisponivel == null)
      _initServicoWebApuracaoOpcaoPadronizadaSobreDisponivelProxy();
    return servicoWebApuracaoOpcaoPadronizadaSobreDisponivel.apurar(dataAtual, dataAnterior, instituicaoId);
  }
  
  
}
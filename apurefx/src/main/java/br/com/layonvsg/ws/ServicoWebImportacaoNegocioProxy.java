package br.com.layonvsg.ws;

public class ServicoWebImportacaoNegocioProxy implements br.com.layonvsg.ws.ServicoWebImportacaoNegocio {
  private String _endpoint = null;
  private br.com.layonvsg.ws.ServicoWebImportacaoNegocio servicoWebImportacaoNegocio = null;
  
  public ServicoWebImportacaoNegocioProxy() {
    _initServicoWebImportacaoNegocioProxy();
  }
  
  public ServicoWebImportacaoNegocioProxy(String endpoint) {
    _endpoint = endpoint;
    _initServicoWebImportacaoNegocioProxy();
  }
  
  private void _initServicoWebImportacaoNegocioProxy() {
    try {
      servicoWebImportacaoNegocio = (new br.com.layonvsg.ws.ServicoWebImportacaoNegocioBeanServiceLocator()).getServicoWebImportacaoNegocioPort();
      if (servicoWebImportacaoNegocio != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)servicoWebImportacaoNegocio)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)servicoWebImportacaoNegocio)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (servicoWebImportacaoNegocio != null)
      ((javax.xml.rpc.Stub)servicoWebImportacaoNegocio)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public br.com.layonvsg.ws.ServicoWebImportacaoNegocio getServicoWebImportacaoNegocio() {
    if (servicoWebImportacaoNegocio == null)
      _initServicoWebImportacaoNegocioProxy();
    return servicoWebImportacaoNegocio;
  }
  
  public br.com.layonvsg.ws.Log[] importarApartirDe(java.lang.String localizacao, long instituicaoId, java.util.Calendar dataFim) throws java.rmi.RemoteException{
    if (servicoWebImportacaoNegocio == null)
      _initServicoWebImportacaoNegocioProxy();
    return servicoWebImportacaoNegocio.importarApartirDe(localizacao, instituicaoId, dataFim);
  }
  
  
}
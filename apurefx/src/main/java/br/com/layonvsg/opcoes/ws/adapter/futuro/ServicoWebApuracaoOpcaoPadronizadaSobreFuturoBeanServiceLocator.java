/**
 * ServicoWebApuracaoOpcaoPadronizadaSobreFuturoBeanServiceLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package br.com.layonvsg.opcoes.ws.adapter.futuro;

public class ServicoWebApuracaoOpcaoPadronizadaSobreFuturoBeanServiceLocator extends org.apache.axis.client.Service implements br.com.layonvsg.opcoes.ws.adapter.futuro.ServicoWebApuracaoOpcaoPadronizadaSobreFuturoBeanService {

    public ServicoWebApuracaoOpcaoPadronizadaSobreFuturoBeanServiceLocator() {
    }


    public ServicoWebApuracaoOpcaoPadronizadaSobreFuturoBeanServiceLocator(final org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public ServicoWebApuracaoOpcaoPadronizadaSobreFuturoBeanServiceLocator(final java.lang.String wsdlLoc, final javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for ServicoWebApuracaoOpcaoPadronizadaSobreFuturoPort
    private java.lang.String ServicoWebApuracaoOpcaoPadronizadaSobreFuturoPort_address = "http://localhost:8080/derivativos-webservices-adapters/ServicoWebApuracaoOpcaoPadronizadaSobreFuturo";

    @Override
	public java.lang.String getServicoWebApuracaoOpcaoPadronizadaSobreFuturoPortAddress() {
        return ServicoWebApuracaoOpcaoPadronizadaSobreFuturoPort_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String ServicoWebApuracaoOpcaoPadronizadaSobreFuturoPortWSDDServiceName = "ServicoWebApuracaoOpcaoPadronizadaSobreFuturoPort";

    public java.lang.String getServicoWebApuracaoOpcaoPadronizadaSobreFuturoPortWSDDServiceName() {
        return ServicoWebApuracaoOpcaoPadronizadaSobreFuturoPortWSDDServiceName;
    }

    public void setServicoWebApuracaoOpcaoPadronizadaSobreFuturoPortWSDDServiceName(final java.lang.String name) {
        ServicoWebApuracaoOpcaoPadronizadaSobreFuturoPortWSDDServiceName = name;
    }

    @Override
	public br.com.layonvsg.opcoes.ws.adapter.futuro.ServicoWebApuracaoOpcaoPadronizadaSobreFuturo getServicoWebApuracaoOpcaoPadronizadaSobreFuturoPort() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(ServicoWebApuracaoOpcaoPadronizadaSobreFuturoPort_address);
        }
        catch (final java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getServicoWebApuracaoOpcaoPadronizadaSobreFuturoPort(endpoint);
    }

    @Override
	public br.com.layonvsg.opcoes.ws.adapter.futuro.ServicoWebApuracaoOpcaoPadronizadaSobreFuturo getServicoWebApuracaoOpcaoPadronizadaSobreFuturoPort(final java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            final br.com.layonvsg.opcoes.ws.adapter.futuro.ServicoWebApuracaoOpcaoPadronizadaSobreFuturoBeanServiceSoapBindingStub _stub = new br.com.layonvsg.opcoes.ws.adapter.futuro.ServicoWebApuracaoOpcaoPadronizadaSobreFuturoBeanServiceSoapBindingStub(portAddress, this);
            _stub.setPortName(getServicoWebApuracaoOpcaoPadronizadaSobreFuturoPortWSDDServiceName());
            return _stub;
        }
        catch (final org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setServicoWebApuracaoOpcaoPadronizadaSobreFuturoPortEndpointAddress(final java.lang.String address) {
        ServicoWebApuracaoOpcaoPadronizadaSobreFuturoPort_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    @Override
	public java.rmi.Remote getPort(final Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (br.com.layonvsg.opcoes.ws.adapter.futuro.ServicoWebApuracaoOpcaoPadronizadaSobreFuturo.class.isAssignableFrom(serviceEndpointInterface)) {
                final br.com.layonvsg.opcoes.ws.adapter.futuro.ServicoWebApuracaoOpcaoPadronizadaSobreFuturoBeanServiceSoapBindingStub _stub = new br.com.layonvsg.opcoes.ws.adapter.futuro.ServicoWebApuracaoOpcaoPadronizadaSobreFuturoBeanServiceSoapBindingStub(new java.net.URL(ServicoWebApuracaoOpcaoPadronizadaSobreFuturoPort_address), this);
                _stub.setPortName(getServicoWebApuracaoOpcaoPadronizadaSobreFuturoPortWSDDServiceName());
                return _stub;
            }
        }
        catch (final java.lang.Throwable t) {
            throw new javax.xml.rpc.ServiceException(t);
        }
        throw new javax.xml.rpc.ServiceException("There is no stub implementation for the interface:  " + (serviceEndpointInterface == null ? "null" : serviceEndpointInterface.getName()));
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    @Override
	public java.rmi.Remote getPort(final javax.xml.namespace.QName portName, final Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        if (portName == null) {
            return getPort(serviceEndpointInterface);
        }
        final java.lang.String inputPortName = portName.getLocalPart();
        if ("ServicoWebApuracaoOpcaoPadronizadaSobreFuturoPort".equals(inputPortName)) {
            return getServicoWebApuracaoOpcaoPadronizadaSobreFuturoPort();
        }
        else  {
            final java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    @Override
	public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://futuro.adapter.ws.opcoes.temasistemas.com.br/", "ServicoWebApuracaoOpcaoPadronizadaSobreFuturoBeanService");
    }

    private java.util.HashSet ports = null;

    @Override
	public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://futuro.adapter.ws.opcoes.temasistemas.com.br/", "ServicoWebApuracaoOpcaoPadronizadaSobreFuturoPort"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(final java.lang.String portName, final java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("ServicoWebApuracaoOpcaoPadronizadaSobreFuturoPort".equals(portName)) {
            setServicoWebApuracaoOpcaoPadronizadaSobreFuturoPortEndpointAddress(address);
        }
        else 
{ // Unknown Port Name
            throw new javax.xml.rpc.ServiceException(" Cannot set Endpoint Address for Unknown Port" + portName);
        }
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(final javax.xml.namespace.QName portName, final java.lang.String address) throws javax.xml.rpc.ServiceException {
        setEndpointAddress(portName.getLocalPart(), address);
    }

}

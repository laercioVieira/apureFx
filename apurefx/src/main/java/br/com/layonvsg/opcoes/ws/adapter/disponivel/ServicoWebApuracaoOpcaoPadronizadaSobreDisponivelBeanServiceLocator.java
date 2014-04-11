/**
 * ServicoWebApuracaoOpcaoPadronizadaSobreDisponivelBeanServiceLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package br.com.layonvsg.opcoes.ws.adapter.disponivel;

public class ServicoWebApuracaoOpcaoPadronizadaSobreDisponivelBeanServiceLocator extends org.apache.axis.client.Service implements br.com.layonvsg.opcoes.ws.adapter.disponivel.ServicoWebApuracaoOpcaoPadronizadaSobreDisponivelBeanService {

    public ServicoWebApuracaoOpcaoPadronizadaSobreDisponivelBeanServiceLocator() {
    }


    public ServicoWebApuracaoOpcaoPadronizadaSobreDisponivelBeanServiceLocator(final org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public ServicoWebApuracaoOpcaoPadronizadaSobreDisponivelBeanServiceLocator(final java.lang.String wsdlLoc, final javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for ServicoWebApuracaoOpcaoPadronizadaSobreDisponivelPort
    private java.lang.String ServicoWebApuracaoOpcaoPadronizadaSobreDisponivelPort_address = "http://localhost:8080/derivativos-webservices-adapters/ServicoWebApuracaoOpcaoPadronizadaSobreDisponivel";

    @Override
	public java.lang.String getServicoWebApuracaoOpcaoPadronizadaSobreDisponivelPortAddress() {
        return ServicoWebApuracaoOpcaoPadronizadaSobreDisponivelPort_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String ServicoWebApuracaoOpcaoPadronizadaSobreDisponivelPortWSDDServiceName = "ServicoWebApuracaoOpcaoPadronizadaSobreDisponivelPort";

    public java.lang.String getServicoWebApuracaoOpcaoPadronizadaSobreDisponivelPortWSDDServiceName() {
        return ServicoWebApuracaoOpcaoPadronizadaSobreDisponivelPortWSDDServiceName;
    }

    public void setServicoWebApuracaoOpcaoPadronizadaSobreDisponivelPortWSDDServiceName(final java.lang.String name) {
        ServicoWebApuracaoOpcaoPadronizadaSobreDisponivelPortWSDDServiceName = name;
    }

    @Override
	public br.com.layonvsg.opcoes.ws.adapter.disponivel.ServicoWebApuracaoOpcaoPadronizadaSobreDisponivel getServicoWebApuracaoOpcaoPadronizadaSobreDisponivelPort() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(ServicoWebApuracaoOpcaoPadronizadaSobreDisponivelPort_address);
        }
        catch (final java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getServicoWebApuracaoOpcaoPadronizadaSobreDisponivelPort(endpoint);
    }

    @Override
	public br.com.layonvsg.opcoes.ws.adapter.disponivel.ServicoWebApuracaoOpcaoPadronizadaSobreDisponivel getServicoWebApuracaoOpcaoPadronizadaSobreDisponivelPort(final java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            final br.com.layonvsg.opcoes.ws.adapter.disponivel.ServicoWebApuracaoOpcaoPadronizadaSobreDisponivelBeanServiceSoapBindingStub _stub = new br.com.layonvsg.opcoes.ws.adapter.disponivel.ServicoWebApuracaoOpcaoPadronizadaSobreDisponivelBeanServiceSoapBindingStub(portAddress, this);
            _stub.setPortName(getServicoWebApuracaoOpcaoPadronizadaSobreDisponivelPortWSDDServiceName());
            return _stub;
        }
        catch (final org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setServicoWebApuracaoOpcaoPadronizadaSobreDisponivelPortEndpointAddress(final java.lang.String address) {
        ServicoWebApuracaoOpcaoPadronizadaSobreDisponivelPort_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    @Override
	public java.rmi.Remote getPort(final Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (br.com.layonvsg.opcoes.ws.adapter.disponivel.ServicoWebApuracaoOpcaoPadronizadaSobreDisponivel.class.isAssignableFrom(serviceEndpointInterface)) {
                final br.com.layonvsg.opcoes.ws.adapter.disponivel.ServicoWebApuracaoOpcaoPadronizadaSobreDisponivelBeanServiceSoapBindingStub _stub = new br.com.layonvsg.opcoes.ws.adapter.disponivel.ServicoWebApuracaoOpcaoPadronizadaSobreDisponivelBeanServiceSoapBindingStub(new java.net.URL(ServicoWebApuracaoOpcaoPadronizadaSobreDisponivelPort_address), this);
                _stub.setPortName(getServicoWebApuracaoOpcaoPadronizadaSobreDisponivelPortWSDDServiceName());
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
        if ("ServicoWebApuracaoOpcaoPadronizadaSobreDisponivelPort".equals(inputPortName)) {
            return getServicoWebApuracaoOpcaoPadronizadaSobreDisponivelPort();
        }
        else  {
            final java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    @Override
	public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://disponivel.adapter.ws.opcoes.temasistemas.com.br/", "ServicoWebApuracaoOpcaoPadronizadaSobreDisponivelBeanService");
    }

    private java.util.HashSet ports = null;

    @Override
	public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://disponivel.adapter.ws.opcoes.temasistemas.com.br/", "ServicoWebApuracaoOpcaoPadronizadaSobreDisponivelPort"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(final java.lang.String portName, final java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("ServicoWebApuracaoOpcaoPadronizadaSobreDisponivelPort".equals(portName)) {
            setServicoWebApuracaoOpcaoPadronizadaSobreDisponivelPortEndpointAddress(address);
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

/**
 * ServicoWebApuracaoEstruturadaBeanServiceLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package br.com.layonvsg.estruturada.ws.adapter;

public class ServicoWebApuracaoEstruturadaBeanServiceLocator extends org.apache.axis.client.Service implements br.com.layonvsg.estruturada.ws.adapter.ServicoWebApuracaoEstruturadaBeanService {

    public ServicoWebApuracaoEstruturadaBeanServiceLocator() {
    }


    public ServicoWebApuracaoEstruturadaBeanServiceLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public ServicoWebApuracaoEstruturadaBeanServiceLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for ServicoWebApuracaoEstruturadaPort
    private java.lang.String ServicoWebApuracaoEstruturadaPort_address = "http://localhost:8080/estruturada-webservices-adapters/ServicoWebApuracaoEstruturada";

    public java.lang.String getServicoWebApuracaoEstruturadaPortAddress() {
        return ServicoWebApuracaoEstruturadaPort_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String ServicoWebApuracaoEstruturadaPortWSDDServiceName = "ServicoWebApuracaoEstruturadaPort";

    public java.lang.String getServicoWebApuracaoEstruturadaPortWSDDServiceName() {
        return ServicoWebApuracaoEstruturadaPortWSDDServiceName;
    }

    public void setServicoWebApuracaoEstruturadaPortWSDDServiceName(java.lang.String name) {
        ServicoWebApuracaoEstruturadaPortWSDDServiceName = name;
    }

    public br.com.layonvsg.estruturada.ws.adapter.ServicoWebApuracaoEstruturada getServicoWebApuracaoEstruturadaPort() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(ServicoWebApuracaoEstruturadaPort_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getServicoWebApuracaoEstruturadaPort(endpoint);
    }

    public br.com.layonvsg.estruturada.ws.adapter.ServicoWebApuracaoEstruturada getServicoWebApuracaoEstruturadaPort(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            br.com.layonvsg.estruturada.ws.adapter.ServicoWebApuracaoEstruturadaBeanServiceSoapBindingStub _stub = new br.com.layonvsg.estruturada.ws.adapter.ServicoWebApuracaoEstruturadaBeanServiceSoapBindingStub(portAddress, this);
            _stub.setPortName(getServicoWebApuracaoEstruturadaPortWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setServicoWebApuracaoEstruturadaPortEndpointAddress(java.lang.String address) {
        ServicoWebApuracaoEstruturadaPort_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (br.com.layonvsg.estruturada.ws.adapter.ServicoWebApuracaoEstruturada.class.isAssignableFrom(serviceEndpointInterface)) {
                br.com.layonvsg.estruturada.ws.adapter.ServicoWebApuracaoEstruturadaBeanServiceSoapBindingStub _stub = new br.com.layonvsg.estruturada.ws.adapter.ServicoWebApuracaoEstruturadaBeanServiceSoapBindingStub(new java.net.URL(ServicoWebApuracaoEstruturadaPort_address), this);
                _stub.setPortName(getServicoWebApuracaoEstruturadaPortWSDDServiceName());
                return _stub;
            }
        }
        catch (java.lang.Throwable t) {
            throw new javax.xml.rpc.ServiceException(t);
        }
        throw new javax.xml.rpc.ServiceException("There is no stub implementation for the interface:  " + (serviceEndpointInterface == null ? "null" : serviceEndpointInterface.getName()));
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(javax.xml.namespace.QName portName, Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        if (portName == null) {
            return getPort(serviceEndpointInterface);
        }
        java.lang.String inputPortName = portName.getLocalPart();
        if ("ServicoWebApuracaoEstruturadaPort".equals(inputPortName)) {
            return getServicoWebApuracaoEstruturadaPort();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://adapter.ws.estruturada.temasistemas.com.br/", "ServicoWebApuracaoEstruturadaBeanService");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://adapter.ws.estruturada.temasistemas.com.br/", "ServicoWebApuracaoEstruturadaPort"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("ServicoWebApuracaoEstruturadaPort".equals(portName)) {
            setServicoWebApuracaoEstruturadaPortEndpointAddress(address);
        }
        else 
{ // Unknown Port Name
            throw new javax.xml.rpc.ServiceException(" Cannot set Endpoint Address for Unknown Port" + portName);
        }
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(javax.xml.namespace.QName portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        setEndpointAddress(portName.getLocalPart(), address);
    }

}

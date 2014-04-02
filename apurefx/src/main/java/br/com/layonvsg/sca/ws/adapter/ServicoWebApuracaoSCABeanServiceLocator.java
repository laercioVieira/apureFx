/**
 * ServicoWebApuracaoSCABeanServiceLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package br.com.layonvsg.sca.ws.adapter;

public class ServicoWebApuracaoSCABeanServiceLocator extends org.apache.axis.client.Service implements br.com.layonvsg.sca.ws.adapter.ServicoWebApuracaoSCABeanService {

    public ServicoWebApuracaoSCABeanServiceLocator() {
    }


    public ServicoWebApuracaoSCABeanServiceLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public ServicoWebApuracaoSCABeanServiceLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for ServicoWebApuracaoSCAPort
    private java.lang.String ServicoWebApuracaoSCAPort_address = "http://localhost:8080/derivativos-webservices-adapters/ServicoWebApuracaoSCA";

    public java.lang.String getServicoWebApuracaoSCAPortAddress() {
        return ServicoWebApuracaoSCAPort_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String ServicoWebApuracaoSCAPortWSDDServiceName = "ServicoWebApuracaoSCAPort";

    public java.lang.String getServicoWebApuracaoSCAPortWSDDServiceName() {
        return ServicoWebApuracaoSCAPortWSDDServiceName;
    }

    public void setServicoWebApuracaoSCAPortWSDDServiceName(java.lang.String name) {
        ServicoWebApuracaoSCAPortWSDDServiceName = name;
    }

    public br.com.layonvsg.sca.ws.adapter.ServicoWebApuracaoSCA getServicoWebApuracaoSCAPort() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(ServicoWebApuracaoSCAPort_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getServicoWebApuracaoSCAPort(endpoint);
    }

    public br.com.layonvsg.sca.ws.adapter.ServicoWebApuracaoSCA getServicoWebApuracaoSCAPort(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            br.com.layonvsg.sca.ws.adapter.ServicoWebApuracaoSCABeanServiceSoapBindingStub _stub = new br.com.layonvsg.sca.ws.adapter.ServicoWebApuracaoSCABeanServiceSoapBindingStub(portAddress, this);
            _stub.setPortName(getServicoWebApuracaoSCAPortWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setServicoWebApuracaoSCAPortEndpointAddress(java.lang.String address) {
        ServicoWebApuracaoSCAPort_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (br.com.layonvsg.sca.ws.adapter.ServicoWebApuracaoSCA.class.isAssignableFrom(serviceEndpointInterface)) {
                br.com.layonvsg.sca.ws.adapter.ServicoWebApuracaoSCABeanServiceSoapBindingStub _stub = new br.com.layonvsg.sca.ws.adapter.ServicoWebApuracaoSCABeanServiceSoapBindingStub(new java.net.URL(ServicoWebApuracaoSCAPort_address), this);
                _stub.setPortName(getServicoWebApuracaoSCAPortWSDDServiceName());
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
        if ("ServicoWebApuracaoSCAPort".equals(inputPortName)) {
            return getServicoWebApuracaoSCAPort();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://adapter.ws.sca.temasistemas.com.br/", "ServicoWebApuracaoSCABeanService");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://adapter.ws.sca.temasistemas.com.br/", "ServicoWebApuracaoSCAPort"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("ServicoWebApuracaoSCAPort".equals(portName)) {
            setServicoWebApuracaoSCAPortEndpointAddress(address);
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

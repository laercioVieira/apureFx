/**
 * ServicoWebImportacaoNegocioBeanServiceLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package br.com.layonvsg.ws;

public class ServicoWebImportacaoNegocioBeanServiceLocator extends org.apache.axis.client.Service implements br.com.layonvsg.ws.ServicoWebImportacaoNegocioBeanService {

    public ServicoWebImportacaoNegocioBeanServiceLocator() {
    }


    public ServicoWebImportacaoNegocioBeanServiceLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public ServicoWebImportacaoNegocioBeanServiceLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for ServicoWebImportacaoNegocioPort
    private java.lang.String ServicoWebImportacaoNegocioPort_address = "http://localhost:8081/apurefx-extrator/ServicoWebImportacaoNegocio";

    public java.lang.String getServicoWebImportacaoNegocioPortAddress() {
        return ServicoWebImportacaoNegocioPort_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String ServicoWebImportacaoNegocioPortWSDDServiceName = "ServicoWebImportacaoNegocioPort";

    public java.lang.String getServicoWebImportacaoNegocioPortWSDDServiceName() {
        return ServicoWebImportacaoNegocioPortWSDDServiceName;
    }

    public void setServicoWebImportacaoNegocioPortWSDDServiceName(java.lang.String name) {
        ServicoWebImportacaoNegocioPortWSDDServiceName = name;
    }

    public br.com.layonvsg.ws.ServicoWebImportacaoNegocio getServicoWebImportacaoNegocioPort() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(ServicoWebImportacaoNegocioPort_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getServicoWebImportacaoNegocioPort(endpoint);
    }

    public br.com.layonvsg.ws.ServicoWebImportacaoNegocio getServicoWebImportacaoNegocioPort(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            br.com.layonvsg.ws.ServicoWebImportacaoNegocioBeanServiceSoapBindingStub _stub = new br.com.layonvsg.ws.ServicoWebImportacaoNegocioBeanServiceSoapBindingStub(portAddress, this);
            _stub.setPortName(getServicoWebImportacaoNegocioPortWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setServicoWebImportacaoNegocioPortEndpointAddress(java.lang.String address) {
        ServicoWebImportacaoNegocioPort_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (br.com.layonvsg.ws.ServicoWebImportacaoNegocio.class.isAssignableFrom(serviceEndpointInterface)) {
                br.com.layonvsg.ws.ServicoWebImportacaoNegocioBeanServiceSoapBindingStub _stub = new br.com.layonvsg.ws.ServicoWebImportacaoNegocioBeanServiceSoapBindingStub(new java.net.URL(ServicoWebImportacaoNegocioPort_address), this);
                _stub.setPortName(getServicoWebImportacaoNegocioPortWSDDServiceName());
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
        if ("ServicoWebImportacaoNegocioPort".equals(inputPortName)) {
            return getServicoWebImportacaoNegocioPort();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://ws.layonvsg.com.br/", "ServicoWebImportacaoNegocioBeanService");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://ws.layonvsg.com.br/", "ServicoWebImportacaoNegocioPort"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("ServicoWebImportacaoNegocioPort".equals(portName)) {
            setServicoWebImportacaoNegocioPortEndpointAddress(address);
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

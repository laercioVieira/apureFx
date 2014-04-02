/**
 * ServicoWebGeracaoRelatorioBeanServiceLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package br.com.layonvsg.relatorios.ws.adapter;

public class ServicoWebGeracaoRelatorioBeanServiceLocator extends org.apache.axis.client.Service implements br.com.layonvsg.relatorios.ws.adapter.ServicoWebGeracaoRelatorioBeanService {

    public ServicoWebGeracaoRelatorioBeanServiceLocator() {
    }


    public ServicoWebGeracaoRelatorioBeanServiceLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public ServicoWebGeracaoRelatorioBeanServiceLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for ServicoWebGeracaoRelatorioPort
    private java.lang.String ServicoWebGeracaoRelatorioPort_address = "http://localhost:8080/relatorio-webservice-adapters/ServicoWebGeracaoRelatorio";

    public java.lang.String getServicoWebGeracaoRelatorioPortAddress() {
        return ServicoWebGeracaoRelatorioPort_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String ServicoWebGeracaoRelatorioPortWSDDServiceName = "ServicoWebGeracaoRelatorioPort";

    public java.lang.String getServicoWebGeracaoRelatorioPortWSDDServiceName() {
        return ServicoWebGeracaoRelatorioPortWSDDServiceName;
    }

    public void setServicoWebGeracaoRelatorioPortWSDDServiceName(java.lang.String name) {
        ServicoWebGeracaoRelatorioPortWSDDServiceName = name;
    }

    public br.com.layonvsg.relatorios.ws.adapter.ServicoWebGeracaoRelatorio getServicoWebGeracaoRelatorioPort() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(ServicoWebGeracaoRelatorioPort_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getServicoWebGeracaoRelatorioPort(endpoint);
    }

    public br.com.layonvsg.relatorios.ws.adapter.ServicoWebGeracaoRelatorio getServicoWebGeracaoRelatorioPort(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            br.com.layonvsg.relatorios.ws.adapter.ServicoWebGeracaoRelatorioBeanServiceSoapBindingStub _stub = new br.com.layonvsg.relatorios.ws.adapter.ServicoWebGeracaoRelatorioBeanServiceSoapBindingStub(portAddress, this);
            _stub.setPortName(getServicoWebGeracaoRelatorioPortWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setServicoWebGeracaoRelatorioPortEndpointAddress(java.lang.String address) {
        ServicoWebGeracaoRelatorioPort_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (br.com.layonvsg.relatorios.ws.adapter.ServicoWebGeracaoRelatorio.class.isAssignableFrom(serviceEndpointInterface)) {
                br.com.layonvsg.relatorios.ws.adapter.ServicoWebGeracaoRelatorioBeanServiceSoapBindingStub _stub = new br.com.layonvsg.relatorios.ws.adapter.ServicoWebGeracaoRelatorioBeanServiceSoapBindingStub(new java.net.URL(ServicoWebGeracaoRelatorioPort_address), this);
                _stub.setPortName(getServicoWebGeracaoRelatorioPortWSDDServiceName());
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
        if ("ServicoWebGeracaoRelatorioPort".equals(inputPortName)) {
            return getServicoWebGeracaoRelatorioPort();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://adapter.ws.relatorios.temasistemas.com.br/", "ServicoWebGeracaoRelatorioBeanService");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://adapter.ws.relatorios.temasistemas.com.br/", "ServicoWebGeracaoRelatorioPort"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("ServicoWebGeracaoRelatorioPort".equals(portName)) {
            setServicoWebGeracaoRelatorioPortEndpointAddress(address);
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

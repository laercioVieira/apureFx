/**
 * Log.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package br.com.layonvsg.estruturada.ws.adapter;

import br.com.layonvsg.apurefx.model.Ocorrencias;
import br.com.temasistemas.java.lang.ext.hash.HashCoder;

public class Log  implements java.io.Serializable {

	private static final long serialVersionUID = 7639463362747306584L;

	private java.lang.String mensagem;

    private java.lang.String stackTrace;

    public Log() {
    }

    public Log(
           final java.lang.String mensagem,
           final java.lang.String stackTrace) {
           this.mensagem = mensagem;
           this.stackTrace = stackTrace;
    }


    /**
     * Gets the mensagem value for this Log.
     * 
     * @return mensagem
     */
    public java.lang.String getMensagem() {
        return mensagem;
    }


    /**
     * Sets the mensagem value for this Log.
     * 
     * @param mensagem
     */
    public void setMensagem(final java.lang.String mensagem) {
        this.mensagem = mensagem;
    }


    /**
     * Gets the stackTrace value for this Log.
     * 
     * @return stackTrace
     */
    public java.lang.String getStackTrace() {
        return stackTrace;
    }


    /**
     * Sets the stackTrace value for this Log.
     * 
     * @param stackTrace
     */
    public void setStackTrace(final java.lang.String stackTrace) {
        this.stackTrace = stackTrace;
    }

	@Override
	public int hashCode()
	{
		return HashCoder.hash().append(
			mensagem ).append(
			stackTrace ).hashCode();
	}

	@Override
	public boolean equals(
		final Object obj )
	{
		if ( obj instanceof Log )
		{
			final Log other = ( Log ) obj;
			return other.equals( getMensagem() ) && other.equals( getStackTrace() );
		}
		return false;
	}
	
    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Log.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://adapter.ws.estruturada.temasistemas.com.br/", "log"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("mensagem");
        elemField.setXmlName(new javax.xml.namespace.QName("", "mensagem"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("stackTrace");
        elemField.setXmlName(new javax.xml.namespace.QName("", "stackTrace"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
    }

    /**
     * Return type metadata object
     */
    public static org.apache.axis.description.TypeDesc getTypeDesc() {
        return typeDesc;
    }

    /**
     * Get Custom Serializer
     */
    public static org.apache.axis.encoding.Serializer getSerializer(
           final java.lang.String mechType, 
           final java.lang.Class _javaType,  
           final javax.xml.namespace.QName _xmlType) {
        return 
          new  org.apache.axis.encoding.ser.BeanSerializer(
            _javaType, _xmlType, typeDesc);
    }

    /**
     * Get Custom Deserializer
     */
    public static org.apache.axis.encoding.Deserializer getDeserializer(
           final java.lang.String mechType, 
           final java.lang.Class _javaType,  
           final javax.xml.namespace.QName _xmlType) {
        return 
          new  org.apache.axis.encoding.ser.BeanDeserializer(
            _javaType, _xmlType, typeDesc);
    }

    public Ocorrencias toOcorrencia(){
    	return new Ocorrencias( getMensagem(), getStackTrace() );
    }
    
}

/**
 * Log.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package br.com.layonvsg.opcoes.ws.adapter.disponivel;

import br.com.layonvsg.apurefx.model.Ocorrencias;

public class Log  implements java.io.Serializable {
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

    private java.lang.Object __equalsCalc = null;
    @Override
	public synchronized boolean equals(final java.lang.Object obj) {
        if (!(obj instanceof Log)) return false;
        final Log other = (Log) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.mensagem==null && other.getMensagem()==null) || 
             (this.mensagem!=null &&
              this.mensagem.equals(other.getMensagem()))) &&
            ((this.stackTrace==null && other.getStackTrace()==null) || 
             (this.stackTrace!=null &&
              this.stackTrace.equals(other.getStackTrace())));
        __equalsCalc = null;
        return _equals;
    }

    private boolean __hashCodeCalc = false;
    @Override
	public synchronized int hashCode() {
        if (__hashCodeCalc) {
            return 0;
        }
        __hashCodeCalc = true;
        int _hashCode = 1;
        if (getMensagem() != null) {
            _hashCode += getMensagem().hashCode();
        }
        if (getStackTrace() != null) {
            _hashCode += getStackTrace().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Log.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://disponivel.adapter.ws.opcoes.temasistemas.com.br/", "log"));
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
    
    public Ocorrencias toOcorrencia()
  	{
  		return new Ocorrencias( getMensagem(), getStackTrace() );
  	}

}

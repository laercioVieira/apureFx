/**
 * ServicoWebImportacaoNegocio.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package br.com.layonvsg.ws;

public interface ServicoWebImportacaoNegocio extends java.rmi.Remote {
    public br.com.layonvsg.ws.Log[] importarApartirDe(java.lang.String localizacao, long instituicaoId, java.util.Calendar dataFim) throws java.rmi.RemoteException;
}

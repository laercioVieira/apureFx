/**
 * ServicoWebApuracaoOpcaoPadronizadaSobreDisponivel.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package br.com.layonvsg.opcoes.ws.adapter.disponivel;

public interface ServicoWebApuracaoOpcaoPadronizadaSobreDisponivel extends java.rmi.Remote {
    public br.com.layonvsg.opcoes.ws.adapter.disponivel.Log[] apurar(java.util.Calendar dataAtual, java.util.Calendar dataAnterior, int instituicaoId) throws java.rmi.RemoteException;
}

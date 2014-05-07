/**
 * ServicoWebGeracaoRelatorio.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package br.com.temasistemas.relatorios.ws.adapter;

public interface ServicoWebGeracaoRelatorio extends java.rmi.Remote {
    public br.com.temasistemas.relatorios.ws.adapter.Log[] gerarRelatorioExtratoConsolidadoDeAtivos(double idCliente, java.util.Calendar dataInicio) throws java.rmi.RemoteException;
    public br.com.temasistemas.relatorios.ws.adapter.Log[] gerarRelatorioNegociosImportados(long idInstituicao, java.util.Calendar dataPregaoInicio, java.util.Calendar dataPregaoFim, long idCorretora, long idCliente) throws java.rmi.RemoteException;
    public br.com.temasistemas.relatorios.ws.adapter.Log[] gerarRelatorioAtivosDisponiveis() throws java.rmi.RemoteException;
    public br.com.temasistemas.relatorios.ws.adapter.Log[] gerarRelatorioOperacoesDerivativosRealizadasDia(double idInstituicao, java.util.Calendar dataPregao, double idCorretora, double idCliente) throws java.rmi.RemoteException;
}

/**
 * ServicoWebGeracaoRelatorio.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package br.com.layonvsg.relatorios.ws.adapter;

public interface ServicoWebGeracaoRelatorio extends java.rmi.Remote {
    public br.com.layonvsg.relatorios.ws.adapter.Log[] gerarRelatorioExtratoConsolidadoDeAtivos(double idCliente, java.util.Calendar dataInicio) throws java.rmi.RemoteException;
    public br.com.layonvsg.relatorios.ws.adapter.Log[] gerarRelatorioMovimentoFinanceiro(long instituicaoId, long corretoraId, long clienteId, java.util.Calendar dataLiquidacao) throws java.rmi.RemoteException;
    public br.com.layonvsg.relatorios.ws.adapter.Log[] gerarRelatorioAtivosDisponiveis() throws java.rmi.RemoteException;
    public br.com.layonvsg.relatorios.ws.adapter.Log[] gerarRelatorioTaxasDeNegociacaoERegistroOperacaoPeriodo(byte usarIdCliente, double idCliente, double idInstituicao, java.util.Calendar dataPregaoInicio, java.util.Calendar dataPregaoFim) throws java.rmi.RemoteException;
    public br.com.layonvsg.relatorios.ws.adapter.Log[] gerarRelatorioOperacoesDerivativosRealizadasDia(double idInstituicao, java.util.Calendar dataPregao, double idCorretora, double idCliente) throws java.rmi.RemoteException;
}

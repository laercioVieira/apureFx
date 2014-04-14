package br.com.layonvsg.servico;

import java.io.File;

import javax.ejb.Local;

@Local
public interface ServicoImportadorNegocio
{
	String NOME_EJB = "ServicoImportadorNegocio";

	void importarFrom(
		File localizacao );

}

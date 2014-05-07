package br.com.layonvsg.servico;

import java.io.File;

import javax.ejb.Local;

import br.com.temasistemas.data.Data;

@Local
public interface ServicoImportadorNegocio
{
	String NOME_EJB = "ServicoImportadorNegocio";

	void importarFrom(
		final File localizacao,
		final long instituicaoId,
		final Data dataMaxima );

}

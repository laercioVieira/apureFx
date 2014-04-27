package br.com.layonvsg.apurefx.servico;

import javafx.scene.Scene;

import javax.inject.Inject;

import br.com.layonvsg.apurefx.BasicApplicationController;
import br.com.layonvsg.apurefx.model.Tema;
import br.com.temasistemas.java.lang.ext.validation.Precondition;

public class ServicoGerenciadorTemas implements GerenciadorTemas
{

	private final BasicApplicationController basicApplicationController;

	
	@Inject
	public ServicoGerenciadorTemas(
		final BasicApplicationController basicApplicationController )
	{
		this.basicApplicationController = basicApplicationController;
	}

	@Override
	public void aplicarTema(
		final Tema temaEscolhido )
	{
		Precondition.checkNotNull(
			temaEscolhido,
			"temaEscolhido" );

		aplicarTema(
			temaEscolhido,
			basicApplicationController.getContainerPrincipalApp().getScene() );
		aplicarTema(
			temaEscolhido,
			basicApplicationController.getStageMudarEstilo().getScene() );
		aplicarTema(
			temaEscolhido,
			basicApplicationController.getApuracaoStageForm().getScene() );

	}

	protected void aplicarTema(
		final Tema temaEscolhido,
		final Scene scene )
	{

		Precondition.checkNotNull(
			temaEscolhido,
			"temaEscolhido" );

		Precondition.checkNotNull(
			scene,
			"scene" );

		scene.getStylesheets().clear();
		scene.getStylesheets().add(
			temaEscolhido.getURL().toExternalForm() );
	}

}

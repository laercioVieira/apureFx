package br.com.layonvsg.apurefx;

import javax.enterprise.inject.Produces;

import br.com.temasistemas.java.lang.ext.validation.Precondition;


public class BasicApplicationControllerProduce
{

	private final BasicApplicationController basicApplicationController;

	public BasicApplicationControllerProduce(
		final BasicApplicationController basicApplicationController )
	{
		Precondition.checkNotNull(
			basicApplicationController,
			"basicApplicationController" );

		this.basicApplicationController = basicApplicationController;
	}
	
	
	@Produces
	public BasicApplicationController getApplication()
	{
		return this.basicApplicationController;					
	}
	
	
}

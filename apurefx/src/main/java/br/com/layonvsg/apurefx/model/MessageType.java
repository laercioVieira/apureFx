package br.com.layonvsg.apurefx.model;

import javafx.scene.image.Image;
import br.com.layonvsg.apurefx.util.LocalizadorResource;

public enum MessageType
{

	INFO( 1, 
		new Image( 
			LocalizadorResource.getInstance().getImageAsStream( "info.jpg" ) ) ),
	ATTENTION( 2, 
		new Image( 
			LocalizadorResource.getInstance().getImageAsStream( "attention-yellow.png" ) ) ),
	ERRO( 3, 
		new Image( 
			LocalizadorResource.getInstance().getImageAsStream( "erro.png" ) ) );


	private int valor;
	
	private Image imagem;
	
	
	private MessageType(
		final int valor,
		final Image imagem )
	{
		this.valor = valor;
		this.imagem = imagem;
	}

	public Image getImage()
	{
		return imagem;
	}
	
	public int getValor()
	{
		return valor;
	}
	
}

package br.com.layonvsg.apurefx.dao;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

import org.apache.poi.util.IOUtils;

import com.google.common.base.Optional;
import com.google.common.io.Files;

public abstract class BasicDao
{

	protected static final String CAMINHO_MAIN_CONFIG_DIR = "C:\\apuracao";

	public BasicDao()
	{
		super();

		createConfigFolder();

	}

	protected void serialize(
		final Serializable serializable,
		final String caminho )
	{
		ObjectOutputStream oos = null;
		try
		{
			oos = new ObjectOutputStream( new FileOutputStream( new File( caminho ) ) );
			oos.writeObject( serializable );
			oos.flush();
		}
		catch ( final IOException e )
		{
			throw new RuntimeException( e );
		}
		finally
		{
			IOUtils.closeQuietly( oos );
		}

	}

	protected <T extends Serializable> Optional<T> deserialize(
		final String caminho )
	{
		ObjectInputStream ois = null;
		try
		{
			final File caminhoConfig = new File( caminho );

			if ( caminhoConfig.exists() )
			{
				ois = new ObjectInputStream( new FileInputStream( caminhoConfig ) );
				final T serializable = ( T ) ois.readObject();
				return Optional.<T> of( serializable );
			}

			return Optional.<T> absent();
		}
		catch ( final Exception ex )
		{
			throw new RuntimeException( ex );
		}
		finally
		{
			IOUtils.closeQuietly( ois );
		}
	}

	private void createConfigFolder()
	{
		try
		{
			Files.forceMkdir( new File( CAMINHO_MAIN_CONFIG_DIR ) );
		}
		catch ( final Exception ex )
		{
			throw new RuntimeException( ex );
		}
	}

}

package br.com.layonvsg.apurefx.dao;

import br.com.temasistemas.derivativos.dto.ConfigInfo;

import com.google.common.base.Optional;

public class ConfigDao
	extends BasicDao
{

	private static final String CAMINHO_MAIN_CONFIG = BasicDao.CAMINHO_MAIN_CONFIG_DIR.concat( "\\config.ser" );

	public ConfigDao()
	{
		super();

	}

	public void salvar(
		final ConfigInfo dataBaseInfo )
	{
		serialize(
			dataBaseInfo,
			CAMINHO_MAIN_CONFIG );
	}

	public ConfigInfo obterConfigInfoVigente()
	{

		final Optional<ConfigInfo> dataBaseInfo = deserialize( CAMINHO_MAIN_CONFIG );

		if ( dataBaseInfo.isPresent() )
		{
			return dataBaseInfo.get();
		}

		return new ConfigInfo( "localhost", "8080" );

	}
}

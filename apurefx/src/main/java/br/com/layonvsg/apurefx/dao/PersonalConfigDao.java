package br.com.layonvsg.apurefx.dao;

import br.com.temasistemas.derivativos.dto.PersonalConfig;

import com.google.common.base.Optional;

public class PersonalConfigDao
	extends BasicDao
{

	private static final String DATA_FILE = BasicDao.CAMINHO_MAIN_CONFIG_DIR.concat( "\\personalConfig.ser" );

	public PersonalConfigDao()
	{
		super();
	}

	public void save(
		final PersonalConfig personalConfig )
	{
		serialize(
			personalConfig,
			DATA_FILE );
	}

	public PersonalConfig getCurrentConfig()
	{

		final Optional<PersonalConfig> config = deserialize( DATA_FILE );

		return config.orNull();
	}

}

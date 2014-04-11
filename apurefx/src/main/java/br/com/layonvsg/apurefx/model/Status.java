package br.com.layonvsg.apurefx.model;


public enum Status
{
	APURADO{
		@Override
		public String getDescricao()
		{
			return "Apurado com �xito";
		}
		
	}, AGUARDANDO{
		@Override
		public String getDescricao()
		{
			return "Aguardando apura��o...";
		}
	}, APURADO_COM_PROBLEMAS{
		@Override
		public String getDescricao()
		{
			return "Apurado com problemas";
		}
	}, NAO_APURADO{
		@Override
		public String getDescricao()
		{
			return "N�o Apurado";
		}
	},
	APURANDO{
		@Override
		public String getDescricao()
		{
			return "Apurando...";
		}
		
	};
	
	public abstract String getDescricao();
}

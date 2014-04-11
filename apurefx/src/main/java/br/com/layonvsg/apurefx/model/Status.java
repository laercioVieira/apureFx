package br.com.layonvsg.apurefx.model;


public enum Status
{
	APURADO{
		@Override
		public String getDescricao()
		{
			return "Apurado com êxito";
		}
		
	}, AGUARDANDO{
		@Override
		public String getDescricao()
		{
			return "Aguardando apuração...";
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
			return "Não Apurado";
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

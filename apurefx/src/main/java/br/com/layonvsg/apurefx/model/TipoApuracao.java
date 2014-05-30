package br.com.layonvsg.apurefx.model;

import java.net.MalformedURLException;
import java.net.URL;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Locale;

import br.com.layonvsg.apurefx.dto.ConfigInfo;
import br.com.layonvsg.disponivel.ws.adapter.ServicoWebApuracaoDisponivel;
import br.com.layonvsg.disponivel.ws.adapter.ServicoWebApuracaoDisponivelBeanServiceLocator;
import br.com.layonvsg.estruturada.ws.adapter.ServicoWebApuracaoEstruturada;
import br.com.layonvsg.estruturada.ws.adapter.ServicoWebApuracaoEstruturadaBeanServiceLocator;
import br.com.layonvsg.futuro.ws.adapter.Log;
import br.com.layonvsg.futuro.ws.adapter.ServicoWebApuracaoFuturo;
import br.com.layonvsg.futuro.ws.adapter.ServicoWebApuracaoFuturoBeanServiceLocator;
import br.com.layonvsg.opcoes.ws.adapter.disponivel.ServicoWebApuracaoOpcaoPadronizadaSobreDisponivel;
import br.com.layonvsg.opcoes.ws.adapter.disponivel.ServicoWebApuracaoOpcaoPadronizadaSobreDisponivelBeanServiceLocator;
import br.com.layonvsg.opcoes.ws.adapter.futuro.ServicoWebApuracaoOpcaoPadronizadaSobreFuturo;
import br.com.layonvsg.opcoes.ws.adapter.futuro.ServicoWebApuracaoOpcaoPadronizadaSobreFuturoBeanServiceLocator;
import br.com.layonvsg.sca.ws.adapter.ServicoWebApuracaoSCA;
import br.com.layonvsg.sca.ws.adapter.ServicoWebApuracaoSCABeanServiceLocator;


public enum TipoApuracao
{
	FUTURO( "Futuro" )
	{

		@Override
		protected String getTemplateURLServico()
		{
			return "http://{0}:{1}/derivativos-webservices-adapters/ServicoWebApuracaoFuturo";
		}

		@Override
		public List<Ocorrencias> apurar(
			final Date dataAtual,
			final Date dataAnterior,
			final int instituicaoId,
			final ConfigInfo configInfo )
		{

			try
			{

				final ServicoWebApuracaoFuturo servicoWebApuracaoFuturo =
					new ServicoWebApuracaoFuturoBeanServiceLocator()
						.getServicoWebApuracaoFuturoPort( this.getURLServico( configInfo ) );

				final Log[] logs = servicoWebApuracaoFuturo.apurar(
					dateToCalendar( dataAtual ),
					dateToCalendar( dataAnterior ),
					instituicaoId );

				if ( logs == null )
				{
					return new ArrayList<Ocorrencias>( 0 );
				}

				final List<Ocorrencias> listaOcorrencia = new ArrayList<Ocorrencias>( logs.length );

				for ( final Log log : logs )
				{
					listaOcorrencia.add( log.toOcorrencia() );
				}

				return listaOcorrencia;
			}
			catch ( final Exception e )
			{
				throw new RuntimeException(
					"Ocorreu um erro inesperado na tentativa de uso do ServicoWebApuracaoFuturo",
					e );
			}
		}

	},
	DISPONIVEL( "Disponível" )
	{

		@Override
		protected String getTemplateURLServico()
		{
			return "http://{0}:{1}/derivativos-webservices-adapters/ServicoWebApuracaoDisponivel";
		}

		@Override
		public List<Ocorrencias> apurar(
			final Date dataAtual,
			final Date dataAnterior,
			final int instituicaoId,
			final ConfigInfo configInfo )
		{
			try
			{
				final ServicoWebApuracaoDisponivel servicoWebApuracaoDisponivel =
					new ServicoWebApuracaoDisponivelBeanServiceLocator()
						.getServicoWebApuracaoDisponivelPort( this.getURLServico( configInfo ) );

				final br.com.layonvsg.disponivel.ws.adapter.Log[] logs = servicoWebApuracaoDisponivel.apurar(
					dateToCalendar( dataAtual ),
					dateToCalendar( dataAnterior ),
					instituicaoId );

				if ( logs == null )
				{
					return new ArrayList<Ocorrencias>( 0 );
				}

				final List<Ocorrencias> listaOcorrencia = new ArrayList<Ocorrencias>( logs.length );

				for ( final br.com.layonvsg.disponivel.ws.adapter.Log log : logs )
				{
					listaOcorrencia.add( log.toOcorrencia() );
				}

				return listaOcorrencia;

			}
			catch ( final Exception ex )
			{
				throw new RuntimeException(
					"OCorreu um erro inesperado na tentativa de uso do ServicoWebApuracaoDisponivel" );
			}
		}
	},

	OPCAO_PADRONIZADA_SOBRE_DISPONIVEL( "Opção sobre Disponível" )
	{

		@Override
		protected String getTemplateURLServico()
		{
			return "http://{0}:{1}/derivativos-webservices-adapters/ServicoWebApuracaoOpcaoPadronizadaSobreDisponivel";
		}

		@Override
		public List<Ocorrencias> apurar(
			final Date dataAtual,
			final Date dataAnterior,
			final int instituicaoId,
			final ConfigInfo configInfo )
		{
			try
			{
				final ServicoWebApuracaoOpcaoPadronizadaSobreDisponivel servicoWebApuracaoOpcaoPadronizada =
					new ServicoWebApuracaoOpcaoPadronizadaSobreDisponivelBeanServiceLocator()
						.getServicoWebApuracaoOpcaoPadronizadaSobreDisponivelPort( this.getURLServico( configInfo ) );

				final br.com.layonvsg.opcoes.ws.adapter.disponivel.Log[] logs = servicoWebApuracaoOpcaoPadronizada.apurar(
					dateToCalendar( dataAtual ),
					dateToCalendar( dataAnterior ),
					instituicaoId );

				if ( logs == null )
				{
					return new ArrayList<Ocorrencias>( 0 );
				}

				final List<Ocorrencias> listaOcorrencia = new ArrayList<Ocorrencias>( logs.length );

				for ( final br.com.layonvsg.opcoes.ws.adapter.disponivel.Log log : logs )
				{
					listaOcorrencia.add( log.toOcorrencia() );
				}

				return listaOcorrencia;
			}
			catch ( final Exception ex )
			{
				throw new RuntimeException(
					"OCorreu um erro inesperado na tentativa de uso do ServicoWebApuracaoOpcaoPadronizadaSobreFuturo" );
			}
		}

	},
	
	OPCAO_PADRONIZADA_SOBRE_FUTURO( "Opção sobre Futuro" )
	{

		@Override
		protected String getTemplateURLServico()
		{
			return "http://{0}:{1}/derivativos-webservices-adapters/ServicoWebApuracaoOpcaoPadronizadaSobreFuturo";
		}

		@Override
		public List<Ocorrencias> apurar(
			final Date dataAtual,
			final Date dataAnterior,
			final int instituicaoId,
			final ConfigInfo configInfo )
		{
			try
			{
				final ServicoWebApuracaoOpcaoPadronizadaSobreFuturo servicoWebApuracaoOpcaoPadronizada =
					new ServicoWebApuracaoOpcaoPadronizadaSobreFuturoBeanServiceLocator()
						.getServicoWebApuracaoOpcaoPadronizadaSobreFuturoPort( this.getURLServico( configInfo ) );

				final br.com.layonvsg.opcoes.ws.adapter.futuro.Log[] logs = servicoWebApuracaoOpcaoPadronizada.apurar(
					dateToCalendar( dataAtual ),
					dateToCalendar( dataAnterior ),
					instituicaoId );

				if ( logs == null )
				{
					return new ArrayList<Ocorrencias>( 0 );
				}

				final List<Ocorrencias> listaOcorrencia = new ArrayList<Ocorrencias>( logs.length );

				for ( final br.com.layonvsg.opcoes.ws.adapter.futuro.Log log : logs )
				{
					listaOcorrencia.add( log.toOcorrencia() );
				}

				return listaOcorrencia;
			}
			catch ( final Exception ex )
			{
				throw new RuntimeException(
					"OCorreu um erro inesperado na tentativa de uso do ServicoWebApuracaoOpcaoPadronizada Sobre Futuro" );
			}
		}

	},
	
	ESTRUTURADA( "Estruturada" )
	{

		@Override
		public List<Ocorrencias> apurar(
			final Date dataAtual,
			final Date dataAnterior,
			final int instituicaoId,
			final ConfigInfo configInfo )
		{
			try
			{
				final ServicoWebApuracaoEstruturada servicoWebApuracaoEstruturada =
					new ServicoWebApuracaoEstruturadaBeanServiceLocator()
						.getServicoWebApuracaoEstruturadaPort( this.getURLServico( configInfo ) );

				final br.com.layonvsg.estruturada.ws.adapter.Log[] logs = servicoWebApuracaoEstruturada.apurar(
					dateToCalendar( dataAtual ),
					dateToCalendar( dataAnterior ),
					instituicaoId );

				if ( logs == null )
				{
					return new ArrayList<Ocorrencias>( 0 );
				}

				final List<Ocorrencias> listaOcorrencia = new ArrayList<Ocorrencias>( logs.length );

				for ( final br.com.layonvsg.estruturada.ws.adapter.Log log : logs )
				{
					listaOcorrencia.add( log.toOcorrencia() );
				}

				return listaOcorrencia;
			}
			catch ( final Exception ex )
			{
				throw new RuntimeException(
					"OCorreu um erro inesperado na tentativa de uso do ServicoWebApuracaoEstruturada" );
			}
		}

		@Override
		protected String getTemplateURLServico()
		{
			return "http://{0}:{1}/derivativos-webservices-adapters/ServicoWebApuracaoEstruturada";
		}
	},
	
	SCA( "SwapCambialComAjuste" )
	{

		@Override
		public List<Ocorrencias> apurar(
			final Date dataAtual,
			final Date dataAnterior,
			final int instituicaoId,
			final ConfigInfo configInfo )
		{
			try
			{
				final ServicoWebApuracaoSCA servicoWebApuracaoSCA =
					new ServicoWebApuracaoSCABeanServiceLocator()
						.getServicoWebApuracaoSCAPort( this.getURLServico( configInfo ) );

				final br.com.layonvsg.sca.ws.adapter.Log[] logs = servicoWebApuracaoSCA.apurar(
					dateToCalendar( dataAtual ),
					dateToCalendar( dataAnterior ),
					instituicaoId );

				if ( logs == null )
				{
					return new ArrayList<Ocorrencias>( 0 );
				}

				final List<Ocorrencias> listaOcorrencia = new ArrayList<Ocorrencias>( logs.length );

				for ( final br.com.layonvsg.sca.ws.adapter.Log log : logs )
				{
					listaOcorrencia.add( log.toOcorrencia() );
				}

				return listaOcorrencia;
			}
			catch ( final Exception ex )
			{
				throw new RuntimeException(
					"OCorreu um erro inesperado na tentativa de uso do ServicoWebApuracaoSCA" );
			}
		}

		@Override
		protected String getTemplateURLServico()
		{
			return "http://{0}:{1}/derivativos-webservices-adapters/ServicoWebApuracaoSCA";
		}
	};

	private final String descricao;

	private TipoApuracao(
		final String descricao )
	{
		this.descricao = descricao;
	}

	public String getDescricao()
	{
		return this.descricao;
	}

	protected abstract String getTemplateURLServico();

	public abstract List<Ocorrencias> apurar(
		final Date dataAtual,
		final Date dataAnterior,
		final int instituicaoId,
		final ConfigInfo configInfo );

	private static Calendar dateToCalendar(
		final Date data )
	{
		final Calendar calendar = new GregorianCalendar( new Locale( "pt", "BR" ) );
		calendar.setTime( data );
		return calendar;
	}

	protected URL getURLServico(
		final ConfigInfo configInfo )
		throws MalformedURLException
	{
		return new URL( MessageFormat.format(
			this.getTemplateURLServico(),
			configInfo.getHost(),
			configInfo.getPorta() ) );
	}
}

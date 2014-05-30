package br.com.layonvsg.apurefx.importador;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

import org.apache.commons.io.IOUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import br.com.layonvsg.apurefx.model.DataApuracao;
import br.com.layonvsg.apurefx.model.Status;

public class ImportadorDataApuracao
{

	public ImportadorDataApuracao()
	{
		super();
	}

	public List<DataApuracao> importarDatas(
		final File arquivo )
	{
		FileInputStream fis = null;

		final Calendar calendar = Calendar.getInstance( new Locale("pt", "BR") );
		calendar.set( Calendar.DAY_OF_MONTH, 1 );
		calendar.set( Calendar.MONTH, 12 );
		calendar.set( Calendar.YEAR, 1901 );
		try
		{
			Date dataAnterior = calendar.getTime();
			
			final List<DataApuracao> datas = new ArrayList<DataApuracao>( 0 );

			fis = new FileInputStream( arquivo );

			final XSSFWorkbook workBook = new XSSFWorkbook( fis );

			final XSSFSheet xssfSheet = workBook.getSheet( "Datas_Úteis" );

			final Iterator<Row> rows = xssfSheet.iterator();

			while ( rows.hasNext() )
			{
				final Row row = rows.next();

				final Cell cell = row.getCell( 0 );

				if ( cell != null )
				{
					final DataApuracao dataApuracao = new DataApuracao( cell.getDateCellValue(), Status.AGUARDANDO, dataAnterior ); 
					datas.add( dataApuracao );
					dataAnterior = dataApuracao.getData();
				}
			}
			Collections.reverse( datas );
			return datas;
		}
		catch ( final Exception ex )
		{
			throw new RuntimeException( "Ocorreu um erro inesperado na importação das datas de apuração", ex );
		}
		finally
		{

			if ( fis != null )
			{
				IOUtils.closeQuietly( fis );
			}
		}
	}
}

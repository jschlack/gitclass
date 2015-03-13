import java.util.Calendar;
import java.util.TimeZone;
import java.util.GregorianCalendar;
import java.util.Date;
import java.text.SimpleDateFormat;

public class TimeZoneTest {
	public static void main (String args[]) {
		
		try {
			if ( args.length == 0 )
				throw new Exception( "Missing date/time parameter" );

			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
			Date date = format.parse ( args[0] ); 

			TimeZone est = TimeZone.getTimeZone( "America/New_York" );
			Calendar calendar = new GregorianCalendar();
			calendar.setTimeZone( est );
			calendar.setTime( date );
			System.out.println( "EST: " + calendar.get(Calendar.HOUR_OF_DAY) );

			TimeZone gmt = TimeZone.getTimeZone( "GMT" );
			calendar.setTimeZone( gmt );
			System.out.println( "GMT: " + calendar.get(Calendar.HOUR_OF_DAY) );
			
		} catch (Exception ex) {
			System.out.println( "Exception: " + ex.getMessage() );
		}
	}
}

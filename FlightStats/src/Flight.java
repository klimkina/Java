import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.Map;

public class Flight {
	public static final int MINUTES_PER_HOUR = 60;
	String airline;
	String flight;
	String fromCity;
	String toCity;
	LocalDateTime schFromTime;
	LocalDateTime schToTime;
	LocalDateTime actFromTime;
	LocalDateTime actToTime;
	public static Flight readFlight(String[] vals)
	{
		if (vals.length != 8)
			return null;
		Flight flight = new Flight();
		flight.airline = vals[0];
		flight.flight= vals[1];
		flight.fromCity = vals[2];
		flight.toCity = vals[3];
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss");
		try
		{
			flight.schFromTime = LocalDateTime.parse(vals[4], formatter);			
			flight.actFromTime = LocalDateTime.parse(vals[5], formatter);
			flight.schToTime = LocalDateTime.parse(vals[6], formatter);
			flight.actToTime = LocalDateTime.parse(vals[7], formatter);
		}
		catch (DateTimeParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		return flight;
	}
	public long departureDelayMinutes()
	{
		return schFromTime.until(actFromTime, ChronoUnit.MINUTES);
	}
	public long arrivalDelayMinutes()
	{
		return schToTime.until(actToTime, ChronoUnit.MINUTES);
	}
	public long calcDurationMinutes(Map<String, Integer> airportTimes)
	{
		return actFromTime.until(actToTime, ChronoUnit.MINUTES) +
				(airportTimes.getOrDefault(fromCity, 0) - airportTimes.getOrDefault(toCity, 0));
	}
	public String[] getFlightData(Map<String, Integer> airportTimes)
	{
		String[] data = new String[4];
		data[0] = airline + flight;
		data[1] = String.valueOf(departureDelayMinutes());
		data[2] = String.valueOf(arrivalDelayMinutes());
		data[3] = String.valueOf(calcDurationMinutes(airportTimes));
		return data;
	}
}

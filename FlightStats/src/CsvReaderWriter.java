import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import org.junit.jupiter.params.shadow.com.univocity.parsers.csv.CsvWriter;

public class CsvReaderWriter {
	private static final String COMMA_DELIMITER = ",";
	public static List<Flight> readFlights(String path)
	{
		List<Flight> flights = new ArrayList<>();
		try (BufferedReader br = new BufferedReader(new FileReader(path))) {
		    String line;
		    while ((line = br.readLine()) != null) {
		        String[] values = line.split(COMMA_DELIMITER);
		        Flight flight = Flight.readFlight(values);
		        if (flight != null)
		        	flights.add(flight);
		    }
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return flights;
	}
	// what about daylight?
	public static Map<String, Integer> readAirportTimes(String path)
	{
		Map<String, Integer> airportTimes = new HashMap<>();
		try (BufferedReader br = new BufferedReader(new FileReader(path))) {
		    String line;
		    while ((line = br.readLine()) != null) {
		        String[] values = line.split(COMMA_DELIMITER);
		        airportTimes.put(values[0], readMinutesOffset(values[1]));
		    }
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return airportTimes;
	}
	private static int readMinutesOffset(String utc_offset)
	{
		String[] values = utc_offset.split(":");
		int res = Flight.MINUTES_PER_HOUR*Integer.valueOf(values[0]);
		if (values.length > 1)
			res += Integer.valueOf(values[1]);
		return res;
	}
	public static boolean writeFlights(List<Flight> flights, Map<String, Integer> airportTimes, String path) throws IOException
	{
		
		BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(path));        
		for(Flight flight : flights)
		{
			String[] data = flight.getFlightData(airportTimes);
	        bufferedWriter.write(String.join(COMMA_DELIMITER, data));
	        bufferedWriter.newLine();
		}
        bufferedWriter.close();
		return true;
	}
	
	private static final Scanner scanner = new Scanner(System.in);
	public static void main(String[] args) throws IOException {
		//System.out.println("Enter flights file path:");
		String flights_path = "";//scanner.nextLine();
		if (flights_path.isEmpty())
			flights_path = "flights.csv";
		
		//System.out.println("Enter airports time zones file path:");
		String time_zones_path = "";//scanner.nextLine();
		if (time_zones_path.isEmpty())
			time_zones_path = "airports.csv";
		//System.out.println("Enter output file path:");
		String out_path = "";//scanner.nextLine();
		if (out_path.isEmpty())
			out_path = "output.csv";        
		List<Flight> flights = readFlights(flights_path);
		Map<String, Integer> airport_times = readAirportTimes(time_zones_path);
		writeFlights(flights, airport_times, out_path);

        scanner.close();
    }

}

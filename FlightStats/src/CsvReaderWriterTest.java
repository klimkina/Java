import static org.junit.jupiter.api.Assertions.*;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.Test;

class CsvReaderWriterTest {

	@Test
	void testReadFlights() {
		List<Flight> flights = CsvReaderWriter.readFlights("flights.csv");
		assertEquals(flights.size(), 4);
	}

	@Test
	void testReadAirportTimes() {
		Map<String, Integer> airport_times = CsvReaderWriter.readAirportTimes("airports.csv");
		assertEquals(airport_times.size(), 8);
	}

	@Test
	void testWriteFlights() {
		List<Flight> flights = CsvReaderWriter.readFlights("flights.csv");
		Map<String, Integer> airport_times = CsvReaderWriter.readAirportTimes("airports.csv");
		try {
			CsvReaderWriter.writeFlights(flights, airport_times, "output.csv");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		assertEquals(new File("output.csv").length(), 65);
	}

}

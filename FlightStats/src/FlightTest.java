import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.Test;

import org.junit.jupiter.api.BeforeEach;

class FlightTest {
	Flight flight;
	Map<String, Integer> airport_times;
	
	@BeforeEach
	void setup() {
		flight = new Flight();
		airport_times = new HashMap<>();
	}
	void init() {
		flight.airline = "UA";
		flight.flight = "320";
		flight.fromCity = "PDX";
		flight.toCity = "BOS";
		flight.schFromTime = LocalDateTime.of(2015, 12, 31, 7, 45, 55);
		flight.actFromTime = LocalDateTime.of(2015, 12, 31, 17, 55, 55);
		flight.schToTime = LocalDateTime.of(2015, 12, 31, 17, 45, 55);
		flight.actToTime = LocalDateTime.of(2016, 01, 01, 01, 45, 55);
		
		airport_times.put("PDX", -420);
		airport_times.put("BOS", -240);
	}

	@Test
	void testReadFlight() {
		String[] vals = 
				"UA,30,PDX,BOS,2015-01-01T08:00:00,2015-01-01T08:03:00,2015-01-01T16:15:00,2015-01-01T16:25:00".split(",");
		Flight f = Flight.readFlight(vals);
		assertEquals(f.airline, "UA");
		assertEquals(f.flight, "30");
		assertEquals(f.fromCity, "PDX");
		assertEquals(f.toCity, "BOS");
		
		assertEquals(f.schFromTime.getYear(), 2015);
		assertEquals(f.schFromTime.getMonthValue(), 1);
		assertEquals(f.schFromTime.getDayOfMonth(), 1);
		assertEquals(f.schFromTime.getHour(), 8);
		assertEquals(f.schFromTime.getMinute(), 0);
		assertEquals(f.schFromTime.getSecond(), 0);
		
		assertEquals(f.actFromTime.getYear(), 2015);
		assertEquals(f.actFromTime.getMonthValue(), 1);
		assertEquals(f.actFromTime.getDayOfMonth(), 1);
		assertEquals(f.actFromTime.getHour(), 8);
		assertEquals(f.actFromTime.getMinute(), 3);
		assertEquals(f.actFromTime.getSecond(), 0);
		
		assertEquals(f.schToTime.getYear(), 2015);
		assertEquals(f.schToTime.getMonthValue(), 1);
		assertEquals(f.schToTime.getDayOfMonth(), 1);
		assertEquals(f.schToTime.getHour(), 16);
		assertEquals(f.schToTime.getMinute(), 15);
		assertEquals(f.schToTime.getSecond(), 0);
		
		assertEquals(f.actToTime.getYear(), 2015);
		assertEquals(f.actToTime.getMonthValue(), 1);
		assertEquals(f.actToTime.getDayOfMonth(), 1);
		assertEquals(f.actToTime.getHour(), 16);
		assertEquals(f.actToTime.getMinute(), 25);
		assertEquals(f.actToTime.getSecond(), 0);
	}

	@Test
	void departureDelayMinutes() {
		init();
		assertEquals(flight.departureDelayMinutes(), 610);
	}
	@Test
	void arrivalDelayMinutes() {
		init();
		assertEquals(flight.arrivalDelayMinutes(), 480);
	}
	@Test
	void testCalcDurationMinutes() {
		init();
		assertEquals(flight.calcDurationMinutes(airport_times), 290);
	}
	@Test
	void testGetFlightData() {
		init();
		String[] data = flight.getFlightData(airport_times);
		assertEquals(data[0], "UA320");
		assertEquals(data[1], "610");
		assertEquals(data[2], "480");
		assertEquals(data[3], "290");		
	}
}

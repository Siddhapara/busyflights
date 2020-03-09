package com.travix.medusa.busyflights.service;

import java.text.ParseException;
import java.time.LocalDateTime;
import java.time.Month;
import java.util.List;

import org.springframework.stereotype.Component;

import com.travix.medusa.busyflights.domain.ToughJetResponse;

@Component
public class ToughJetRecords {

	public List<ToughJetResponse> getRecords() throws ParseException {
		LocalDateTime arr1 = LocalDateTime.of(2020, Month.MARCH, 10, 19, 30, 40);
		LocalDateTime dep1 = LocalDateTime.of(2020, Month.MARCH, 01, 02, 05, 50);
		LocalDateTime arr2 = LocalDateTime.of(2020, Month.MARCH, 10, 14, 34, 42);
		LocalDateTime dep2 = LocalDateTime.of(2020, Month.MARCH, 01, 02, 45, 32);
		LocalDateTime arr3 = LocalDateTime.of(2020, Month.FEBRUARY, 11, 16, 30, 40);
		LocalDateTime dep3 = LocalDateTime.of(2020, Month.FEBRUARY, 11, 07, 30, 40);
		
		final List<ToughJetResponse> records = List.of(
				new ToughJetResponse("Emirates", 240.60, 10.00, 5.8, "LHR", "BOM", arr1,dep1),
				new ToughJetResponse("AirIndia", 675.60, 11.00, 6.8, "LHR", "BOM", arr2,dep2),
				new ToughJetResponse("Virgin", 380.60, 15.00, 8.8, "BOM", "LHR",arr3, dep3));
		return records;
	}

}

package com.travix.medusa.busyflights.service;

import java.time.LocalDateTime;
import java.time.Month;
import java.util.List;

import org.springframework.stereotype.Component;

import com.travix.medusa.busyflights.domain.CrazyAirResponse;

@Component
public class CrazyAirRecords {
	
    public List<CrazyAirResponse> getRecords() {
    	LocalDateTime arr1 = LocalDateTime.of(2020, Month.MARCH, 10, 12, 30, 40);
		LocalDateTime dep1 = LocalDateTime.of(2020, Month.MARCH, 01, 07, 40, 33);
		LocalDateTime arr2 = LocalDateTime.of(2020, Month.MARCH, 10, 19, 30, 40);
		LocalDateTime dep2 = LocalDateTime.of(2020, Month.MARCH, 01, 13, 33, 25);
		LocalDateTime arr3 = LocalDateTime.of(2020, Month.MARCH, 10, 19, 30, 40);
		LocalDateTime dep3 = LocalDateTime.of(2020, Month.MARCH, 01, 19, 30, 40);
    	
    	 final List<CrazyAirResponse> airRecords = List.of(
    			new CrazyAirResponse("Ryanair",180.50,"E","LHR","BOM",dep1,arr1),
    			new CrazyAirResponse("British Airways",290.50,"B","LHR","BOM",dep2,arr2),
    			new CrazyAirResponse("British Airways",350,"B","BOM","LHR",dep3,arr3));
    	 
    	 return airRecords;
    	
    }

}

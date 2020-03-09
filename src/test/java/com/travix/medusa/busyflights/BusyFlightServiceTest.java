package com.travix.medusa.busyflights;

import static org.junit.Assert.assertEquals;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.ExecutionException;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import com.travix.medusa.busyflights.domain.BusyFlightsRequest;
import com.travix.medusa.busyflights.service.BusyFlightsService;
import com.travix.medusa.busyflights.service.SearchSupplierService;

@RunWith(MockitoJUnitRunner.class)
public class BusyFlightServiceTest {
	
	@InjectMocks
	BusyFlightsService busyFlightService;
	
	@Mock
	SearchSupplierService searchSupplier;
	
	BusyFlightsRequest busyFlightsRequest= new BusyFlightsRequest("LHR","",new Date(),new Date(),1);
	
	@Test
	public void RequestWithEmptyParamters() throws InterruptedException, ExecutionException{
		assertEquals("PLEASE PROVIDE THE CORRECT DETAILS", busyFlightService.search(new BusyFlightsRequest("LHR","",new Date(),new Date(),1)).getBody());
	}
	
	@Test
	public void RequestWithInvalidOriginCode() throws InterruptedException, ExecutionException{
		assertEquals("PLEASE PROVIDE 3-LETTER'S CODE OF ORIGIN/DESTINATION", busyFlightService.search(new BusyFlightsRequest("LHRa","BOM",new Date(),new Date(),1)).getBody());
	}
	
	@Test
	public void RequestWithInvalidReturnDate() throws InterruptedException, ExecutionException, ParseException{
		assertEquals("PLEASE PROVIDE THE VALID RETURN DATE", 
				busyFlightService.search(new BusyFlightsRequest("LHR","B",
						new SimpleDateFormat("yyyy-MM-dd").parse("2020-02-12"),
						new SimpleDateFormat("yyyy-MM-dd").parse("2020-02-05"),1)).getBody());
	}
	
	@Test
	public void RequestWithInvalidDestinationCode() throws InterruptedException, ExecutionException{
		assertEquals("PLEASE PROVIDE 3-LETTER'S CODE OF ORIGIN/DESTINATION", busyFlightService.search(new BusyFlightsRequest("LHR","B",new Date(),new Date(),1)).getBody());
	}
	
	@Test
	public void RequestWithWrongPassengerNumber() throws InterruptedException, ExecutionException{
		assertEquals("PLEASE PROVIDE THE CORRECT DETAILS", busyFlightService.search(new BusyFlightsRequest("LHR","BOM",new Date(),new Date(),0)).getBody());
	}
	

}

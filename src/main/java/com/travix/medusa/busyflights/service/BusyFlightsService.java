package com.travix.medusa.busyflights.service;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.travix.medusa.busyflights.domain.BusyFlightsRequest;
import com.travix.medusa.busyflights.domain.BusyFlightsResponse;
import com.travix.medusa.util.SupplierConst;

@Service
public class BusyFlightsService {

    @Autowired
    private SearchSupplierService searchSupplier;

    public ResponseEntity<?> search(BusyFlightsRequest busyFlightsRequest) throws InterruptedException, ExecutionException{
        List<BusyFlightsResponse> resultsCombined = new LinkedList<>();
        
        ResponseEntity<?> result= validateInputs(busyFlightsRequest);
        if(result.getBody().equals("OK")) {
        	
			Future<List<BusyFlightsResponse>> crazyAirResponse = searchSupplier.search(busyFlightsRequest,SupplierConst.CRAZY_AIR);
			Future<List<BusyFlightsResponse>> toughJetResponse = searchSupplier.search(busyFlightsRequest,SupplierConst.TOUGH_JET);

			while (!(crazyAirResponse.isDone() && toughJetResponse.isDone())) {
				Thread.sleep(10); // 10-millisecond pause between each check
			}

			resultsCombined.addAll(crazyAirResponse.get());
			resultsCombined.addAll(toughJetResponse.get());

			if (!resultsCombined.isEmpty()) {
				resultsCombined.sort(Comparator.comparing(BusyFlightsResponse::getFare));
				return ResponseEntity.ok(resultsCombined);
			}else {
				return new ResponseEntity<Object>("NO RECORDS FOUND FOR GIVEN INFORMATION", HttpStatus.NOT_FOUND);
			}
        
        }else {
        	return result;
        }		
    }
    
    
    public ResponseEntity<?> validateInputs(BusyFlightsRequest busyFlightsRequest) {
    	if (busyFlightsRequest.getOrigin() == "" || busyFlightsRequest.getDestination() == ""
				|| busyFlightsRequest.getDepartureDate() == null || busyFlightsRequest.getReturnDate() == null
				|| busyFlightsRequest.getNumberOfPassengers() <= 0) {

			return new ResponseEntity<Object>("PLEASE PROVIDE THE CORRECT DETAILS", HttpStatus.BAD_REQUEST);
		}else {

			if (busyFlightsRequest.getReturnDate().compareTo(busyFlightsRequest.getDepartureDate()) < 0) 
				return new ResponseEntity<Object>("PLEASE PROVIDE THE VALID RETURN DATE", HttpStatus.BAD_REQUEST);
			else if(busyFlightsRequest.getOrigin().length()>3 ||busyFlightsRequest.getDestination().length()>3)
				return new ResponseEntity<Object>("PLEASE PROVIDE 3-LETTER'S CODE OF ORIGIN/DESTINATION", HttpStatus.BAD_REQUEST);
			else
				return new ResponseEntity<Object>("OK",HttpStatus.OK);
		}
    }
    

}

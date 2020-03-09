package com.travix.medusa.busyflights.service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.travix.medusa.busyflights.domain.CrazyAirRequest;
import com.travix.medusa.busyflights.domain.CrazyAirResponse;
import com.travix.medusa.util.DateConversion;

@Service
public class CrazyAirService {

    @Autowired
    CrazyAirRecords crazyAirRecords;
    
    @Autowired
    DateConversion dateConversion;
    
    public List<CrazyAirResponse> search(CrazyAirRequest crazyAirRequestDTO ){
    	String dep=new SimpleDateFormat("yyyy-MM-dd").format(crazyAirRequestDTO.getDepartureDate());
    	String ret=new SimpleDateFormat("yyyy-MM-dd").format(crazyAirRequestDTO.getReturnDate());
        List<CrazyAirResponse> response = new ArrayList<>();
        response= crazyAirRecords.getRecords().stream()
                .filter(r -> dateConversion.parseDate(r.getDepartureDate()).equals(dep))
                .filter(r -> dateConversion.parseDate(r.getArrivalDate()).equals(ret))
                .filter(r -> r.getDepartureAirportCode().equals(crazyAirRequestDTO.getOrigin()))
                .filter(r -> r.getDestinationAirportCode().equals(crazyAirRequestDTO.getDestination()))
                .collect(Collectors.toList());
        return  response;
  
    }
}
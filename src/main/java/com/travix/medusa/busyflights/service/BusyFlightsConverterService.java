package com.travix.medusa.busyflights.service;

import org.springframework.stereotype.Service;

import com.travix.medusa.busyflights.domain.BusyFlightsRequest;
import com.travix.medusa.busyflights.domain.BusyFlightsResponse;
import com.travix.medusa.busyflights.domain.CrazyAirRequest;
import com.travix.medusa.busyflights.domain.CrazyAirResponse;
import com.travix.medusa.busyflights.domain.ToughJetRequest;
import com.travix.medusa.busyflights.domain.ToughJetResponse;
import com.travix.medusa.util.SupplierConst;

@Service
public class BusyFlightsConverterService {
	

    public ToughJetRequest getToughJetRequestBean(BusyFlightsRequest busyFlightsRequest) {
        ToughJetRequest toughJetRequest = new ToughJetRequest();
        toughJetRequest.setFrom(busyFlightsRequest.getOrigin());
        toughJetRequest.setTo(busyFlightsRequest.getDestination());
        toughJetRequest.setInboundDate(busyFlightsRequest.getDepartureDate());
        toughJetRequest.setOutboundDate(busyFlightsRequest.getReturnDate());
        toughJetRequest.setNumberOfAdults(busyFlightsRequest.getNumberOfPassengers());
        
        return toughJetRequest;
    }

    public CrazyAirRequest getCrazyAirRequestBean(BusyFlightsRequest busyFlightsRequest) {
        CrazyAirRequest crazyAirRequest = new CrazyAirRequest();
        crazyAirRequest.setOrigin(busyFlightsRequest.getOrigin());
        crazyAirRequest.setDestination(busyFlightsRequest.getDestination());
        crazyAirRequest.setDepartureDate(busyFlightsRequest.getDepartureDate());
        crazyAirRequest.setReturnDate(busyFlightsRequest.getReturnDate());
        crazyAirRequest.setPassengerCount(busyFlightsRequest.getNumberOfPassengers());

        return crazyAirRequest;
    }

    public BusyFlightsResponse getBusyFlightResponseBean(ToughJetResponse toughJetResponse) {
        BusyFlightsResponse busyFlightsResponse = new BusyFlightsResponse();
        busyFlightsResponse.setAirline(toughJetResponse.getCarrier());
        busyFlightsResponse.setArrivalDate(toughJetResponse.getInboundDateTime());
        busyFlightsResponse.setDepartureDate(toughJetResponse.getOutboundDateTime());
        busyFlightsResponse.setDepartureAirportCode(toughJetResponse.getDepartureAirportName());
        busyFlightsResponse.setDestinationAirportCode(toughJetResponse.getArrivalAirportName());
        busyFlightsResponse.setFare(toughJetResponse.getBasePrice());
        busyFlightsResponse.setSupplier(SupplierConst.TOUGH_JET);

        return busyFlightsResponse;
    }

    public BusyFlightsResponse getBusyFlightResponseBean(CrazyAirResponse crazyAirResponse) {
        BusyFlightsResponse busyFlightsResponse = new BusyFlightsResponse();
        busyFlightsResponse.setAirline(crazyAirResponse.getAirline());
        busyFlightsResponse.setArrivalDate(crazyAirResponse.getArrivalDate());
        busyFlightsResponse.setDepartureDate(crazyAirResponse.getDepartureDate());
        busyFlightsResponse.setDepartureAirportCode(crazyAirResponse.getDepartureAirportCode());
        busyFlightsResponse.setDestinationAirportCode(crazyAirResponse.getDestinationAirportCode());
        busyFlightsResponse.setFare(crazyAirResponse.getPrice());
        busyFlightsResponse.setSupplier(SupplierConst.CRAZY_AIR);
        return busyFlightsResponse;
    }

}

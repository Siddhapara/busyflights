package com.travix.medusa.busyflights.domain;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public class BusyFlightsRequest {

    private String origin;
    private String destination;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private Date departureDate;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private Date returnDate;
    private int numberOfPassengers;

    
    
    public BusyFlightsRequest() {
		super();
		// TODO Auto-generated constructor stub
	}

	public BusyFlightsRequest(String origin, String destination, Date departureDate, Date returnDate,
			int numberOfPassengers) {
		super();
		this.origin = origin;
		this.destination = destination;
		this.departureDate = departureDate;
		this.returnDate = returnDate;
		this.numberOfPassengers = numberOfPassengers;
	}

	public String getOrigin() {
        return origin;
    }

    public void setOrigin(final String origin) {
        this.origin = origin;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(final String destination) {
        this.destination = destination;
    }

    public Date getDepartureDate() {
        return departureDate;
    }

    public void setDepartureDate(Date departureDate) {
        this.departureDate = departureDate;
    }

    public Date getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(Date returnDate) {
        this.returnDate = returnDate;
    }

    public int getNumberOfPassengers() {
        return numberOfPassengers;
    }

    public void setNumberOfPassengers(int numberOfPassengers) {
        this.numberOfPassengers = numberOfPassengers;
    }
}

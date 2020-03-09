package com.travix.medusa.busyflights.domain;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class CrazyAirRequest {

	private String origin;
	private String destination;

	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date departureDate;

	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date returnDate;
	private int passengerCount;

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

	public int getPassengerCount() {
		return passengerCount;
	}

	public void setPassengerCount(int passengerCount) {
		this.passengerCount = passengerCount;
	}
}

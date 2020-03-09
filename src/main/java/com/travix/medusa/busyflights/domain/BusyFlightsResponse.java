package com.travix.medusa.busyflights.domain;

import java.time.LocalDateTime;
import java.util.Objects;

public class BusyFlightsResponse {

	private String airline;
	private String supplier;
	private Double fare;
	private String departureAirportCode;
	private String destinationAirportCode;
	private LocalDateTime departureDate;
	private LocalDateTime arrivalDate;

	public BusyFlightsResponse() {
	}
	
	

	public BusyFlightsResponse(String airline, String supplier, Double fare, String departureAirportCode,
			String destinationAirportCode, LocalDateTime departureDate, LocalDateTime arrivalDate) {
		super();
		this.airline = airline;
		this.supplier = supplier;
		this.fare = fare;
		this.departureAirportCode = departureAirportCode;
		this.destinationAirportCode = destinationAirportCode;
		this.departureDate = departureDate;
		this.arrivalDate = arrivalDate;
	}



	public String getAirline() {
		return airline;
	}

	public void setAirline(String airline) {
		this.airline = airline;
	}

	public String getSupplier() {
		return supplier;
	}

	public void setSupplier(String supplier) {
		this.supplier = supplier;
	}

	public Double getFare() {
		return fare;
	}

	public void setFare(Double fare) {
		this.fare = fare;
	}

	public String getDepartureAirportCode() {
		return departureAirportCode;
	}

	public void setDepartureAirportCode(String departureAirportCode) {
		this.departureAirportCode = departureAirportCode;
	}

	public String getDestinationAirportCode() {
		return destinationAirportCode;
	}

	public void setDestinationAirportCode(String destinationAirportCode) {
		this.destinationAirportCode = destinationAirportCode;
	}

	public LocalDateTime getDepartureDate() {
		return departureDate;
	}

	public void setDepartureDate(LocalDateTime departureDate) {
		this.departureDate = departureDate;
	}

	public LocalDateTime getArrivalDate() {
		return arrivalDate;
	}

	public void setArrivalDate(LocalDateTime arrivalDate) {
		this.arrivalDate = arrivalDate;
	}

	@Override
	public String toString() {
		return "{" + "airline='" + airline + '\'' + ", supplier='" + supplier + '\'' + ", fare=" + fare
				+ ", departureAirportCode='" + departureAirportCode + '\'' + ", destinationAirportCode='"
				+ destinationAirportCode + '\'' + ", departureDate='" + departureDate + '\'' + ", arrivalDate='"
				+ arrivalDate + '\'' + '}';
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (!(o instanceof BusyFlightsResponse))
			return false;
		BusyFlightsResponse that = (BusyFlightsResponse) o;
		return Objects.equals(airline, that.airline) && Objects.equals(supplier, that.supplier)
				&& Objects.equals(fare, that.fare) && Objects.equals(departureAirportCode, that.departureAirportCode)
				&& Objects.equals(destinationAirportCode, that.destinationAirportCode)
				&& Objects.equals(departureDate, that.departureDate) && Objects.equals(arrivalDate, that.arrivalDate);
	}

	@Override
	public int hashCode() {
		return Objects.hash(airline, supplier, fare, departureAirportCode, destinationAirportCode, departureDate,
				arrivalDate);
	}

}

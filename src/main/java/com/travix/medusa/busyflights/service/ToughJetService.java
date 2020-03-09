package com.travix.medusa.busyflights.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.travix.medusa.busyflights.domain.ToughJetRequest;
import com.travix.medusa.busyflights.domain.ToughJetResponse;
import com.travix.medusa.util.DateConversion;

@Service
public class ToughJetService {

	@Autowired
	ToughJetRecords toughJetRecords;

	@Autowired
	DateConversion dateConversion;

	public List<ToughJetResponse> search(ToughJetRequest toughJetRequestDTO) throws ParseException {

		String dep = new SimpleDateFormat("yyyy-MM-dd").format(toughJetRequestDTO.getInboundDate());
		String arr = new SimpleDateFormat("yyyy-MM-dd").format(toughJetRequestDTO.getOutboundDate());
		List<ToughJetResponse> response = toughJetRecords.getRecords().stream()
				.filter(r -> r.getDepartureAirportName().equals(toughJetRequestDTO.getFrom()))
				.filter(r -> r.getArrivalAirportName().equals(toughJetRequestDTO.getTo()))
				.filter(r -> dateConversion.parseDate(r.getInboundDateTime()).equals(dep))
				.filter(r -> dateConversion.parseDate(r.getOutboundDateTime()).equals(arr))
				.collect(Collectors.toList());

		return response;
	}

}

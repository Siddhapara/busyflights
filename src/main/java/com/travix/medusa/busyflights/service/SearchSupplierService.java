package com.travix.medusa.busyflights.service;

import java.util.Collections;
import java.util.List;
import java.util.concurrent.Future;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Service;

import com.travix.medusa.busyflights.domain.BusyFlightsRequest;
import com.travix.medusa.busyflights.domain.BusyFlightsResponse;
import com.travix.medusa.busyflights.service.supplier.CrazyAirCallerService;
import com.travix.medusa.busyflights.service.supplier.ToughJetCallerService;
import com.travix.medusa.util.SupplierConst;

@Service
public class SearchSupplierService {

    @Autowired
    CrazyAirCallerService crazyAirCallerService;

    @Autowired
    ToughJetCallerService toughJetCallerService;

    private static final Logger LOGGER = LoggerFactory.getLogger(SearchSupplierService.class);

    public Future<List<BusyFlightsResponse>> search(BusyFlightsRequest busyFlightsRequest, String supplier){
        Future<List<BusyFlightsResponse>> results = new AsyncResult<>(Collections.emptyList());
        try {
            switch (supplier){
                case SupplierConst.CRAZY_AIR:
                    results = crazyAirCallerService.search(busyFlightsRequest);
                    break;
                case SupplierConst.TOUGH_JET:
                    results = toughJetCallerService.search(busyFlightsRequest);
                    break;
            }
        } catch (InterruptedException e) {
            LOGGER.error(String.format("Error during searching with supplier %s", supplier), e);
        }
        return results;
    }

}


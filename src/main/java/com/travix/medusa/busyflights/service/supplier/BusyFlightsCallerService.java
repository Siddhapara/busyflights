package com.travix.medusa.busyflights.service.supplier;

import java.util.List;
import java.util.concurrent.Future;

import com.travix.medusa.busyflights.domain.BusyFlightsRequest;
import com.travix.medusa.busyflights.domain.BusyFlightsResponse;

public interface BusyFlightsCallerService {

    Future<List<BusyFlightsResponse>> search(BusyFlightsRequest busyFlightsRequest) throws InterruptedException;

}


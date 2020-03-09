package com.travix.medusa.busyflights.service.supplier;

import java.util.List;
import java.util.concurrent.Future;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.travix.medusa.busyflights.domain.BusyFlightsRequest;
import com.travix.medusa.busyflights.domain.BusyFlightsResponse;
import com.travix.medusa.busyflights.domain.CrazyAirRequest;
import com.travix.medusa.busyflights.domain.CrazyAirResponse;
import com.travix.medusa.busyflights.service.BusyFlightsConverterService;

@Service
public class CrazyAirCallerService implements BusyFlightsCallerService {

    @Value("${supplier.crazyair.url}")
    private String url;

    @Autowired
    private BusyFlightsConverterService busyFlightsConverterService;

    @Override
    @Async
    public Future<List<BusyFlightsResponse>> search(BusyFlightsRequest busyFlightsRequest) throws InterruptedException {
        CrazyAirRequest crazyAirRequest = busyFlightsConverterService.getCrazyAirRequestBean(busyFlightsRequest);

        final RestTemplate restTemplate = new RestTemplate();

        CrazyAirResponse[] crazyAirResponse = restTemplate.postForObject(url,crazyAirRequest, CrazyAirResponse[].class);

        List<BusyFlightsResponse> busyFlightsResponseDTO = Stream.of(crazyAirResponse)
                                .map(r -> busyFlightsConverterService.getBusyFlightResponseBean(r))
                                .collect(Collectors.toList());

        //Artificial delay
        Thread.sleep(1000L);

        return new AsyncResult<>(busyFlightsResponseDTO);
    }

}


package com.travix.medusa.busyflights.controller;

import java.text.ParseException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.travix.medusa.busyflights.domain.ToughJetRequest;
import com.travix.medusa.busyflights.domain.ToughJetResponse;
import com.travix.medusa.busyflights.service.ToughJetService;

import springfox.documentation.annotations.ApiIgnore;

@RequestMapping("/toughJet")
@RestController
@ApiIgnore
public class ToughJetController {

    @Autowired
    private ToughJetService toughJetService;

    @PostMapping(value = "/search",produces = {"application/json"})
    public List<ToughJetResponse> search(@RequestBody ToughJetRequest toughJetRequest) throws ParseException {
        return toughJetService.search(toughJetRequest);
    }

}

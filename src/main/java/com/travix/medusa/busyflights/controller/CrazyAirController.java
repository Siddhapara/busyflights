package com.travix.medusa.busyflights.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.travix.medusa.busyflights.domain.CrazyAirRequest;
import com.travix.medusa.busyflights.domain.CrazyAirResponse;
import com.travix.medusa.busyflights.service.CrazyAirService;

import springfox.documentation.annotations.ApiIgnore;

@RequestMapping("/crazyAir")
@RestController
@ApiIgnore
public class CrazyAirController {

	    @Autowired
	    private CrazyAirService crazyAirService;

	    @PostMapping(value = "/search",produces = {"application/json"}, consumes = {"application/json"})
	    public List<CrazyAirResponse> search(@RequestBody CrazyAirRequest searchDTO) {
	        return crazyAirService.search(searchDTO);
	    }

}

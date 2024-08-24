package com.klauderdias.spring.redis.controller;

import com.klauderdias.spring.redis.cloud.IbgeResponse;
import com.klauderdias.spring.redis.service.IbgeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/ibge")
public class IbgeController {

    @Autowired
    private IbgeService ibgeService;

    @GetMapping
    public ResponseEntity<List<IbgeResponse>> findAllCities(@RequestParam String estado) {
        return ResponseEntity.ok(ibgeService.findAllCities(estado));
    }

}

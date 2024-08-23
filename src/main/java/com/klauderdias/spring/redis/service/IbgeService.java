package com.klauderdias.spring.redis.service;

import com.klauderdias.spring.redis.cloud.Ibge;
import com.klauderdias.spring.redis.cloud.IbgeResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IbgeService {

    @Autowired
    private Ibge ibge;

    @Cacheable(value = "estados", condition = "#estado.equalsIgnoreCase('MG')")
    public List<IbgeResponse> findAllCities(String estado) {
        System.out.println("vai buscar no IBGE: " + estado );
        return ibge.findAllCities(estado);
    }
}
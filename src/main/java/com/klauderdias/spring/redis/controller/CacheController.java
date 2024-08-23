package com.klauderdias.spring.redis.controller;

import com.klauderdias.spring.redis.service.CacheService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/cache")
public class CacheController {

    @Autowired
    private CacheService cacheService;

    @PostMapping
    public void clear(@RequestParam("cacheName") String cacheName) {
        cacheService.evictAllCacheValues(cacheName);
    }

    @PutMapping
    public void atualizar() {
        cacheService.atualizarCacheEmpresas();
    }
}

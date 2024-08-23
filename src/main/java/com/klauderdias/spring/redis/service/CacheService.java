package com.klauderdias.spring.redis.service;

import com.klauderdias.spring.redis.entity.Empresa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.CachePut;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class CacheService {

    @Autowired
    private CacheManager cacheManager;
    @Autowired
    private EmpresaService empresaService;

    //Manual way to clean the cache by cacheName
    public void evictAllCacheValues(String cacheName) {
        Objects.requireNonNull(cacheManager.getCache(cacheName)).clear();
    }

    //Manual way to update the cache("empresas")
    @CachePut("empresas")
    public List<Empresa> manualUpdateCacheEmpresas() {
        return empresaService.findAll();
    }

}

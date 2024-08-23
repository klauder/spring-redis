package com.klauderdias.spring.redis.scheduler;

import lombok.extern.log4j.Log4j2;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.concurrent.TimeUnit;

@Component
@Log4j2
public class CacheScheduler {

    //Automatic way to clean the cache ("empresas")
    @Scheduled(fixedDelay = 60, timeUnit = TimeUnit.SECONDS)
    @CacheEvict("empresas")
    public void limparCacheEmpresas(){
        log.info("Clean cache at: " + LocalDateTime.now());
    }

    //Automatic way to update the cache ("empresas")
    @Scheduled(fixedDelay = 25, timeUnit = TimeUnit.SECONDS)
    @CachePut("empresas")
    public void atualizarCacheEmpresas(){
        log.info("Updated cache at: " + LocalDateTime.now());
    }

}

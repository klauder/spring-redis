package com.klauderdias.spring.redis.scheduler;

import lombok.extern.log4j.Log4j2;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.xml.stream.Location;
import java.time.LocalDateTime;
import java.util.concurrent.TimeUnit;

@Component
@Log4j2
public class CacheScheduler {

    @Scheduled(fixedDelay = 20, timeUnit = TimeUnit.SECONDS)
    @CacheEvict("empresas")
    public void limparCacheEmpresas(){
        log.info("Executado: " + LocalDateTime.now());
    }
}

package com.klauderdias.spring.redis.service;

import com.klauderdias.spring.redis.entity.Empresa;
import com.klauderdias.spring.redis.repository.EmpresaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmpresaService {

    @Autowired
    private EmpresaRepository empresaRepository;

    @Cacheable("empresas")
    public List<Empresa> findAllWithCache() {
        return this.findAll();
    }

    public List<Empresa> findAll() {
        return (List<Empresa>) empresaRepository.findAll();
    }
}

package com.klauderdias.spring.redis.controller;

import com.klauderdias.spring.redis.entity.Empresa;
import com.klauderdias.spring.redis.service.EmpresaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/empresa")
public class EmpresaController {

    @Autowired
    private EmpresaService empresaService;

    @GetMapping
    public ResponseEntity<List<Empresa>> findAll(){
         return ResponseEntity.ok(empresaService.findAllWithCache());
    }

}

package com.estudo.avaliadorcredito.infra.ServiceHttp;

import com.estudo.avaliadorcredito.domain.model.CardClient.CardClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient(value = "card", path = "/card")
public interface CardClientServiceHttp {

    @GetMapping(name = "status")
    public String status();

    @GetMapping(name = "cardClientByCpf",params = "cpf")
    public  ResponseEntity<List<CardClient>> GetCartoesByClient(@RequestParam("cpf") String cpf);

    }

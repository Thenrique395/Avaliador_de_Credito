package com.estudo.avaliadorcredito.infra.ServiceHttp;

import com.estudo.avaliadorcredito.domain.model.DadosClient.DadosClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "client", path = "/client")
public interface ClientServiceHttp {

    @GetMapping
    String status();

    @GetMapping(name = "getClient", params = "cpf")
    ResponseEntity<DadosClient> dataClient(@RequestParam("cpf") String cpf);
}

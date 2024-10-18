package com.estudo.avaliadorcredito.controller;


import com.estudo.avaliadorcredito.application.AvaliadorcreditoService;
import com.estudo.avaliadorcredito.application.DadosClientNotFoundException;
import com.estudo.avaliadorcredito.application.ErrorComunicacaoMicroServicesException;
import com.estudo.avaliadorcredito.domain.model.ClientSituation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Objects;

@RestController
@RequestMapping("avaliator")
@RequiredArgsConstructor
public class avaliadorCreditoController {

    private  final AvaliadorcreditoService avaliadorcreditoService;
    @GetMapping
    public String Status(){
        return "OK";
    }

    @GetMapping(value = "Clientsituation", params = "cpf")
    public ResponseEntity GetClientSituation(@RequestParam("cpf" )String cpf){

        ClientSituation clientSituation = null;
        try {
            clientSituation = avaliadorcreditoService.getClientSituation(cpf);
        } catch (DadosClientNotFoundException e) {
            return  ResponseEntity.notFound().build();

        } catch (ErrorComunicacaoMicroServicesException e) {
            return ResponseEntity.status(Objects.requireNonNull(HttpStatus.resolve(e.getStatus()))).build();
        }

        return  ResponseEntity.ok(clientSituation);
    }
}

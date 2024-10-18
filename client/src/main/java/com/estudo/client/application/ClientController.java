package com.estudo.client.application;

import com.estudo.client.application.representation.ClientSaveRequest;

import com.estudo.client.domians.Client;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.jetbrains.annotations.NotNull;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("client")
@RequiredArgsConstructor
@Slf4j
public class ClientController {

    private  final  ClientService clientService;

    @GetMapping(name = "status")
    public String status(){
        log.info("Obtendo o status do microservice e client");
        return  "Ok";
    }

    @PostMapping
    public ResponseEntity Save(@NotNull @RequestBody ClientSaveRequest clientSaveRequest){
            var client=  clientSaveRequest.toModel();
        clientService.save(client);

        URI headerLocation = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .query("cpf={cpf}")
                .buildAndExpand( client.getCpf())
                .toUri();

        return  ResponseEntity.created(headerLocation).build();
    }

    @GetMapping(name = "getClient", params = "cpf")
    public  ResponseEntity<Client> dataClient(@RequestParam("cpf") String cpf){
        var client = clientService.getByCpf(cpf);

        if (client.isEmpty()){
            return  ResponseEntity.notFound().build();
        }
        return  ResponseEntity.ok(client.get());
    }
}

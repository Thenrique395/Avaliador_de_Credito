package com.estudo.client.application.representation;

import com.estudo.client.domians.Client;
import lombok.Data;

@Data
public class ClientSaveRequest {
    private  String cpf;
    private  String nome;
    private  Integer idade;

    public Client toModel(){
        return  new Client(cpf,nome,idade);
    }
}

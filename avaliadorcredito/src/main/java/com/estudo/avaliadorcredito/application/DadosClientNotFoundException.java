package com.estudo.avaliadorcredito.application;

public class DadosClientNotFoundException extends Exception{

    public  DadosClientNotFoundException(){
        super("Dados do client não encontrados para o CPF informado.");
    }
}

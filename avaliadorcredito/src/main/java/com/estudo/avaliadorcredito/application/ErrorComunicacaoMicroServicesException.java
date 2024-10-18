package com.estudo.avaliadorcredito.application;

import lombok.Getter;

public class ErrorComunicacaoMicroServicesException  extends  Exception{

    @Getter
    private  Integer status;

    public  ErrorComunicacaoMicroServicesException(String msg,Integer status){
    super(msg);
    this.status = status;
}
}

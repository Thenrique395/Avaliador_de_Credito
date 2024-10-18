package com.estudo.card.dto;

import com.estudo.card.domain.BandeiraCartao;
import com.estudo.card.domain.Card;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class CardSaveRequest {

private  String nome;
private BandeiraCartao bandeira;
private BigDecimal renda;
private  BigDecimal limite;

    public Card toModel(){
        return  new Card(nome,bandeira,renda,limite);
    }
}


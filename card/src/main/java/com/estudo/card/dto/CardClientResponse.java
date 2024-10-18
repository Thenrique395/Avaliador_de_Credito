package com.estudo.card.dto;

import com.estudo.card.domain.CardClient;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
public class CardClientResponse {
    private String nome;
    private String bandeira;
    private BigDecimal limiteLiberado;

    public static CardClientResponse fromModel(CardClient cardClient){

        return  new CardClientResponse(
                cardClient.getCard().getNome(),
                cardClient.getCard().getBandeiraCartao().toString(),
                cardClient.getLimite()
        );
    }
}

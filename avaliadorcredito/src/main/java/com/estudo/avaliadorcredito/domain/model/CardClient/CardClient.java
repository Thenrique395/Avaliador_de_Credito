package com.estudo.avaliadorcredito.domain.model.CardClient;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CardClient {
    private  String name;
    private String bandeira;
    private BigDecimal limiteLiberado;
}

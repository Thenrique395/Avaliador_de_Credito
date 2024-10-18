package com.estudo.avaliadorcredito.domain.model;

import com.estudo.avaliadorcredito.domain.model.CardClient.CardClient;
import com.estudo.avaliadorcredito.domain.model.DadosClient.DadosClient;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ClientSituation {

    private DadosClient client;
    private List<CardClient> cards;
}

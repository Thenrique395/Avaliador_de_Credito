package com.estudo.card.domain;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Entity
@Data
@NoArgsConstructor
public class Card {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long id;

    private String nome;

    @Enumerated(EnumType.STRING)
    private BandeiraCartao bandeiraCartao;

    private BigDecimal renda;

    private  BigDecimal limiteBasico;

    public Card(String nome, BandeiraCartao bandeiraCartao, BigDecimal renda, BigDecimal limiteBasico) {
        this.nome = nome;
        this.bandeiraCartao = bandeiraCartao;
        this.renda = renda;
        this.limiteBasico = limiteBasico;
    }
}

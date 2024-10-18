package com.estudo.card.infra.repository;

import com.estudo.card.domain.CardClient;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CardClientRepository  extends JpaRepository<CardClient,Long> {
    List<CardClient> findByCpf(String cpf);
}

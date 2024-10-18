package com.estudo.card.application;

import com.estudo.card.domain.CardClient;
import com.estudo.card.infra.repository.CardClientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CardClientService {
    private final CardClientRepository repository;

    public List<CardClient> listCartoesByCpf(String cpf){
        return repository.findByCpf(cpf);
    }
}

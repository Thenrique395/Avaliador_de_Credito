package com.estudo.client.application;

import com.estudo.client.domians.Client;
import com.estudo.client.infra.repository.ClientRepository;
import jakarta.transaction.Transactional;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ClientService {

    private final ClientRepository clientRepository;

    @Transactional
    public Client save(Client client){
        return  clientRepository.save(client);
    }

    public Optional<Client> getByCpf(String cpf){
        return  clientRepository.findByCpf(cpf);
    }
}

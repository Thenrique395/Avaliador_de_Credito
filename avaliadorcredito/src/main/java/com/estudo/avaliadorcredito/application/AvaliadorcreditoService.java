package com.estudo.avaliadorcredito.application;

import com.estudo.avaliadorcredito.domain.model.CardClient.CardClient;
import com.estudo.avaliadorcredito.domain.model.ClientSituation;
import com.estudo.avaliadorcredito.domain.model.DadosClient.DadosClient;
import com.estudo.avaliadorcredito.infra.ServiceHttp.CardClientServiceHttp;
import com.estudo.avaliadorcredito.infra.ServiceHttp.ClientServiceHttp;
import feign.FeignException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@RequiredArgsConstructor
public class AvaliadorcreditoService {

    private  final ClientServiceHttp clientServiceHttp;
    private final CardClientServiceHttp cardClientServiceHttp;

    public ClientSituation getClientSituation(String cpf) throws DadosClientNotFoundException, ErrorComunicacaoMicroServicesException {
        try {
            ResponseEntity<DadosClient> dataClient = clientServiceHttp.dataClient(cpf);
            ResponseEntity<List<CardClient>> cardClient = cardClientServiceHttp.GetCartoesByClient(cpf);

            return ClientSituation.builder().client(dataClient.getBody())
                    .cards(cardClient.getBody()).build();

        }
        catch (FeignException.FeignClientException ex){
          if (HttpStatus.NOT_FOUND.value() == ex.status()){
              throw  new DadosClientNotFoundException();
          }
          throw new ErrorComunicacaoMicroServicesException(ex.getMessage(),ex.status());
        }
    }
}

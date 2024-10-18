package com.estudo.card.application;

import com.estudo.card.domain.Card;
import com.estudo.card.domain.CardClient;
import com.estudo.card.dto.CardClientResponse;
import com.estudo.card.dto.CardSaveRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("card")
@RequiredArgsConstructor
@Slf4j
public class CardController {

    private  final CardService cardService;
    private  final CardClientService cardClientService;

    @GetMapping(name = "status")
    public String status(){
        log.info("Obtendo o status do microservice e client");
        return  "Ok";
    }

    @PostMapping()
    public ResponseEntity<Card> cadastrar(@RequestBody CardSaveRequest cardSave){
        Card card = cardSave.toModel();
        cardService.save(card);
        return  ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping(name = "cardAll",params = "renda")
    public  ResponseEntity<List<Card>> GetCartoesRendaAte5000(@RequestParam("renda") Long renda){
        List<Card> cartoes = cardService.getCardMenorIgual(renda);
        return  ResponseEntity.ok(cartoes);
    }

    @GetMapping(name = "cardClientByCpf",params = "cpf")
    public  ResponseEntity<List<CardClientResponse>> GetCartoesByClient(@RequestParam("cpf") String cpf){
        List<CardClient> cartoesClient = cardClientService.listCartoesByCpf(cpf);
        List<CardClientResponse> resultList = cartoesClient.stream().map(CardClientResponse::fromModel).collect(Collectors.toList());
        return  ResponseEntity.ok(resultList);
    }
}
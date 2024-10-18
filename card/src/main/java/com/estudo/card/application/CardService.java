package com.estudo.card.application;

import com.estudo.card.domain.Card;
import com.estudo.card.infra.repository.CardRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CardService {

    private final CardRepository cardRepository;

    @Transactional
    public Card save(Card card){
        return  cardRepository.save(card);
    }

    public List<Card> getCardMenorIgual(Long renda){
        var rendaBigDecimal = BigDecimal.valueOf(renda);
        return  cardRepository.findByRendaLessThanEqual(rendaBigDecimal);
    }
}

package com.codurance.spanishdeck.baraja;

import com.codurance.spanishdeck.Deck;

import static com.codurance.spanishdeck.baraja.FrenchBarajaSuits.*;

public class FrenchBaraja extends Baraja implements IBaraja {

    public FrenchBaraja() {
        super();
        this.numberOfDeck = 52;
        this.numberOfDeckBySuit = 13;
        createDeck();
        super.shuffle();
    }

    private void createDeck() {
        this.deck = new Deck[numberOfDeck];
        FrenchBarajaSuits frenchBarajaSuits[] = values();

        for (int i = 0; i < frenchBarajaSuits.length; i++) {
            for (int j = 0; j < numberOfDeckBySuit; j++) {
                deck[((i * numberOfDeckBySuit) + j)] = new Deck(j + 1, frenchBarajaSuits[i]);
            }
        }
    }

    public boolean cartaRoja(Deck<FrenchBarajaSuits> c){
        return c.getSuits() == CORAZONES || c.getSuits() == DIAMANTES;
    }

    public boolean cartaNegra(Deck<FrenchBarajaSuits> c){
        return c.getSuits() == TREBOLES || c.getSuits() == PICAS;
    }
}

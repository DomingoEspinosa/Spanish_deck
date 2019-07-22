package com.codurance.spanishdeck.baraja;

import com.codurance.spanishdeck.Deck;

public class SpanishBaraja extends Baraja {

    private boolean incluid_8_9;

    public SpanishBaraja(boolean incluid_8_9) {
        super();
        this.incluid_8_9 = incluid_8_9;
        if (incluid_8_9) {
            this.numberOfDeck = 48;
            this.numberOfDeckBySuit = 12;
        } else {
            this.numberOfDeckBySuit = 40;
            this.numberOfDeckBySuit = 10;
        }
        createDeck();
        super.shuffle();
    }

    private void createDeck() {
        this.deck = new Deck[numberOfDeck];
        SpanishBarajaSuits[] spanishBarajaSuits = SpanishBarajaSuits.values();

        for (int i = 0; i < spanishBarajaSuits.length; i++) {
            for (int j = 0; j < numberOfDeckBySuit; j++) {
                if (incluid_8_9) {
                    deck[((i * numberOfDeckBySuit) + j)] = new Deck(j + 1, spanishBarajaSuits[i]);
                } else {
                    if (!(j == 7 || j == 8)) {
                        if (j >= 9) {
                            deck[((i * (numberOfDeckBySuit)) + j)] = new Deck(j + 3, spanishBarajaSuits[i]);
                        } else {
                            deck[((i * (numberOfDeckBySuit)) + j)] = new Deck(j + 1, spanishBarajaSuits[i]);
                        }
                    }
                }
            }
        }

    }

}

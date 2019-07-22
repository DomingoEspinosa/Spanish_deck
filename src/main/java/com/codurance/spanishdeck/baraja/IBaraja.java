package com.codurance.spanishdeck.baraja;

import com.codurance.spanishdeck.Deck;

public interface IBaraja {

    void shuffle();

    Deck nextDeck();

    int deckAvailable();

    Deck[] giveCards(int numberOfCars);

    int availableDecks();

    void pillOfDecks();

    void showDecks();
}

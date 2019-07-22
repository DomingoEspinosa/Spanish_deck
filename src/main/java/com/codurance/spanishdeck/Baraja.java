package com.codurance.spanishdeck;

import java.util.Random;

public class Baraja {
    private Deck deck[];
    private int nextDeck;

    public static final int NUMBER_OF_DECK = 40;

    public Baraja() {
        this.deck = new Deck[40];
        this.nextDeck = 0;
        createSpanishDeck();
        shuffle();
    }

    public void shuffle() {
        int posRandom;
        Deck deckActual;
        for (int i = 0; i < deck.length; i++) {
            posRandom = getRandomNumberInRange(0, NUMBER_OF_DECK - 1);
            deckActual = deck[i];
            deck[i] = deck[posRandom];
            deck[posRandom] = deckActual;
        }
        this.nextDeck = 0;
    }

    private void createSpanishDeck() {
        String[] suits = Deck.SUITS;
        for (int i = 0; i < suits.length; i++) {
            for (int j = 0; j < Deck.NUMBER_OF_CARDS; j++) {
                if (!(j == 7 || j == 8)) {
                    if (j >= 9) {
                        deck[((i * (Deck.NUMBER_OF_CARDS - 2)) + (j - 2))] = new Deck(j + 1, suits[i]);
                    } else {
                        deck[((i * (Deck.NUMBER_OF_CARDS - 2)) + j)] = new Deck(j + 1, suits[i]);
                    }
                }
            }
        }
    }

    private static int getRandomNumberInRange(int min, int max) {

        Random r = new Random();
        return r.ints(min, (max + 1)).findFirst().getAsInt();

    }

    public Deck nextDeck(){
        Deck c = null;
        if (this.nextDeck == NUMBER_OF_DECK){
            System.out.println("Not exist more cards");
        } else {
            c = deck[nextDeck++];
        }

        return c;
    }

    public int deckAvailable(){
        return NUMBER_OF_DECK - nextDeck;
    }

    public Deck[] giveCards(int numberOfCars){
        if (numberOfCars > NUMBER_OF_DECK){
            System.out.println("Te has pasado");
        } else if (deckAvailable() < numberOfCars) {
            System.out.println("No hay cartas suficientes");
        } else {
            Deck[] giveCards = new Deck[numberOfCars];
            for (int i = 0; i < giveCards.length; i++) {
                giveCards[i] = nextDeck();
            }
            return giveCards;
        }
        return null;
    }

    public int cartasDisponible() {
        return NUMBER_OF_DECK - nextDeck;
    }

    /**
     * Muestro las cartas que ya han salido
     */
    public void cartasMonton() {

        if (cartasDisponible() == NUMBER_OF_DECK) {
            System.out.println("No se ha sacado ninguna carta");
        } else {
            //Recorro desde 0 a la posSiguienteCarta
            for (int i = 0; i < nextDeck; i++) {
                System.out.println(deck[i]);
            }
        }

    }

    /**
     * Muestro las cartas que aun no han salido
     */
    public void mostrarBaraja() {

        if (cartasDisponible() == 0) {
            System.out.println("No hay cartas que mostrar");
        } else {
            for (int i = nextDeck; i < deck.length; i++) {
                System.out.println(deck[i]);
            }
        }

    }
}

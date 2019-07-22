package com.codurance.spanishdeck.baraja;

import com.codurance.spanishdeck.Deck;

import java.util.Random;

public abstract class Baraja<T> {
    protected Deck<T> deck[];
    protected int nextDeck;
    protected int numberOfDeck;
    protected int numberOfDeckBySuit;

    /*public static final int numberOfDeck = 40;
    public static final int numberOfDeckBySuit = 12;*/

    public Baraja() {
        this.nextDeck = 0;
    }

    abstract void createDeck();

    public void shuffle() {
        int posRandom;
        Deck deckActual;
        for (int i = 0; i < deck.length; i++) {
            posRandom = getRandomNumberInRange(0, numberOfDeck - 1);
            deckActual = deck[i];
            deck[i] = deck[posRandom];
            deck[posRandom] = deckActual;
        }
        this.nextDeck = 0;
    }

    private static int getRandomNumberInRange(int min, int max) {

        Random r = new Random();
        return r.ints(min, (max + 1)).findFirst().getAsInt();

    }

    public Deck nextDeck(){
        Deck c = null;
        if (this.nextDeck == numberOfDeck){
            System.out.println("Not exist more cards");
        } else {
            c = deck[nextDeck++];
        }

        return c;
    }

    public int deckAvailable(){
        return numberOfDeck - nextDeck;
    }

    public Deck[] giveCards(int numberOfCars){
        if (numberOfCars > numberOfDeck){
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

    public int availableDecks() {
        return numberOfDeck - nextDeck;
    }

    public void pillOfDecks() {

        if (availableDecks() == numberOfDeck) {
            System.out.println("No se ha sacado ninguna carta");
        } else {
            //Recorro desde 0 a la posSiguienteCarta
            for (int i = 0; i < nextDeck; i++) {
                System.out.println(deck[i]);
            }
        }

    }

    public void showDecks() {

        if (availableDecks() == 0) {
            System.out.println("No hay cartas que mostrar");
        } else {
            for (int i = nextDeck; i < deck.length; i++) {
                System.out.println(deck[i]);
            }
        }

    }
}

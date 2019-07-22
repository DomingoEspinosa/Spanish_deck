package com.codurance.spanishdeck;

public class Deck {
    private int number;
    private String suits;
    public final static String[] SUITS = {"OROS", "COPAS", "BASTOS", "ESPADAS"};
    public final static int NUMBER_OF_CARDS = 12;


    public Deck(int number, String suits) {
        this.number = number;
        this.suits = suits;
    }

    @Override
    public String toString() {
        return "Deck{" +
                "number=" + number +
                ", suits='" + suits + '\'' +
                '}';
    }
}

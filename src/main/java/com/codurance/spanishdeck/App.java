package com.codurance.spanishdeck;

import com.codurance.spanishdeck.baraja.Baraja;
import com.codurance.spanishdeck.baraja.FrenchBaraja;
import com.codurance.spanishdeck.baraja.IBaraja;

public class App {
    public static void main(String[] args) {
        //Creamos la baraja
        IBaraja b = new FrenchBaraja();
        runBaraja(b);

    }

    public static void runBaraja(IBaraja b) {
        //Mostramos las cartas disponibles (40)
        System.out.println("Hay "+b.availableDecks()+" cartas disponibles");

        //Saco una carta
        b.nextDeck();

        //Saco 5 cartas
        b.giveCards(5);

        //Mostramos las cartas disponibles (34)
        System.out.println("Hay "+b.availableDecks()+" cartas disponibles");

        System.out.println("Cartas sacadas de momento");

        b.pillOfDecks();


        //Barajamos de nuevo
        b.shuffle();

        //Saco 5 cartas
        Deck[] c = b.giveCards(5);

        System.out.println("Cartas sacadas despues de barajar ");
        for(int i=0;i<c.length;i++){
            System.out.println(c[i]);
        }
    }
}

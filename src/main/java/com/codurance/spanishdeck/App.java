package com.codurance.spanishdeck;

public class App {
    public static void main(String[] args) {
        //Creamos la baraja
        Baraja b = new Baraja();

        //Mostramos las cartas disponibles (40)
        System.out.println("Hay "+b.cartasDisponible()+" cartas disponibles");

        //Saco una carta
        b.nextDeck();

        //Saco 5 cartas
        b.giveCards(5);

        //Mostramos las cartas disponibles (34)
        System.out.println("Hay "+b.cartasDisponible()+" cartas disponibles");

        System.out.println("Cartas sacadas de momento");

        b.cartasMonton();


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

package com.codurance.spanishdeck;

public class Deck<T> {
    private int number;
    private T suits;


    public Deck(int number, T suits) {
        this.number = number;
        this.suits = suits;
    }

    public int getNumber() {
        return number;
    }

    public T getSuits() {
        return suits;
    }

    @Override
    public String toString() {
        String nameOfFigure = "";
        if (suits.getClass().getSimpleName().equals("SpanishBarajaSuits")) {
            switch (number) {
                case 1:
                    nameOfFigure = "As";
                    break;
                case 10:
                    nameOfFigure = "Sota";
                    break;
                case 11:
                    nameOfFigure = "Caballo";
                    break;
                case 12:
                    nameOfFigure = "Rey";
                    break;
                default:
                    nameOfFigure = number + "";

            }

        }
        if (suits.getClass().getSimpleName().equals("FrenchBarajaSuits")) {
            switch (number) {
                case 1:
                    nameOfFigure = "As";
                    break;
                case 11:
                    nameOfFigure = "Jota";
                    break;
                case 12:
                    nameOfFigure = "Reina";
                    break;
                case 13:
                    nameOfFigure = "Rey";
                    break;
                default:
                    nameOfFigure = number + "";

            }
        }

        return nameOfFigure + " de " + suits;
    }
}

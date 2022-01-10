package model;

import java.util.Random;

public interface IDiceThrow {
    static final int AANTAL_DOBBELSTENEN = 2;
    static Random random = new Random();
    static int[] dobbelworp = new int[AANTAL_DOBBELSTENEN];

    public static int genereerRandomNr() {
        // Doel: genereer random nr 1-6

        // Input

        // Verwerking

        // Output
        return random.nextInt(6) + 1;
    }

    public static int[] gooi2Dobbelstenen() {
        // Doel: genereer 2 random nr 1-6

        // Input
        int[] worp = new int[AANTAL_DOBBELSTENEN];

        // Verwerking
        for (int i = 0; i < AANTAL_DOBBELSTENEN; i++) {
            worp[i] = genereerRandomNr();
            System.out.println("Worp " + (i + 1) + ": " + worp[i]);
        }

        // Output
        return worp;
    }

    public static int berekenEnPrintTotaalDobbelworp(int[] worp) {
        // Doel: bereken totaalwaarde van 2 gegooide dobbelstenen

        // Input
        int totaal = 0;

        // Verwerking
        for (int i = 0; i < worp.length; i++) {
            totaal = totaal + worp[i];
        }

        // output
        System.out.println(totaal);
        return totaal;
    }
}

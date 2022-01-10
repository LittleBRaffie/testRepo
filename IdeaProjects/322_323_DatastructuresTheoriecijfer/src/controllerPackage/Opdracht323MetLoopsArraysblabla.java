package controllerPackage;

import java.util.Scanner;

public class Opdracht323MetLoopsArraysblabla {
    static Scanner scanner = new Scanner(System.in);
    static final String[] ALLE_VAKKEN = new String[]{"Datastructures", "Sorting & Searching", "Vak 3"};
    static final int AANTAL_VAKKEN = ALLE_VAKKEN.length;
    static final int AANTAL_TOETSEN = 2;
    static final int GRENS_VOLDOENDE = 12;

    public static void main(String[] args) {
        // doel:

        // input
        int[][] puntenToetsen = new int[AANTAL_VAKKEN][AANTAL_TOETSEN];
        double[][] cijferToetsen = new double[AANTAL_VAKKEN][AANTAL_TOETSEN];
        String[][] voldoendeToetsen = new String[AANTAL_VAKKEN][AANTAL_TOETSEN];

        // verwerking
        // for loop in multi array die eerst alle vakken doorgaat en dan de deeltoetsen, gebruiker voor punten in
        for (int i = 0; i < AANTAL_VAKKEN; i++) {
            System.out.println("Voer de behaalde punten in voor het vak " + ALLE_VAKKEN[i] + ":");
            for (int j = 0; j < AANTAL_TOETSEN; j++) {
                int puntenDeeltoets = vragenBehaaldePunten(ALLE_VAKKEN[i] + " Deeltoets " + (j + 1) + ":");
                puntenToetsen[i][j] = puntenDeeltoets;
            }
            System.out.println("\n");
        }

        // for loop in multi array die alle punten per toets omzet in cijfers
        for (int i = 0; i < AANTAL_VAKKEN; i++) {
            for (int j = 0; j < AANTAL_TOETSEN; j++) {
                double cijferDeeltoets = berekenenCijfer(puntenToetsen[i][j]);
                cijferToetsen[i][j] = cijferDeeltoets;
            }
        }

        // for loop in multi array die alle punten per toets omzet in (on)voldoendes
        for (int i = 0; i < AANTAL_VAKKEN; i++) {
            for (int j = 0; j < AANTAL_TOETSEN; j++) {
                String voldoendeDeeltoets = berekenenVoldoende(puntenToetsen[i][j]);
                voldoendeToetsen[i][j] = voldoendeDeeltoets;
            }
        }

        // output
        // tonen punten + cijfers + voldoendes
        for (int i = 0; i < AANTAL_VAKKEN; i++) {
            for (int j = 0; j < AANTAL_TOETSEN; j++) {
                System.out.println("Resultaat " + ALLE_VAKKEN[1] + ":\t" + puntenToetsen[i][j] + " (punten)\t\t" + cijferToetsen[i][j] + " (cijfer)\t" + voldoendeToetsen[i][j]);
            }
            System.out.println("\n");
        }

        // tenslotte berekening van eindcijfer en eind(on)voldoende via for loop en multi array, deze cijfers worden niet opgeslagen, maar alleen weergegeven!
        for (int i = 0; i < AANTAL_VAKKEN; i++) {
            weergaveEindCijfer(ALLE_VAKKEN[i],voldoendeToetsen[i][0],voldoendeToetsen[i][1],cijferToetsen[i][0],cijferToetsen[i][1]);
            System.out.println("\n");
        }

    }

    public static int vragenBehaaldePunten(String vraag) {
        // doel: vragen aan gebruiker om input van aantal punten voor de betreffende toets

        // input
        int aantalPunten;

        // verwerking
        System.out.println(vraag);
        aantalPunten = scanner.nextInt();

        // output
        return aantalPunten;
    }

    public static double berekenenCijfer(int punten) {
        // doel: berekenen van het cijfer ahv aantal behaalde punten

        // input
        double cijfer;

        // verwerking
        /*
        •	Een deeltoets is voldoende als het aantal punten >= 12 is.
        •	Het cijfer dat daarbij hoort is: (aantal punten) / 2.
        •	Een deeltoets is onvoldoende als het aantal punten < 12 is.
        •	Het cijfer dat daarbij hoort is: (aantal punten - 1.5) / 2.
         */
        if (punten >= GRENS_VOLDOENDE) {
            cijfer = (double) punten / 2;
        } else {
            cijfer = ((double) punten - 1.5) / 2;
        }

        // output
        return cijfer;
    }

    public static String berekenenVoldoende(int punten) {
        // doel: berekenen van het cijfer ahv aantal behaalde punten

        // input
        String voldoende = "";

        // verwerking
        /*
        •	Een deeltoets is voldoende als het aantal punten >= 12 is.
        •	Het cijfer dat daarbij hoort is: (aantal punten) / 2.
        •	Een deeltoets is onvoldoende als het aantal punten < 12 is.
        •	Het cijfer dat daarbij hoort is: (aantal punten - 1.5) / 2.
         */
        if (punten >= GRENS_VOLDOENDE) {
            voldoende = "Voldoende";
        } else {
            voldoende = "Onvoldoende";
        }

        // output
        return voldoende;
    }

    public static void weergaveEindCijfer(String vak, String voldoende1, String voldoende2, double cijfer1, double cijfer2) {
        // doel: berekening en weergave van het eindcijfer en (on)voldoende

        // input
        double eindCijfer;
        String eindVoldoende;

        // verwerking
        /*
        •	Alleen als beide deeltoetsen voldoende zijn gemaakt, dan krijgt de student een voldoende voor het vak.
        •	Het eindcijfer is dan het gemiddelde van de beide voldoendes.
        •	Als een van beide deeltoetsen onvoldoende is gemaakt, dan is het eindcijfer de onvoldoende voor die deeltoets.
        */
        if (voldoende1.equals("Voldoende") && voldoende2.equals("Voldoende")) {
            eindCijfer = (cijfer1 + cijfer2) / 2;
            eindVoldoende = "voldoende";
        } else {
            if (cijfer1 < cijfer2) {
                eindCijfer = cijfer1;
            } else {
                eindCijfer = cijfer2;
            }
            eindVoldoende = "onvoldoende";
        }

        eindCijfer = (Math.round(eindCijfer * 10))/10.0;

        // output
        System.out.println("Je hebt een " + eindVoldoende + " voor het vak " + vak + ".\n" +
                "Je cijfer is " + eindCijfer);
    }

}

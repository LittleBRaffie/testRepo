package controllerPackage;

import java.util.Scanner;

public class TicTacToeMetSpelerKeuze {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        // Doel: 3 op een rij spelletje waarbij 2 spelers kunnen spelen

        // Input
        // maak speelbord --> zie scanner

        // spelbord van 3 rijen bij 3 kolommen
        char[][] spelbord = new char[3][3]; //eerste is aantal rijen, 2e kolommen
        char symboolSpeler1;
        char symboolSpeler2;
        boolean spelerAanDeBeurt = true;
        int speler = 0;
        int keuzeSpeler;

        // speluitleg
        System.out.println("\nWelkom bij 3-op-n-rij!\nWanneer één van jullie 3-op-n rij heeft, heb je gewonnen.\n");
//        nogEenSpel();
        //TODO in while loop totdat speler 0 toets wanneer deze gewonnen heeft? break invoeren?

        // Verwerking
        // vraag om character per speler
        symboolSpeler1 = invoerKeuzeSpelerChar("Speler 1, Geef het symbool waarmee je wil spelen: ");
        symboolSpeler2 = invoerKeuzeSpelerChar("Speler 2, Geef het symbool waarmee je wil spelen: ");
        System.out.println("");

        // creeer leeg spelbord en toon dit
        maakLeegSpelbord(spelbord, ' ');
        printSpelbord(spelbord);
        System.out.println("");

        for (int beurten = 0; beurten < 9; beurten++) {
            if (spelerAanDeBeurt) {
                speler = 1;
                spelerKiestPositie(spelbord,symboolSpeler1,speler);
                spelerAanDeBeurt = false;
            } else {
                speler = 2;
                spelerKiestPositie(spelbord,symboolSpeler2,speler);
                spelerAanDeBeurt = true;
            }

            //TODO voorkomen dat zelfde veld overschreven wordt
        }

    }

//    public static void nogEenSpel(){
//        char nogEens;
//        invoerKeuzeSpelerChar("Wil je nog een spel spelen? (j/n)");
//        if (nogEens == 'j'){
//
//        } else {
//
//        }
//    }

    public static void weergaveKeuzes() {
        String[] namenVakjes = new String[]{"linksboven", "linksmidden", "linksonder", "middenboven", "middenmidden", "middenonder", "rechtsboven", "rechtsmidden", "rechtsonder"};
        int counter = 0;
        for (int rij = 0; rij < 3; rij++) {
            for (int kolom = 0; kolom < 3; kolom++) {
                System.out.println((counter + 1) + " = rij " + (rij + 1) + ", kolom " + (kolom + 1) + " (" + namenVakjes[counter] + ")");
                counter++;
            }
        }
        /*
        1 = rij 1, kolom 1 = linksboven
        2 = rij 1, kolom 2 = middenboven
        3 = rij 1, kolom 3 = rechtsboven
        4 = rij 2, kolom 1 = linksmidden
        5 = rij 2, kolom 2 = middenmidden
        6 = rij 2, kolom 3 = rechtsmidden
        7 = rij 3, kolom 1 = linksonder
        8 = rij 3, kolom 2 = middenonder
        9 = rij 3, kolom 3 = rechtsonder
         */

        // TODO denk eraan dat keuze die al geweest is, niet meer gegeven kan worden! zowel bij weergave als bij input!
    }

    public static int invoerKeuzeSpelerInt(String vraag) {
        System.out.println(vraag);
        return scanner.nextInt();
    }

    public static char invoerKeuzeSpelerChar(String vraag) {
        System.out.println(vraag);
        return scanner.next().charAt(0);
    }

    public static String maakHorizontaleLijn(char[][] hetSpelbord) {
        String lijn = "";
        for (int kolom = 0; kolom < hetSpelbord[0].length; kolom++) {
            lijn = lijn + "----";
        }
        lijn = lijn + "-";
        return lijn;
    }

    public static void maakLeegSpelbord(char[][] mijnSpelbord, char gegevenChar) {
        for (int rij = 0; rij < mijnSpelbord.length; rij++) {
            for (int kolom = 0; kolom < mijnSpelbord[rij].length; kolom++) {
                // vul elk vakje met meegegeven char
                mijnSpelbord[rij][kolom] = gegevenChar;
            }
        }
    }

    public static void spelerKiestPositie(char[][] spelbord, char symbool, int spelerAanBeurt) {
        // laat keuzes zien voor het vullen van vakjes en vraag gebruiker voor een optie
        weergaveKeuzes();
        System.out.println("");
        String s = "Speler " + spelerAanBeurt + ": Welke positie wil je spelen? (kies 1 tot 9 die nog niet is gespeeld)";
        int keuzeSpeler = invoerKeuzeSpelerInt(s);

        // vul de opgegeven plek met het symbool van de speler
        vul1PositieSpelbord(spelbord, symbool, keuzeSpeler);
        printSpelbord(spelbord);
        System.out.println("\n");
    }

    public static void vul1PositieSpelbord(char[][] mijnSpelbord, char spelerSymbool, int spelerKeuze) {
        switch (spelerKeuze) {
            case 1:
                mijnSpelbord[0][0] = spelerSymbool;
                break;
            case 2:
                mijnSpelbord[0][1] = spelerSymbool;
                break;
            case 3:
                mijnSpelbord[0][2] = spelerSymbool;
                break;
            case 4:
                mijnSpelbord[1][0] = spelerSymbool;
                break;
            case 5:
                mijnSpelbord[1][1] = spelerSymbool;
                break;
            case 6:
                mijnSpelbord[1][2] = spelerSymbool;
                break;
            case 7:
                mijnSpelbord[2][0] = spelerSymbool;
                break;
            case 8:
                mijnSpelbord[2][1] = spelerSymbool;
                break;
            case 9:
                mijnSpelbord[2][2] = spelerSymbool;
                break;
            default:
                System.out.println("Verkeerde keuze! Je slaat een beurt over. ;)");
                break;
        }
    }

    public static void printSpelbord(char[][] hetSpelbord) {
        String lijn = maakHorizontaleLijn(hetSpelbord);
        System.out.println(lijn);
        for (int rij = 0; rij < hetSpelbord.length; rij++) {
            for (int kolom = 0; kolom < hetSpelbord[rij].length; kolom++) {
                System.out.print("| " + hetSpelbord[rij][kolom] + " ");
            }
            System.out.print("|\n" + lijn + "\n");
        }
    }
}
package controllerPackage;

import model.Card;
import model.Deck;

import java.util.Scanner;

public class MonopolyLauncher {
    // aantal andere klasses die nodig zijn
    static Scanner scanner = new Scanner(System.in);
    // aantal 'magic numbers' die nodig zijn voor methodes
    private static final String TYPE_IS_CHANCE = "Kans";
    private static final String TYPE_IS_FUND = "Fonds";
    static final int AANTAL_HUIZEN = 32; // TODO: check
    static final int AANTAL_HOTELS = 12; // TODO: check
    static final int AANTAL_STRATEN_EIGENDOMSBEWIJZEN = 28; // TODO: check
    // aantal arrays die standaard zijn of later ingevuld worden


    public static void main(String[] args) {
        // Doel: Monopoly spelen met elkaar of tegen de PC. Speler kiest in begin hoeveel spelers er zijn (bij 1 automatisch
        // tegen de PC). Elke speler heeft eigen symbool (keuze). Verder gelden de normale monopoly regels (huizen, hotels,
        // geld, dobbelen, kanskaarten) TODO: spelregels opzoeken
        // Wanneer iemand heeft gewonnen, stopt het spel TODO: wanneer wint iemand? geldbedrag, huizen?

        // Input
        // welkom + uitleg
        System.out.println("\nWelkom bij Monopoly. It's time to get ritch!\n");

//        speelbord = creerenSpeelbord();
//        tekenenSpelbord(speelbord);

        // spelers

        int totaalDobbelworp; //TODO

        // Verwerking

        System.out.println();
        System.out.println("========TESTEN===========");
        System.out.println("========shudden 2 decks kaarten ===========");

        //region aanmaken van de decks = AF
        // deck kanskaarten
        Deck deckOfChanceCards = new Deck(TYPE_IS_CHANCE);
        // deck algemeen fonds kaarten
        Deck deckOfGeneralFundCards = new Deck(TYPE_IS_FUND);
        //endregion

        //region schudden van de decks
        // schudden kanskaarten
        System.out.println("GESCHUD");
        deckOfChanceCards.shuffleDeck();
        deckOfChanceCards.printDeckOfAllCards(); // TODO: ter controle, weghalen als alles werkt
        System.out.println();
        // schudden algemeen fonds kaarten
        deckOfGeneralFundCards.shuffleDeck();
        deckOfGeneralFundCards.printDeckOfAllCards(); // TODO: ter controle, weghalen als alles werkt
        System.out.println();
        //endregion


        // tekenen bord

        // dobbelworp // TODO: check
//        dobbelworp = gooi2Dobbelstenen();
//        totaalDobbelworp = berekenEnPrintTotaalDobbelworp(dobbelworp);

        // Output
    }
    // TODO: check alle methodes


    public static int[] creerenReeksRandomNummers(int aantalNummers) {
        // Doel: aanmaken van een reeks van x aantal random getallen van 1 tot maximum

        // Input = array van kaarten + array van nummers om te shuffelen
        int nummers[] = new int[aantalNummers];

        // Verwerking
        // aanmaken array 1 tot 16 met random nummer
        for (int i = 0; i < nummers.length; i++) {
            nummers[i] = (int) (Math.random() * nummers.length);
            for (int j = 0; j < i; j++) {
                if (nummers[i] == nummers[j]) {
                    i--;
                }
            }
        }

        // Output = return vd nummers
        return nummers;
    }


}

package model;

import java.util.ArrayList;
import java.util.Scanner;

public class Player implements IDiceThrow {
    Scanner scanner = new Scanner(System.in);
    //region INPUT
    private static final int MIN_NUMBER_OF_PLAYERS = 1;
    private static final int MAX_NUMBER_OF_PLAYERS = 7;
    private static int numberOfPlayers = 0;
    private int playerNumber;
    private char playerSymbol;
    private static char[] playerSymbols = {'\u26C4', '\u26F5', '\u26BE', '\u2615', '\u2614', '\u23F0', '\u265A'}; // ⛄ ⛵ ⚾ ☕ ☔ ⏰ ♚
    private static final int START_MONEY = 1500;
    private int pocketMoney;
    ArrayList<Building> buildings = new ArrayList<Building>(); // TODO class Building nog maken en hier doorlinken


    //endregion

    //region VERWERKING
    //region Constructors

    //endregion
    //region GetSet

    //endregion
    //region Functies
    // hoeveel spelers TODO============================= dit stuk werkt, alleen als comment voor testen
    public void start() {
        numberOfPlayers = invoerenAantalSpelers();
        // kiezen spelersymbolen + weergeven op scherm
        char[] speelSymbolenVanAlleSpelerDieMeedoen = toewijzenSpelerSymbolen(numberOfPlayers);
        for (int i = 0; i < numberOfPlayers; i++) {
            System.out.println("Speler " + (i + 1) + " speelt met: " + speelSymbolenVanAlleSpelerDieMeedoen[i]);
        }
    }
    //TODO=============================================== tot hier werkt dit stuk code

    public char inputSpelerChar(String vraag) {
        System.out.println(vraag);
        return scanner.next().charAt(0);
    }

    public int inputSpelerInt(String vraag) {
        System.out.println(vraag);
        return scanner.nextInt();
    }

    public int invoerenAantalSpelers() {
        // Doel: invoer van aantal spelers en check of dit klopt

        // Input = aantal spelers
        int aantalSpelers = 0;
        // bevestiging keuze j/n
        char correcteKeuze = 'n';

        // Verwerking =
        while (correcteKeuze == 'n') {
            aantalSpelers = inputSpelerInt("Met hoeveel spelers zijn jullie (maximaal 7)? Voer een getal in (1 - 7) " +
                    "en druk op 'Enter.");
            while (aantalSpelers < MIN_NUMBER_OF_PLAYERS || aantalSpelers > MAX_NUMBER_OF_PLAYERS) {
                aantalSpelers = inputSpelerInt("Foute invoer, het aantal spelers moet tussen de 1 en 7 liggen.");
            }
            correcteKeuze = inputSpelerChar("Jullie zijn dus met " + aantalSpelers + " spelers. Klopt dit? (j/n)");
        }

        // Output = aantal spelers dat meedoen
        return aantalSpelers;
    }

    public char keuzeVan1SpelerInChar(int speler, int keuze) {
        // Doel: ahv speler en keuze een char bepalen die is gekozen

        // Input = speler, keuze, symbool
        char symbool;

        switch (keuze) {
            case 1:
                System.out.println("Speler " + speler + ": Je hebt gekozen voor het sneeuwpopje (⛄).\n");
                symbool = playerSymbols[0];
                break;
            case 2:
                System.out.println("Speler " + speler + ": Je hebt gekozen voor de boot (⛵).\n");
                symbool = playerSymbols[1];
                break;
            case 3:
                System.out.println("Speler " + speler + ": Je hebt gekozen voor de softbal (⚾).\n");
                symbool = playerSymbols[2];
                break;
            case 4:
                System.out.println("Speler " + speler + ": Je hebt gekozen voor het kopje koffie (☕).\n");
                symbool = playerSymbols[3];
                break;
            case 5:
                System.out.println("Speler " + speler + ": Je hebt gekozen voor de paraplu (☔).\n");
                symbool = playerSymbols[4];
                break;
            case 6:
                System.out.println("Speler " + speler + ": Je hebt gekozen voor de wekker (♚).\n");
                symbool = playerSymbols[5];
                break;
            case 7:
                System.out.println("Speler " + speler + ": Je hebt gekozen voor de koning (♚).\n");
                symbool = playerSymbols[6];
                break;
            case 8:
                symbool = inputSpelerChar("Speler " + speler + ": Je hebt gekozen om zelf iets te kiezen. " +
                        "Voer 1 teken in en druk op 'Enter'.");
                System.out.println("Speler " + speler + ": Je hebt gekozen voor: " + symbool + ".\n");
                break;
            case 0:
                //TODO stoppen van het spel in zijn geheel
                symbool = '0';
                break;
            default:
                System.out.println("Omdat er geen invoer is gegeven, speel je met een 'X'.");
                symbool = 'X';
                break;
        }
        return symbool;
    }

    public boolean controleOfSymboolVrijIs(char gekozenSymbool, char[] alleGekozenSymbolen) {
        //Doel: checkt de input van een symbool of deze nog niet is gebruikt

        // Input = te checken symbool, array symbolen, boolean die aangeeft 'false' als het symbool al in gebruik is
        boolean nogNietInGebruik = true;

        // Verwerking = vergelijk symbool met symbolen in array
        for (int i = 0; i < alleGekozenSymbolen.length; i++) {
            if (gekozenSymbool == alleGekozenSymbolen[i]) {
                nogNietInGebruik = false;
            }
        }

        // Output = false als het dubbel is, true als het gekozen symbool okay is
        return nogNietInGebruik;
    }

    public char[] toewijzenSpelerSymbolen(int aantalSpelers) {
        // Doel: overzicht van de speelsymbolen die spelers kunnen gebruiken en waarvan elke speler er eentje kan kiezen

        // Input
        // aanmaken 7 speelsymbolen via unicode (staan in klasse) --> ⛄ ⛵ ⚾ ☕ ☔ ⏰ ♚
        // aanmaken x speelsymbolen die daadwerkelijk gebruikt worden
        char[] symbolenWaarmeeGespeeldWordt = new char[aantalSpelers];
        // weergave van 7 standaard spelersymbolen
        for (int i = 0; i < MAX_NUMBER_OF_PLAYERS; i++) {
            System.out.println((i + 1) + " = " + playerSymbols[i]);
        }
        // variabele spelerkeuze
        int[] spelerKeuze = new int[aantalSpelers];

        // Verwerking
        // vragen om keuze speler x + deze opslaan
        for (int speler = 0; speler < aantalSpelers; speler++) {
            System.out.println("Speler " + (speler + 1) + ": Kies één van bovengenoemde symbolen door het cijfer in te toetsen en " +
                    "druk op 'Enter'.");
            spelerKeuze[speler] = inputSpelerInt("Je kunt ook zelf een symbool invoeren door '8' te kiezen. " +
                    "Type je '0', dan stopt het spel.");

            // ahv keuze een char toekennen aan variabele
            char gekozenSymbool = keuzeVan1SpelerInChar((speler + 1), spelerKeuze[speler]);

            // testen of dit figuur nog beschikbaar is
            for (int vorigeSpelers = 0; vorigeSpelers < speler; vorigeSpelers++) {
                boolean checkSymbool = controleOfSymboolVrijIs(gekozenSymbool, symbolenWaarmeeGespeeldWordt);
                while (!checkSymbool) {
                    spelerKeuze[speler] = inputSpelerInt("Helaas is dit symbool al in gebruik, kies opnieuw een " +
                            "cijfer van 1 - 7 om een symbool te kiezen.");
                    gekozenSymbool = keuzeVan1SpelerInChar((speler + 1), spelerKeuze[speler]);
                    checkSymbool = controleOfSymboolVrijIs(gekozenSymbool, symbolenWaarmeeGespeeldWordt);
                }
            }

            // na check variabele pas in array toevoegen
            symbolenWaarmeeGespeeldWordt[speler] = gekozenSymbool;
        }

        // Output
        // return de symbolen
        return symbolenWaarmeeGespeeldWordt;
    }

    //endregion
    //endregion

    //region OUTPUT

    //endregion
}

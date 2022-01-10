package controllerPackage;


import java.util.Random;
import java.util.Scanner;

public class MasterMind {
    static Scanner scanner = new Scanner(System.in);
    static Random random = new Random();
    static final int AANTAL_GETALLEN = 4;
    static final int BOVENGRENS = 10;
    static final int MAXIMAAL_AANTAL_KEER_RADEN = 12;

    public static void main(String[] args) {

        // Doel: Mastermind met getallen. App genereert 4 random nummers. Gebruiker probeert deze te raden. Na elke poging
        // geeft app aan hoeveel getallen goed zijn. Ook geeft de app aan hoeveel getallen op de juiste plek zitten.
        // Wanneer alle getallen geraden zijn, geeft de app aan in hoeveel pogingen dit is gehaald. Hierbij is een maximum
        // van 12 keer raden.

        // Input
        // Aantal finals (static) voor aantallen/grenzen

        // Array met 3 verschillende getallen
        int[] randomGetallenReeks = new int[AANTAL_GETALLEN];
        // Array invoer speler
        int[] ingevoerdeGetallenReeksSpeler = new int[AANTAL_GETALLEN];
        // aantal goed geraden getallen
        int aantalGoedeGetallenInReeks;
        // aantal getallen op goede positie
        int aantalGetallenOpGoedePlekInReeks;
        // Aantal pogingen
        int aantalPogingen;
        // keuze nog een spel beginnen + ja/nee
        char keuze;
        boolean nogEenSpel = true;

        // Verwerking
        // Spel start- 1x en erna komt vraag om nog een te spelen (do-while met boolean)
        while (nogEenSpel) {
            // (re)set startwaarden
            aantalGetallenOpGoedePlekInReeks = 0;
            aantalGetallenOpGoedePlekInReeks = 0;
            aantalPogingen = 0;

            // Maak array 3 random getallen
            randomGetallenReeks = creeerXRandomGetallen();
            //printenArrayGetallen("", randomGetallenReeks);

            // Herhaal onderstaande 3 stappen totdat alle getallen zijn geraden of totdat 12x geraden is
            while (aantalGetallenOpGoedePlekInReeks < AANTAL_GETALLEN && aantalPogingen < MAXIMAAL_AANTAL_KEER_RADEN) {
                // Vraag spelerinput
                ingevoerdeGetallenReeksSpeler = leesIngevoerdeGetallenUit();
                // Check input met getallen
                aantalGoedeGetallenInReeks = checkOfGetallenVoorkomen(ingevoerdeGetallenReeksSpeler, randomGetallenReeks);
                aantalGetallenOpGoedePlekInReeks = checkOfGetallenOpGoedePlekStaan(ingevoerdeGetallenReeksSpeler, randomGetallenReeks);
                // Geef feedback
                System.out.println("Aantal correcte getallen = " + aantalGoedeGetallenInReeks);
                System.out.println("Aantal getallen op de goede plek = " + aantalGetallenOpGoedePlekInReeks);
                aantalPogingen++;
            }

            // Output
            // Print aantal pogingen
            System.out.print("U heeft " + aantalPogingen + " keer geraden. ");
            // Geef aan gewonnen of niet
            if (aantalPogingen <= MAXIMAAL_AANTAL_KEER_RADEN && aantalGetallenOpGoedePlekInReeks == AANTAL_GETALLEN) {
                System.out.println("Proficiat MasterMind, je hebt het geraden!");
            } else {
                System.out.println("Helaas, je hebt het niet geraden binnen " + MAXIMAAL_AANTAL_KEER_RADEN + " keer raden.");
            }
            // Print de getallen
            printenArrayGetallen("De te raden getallen waren: ", randomGetallenReeks);

            // Vragen om nog eens te spelen do-while met boolean
            System.out.println("\n\nWil je nog eens spelen? (j/n)");
            keuze = scanner.next().charAt(0);
            if (keuze == 'j') {
                System.out.println("Succes!");
            } else {
                System.out.println("Leuk dat je gespeeld hebt!");
                nogEenSpel = false;
            }
        }

    }

    public static int genereerRandomGetal() {
        // Doel: genereer 1 random getal tussen 1 en 10

        // Input - getal
        int randomGetal;

        // Verwerking - genereer getal 1-10
        randomGetal = random.nextInt(BOVENGRENS) + 1;

        // Output
        return randomGetal;
    }

    public static int[] creeerXRandomGetallen() {
        // Doel: creeer array met x aantal getallen

        // Input - array + aantal getallen + getal
        int getal;
        int[] arrayGetallen = new int[AANTAL_GETALLEN];

        // Verwerking - loop om getallen op te slaan + methode genereer getallen + check op dubbele getallen
        arrayGetallen[0] = genereerRandomGetal();

        for (int i = 1; i < AANTAL_GETALLEN; i++) {
            arrayGetallen[i] = genereerRandomGetal();
            for (int j = 0; j < i; j++) {
                if (arrayGetallen[i] == arrayGetallen[j]) {
                    i--;
                    break;
                }
            }

        }

        // Output
        return arrayGetallen;
    }

    public static int spelerInvoerInt() {
        // Doel: ingave en return int door speler

        // Input - getal
        int getal;

        // Verwerking - ingave door speler
        getal = scanner.nextInt();

        // Output
        return getal;
    }

    public static int[] leesIngevoerdeGetallenUit() {
        // Doel: invoeren + opslaan van x getallen

        // Input - vraag + aantal getallen + array ingevoerde getallen
        System.out.println("Geef " + AANTAL_GETALLEN + " verschillende getallen tussen 1 en " + BOVENGRENS +
                ", gescheiden door spaties en druk op 'Enter': ");
        int[] getallen = new int[AANTAL_GETALLEN];

        // Verwerking - loop per getal invoeren en opslaan
        for (int i = 0; i < AANTAL_GETALLEN; i++) {
            getallen[i] = spelerInvoerInt();
        }

        // Output
        return getallen;
    }

    public static int checkOfGetallenVoorkomen(int[] getallenInvoer, int[] getallenOplossing) {
        // Doel: check of getallen van 1 array voorkomen in de andere array

        // Input
        int aantalCorrecteGetallen = 0;

        // Verwerking
        for (int i = 0; i < getallenInvoer.length; i++) {
            for (int j = 0; j < getallenOplossing.length; j++) {
                if (getallenOplossing[i] == getallenInvoer[j]) {
                    aantalCorrecteGetallen++;
                }
            }

        }

        // Output
        return aantalCorrecteGetallen;
    }

    public static int checkOfGetallenOpGoedePlekStaan(int[] getallenInvoer, int[] getallenOplossing) {
        // Doel: check of getal 0 in reeks 1 hetzelfde is als getal 0 in reeks 2...etc

        // Input - 2 reeksen + aantal gelijk
        int aantalGelijk = 0;

        // Verwerking - loop door getallen + check gelijk
        for (int i = 0; i < getallenInvoer.length; i++) {
            if (getallenInvoer[i] == getallenOplossing[i]) {
                aantalGelijk++;
            }
        }

        // Output - return aantal dat gelijk is
        return aantalGelijk;
    }

    public static void printenArrayGetallen(String vraag, int[] arrayGetallen) {
        // Doel: printen van een array met x aantal getallen

        // Input
        System.out.print(vraag);

        // Verwerking
        for (int i = 0; i < arrayGetallen.length; i++) {
            System.out.print(arrayGetallen[i] + " ");
        }

        // Output
    }
}

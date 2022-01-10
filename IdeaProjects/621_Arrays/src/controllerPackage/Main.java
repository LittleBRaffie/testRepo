package controllerPackage;

import java.util.Random;
import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);
    static Random random = new Random();

    /*
    Beschrijving
In deze serie opdrachten ga je arrays gebruiken, meestal in combinatie met de for-loop.
Elke opdracht beschrijft wat je moet doen. Je ziet eventueel ook een voorbeeld van input en output. Input die de
gebruiker invoert is schuin en onderstreept.

Rij van random getallen
Schrijf een methode die een array van maakt met random getallen van 1 tot een zeker maximum. Je geeft de lengte van de
array mee en het maximum.
De methode heeft als signature public static int[] maakRandomRijGetallen(int mpAantal, int mpMaximum).
Maak in je main methode een rij getallen aan en print de getallen om te zien of het werkt.
Hoeveel getallen wil je genereren? 11
Wat is het grootste getal dat mag voorkomen? 50
Dit zijn de getallen: 8  50  28  27  49  9  44  15  15  43  19

Som van een rij getallen
Schrijf een methode die van een rij gehele getallen de som berekent.
De methode heeft als signature public static int somVanRij (int[] mpRij).

Gemiddelde van een rij getallen
Schrijf een methode die van een rij gehele getallen het gemiddelde berekent. Je kunt handig gebruik maken van de somVanRij
methode.
De methode heeft als signature public static double gemiddeldeVanRij (int[] mpRij).
Getallen: 29  33  11  17  39  6  34  47  36  16  42
De som is: 310
Het gemiddelde is: 28.181818181818183 * * * * * *

Minimum van een rij.
Schrijf een methode die van een rij getallen het minimum bepaalt. Hint: loop door de rij en vergelijk met het tot dan toe
kleinste getal, vind je een kleiner getal, sla dat dan op in het minimum.

Hoe vaak komt een getal voor?
Schrijf een methode die in een rij van getallen telt hoe vaak een getal daarin voorkomt.
De signature van de methode is public static int telVoorkomensInRij(int[] mpRij, int mpGetal). Test door in de main methode
een rij van 1000 willekeurige getallen te genereren die tussen 1 en 50 liggen. Tel hoe vaak getal 23 voorkomt.
“Get

Voorkomen van alle getallen tellen.
Schrijf een methode die voor alle getallen vanaf 1 tot aan een zekere bovengrens telt hoe vaak elk afzonderlijk getal in een
rij voorkomen. De methode moet een rij teruggeven, waarin de aantallen zijn opgeslagen. Hint: het aantal keer dat 1 voorkomt
staat op index 0, het aantal keer dat 23 voorkomt staat op index 22. Zorg dat de rij die je teruggeeft precies de juiste lengte
heeft.
Genereer in de main methode een rij van 1000 willekeurige getallen tussen 1 en 50. Tel van de getallen van 1 tot 50 hoe vaak
ze in de rij voorkomen.

Overzicht van voorkomens van getallen in rij:
Getal 1 komt 26 voor.
Getal 2 komt 15 voor.
Getal 3 komt 22 voor.
Getal 4 komt 22 voor.
Getal 5 komt 18 voor.
Getal 6 komt 19 voor.
Getal 7 komt 20 voor.
Getal 8 komt 19 voor.
Getal 9 komt 18 voor.
Getal 10 komt 19 voor.
………………… enz.

     */

    public static void main(String[] args) {

        // Doel:
        // opdracht 1: maak array met aantal getallen en max hoogte die door gebruiker worden ingegeven
        // opdracht 2: bereken som vd getallen in de gemaakte array en print dit
        // opdracht 3: bereken gemiddelde vd getallen en print dit
        // opdracht 4: bereken minimum en print dit
        // opdracht 5: bereken hoe vaak een getal (ingegeven door gebruiker) voorkomt en print dit
        // opdracht 6: bereken hoe vaak alle getallen voorkomen en print dit

        // Input
        int aantalGetallen; // opdracht 1
        int grootsteGetal;
        int somVanArrayMetGetallen; // opdracht 2
        double gemiddeldeVanArrayMetGetallen; // opdracht 3
        int minimumGetalVanArrayGetallen; // opdracht 4
        int hoeVaakKomtGetalVoorInArray; // opdracht 5
        int gevraagdeGetal;
        // opdracht 6

        // Verwerking
        // opdracht 1:
        aantalGetallen = vraagGetal("Hoeveel getallen wil je genereren?");
        grootsteGetal = vraagGetal("Wat is het grootste getal dat mag voorkomen?");
        int[] arrayMetGetallen = maakRandomRijGetallen(aantalGetallen, grootsteGetal);

        // opdracht 2:
        somVanArrayMetGetallen = somVanRij(arrayMetGetallen);

        // opdracht 3
        gemiddeldeVanArrayMetGetallen = gemiddeldeVanRij(arrayMetGetallen);

        // opdracht 4
        minimumGetalVanArrayGetallen = minimumVanRijRandomGetallen(arrayMetGetallen);

        // opdracht 5
        gevraagdeGetal = vraagGetal("Van welk getal wil je weten hoe vaak het voorkomt?");
        hoeVaakKomtGetalVoorInArray = telVoorkomensInRij(arrayMetGetallen,gevraagdeGetal);

        // opdracht 6
        int[] hoeVaakKomtElkGetalVoorInArray = berekenenHoeVaakKomtElkGetalVoorInArray(arrayMetGetallen, grootsteGetal);

        // Output
        printArray(arrayMetGetallen); // opdracht 1
        System.out.println("De som is: " + somVanArrayMetGetallen); // opdracht 2
        System.out.println("Het gemiddelde is: " + gemiddeldeVanArrayMetGetallen); // opdracht 3
        System.out.println("Het laagste getal is: " + minimumGetalVanArrayGetallen);// opdracht 4
        System.out.println("Het getal dat je vroeg, komt "+hoeVaakKomtGetalVoorInArray+" keer voor in de rij getallen.\n");// opdracht 5
        printAantalKeerDatElkGetalVoorkomt(hoeVaakKomtElkGetalVoorInArray); // opdracht 6
    }

    public static int[] maakRandomRijGetallen(int mpAantal, int mpMaximum) {
        int[] randomRijGetallen = new int[mpAantal];

        for (int i = 0; i < mpAantal; i++) {
            randomRijGetallen[i] = random.nextInt(mpMaximum)+1;
        }
        return randomRijGetallen;
    }

    public static int vraagGetal(String vraag) {
        System.out.println(vraag);
        return scanner.nextInt();
    }

    public static void printArray(int array[]) {
        System.out.print("Getallen:\n");
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + "\t");
            if ((i+1) % 10 == 0){
                System.out.println("");
            }
        }
        System.out.print("\n");
    }

    public static int somVanRij(int[] mpRij) {
        // Doel: som berekenen van rij random getallen

        // Input
        // array random getallen
        // variabele van som van deze getallen
        int somGetallenInRij = 0;

        // Verwerking
        // loop door array en tel componenten op
        for (int i = 0; i < mpRij.length; i++) {
            somGetallenInRij = somGetallenInRij + mpRij[i];
        }

        // Output
        // return som
        return somGetallenInRij;

    }

    public static double gemiddeldeVanRij(int[] mpRij) {
        // Doel: gemiddelde berekenen van rij met getallen

        // Input - gemiddelde + array aantal + som
        double gemiddeldeVanRij;

        // Verwerking - bereken gemiddelde + afronden
        gemiddeldeVanRij = (double) somVanRij(mpRij) / mpRij.length;
        gemiddeldeVanRij = (Math.round(gemiddeldeVanRij*10)/10.0);

        // Output - return gemiddelde
        return gemiddeldeVanRij;
    }

    public static int minimumVanRijRandomGetallen(int[] mpRij) {
        // Doel: zoek het laagste getal in een array

        // Input - laagste getal + array
        int laagsteGetal = Integer.MAX_VALUE;

        // Verwerking - loop door array en assign laagste getal
        for (int i = 0; i < mpRij.length; i++) {
            if (mpRij[i] < laagsteGetal) {
                laagsteGetal = mpRij[i];
            }
        }

        // Output - return getal
        return laagsteGetal;
    }

    public static int telVoorkomensInRij(int[] mpRij, int mpGetal) {
        // Doel: tel hoe vaak een getal voorkomt in een array

        // Input - array + te tellen getal + aantal
        int aantalKeerGetal = 0;

        // Verwerking
        for (int i = 0; i < mpRij.length; i++) {
            if (mpRij[i] == mpGetal){
                aantalKeerGetal++;
            }
        }

        // Output - return aantal
        return aantalKeerGetal;
    }

    public static int[] berekenenHoeVaakKomtElkGetalVoorInArray(int[] mpRij, int mpMaxGetal) {
        // Doel: uitrekenen hoe vaak elk getal in de rij voorkomt

        // Input - array + methode die getal telt - array om uitkomsten in op te slaan
        int[] arrayUitkomsten = new int[mpMaxGetal];

        // Verwerking - loop door array om per getal te kijken hoe vaak het voorkomt + opslaan uitkomst in array2
        for (int i = 0; i < mpMaxGetal; i++) {
            arrayUitkomsten[i] = telVoorkomensInRij(mpRij,(i+1));
        }

        // Output - return array met uitkomsten
        return arrayUitkomsten;
    }

    public static void printAantalKeerDatElkGetalVoorkomt(int[] mpAantalKeerGetal) {
        // Doel: printen van waardes van een array die iets zeggen over waardes in ander array

        // Input - array 2 (array 1 niet nodig omdat begonnen wordt bij getal 0 en dit oploopt)
        System.out.println("Overzicht van voorkomens van getallen in rij:\n");

        // Verwerking
        for (int i = 0; i < mpAantalKeerGetal.length; i++) {
            System.out.println("Getal "+(i+1)+" komt "+mpAantalKeerGetal[i]+" voor.");
        }

        // Output

    }
}

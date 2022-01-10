package controllerPackage;

import java.util.Locale;
import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        /*
Schrijf een applicatie die het gemiddelde uitrekent van twee of meer getallen. De gebruiker wordt altijd gevraagd om twee getallen te geven. Daarna wordt gevraagd of het om meer getallen gaat. Zolang de gebruiker ja zegt, gaat dit door. Als de gebruiker nee zegt, dan geeft het programma als resultaat het gemiddelde van de getallen.
Zie hier twee voorbeelden van input/output van deze applicatie. Input die de gebruiker invoert is schuin en onderstreept.
Dit programma berekent het gemiddelde van twee of meer getallen.
Geef het eerste getal: 34
Geeft het tweede getal: 15
Wil je van meer getallen het gemiddelde bepalen (ja/nee)? nee
Het gemiddelde van jouw 2 getallen is 24.5

Dit programma berekent het gemiddelde van twee of meer getallen.
Geef het eerste getal: 21
Geef het tweede getal: 8
Wil je van meer getallen het gemiddelde bepalen (ja/nee)? jo
Je moet ‘ja’ of ‘nee’ antwoorden.
Wil je van meer getallen het gemiddelde bepalen (ja/nee)? ja
Geef het volgende getal: 13
Wil je van meer getallen het gemiddelde bepalen (ja/nee)? ja
Geef het volgende getal: 5
Wil je van meer getallen het gemiddelde bepalen (ja/nee)? no
Je moet ‘ja’ of ‘nee’ antwoorden.
Wil je van meer getallen het gemiddelde bepalen (ja/nee)? nee
Het gemiddelde van jouw 4 getallen is 11.75
         */

        // Input
        System.out.println("Dit programma berekent het gemiddelde van twee of meer getallen.");
        int getal1;
        int getal2;
        double som;
        int aantalGetallen;
        double gemiddelde;
        String nogEen;
        boolean toevoegen = true;

        // Verwerking
        System.out.println("Geef het eerste getal: ");
        getal1 = scanner.nextInt();
        System.out.println("Geef het tweede getal: ");
        getal2 = scanner.nextInt();
        som = getal1 + getal2;
        aantalGetallen = 2;
        gemiddelde = som / 2.0;

        while (toevoegen) {
            System.out.println("Wil je van meer getallen het gemiddelde bepalen (ja/nee)?");
            nogEen = scanner.next();
            nogEen = nogEen.toLowerCase(Locale.ROOT);
            if (nogEen.equals("ja")) {
                aantalGetallen++;
                System.out.println("Geef het volgende getal: ");
                int extraGetal = scanner.nextInt();
                som = som + extraGetal;
            }
            if (nogEen.equals("nee")) {
                toevoegen = false;
            }
            if (!nogEen.equals("ja") && !nogEen.equals("nee")) {
                System.out.println("Je moet ‘ja’ of ‘nee’ antwoorden.");
            }
            gemiddelde = som / aantalGetallen;
        }


        // Output
        //System.out.println(som);
        //System.out.println(aantalGetallen);
        //System.out.println(gemiddelde);
        System.out.println("Het gemiddelde van jouw "+aantalGetallen+" getallen is "+gemiddelde+".");
    }


}

package controllerPackage;

import java.util.Scanner;

public class Opdracht323 {
    static Scanner scanner = new Scanner(System.in);
    static final String VAK_DATA = "Datastructures";
    static final String VAK_SS = "Sorting & Searching";
    static final int AANTAL_TOETSEN = 2;
    static final int AANTAL_VAKKEN = 3;
    static final int GRENS_VOLDOENDE = 12;

    public static void main(String[] args) {
        /*
        Cijfer theorie van de vakken Datastructures en Sorting & Searching
De theorie van de tweedejaars vakken Datastructures en Sorting & Searching van de opleiding tot Software Engineer in de voltijd variant worden getentamineerd met twee deeltoetsen.
Voor de normering van het theoriedeel van deze vakken gelden de volgende regels.
•	Een deeltoets is voldoende als het aantal punten >= 12 is.
•	Het cijfer dat daarbij hoort is: (aantal punten) / 2.
•	Een deeltoets is onvoldoende als het aantal punten < 12 is.
•	Het cijfer dat daarbij hoort is: (aantal punten - 1.5) / 2.
•	Alleen als beide deeltoetsen voldoende zijn gemaakt, dan krijgt de student een voldoende voor het vak.
•	Het eindcijfer is dan het gemiddelde van de beide voldoendes.
•	Als een van beide deeltoetsen onvoldoende is gemaakt, dan is het eindcijfer de onvoldoende voor die deeltoets.
Stappenplan
a.	Maak een nieuw Java project in IntelliJ genaamd “TheoriecijfersDSenSS”.
b.	Voor beide vakken declareer en initialiseer je:
•	een constante met de naam van het vak
•	een variabele met het eindcijfer voor het vak
c.	Declareer hierna voor ieder vak twee variabelen die het aantal behaalde punten voor de beide deeltoetsen bevatten. Gebruik de Scanner Class om je punten tijdens runtime in te voeren. Laat het programma de gebruiker om de punten vragen voor de twee deeltoetsen van beide vakken.
d.	Nadat de gebruiker de punten heeft ingevoerd kan het programma bepalen welke deeltoetsen met een voldoende zijn afgerond. En per vak kan het programma ook bepalen of een voldoende is gehaald en wat het eindcijfer is.
e.	Toon nu de resultaten per vak op het scherm. Gebruik de escape sequence “\t” (zie boek § 4.3) om de uitlijning van de uitvoer netjes te maken.

Input/Output
Zie hier een voorbeeld van input/output van deze applicatie. Input die de gebruiker invoert is schuin en onderstreept.
Voer de behaalde punten in voor het vak Datastructures:
Datastructures Deeltoets 1: 14
Datastructures Deeltoets 2: 11

Voer de behaalde punten in voor het vak Sorting & Searching:
Sorting & Searching Deeltoets 1: 13
Sorting & Searching Deeltoets 2: 18

Cijfer Datastructures Deeltoets 1: 7.0			Voldoende
Cijfer Datastructures Deeltoets 2: 4.75		Onvoldoende
Cijfer Sorting & Searching Deeltoets 1: 6.5		Voldoende
Cijfer Sorting & Searching Deeltoets 2: 9.0		Voldoende

Je hebt een onvoldoende voor het vak Datastructures.
Je cijfer is 4.8
Je hebt een voldoende voor het vak Sorting & Searching.
Je cijfer is 7.8

         */
        // doel:

        // input
        // variabelen voor alle behaalde punten en gelinkte cijfers/(on)voldoendes
        int puntenDataDeeltoets1;
        int puntenDataDeeltoets2;
        int puntenSSDeeltoets1;
        int puntenSSDeeltoets2;
        double cijferDataDeeltoets1;
        double cijferDataDeeltoets2;
        double cijferSSDeeltoets1;
        double cijferSSDeeltoets2;
        String voldoendeDataDeeltoets1;
        String voldoendeDataDeeltoets2;
        String voldoendeSSDeeltoets1;
        String voldoendeSSDeeltoets2;

        // verwerking
        // eerst vragen voor de 4 toetsen hoeveel punten zijn behaald (2 per vak)
        weergaveWelkVak(VAK_DATA);
        puntenDataDeeltoets1 = vragenBehaaldePunten("Datastructures Deeltoets 1: ");
        puntenDataDeeltoets2 = vragenBehaaldePunten("Datastructures Deeltoets 2: ");
        weergaveWelkVak(VAK_SS);
        puntenSSDeeltoets1 = vragenBehaaldePunten("Sorting & Searching Deeltoets 1: ");
        puntenSSDeeltoets2 = vragenBehaaldePunten("Sorting & Searching Deeltoets 2: ");

        // vervolgens punten per toets omzetten in cijfer
        cijferDataDeeltoets1 = berekenenCijfer(puntenDataDeeltoets1);
        cijferDataDeeltoets2 = berekenenCijfer(puntenDataDeeltoets2);
        cijferSSDeeltoets1 = berekenenCijfer(puntenSSDeeltoets1);
        cijferSSDeeltoets2 = berekenenCijfer(puntenSSDeeltoets2);

        // daarna ook kijken of toets (on)voldoende is ahv punten
        voldoendeDataDeeltoets1 = berekenenVoldoende(puntenDataDeeltoets1);
        voldoendeDataDeeltoets2 = berekenenVoldoende(puntenDataDeeltoets2);
        voldoendeSSDeeltoets1 = berekenenVoldoende(puntenSSDeeltoets1);
        voldoendeSSDeeltoets2 = berekenenVoldoende(puntenSSDeeltoets2);

        // output
        // weergave resultaten per toets
        weergaveEenToets(VAK_DATA, 1, cijferDataDeeltoets1, voldoendeDataDeeltoets1);
        weergaveEenToets(VAK_DATA, 2, cijferDataDeeltoets2, voldoendeDataDeeltoets2);
        weergaveEenToets(VAK_SS, 1, cijferSSDeeltoets1, voldoendeSSDeeltoets1);
        weergaveEenToets(VAK_SS, 2, cijferSSDeeltoets2, voldoendeSSDeeltoets2);

        // tenslotte weergave eindresultaten
        weergaveEindCijfer(VAK_DATA,voldoendeDataDeeltoets1,voldoendeDataDeeltoets2,cijferDataDeeltoets1,cijferDataDeeltoets2);
        weergaveEindCijfer(VAK_SS,voldoendeSSDeeltoets1,voldoendeSSDeeltoets2,cijferSSDeeltoets1,cijferSSDeeltoets2);
    }

    public static void weergaveWelkVak(String vak) {
        // doel: standaardvraag per vak
        System.out.println("Voer de behaalde punten in voor het vak " + vak + ":");
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

    public static void weergaveEenToets(String vak, int toets, double cijfer, String voldoende) {
        // doel: weergave van cijfer en (on)voldoende van een toets netjes uitgelijnd

        // input

        // verwerking

        // output
        System.out.println("Cijfer " + vak + " Deeltoets " + toets + ":\t" + cijfer + "\t" + voldoende);
    }

    public static void weergaveEindCijfer(String vak, String voldoende1, String voldoende2, double cijfer1, double cijfer2){
        // doel: berekening en weergave van het eindcijfer en (on)voldoende

        // input
        double eindCijfer;
        double eindCijferAfgerond;
        String eindVoldoende;

        // verwerking
        /*
        •	Alleen als beide deeltoetsen voldoende zijn gemaakt, dan krijgt de student een voldoende voor het vak.
        •	Het eindcijfer is dan het gemiddelde van de beide voldoendes.
        •	Als een van beide deeltoetsen onvoldoende is gemaakt, dan is het eindcijfer de onvoldoende voor die deeltoets.
        */
        if (voldoende1.equals("Voldoende") && voldoende2.equals("Voldoende")){
            eindCijfer = (cijfer1+cijfer2)/2;
            eindVoldoende = "voldoende";
        } else {
            if (cijfer1 < cijfer2){
                eindCijfer = cijfer1;
            } else {
                eindCijfer = cijfer2;
            }
            eindVoldoende = "onvoldoende";
        }

        eindCijferAfgerond = Math.round(eindCijfer*10);
        eindCijferAfgerond = eindCijferAfgerond/10;

        // output
        System.out.println("Je hebt een "+eindVoldoende+" voor het vak "+vak+".\n" +
                "Je cijfer is "+eindCijferAfgerond);
    }
    // doel:

    // input

    // verwerking

    // output
}

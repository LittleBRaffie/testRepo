package com.company;

import java.util.Scanner;

public class OefententamenParkeerGarage2 {
    static Scanner scanner = new Scanner(System.in);
    /*Parkeergarage
Inleiding
Het doel van deze opdracht is om een applicatie te schrijven die de parkeerkosten berekent in een
parkeergarage. Na het invoeren van auto’s die geparkeerd hebben, bepaalt de applicatie de
parkeerkosten voor elke auto en de totale parkeerkosten voor alle auto’s die hebben geparkeerd.

De parkeertarieven in de parkeergarage zijn als volgt:
Het tarief voor de eerste 3 uur is € 3,75 per uur. Voor de uren daarna is het tarief € 2,75 per uur.
De maximale parkeerkosten bedragen € 25,--, dit is de prijs van een dagkaart.

Outputvoorbeeld
Zorg dat de output van je programma er hetzelfde uitziet als onderstaand outputvoorbeeld. Voor de
duidelijkheid zijn in het voorbeeld de gegevens die de gebruiker heeft ingevoerd schuin en
onderstreept. Jouw programma hoeft dus niets schuin en onderstreept af te drukken.

Dit programma is gemaakt door <student>, <klas>, <studentnummer>
Hoeveel auto's hebben geparkeerd? 5
Auto 1
 Kenteken: 91-RXK-6
 Geparkeerde uren (max. 24): 12
Auto 2
 Kenteken: 84-VR-NP
 Geparkeerde uren (max. 24): 1
Auto 3
 Kenteken: 2-ZNH-47
 Geparkeerde uren (max. 24): 4
Auto 4
 Kenteken: 06-LK-VP
 Geparkeerde uren (max. 24): 25
 De parkeerduur kan maximaal 24 uur zijn.
 Geparkeerde uren (max. 24): 24
Auto 5
 Kenteken: 48-KHB-5
 Geparkeerde uren (max. 24): 7
Parkeeroverzicht
kenteken uren bedrag
91-RXK-6 12 25.00
84-VR-NP 1 3.75
2-ZNH-47 4 14.00
06-LK-VP 24 25.00
48-KHB-5 7 22.25
Totaal van alle parkeergelden: 90.0 euro.

     */

    public static void main(String[] args) {
        // Doel: Applicatie die x aantal auto's als invoer krijgt (kenteken en parkeerduur) en hier parkeerkosten voor uitrekent.
        // Op het einde volgt een overzicht van alle auto's met kosten per auto en het totaal.

        // Input
        // Auteurgegevens
        System.out.println("\nDit programma is gemaakt door Ralf Wingen, Make IT Work, 479112.\n");
        // max parkeerduur
        final int MAX_PARKEERDUUR = 24;
        // totaal aantal auto's = array length
        int aantalAutos = 0;
        // totaalkosten
        double totaalkosten = 0.0;

        // Verwerking
        // invoer gebruiker aantal auto's
        aantalAutos = invoerGebruikerInt("Hoeveel auto's hebben geparkeerd?");
        // array voor kenteken, parkeerduur, kosten (pas aanmaken nadat aantal auto's bekend is)
        String[] kentekenPerAuto = new String[aantalAutos];
        int[] parkeerduurPerAuto = new int[aantalAutos];
        double[] parkeerkostenPerAuto = new double[aantalAutos];
        // invoer gebruiker gegevens per auto
        for (int i = 0; i < aantalAutos; i++) {
            System.out.println("Auto " + (i + 1));
            kentekenPerAuto[i] = invoerenGebruikerString("Kenteken: ");
            parkeerduurPerAuto[i] = invoerGebruikerInt("Geparkeerde uren (max. 24):");
            if (parkeerduurPerAuto[i] > MAX_PARKEERDUUR) {
                System.out.println("De parkeerduur kan maximaal 24 uur zijn, voor deze auto wordt dat dus berekend.");
                parkeerduurPerAuto[i] = MAX_PARKEERDUUR;
            }
        }
        // uitrekenen kosten per auto
        parkeerkostenPerAuto = berekenenParkeerkostenPerAuto(parkeerduurPerAuto);
        // uitrekenen kosten totaal
        totaalkosten = uitrekenenTotaalKosten(parkeerkostenPerAuto);

        // Output
        // printen overzicht alle auto's
        printenArrays(kentekenPerAuto, parkeerduurPerAuto, parkeerkostenPerAuto);
        // printen totaalkosten
        System.out.printf("%-31s %5.2f", "Totaal van alle parkeergelden: ", totaalkosten);
    }

    public static int invoerGebruikerInt(String vraag) {
        // Doel: invoer int vragen aan gebruiker

        // Input
        System.out.print(vraag);
        int aantal = 0;

        // Verwerking
        aantal = scanner.nextInt();

        // Output
        return aantal;
    }

    public static String invoerenGebruikerString(String vraag) {
        // Doel: invoer String vragen aan gebruiker

        // Input
        System.out.print(vraag);
        String invoer;

        // Verwerking
        invoer = scanner.next();

        // Output
        return invoer;
    }

    public static double[] berekenenParkeerkostenPerAuto(int duur[]) {
        // Doel: per auto uitrekenen wat de parkeerkosten zijn, afgerond op 2 decimalen

        // Input - parkeerkosten + parkeerduur + tarieven
        double[] parkeerkosten = new double[duur.length]; // indien vermelden in klasse maak dit PRIVATE!!! dus private static variabele
        final int ONDERGRENS = 3;
        final double TARIEF_EERSTE_3UUR = 3.75;
        final double TARIEF_NORMAAL = 2.75;
        final double TARIEF_DAGKAART = 25.00;

        // Verwerking - loop door array
        for (int i = 0; i < duur.length; i++) {
            // eerste 3 uur = € 3,75 per uur
            if (duur[i] <= ONDERGRENS) {
                parkeerkosten[i] = (double) duur[i] * TARIEF_EERSTE_3UUR;
            } else { // daarna = € 2,75 per uur
                parkeerkosten[i] = ((double) ONDERGRENS * TARIEF_EERSTE_3UUR) + ((double) (duur[i] - ONDERGRENS) * TARIEF_NORMAAL);
            }
            // max = € 25,- = dagkaart
            if (parkeerkosten[i] > TARIEF_DAGKAART) {
                parkeerkosten[i] = TARIEF_DAGKAART;
            }
        }

        // Output
        return parkeerkosten;
    }

    public static double uitrekenenTotaalKosten(double[] kosten) {
        // Doel: uitrekenen totaal kosten van een array

        // Input
        double totaalKosten = 0;

        // Verwerking
        for (int i = 0; i < kosten.length; i++) {
            totaalKosten = totaalKosten + kosten[i];
        }

        // Output
        return totaalKosten;
    }

    public static void printenArrays(String[] kenteken, int[] duur, double[] kosten) {
        // Doel: van elke auto de bijhorende informatie printen

        // Input
        System.out.println("\nParkeeroverzicht");
        System.out.printf("%-10s %-5s %-6s", "Kenteken ", "Uren ", "Bedrag");
        System.out.println("");

        // Verwerking
        for (int i = 0; i < kenteken.length; i++) {
            System.out.printf("%-10s %-5d %6.2f", kenteken[i], duur[i], kosten[i]);
            System.out.println("");
        }

        // Output
    }
}

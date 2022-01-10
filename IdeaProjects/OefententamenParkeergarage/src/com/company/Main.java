package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
    //main method wordt automatisch uitgevoerd en roept de twee methodes aan die het parkeerprogramma uitvoeren
	intro();
    autoGegevens();
    }

    //methode voor weergave van studentinfo
    public static void intro() {
        System.out.println("");
        System.out.println("Dit programma is gemaakt door Ralf Wingen, Make IT Work, 479112");
        System.out.println("");
        System.out.println("Opdracht: Het doel van deze opdracht is om een applicatie te schrijven die de parkeerkosten berekent in een \n" +
                "parkeergarage. Na het invoeren van auto’s die geparkeerd hebben, bepaalt de applicatie de \n" +
                "parkeerkosten voor elke auto en de totale parkeerkosten voor alle auto’s die hebben geparkeerd.");
        System.out.println("");
    }

    //methode om userinput te gebruiken (int)
    public static int invoerGebruikerGetal(){
        Scanner invoerGebruiker = new Scanner (System.in);
        System.out.println("Voer een getal in via de numpad en druk op 'Enter'.");
        int ingevoerdeGetal = invoerGebruiker.nextInt();
        return ingevoerdeGetal;
    }

    //methode om userinput te gebruiken (double)
    public static double invoerGebruikerDecimaalGetal(){
        Scanner invoerGebruiker = new Scanner (System.in);
        System.out.println("Voer een decimaalgetal in via de numpad en druk op 'Enter'. Gebruik geen punt, maar een komma!");
        double ingevoerdeGetal = invoerGebruiker.nextDouble();
        return ingevoerdeGetal;
    }

    //methode om userinput te gebruiken (String)
    public static String invoerGebruikerTekst(){
        Scanner invoerGebruiker = new Scanner (System.in);
        System.out.println("Voer tekst in via het toetsenbord en druk op 'Enter'.");
        String ingevoerdeTekst = invoerGebruiker.nextLine();
        return ingevoerdeTekst;
    }

    //methode om aantal auto's in te voeren
    public static int totaalAantalAutos() {
        //vraag gebruiker om input
        System.out.println ("Hoeveel auto's hebben geparkeerd?");
        //ingevoerde aantal wordt opgeslagen
        int totaalAantalAutos = invoerGebruikerGetal();
        while (totaalAantalAutos > 25 || totaalAantalAutos < 0){
            if (totaalAantalAutos > 25) {
                System.out.println("Helaas is dit niet mogelijk, de parkeergarage heeft maar 25 plaatsen.");
            } else {
                System.out.println("Je hebt een typefout gemaakt, een negatief aantal auto's is niet mogelijk.");
            }
            totaalAantalAutos = invoerGebruikerGetal();
        }

        System.out.println("Totaal aantal geparkeerde auto's is: " + totaalAantalAutos);
        System.out.println("");

        //methode returned het totaalAantalAutos als int waarde
        return totaalAantalAutos;
    }

    //methode om parkeergeld per auto te berekenen
    public static double berekenParkeergeld(int parkeerduur){
        double parkeergeld;

        //Het tarief voor de eerste 3 uur is € 3,75 per uur. Voor de uren daarna is het tarief € 2,75 per uur.
        if (parkeerduur < 4) {
            parkeergeld = parkeerduur * 3.75;
        } else {
            parkeergeld = (3 * 3.75) + ((parkeerduur - 3) * 2.75);
        }

        //De maximale parkeerkosten bedragen € 25,--, dit is de prijs van een dagkaart
        if (parkeergeld > 25) {
            parkeergeld = 25.00;
        }
        System.out.println(parkeergeld);
        return parkeergeld;
    }

    public static void autoGegevens() {
        String[] kenteken = new String[25]; //maximale aantal auto's is 25 (dus max lengte array)
        int[] parkeerduur = new int[25];
        double[] parkeergeld = new double[25];
        double totaalParkeergeld = 0;
        int totaalAutos = totaalAantalAutos();

        //loop om de auto's 1-voor-1 te doorlopen ahv het gegeven totaal aantal
        for (int i = 0; i < totaalAutos; i++) {
            //Vraag om input per auto van de gebruiker, eerst kenteken, dan parkeertijd
            System.out.println("Welk kenteken heeft de " + (i + 1) + "e auto?");
            kenteken[i] = invoerGebruikerTekst();

            System.out.println("Hoeveel uur heeft deze auto geparkeerd (max. 24 uur)?");
            parkeerduur[i] = invoerGebruikerGetal();

            //Omdat de parkeerduur een positief getal moet zijn en maximaal 24 uur is, onderstaande 2 statements die om nieuwe invoer vragen indien dit niet zo is
            while (parkeerduur[i] < 0) {
                System.out.println("Foute invoer, voer een positief getal in.");
                parkeerduur[i] = invoerGebruikerGetal();
            }

            if (parkeerduur[i] > 24) {
                System.out.println("Auto heeft langer dan 24 uur geparkeerd. Dit wordt afgerond naar een dagkaart van 24 uur.");
            }

            //Wanneer de gebruiker het kenteken en de tijd heeft ingevoerd, worden de kosten berekend mbv de parkeerduur en berekenParkeergeld-methode
            parkeergeld[i] = berekenParkeergeld(parkeerduur[i]);
            //Tevens wordt het parkeergeld per auto [i] meteen bij het totaal geteld
            totaalParkeergeld = totaalParkeergeld + parkeergeld[i];

            System.out.println("");

        }
        System.out.println("Parkeeroverzicht:");
        System.out.println("Auto    - Kenteken - Parkeerduur - Parkeerkosten");
        for (int i = 0; i < totaalAutos; i++){
            System.out.println("Auto " + (i+1) + ": - " + kenteken[i] + "   - " + parkeerduur[i] + " uur      - € " + parkeergeld[i]);
        }
        System.out.println("");
        System.out.println("Totale parkeerkosten: " + totaalParkeergeld);
        System.out.println("");
    }

}

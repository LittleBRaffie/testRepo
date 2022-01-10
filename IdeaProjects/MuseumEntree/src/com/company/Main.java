package com.company;

import java.util.Locale;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	    // Aanroepen verschillende methodes
        intro();
        String naamKassaMedewerker = kassamedewerker();
        int dagVanDeWeek = welkeDagVanDeWeek();

        if (dagVanDeWeek > 2){
            System.out.println("Goed gewerkt " + naamKassaMedewerker + "! Je mag je kassa sluiten.");
        } else if (dagVanDeWeek == 2) {
            System.out.println("Je hoeft vandaag je bezoekers niet te registreren.");
        }

    }

    public static void intro(){
        //Begintekst met het doel van het programma
        System.out.println("");
        System.out.println("Dit programma rekent automatisch uit welk tarief iemand moet betalen aan de kassa van een \n" +
                "museum. Daarnaast kijkt het programma ook naar de dagen van de week want op maandag is het museum \n" +
                "gesloten en op dinsdag is toegang voor iedereen gratis.");
        System.out.println("");

        //Vervolgens leest men ook dat ik het programma heb gemaakt
        System.out.println("Dit programma is gemaakt door Ralf Wingen, 479112 op 28 augustus 2021");
        System.out.println("");
    }

    public static String invoerGebruikerTekst() {
        //methode om tekstinput van de gebruiker te vragen
        Scanner invoerGebruiker = new Scanner(System.in);
        //System.out.println("Voer hieronder de gewenste tekst in en druk op 'Enter'.");
        String invoerTekst = invoerGebruiker.next();
        System.out.println("");
        //System.out.println(invoerTekst);
        return invoerTekst;
    }

    public static double invoerGebruikerGetal() {
        //methode om numerieke (decimale) input van de gebruiker te vragen
        Scanner invoerGebruiker = new Scanner (System.in);
        //System.out.println("Voer een getal in (voor decimalen, gebruik een komma) en druk op 'Enter'.");
        double invoerGetal = invoerGebruiker.nextDouble();
        System.out.println("");
        //System.out.println(invoerGetal);
        return invoerGetal;
    }

    public static boolean isIetsWaar () {
        //methode om te zien of er een situatie waar is, hier geeft de kassamedewerker antwoord op geeft
        //invoer omzetten in kleine letters omdat if-statement hoofdletter gevoelig is
        String vraag = invoerGebruikerTekst().toLowerCase(Locale.ROOT);
        boolean isTrue = false;
        //zolang geen ja of nee wordt gegeven, blijft deze boolean false en de loop zich herhalen
        boolean juisteInvoer = false;

        do {
            if (vraag.equals("ja")) {
                isTrue = true;
                juisteInvoer = true;
            } else if (vraag.equals("nee")) {
                isTrue = false;
                juisteInvoer = true;
            } else {
                System.out.print("Onjuiste invoer, probeer het opnieuw.");
                System.out.println("");
                vraag = invoerGebruikerTekst().toLowerCase(Locale.ROOT);
            }
        } while (!juisteInvoer);

        return isTrue;
    }

    public static String kassamedewerker() {
        //methode om de kassamedewerker die de tickets invoert te registreren
        System.out.println("Voer uw voornaam in en druk op 'Enter'.");
        String voornaam = invoerGebruikerTekst();
        //System.out.println("");

        System.out.println("Voer uw achternaam in en druk op 'Enter'.");
        String achternaam = invoerGebruikerTekst();
        //System.out.println("");

        String naam = voornaam + " " + achternaam;
        System.out.println("Kassamedewerker: " + naam);
        System.out.println("");

        return naam;
    }

    public static int welkeDagVanDeWeek (){
        //methode om de dag van de week te bepalen, en of er dus nog speciale voorwaarden zijn
        System.out.println("Welke dag is het vandaag? Kies het bijhorende cijfer.");
        System.out.println("1 = Maandag");
        System.out.println("2 = Dinsdag");
        System.out.println("3 = Woensdag");
        System.out.println("4 = Donderdag");
        System.out.println("5 = Vrijdag");
        System.out.println("6 = Zaterdag");
        System.out.println("7 = Zondag");

        int dag = (int) invoerGebruikerGetal();

        while (dag < 0 || dag > 7){
            System.out.println("Ongeldige invoer, kies een getal tussen 1 en 7.");
            dag = (int) invoerGebruikerGetal();
        }

        switch (dag){
            case 1:
                System.out.println("Vandaag is het museum gesloten, tijd voor de administratie!");
                break;
            case 2:
                System.out.println("Vandaag geldt een promotieactie en is toegang voor iedereen gratis.");
                break;
            default:
                System.out.println("Vandaag gelden de normale tarieven. Check of bezoekers individuele korting krijgen.");
                System.out.println("");
                bezoekerRegistratie();
                break;
        }

        return dag;
    }

    public static double berekeningTicketPrijs (){
        int leeftijd;
        boolean isStudent;
        double prijsPerPersoon = 15.00;

        //Eerst wordt naar de leeftijd van de bezoeker gevraagd
        System.out.println("Wat is de leeftijd van de eerstvolgende bezoeker?");
        leeftijd = (int) invoerGebruikerGetal();

        //Erna wordt gevraagd of de bezoeker student is
        System.out.println("Is de bezoeker een student? (type 'ja' of 'nee' en druk op 'Enter')");
        isStudent = isIetsWaar();

        if (leeftijd <= 18 || leeftijd > 65 || isStudent) {
            prijsPerPersoon = 7.50;
            System.out.println("De bezoeker voldoet aan één van de criteria om 50% korting te krijgen.");
        }

        System.out.println("Deze bezoeker betaalt: € " + prijsPerPersoon);
        System.out.println("");

        return prijsPerPersoon;
    }

    public static void bezoekerRegistratie(){
        boolean volgendGroepje = true;
        double ticketPrijs = 0.00;
        double ticketPrijsPerGroep;
        int aantalBezoekersPerGroepje;
        int totaalAantalBezoekers = 0;
        double totaalOmzet = 0.00;

        System.out.println("De eerste bezoekers van vandaag staan aan de kassa.");
        do {
            //methode om per groepje bezoekers per persoon uit te rekenen wat ze moeten betalen. Tevens wordt totale prijs van de groep gegeven
            System.out.println("Uit hoeveel bezoekers bestaat deze groep?");
            aantalBezoekersPerGroepje = (int) invoerGebruikerGetal();
            totaalAantalBezoekers = totaalAantalBezoekers + aantalBezoekersPerGroepje;
            ticketPrijsPerGroep = 0.00;

            for (int i = 0; i < aantalBezoekersPerGroepje; i++){
                ticketPrijs = berekeningTicketPrijs();
                ticketPrijsPerGroep = ticketPrijsPerGroep + ticketPrijs;
            }

            totaalOmzet = totaalOmzet + ticketPrijsPerGroep;

            System.out.println("Het totaalaantal bezoekers van deze groep is: " + aantalBezoekersPerGroepje);
            System.out.println("Het totaalbedrag van deze groep is: € " + ticketPrijsPerGroep);
            System.out.println("");

            System.out.println("Staat er nog een groepje in de wachtrij? (type 'ja' of 'nee' en druk op 'Enter')");
            volgendGroepje = isIetsWaar();
            System.out.println("");

        } while (volgendGroepje);

        System.out.println("Het totaal aantal bezoekers vandaag is: " + totaalAantalBezoekers);
        System.out.println("Het totaalbedrag van vandaag is: € " + totaalOmzet);
        System.out.println("");
    }
}

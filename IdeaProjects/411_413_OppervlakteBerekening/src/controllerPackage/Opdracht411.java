package controllerPackage;

import java.util.Random;
import java.util.Scanner;

public class Opdracht411 {
    static Scanner scanner = new Scanner(System.in);
    static Random random = new Random();
    /*
    Beschrijving
Schrijf een applicatie waarin de gebruiker kan oefenen met het uitrekenen van de oppervlakte van een driehoek. De applicatie vraagt aan de gebruiker of die wil doorgaan of stoppen. Bij doorgaan geeft het een willekeurig hoogte en basis van de driehoek. De applicatie vraagt om het antwoord van de gebruiker en geeft aan of het goed of fout is. Bij een fout antwoord geeft de applicatie alsnog het juiste antwoord. De gebruiker kan dan kiezen om nog een berekening te gaan doen of te stoppen.
Hieronder een voorbeeld van input/output van deze applicatie. Input die de gebruiker invoert is schuin en onderstreept.
Wil je de oppervlakte van een driehoek uitrekenen?
Doorgaan (j/n)?: j
Bereken de oppervlakte van
een driehoek met basis 8 en hoogte 5: 40

Jouw antwoord is fout!
Het juiste antwoord is 20.0.

Wil je de oppervlakte van een driehoek uitrekenen?
Doorgaan (j/n)?:  j
Bereken de oppervlakte van
een driehoek met basis 6 en hoogte 2: 6

Jouw antwoord is goed!
Wil je de oppervlakte van een driehoek uitrekenen?
Doorgaan (j/n)?: n
Het programma wordt nu gestopt.
Stappenplan
a.	Maak een Scanner aan voor het krijgen van invoer van de gebruiker (zie boek § 2.3).
b.	Gebruik een while-loop om het programma door te laten gaan zolang de gebruiker geen ‘n’ intypt.
c.	Gebruik de Math.random() methode om twee willekeurige gehele getallen tussen 2 en 10 te genereren.
d.	Vraag de gebruiker om het antwoord.
e.	Maak een methode berekenOppervlakteDriehoek(int mpBasis, int mpHoogte), die de oppervlakte berekent en bereken de oppervlakte van de driehoek op basis van de gegenereerde getallen.
f.	Vergelijk de juiste oppervlakte met het antwoord van de gebruiker en geef de toepasselijke reactie.
g.	Zorg ervoor dat je input en output precies overeenkomt met het hierboven gegeven voorbeeld.
Tip: test steeds tussendoor of je programma werkt door het te runnen.

     */

    public static void main(String[] args) {
        // Doel: Quiz programma over uitrekenen van de oppervlakte van een driehoek

        // Input
        char letter = 'j';
        int basisDriehoek = 0;
        int hoogteDriehoek = 0;
        double oppervlakteDriehoek = 0.0;
        double antwoordGebruiker = 0.0;

        // Verwerking
        // Vragen gebruiker doorgaan/stoppen? - methode + do/while
        // Genereren van 2 nummer voor de quiz
        // Quiz ( 1 = geven hoogte + basis driehoek 2 = vraag antwoord 3 = Controle + geven juiste antwoord
        // Vragen gebruiker doorgaan/stoppen?
        do {
            // vragen of gebruiker (nog een) som wil maken
            letter = vraagOmInputGebruikerChar("Wil je de oppervlakte van een driehoek uitrekenen?\nDoorgaan? (j/n)");
            // zolang er geen j of n geantwoord wordt, blijft de vraag opnieuw gesteld worden
            while (letter != 'j' && letter != 'n') {
                letter = vraagOmInputGebruikerChar("Foutieve invoer.\nDoorgaan? (j/n)");
            }
            // als de gebruiker j zegt, wordt de som gevraagd, zo niet (dus n geantwoord) stopt het programma
            if (letter == 'j') {
                //quiz: 1) genereer 2 getallen 2) bereken oppervlakte 3) vraag antwoord gebruiker en 4) geeft uitslag
                basisDriehoek = genereerRandomNummer();
                hoogteDriehoek = genereerRandomNummer();
                oppervlakteDriehoek = uitrekenenOppervlakteDriehoek(basisDriehoek, hoogteDriehoek);
                antwoordGebruiker = vraagOmInputGebruikerDouble("Bereken de oppervlakte van een driehoek met basis " + basisDriehoek + " en hoogte " + hoogteDriehoek + " (gebruik de komma voor decimalen).");
                controleAntwoordGebruiker(antwoordGebruiker, oppervlakteDriehoek);
            } else {
                break;
            }

            //
        } while (letter == 'j');

        // Output

    }

    public static double vraagOmInputGebruikerDouble(String vraag) {
        // Doel: methode om gebruikerinput te vragen en op te slaan

        // Input
        double invoer;

        // Verwerking
        System.out.println(vraag);
        invoer = scanner.nextDouble();

        // Output
        return invoer;
    }

    public static char vraagOmInputGebruikerChar(String vraag) {
        // Doel: methode om gebruikerinput te vragen en op te slaan

        // Input
        char invoer;

        // Verwerking
        System.out.println(vraag);
        invoer = scanner.next().charAt(0);
        if (invoer == 'J') {
            invoer = 'j';
        } else if (invoer == 'N') {
            invoer = 'n';
        }

        // Output
        return invoer;
    }

    public static int genereerRandomNummer() {
        // Doel: methode om een random nummer te genereren

        // Input
        int randomNummer = 0;

        // Verwerking
        randomNummer = random.nextInt(10) + 1;

        // Output
        return randomNummer;
    }

    public static double uitrekenenOppervlakteDriehoek(int basis, int hoogte) {
        // Doel: methode om met de hoogte en basis van een driehoek de oppervlakte uit te rekenen

        // Input
        double oppervlakte = 0.0;

        // Verwerking
        // Oppervlakte driehoek = (BASIS x HOOGTE)/2
        oppervlakte = (basis * hoogte) / 2.0;

        // Output
        return oppervlakte;

    }

    public static void controleAntwoordGebruiker(double antwoordGebruiker, double correctAntwoord) {
        // Doel: methode om antwoord gebruiker te vergelijken met het correcte antwoord en uitslag mede te delen

        // Input

        // Verwerking
        if (antwoordGebruiker == correctAntwoord) {
            System.out.println("Jouw antwoord is goed!");
        } else {
            System.out.println("Jouw antwoord is fout!\nHet juiste antwoord is "+correctAntwoord+".");
        }

        // Output

    }

}

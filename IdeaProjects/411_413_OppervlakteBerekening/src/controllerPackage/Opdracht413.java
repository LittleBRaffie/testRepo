package controllerPackage;

import java.util.Scanner;

public class Opdracht413 {
    static Scanner scanner = new Scanner(System.in);
    static final double PI = Math.PI;

    public static void main(String[] args) {
        /*
        Programming –opdracht 4.1.3
Oppervlakteberekening gevorderden
Beschrijving
Schrijf een applicatie die van een cirkel, een rechthoek, een vierkant en een driehoek de oppervlakte uit kan rekenen. De applicatie vraagt aan de gebruiker van welke figuur de oppervlakte moet worden berekend en vraagt dan afhankelijk van de keuze om de juiste informatie (straal bij een cirkel, hoogte en breedte bij een rechthoek, zijde bij een vierkant, basis en hoogte bij een driehoek). De applicatie geeft de juiste oppervlakte terug. De gebruiker kan dan kiezen om nog een berekening te laten doen of te stoppen.
Hieronder een voorbeeld van input/output van deze applicatie. Input die de gebruiker invoert is schuin en onderstreept.
Van welke figuur wil je de oppervlakte uit laten rekenen? (cirkel = 1; rechthoek = 2; vierkant = 3; driehoek = 4; stoppen = 0): 2
Wat is de hoogte in centimeter? 12
Wat is de breedte in centimeter? 5

De oppervlakte van jouw rechthoek is 60 vierkante centimeter.
Van welke figuur wil je de oppervlakte uit laten rekenen? (cirkel = 1; rechthoek = 2; vierkant = 3; driehoek = 4; stoppen = 0): 3
Wat is de zijde in centimeter? 7

De oppervlakte van jouw vierkant is 49 vierkante centimeter.
Van welke figuur wil je de oppervlakte uit laten rekenen? (cirkel = 1; rechthoek = 2; vierkant = 3; driehoek = 4; stoppen = 0): 0
Het programma wordt nu gestopt.
Stappenplan
a.	Maak een Scanner aan voor het krijgen van invoer van de gebruiker (zie boek § 2.3).
b.	Gebruik een while-loop om het programma door te laten gaan zolang de gebruiker geen 0 intypt.
c.	Maak voor de oppervlakte berekeningen methodes aan. Je hebt dus vier methodes nodig.
d.	Gebruik de constante Math.PI voor het getal π voor het berekenen van de oppervlakte van een cirkel.
e.	Je kunt voor het afhandelen van de keuzes een switch-statement gebruiken, maar het kan ook met een serie van if-statements.
f.	Geef de oppervlakte als output weer op de console. Controleer of je berekening klopt.
g.	Zorg ervoor dat je input en output precies overeenkomt met het hierboven gegeven voorbeeld.
Tip: test steeds tussendoor of je programma werkt door het te runnen.

         */
        // Doel:

        // Input
        int keuzeGebruiker = 5;

        // Verwerking
        // while loop om andere berekening te doen + switch statement voor keuze
        while (keuzeGebruiker != 0){
            int invoerGebruiker;
            int invoerGebruiker2;
            int oppervlakteFiguur;

            // vragen keuze gebruiker
            keuzeGebruiker = vragenGebruikerInputInt("Van welke figuur wil je de oppervlakte uit laten rekenen?" +
                    "\n(cirkel = 1; rechthoek = 2; vierkant = 3; driehoek = 4; stoppen = 0):");

            switch (keuzeGebruiker){
                case 1:
                    invoerGebruiker = vragenGebruikerInputInt("Wat is de straal in centimeters?");
                    oppervlakteFiguur = berekenenOppervlakteCirkel(invoerGebruiker);
                    System.out.println("De oppervlakte van jouw cirkel is "+oppervlakteFiguur+" vierkante centimeter.");
                    break;
                case 2:
                    invoerGebruiker = vragenGebruikerInputInt("Wat is de lengte in centimeters?");
                    invoerGebruiker2 = vragenGebruikerInputInt("Wat is de breedte in centimeters?");
                    oppervlakteFiguur = berekenenOppervlakteRechthoek(invoerGebruiker,invoerGebruiker2);
                    System.out.println("De oppervlakte van jouw rechthoek is "+oppervlakteFiguur+" vierkante centimeter.");
                    break;
                case 3:
                    invoerGebruiker = vragenGebruikerInputInt("Wat is een zijde in centimeters?");
                    oppervlakteFiguur = berekenenOppervlakteVierkant(invoerGebruiker);
                    System.out.println("De oppervlakte van jouw vierkant is "+oppervlakteFiguur+" vierkante centimeter.");
                    break;
                case 4:
                    invoerGebruiker = vragenGebruikerInputInt("Wat is de hoogte in centimeters?");
                    invoerGebruiker2 = vragenGebruikerInputInt("Wat is de basis in centimeters?");
                    oppervlakteFiguur = berekenenOppervlakteDriehoek(invoerGebruiker2,invoerGebruiker);
                    System.out.println("De oppervlakte van jouw driehoek is "+oppervlakteFiguur+" vierkante centimeter.");
                    break;
                case 0:
                    System.out.println("Het programma wordt nu gestopt.");
                    break;
                default:
                    System.out.println("Foute invoer. Kiers opnieuw.");
                    break;
            }
            System.out.println("\n3");
        }

        // Output

    }

    public static int vragenGebruikerInputInt(String vraag) {
        // Doel: getalinvoer van gebruiker vragen en opslaan

        // Input
        int getal;

        // Verwerking
        System.out.println(vraag);
        getal = scanner.nextInt();

        // Output
        return getal;
    }

    public static int berekenenOppervlakteVierkant(int zijdeVierkant) {
        // Doel: oppervlakteberekening vierkant ahv ingegeven zijde

        // Input
        int oppervlakteVierkant;

        // Verwerking
        // opp = lengte x lengte
        oppervlakteVierkant = zijdeVierkant * zijdeVierkant;

        // Output
        return oppervlakteVierkant;
    }

    public static int berekenenOppervlakteRechthoek(int lengteRechthoek, int breedteRechthoek) {
        // Doel: oppervlakteberekening rechthoek ahv ingegeven lengte en breedte

        // Input
        int oppervlakteRechthoek;

        // Verwerking
        // opp = lengte x breedte
        oppervlakteRechthoek = lengteRechthoek * breedteRechthoek;

        // Output
        return oppervlakteRechthoek;

    }

    public static int berekenenOppervlakteCirkel(int straalCirkel) {
        // Doel: oppervlakteberekening cirkel ahv ingegeven

        // Input
        double oppervlakteCirkel;
        int oppervlakte;

        // Verwerking
        // opp = (straal x straal) x pi
        oppervlakteCirkel = Math.round((Math.pow (straalCirkel, 2)) * PI);
        oppervlakte = (int) oppervlakteCirkel;

        // Output
        return oppervlakte;
    }

    public static int berekenenOppervlakteDriehoek(int basis, int hoogte) {
        // Doel: oppervlakteberekening driehoek ahv ingegeven basis en hoogte

        // Input
        int oppervlakteDriehoek;

        // Verwerking
        // opp = (basis x hoogte)/2.0
        oppervlakteDriehoek = (basis * hoogte)/2;

        // Output
        return oppervlakteDriehoek;

    }

    public static void demo() {
        // Doel:

        // Input

        // Verwerking

        // Output

    }
}

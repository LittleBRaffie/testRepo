package controller;

import java.awt.*;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        // write your code here

        //VASTE STRUCTUUR
        // 1) input
        // 2) verwerking
        // 3) output

        /*PRIMITIEVE DATA TYPEN
        byte = 8 bit -->
        short = 16 bit - Gehele getallen
        int = 32 bit
        long = 64 bit
        float = 32 bit - decimale getallen
        double = 64 bit
        boolean = 16 bit - true/false
        char = 8 bit - letter
        Een bit = 0 of 1

        NON PRIMITIEVE DATA TYPEN
        String = object voor tekst
        Array
        Classes
        */

        //input
        Scanner invoerInCm = new Scanner(System.in);
        int breedteInCm = 0;
        int lengteInCm = 0;
        int hoogteInCm = 0;
        int oppervlakteVierkant = 0;
        breedteInCm = vraagIntInputGebruiker("Voer de breedte van het vierkant in (in hele cm) en druk op 'Enter'",invoerInCm);
        lengteInCm = vraagIntInputGebruiker("Voer de lengte van het vierkant in (in hele cm) en druk op 'Enter'", invoerInCm);
        hoogteInCm = vraagIntInputGebruiker("Wat is de hoogte van de kubus? Voer in (in cm) en druk op 'Enter'", invoerInCm);
        //verwerking
        oppervlakteVierkant = berekenenRechthoek(breedteInCm, lengteInCm);

        //output

    }

    public static int berekenenRechthoek(int breedteInCm, int lengteInCm) {//je kunt zelfde namen gebruiken voor variabelen, maar qua leesbaarheid niet aan te raden
        // input
        int oppervlakteInVierkanteCm = 0;
        oppervlakteInVierkanteCm = breedteInCm * lengteInCm;

        // verwerking

        // output
        System.out.println("De oppervlakte van de rechthoek is: " + oppervlakteInVierkanteCm);
        return oppervlakteInVierkanteCm;
    }

    public static int berekenenKubus(int vierkantOppervlakte, int hoogteInCm){
        int inhoudKubusInCm2 = 0;
        inhoudKubusInCm2 = vierkantOppervlakte * hoogteInCm;

        System.out.println("De inhoud van de kubus is: " + inhoudKubusInCm2);
        return inhoudKubusInCm2;
    }

    public static int vraagIntInputGebruiker (String inputVraag, Scanner scanner){
        int getalInCm;

        System.out.println(inputVraag);
        getalInCm = scanner.nextInt();

        return getalInCm;
    }

    public static void stringVergelijken() {
        //java8 = stringNaam.equals of !stringNaam.equals
        //java14 = == of != werkt ook
    }

    public static void cirkelUitrekenen() {
        //De omtrek van een cirkel is pi x de diameter. De omtrek van een cirkel is 2 x de straal x pi.

        //Bepaal de straal; de helft van de diameter.
        //Vermenigvuldig de straal met de straal; (straal)2
        //Vermenig deze uitkomst met pi; 3,14.
        //Noteer het als "vierkante" m, cm, km,...etc.

        //input = gebruiker voert straal in
        Scanner invoerGebruiker = new Scanner(System.in);
        System.out.println("Voer de straal van de cirkel in (in cm)");
        double straalCirkelInCentimeters = invoerGebruiker.nextDouble();
        double diameterCirkelInCentimeters = 2 * straalCirkelInCentimeters;
        double omtrekCirkelInCentimeters;
        double oppervlakteCirkelInVierkanteCentimeters;
        final double PI = 3.1415; // kunt ook Math.PI halen

        //verwerking = omzetten van straal in omtrek en oppervlakte
        omtrekCirkelInCentimeters = PI * diameterCirkelInCentimeters;
        oppervlakteCirkelInVierkanteCentimeters = (straalCirkelInCentimeters * straalCirkelInCentimeters) * PI; // kunt hiervoor ook Math.pow gebruiken voor kwadraat of andere machten
        //output
        System.out.println("De omtrek van de cirkel is: " + omtrekCirkelInCentimeters + " centimeter.");
        System.out.println("De oppervlakte van de cirkel is: " + oppervlakteCirkelInVierkanteCentimeters + " vierkante centimeter.");

    }

    public static void kerstgroet() {
        System.out.println("Vrolijk kerstfeest Snow, ehow dwergen!");
        System.out.println("\n" +
                "   *\n" +
                "  ***\n" +
                " *****\n" +
                "  ***\n" +
                " *****\n" +
                "*******\n" +
                "   ||");
    }

    public static void paasgroet() {
        System.out.println("Helaas, ik ben geen schilder en een paashaas kan ik niet tekenen\n" +
                "Vrolijk pasen allemaal!");
    }
}

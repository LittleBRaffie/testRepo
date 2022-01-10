package controllerPackage;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	    watIsDeUitkomst();
    }

    public static void watIsDeUitkomst () {
        // oefen methode

        // input -
        int getal1;
        int getal2;
        int som;
        int antwoordGebruiker;

        // verwerking -
        getal1 = randomGetal();
        getal2 = randomGetal();
        System.out.println("Wat is de optelling van " + getal1 + " + " + getal2 + "?");
        antwoordGebruiker = voerGetalIn("Wat is je antwoord?");
        som = getal1 + getal2;


        // output -
        if (antwoordGebruiker == som){
            System.out.println("Goed zo! Je antwoord " + antwoordGebruiker + " is correct!");
        } else {
            System.out.println("Helaas, je antwoord is niet goed. Het goede antwoord is: " + som + ".");
        }

        System.out.println("Tijd voor de volgende oefening.");
    }

    public static int voerGetalIn(String vraag){
        // input
        Scanner invoerGebruiker = new Scanner(System.in);
        int ingevoerdeGetal;

        // verwerking
        System.out.println(vraag);
        ingevoerdeGetal = invoerGebruiker.nextInt();

        // output
        System.out.println(ingevoerdeGetal);
        return ingevoerdeGetal;
    }

    public static int randomGetal(){
        // input
        double randomGetalTussen0EnBijna1;
        double randomGetalTussen0EnBijnaInput;
        int randomGetalTussen0EnInputMin1;
        int randomGetalTussen1EnInput;
        int rangeGetal;

        // verwerking
        rangeGetal = voerGetalIn("Tot welk getal wil je de range laten lopen? Van 1 tot ?");
        randomGetalTussen0EnBijna1 = Math.random();
        randomGetalTussen0EnBijnaInput = randomGetalTussen0EnBijna1 * rangeGetal;
        randomGetalTussen0EnInputMin1 = (int) randomGetalTussen0EnBijnaInput;
        randomGetalTussen1EnInput = randomGetalTussen0EnInputMin1 + 1;

        // output
        System.out.println("Het random getal is: " + randomGetalTussen1EnInput);
        return randomGetalTussen1EnInput;

        /*
        instance class Random.nextInt of nextDouble kan ook gebruikt worden:
            Bijv.
            Random randomGetal; --> java.utill. wordt automatisch geïmporteerd
            randomGetal = new Random();
            getalX = randomGetal.next... --> kan met of zonder parameter (max range), hierbij is 0 en max inclusief!

         */
    }
}

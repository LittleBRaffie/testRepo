package controllerPackage;

import java.util.Scanner;

public class Loops {
    static Scanner scanner;

    public static void main(String[] args) {
        System.out.println("Voer je boodschap in.");
        String inputTekst = scanner.nextLine();
        System.out.println("Hoe vaak wil je dit zien?");
        int inputGetal = scanner.nextInt();

        //herhaalBoodschap(inputTekst, inputGetal);
        //String s = generateMessageMultipleTimes(inputTekst, inputGetal);
        //herhaalBoodschap(s);
    }

    public static void herhaalBoodschap(String boodschap, int aantal){
        for (int i = 0; i < aantal; i++) {
            System.out.println(boodschap);
        }
        System.out.println("\n");

        int i = 0;
        while (i < aantal){
            System.out.println(boodschap+2);
            i++;
        }
        System.out.println("\n");

        int j =0;
        do {
            System.out.println(boodschap+3);
            j++;
        } while (j < aantal);

    }

    public static String generateMessageMultipleTimes (String message, int count){
        String result = "";
        for (int i = 0; i < count; i++) {
            System.out.println(message);
            result = result + " " + message;
        }
        return result;
    }
}

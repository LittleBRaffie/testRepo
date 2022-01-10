package controllerPackage;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	    // input - Scanner object aanmaken en variabelen definiëren
        double bodyMassIndex;
        int lengteInCm;
        double gewichtInKilo;
        Scanner invoerGebruiker = new Scanner(System.in);

        // verwerking - BMI = Gewicht in kilogram / (Lengte in meter * Lengte in meter)
        // vragen input gebruiker

        lengteInCm = vragenOmGebruikerInput("Geef je lengte in centimeters en druk op 'Enter': ", invoerGebruiker);
        gewichtInKilo = vragenOmGebruikerInputDouble("Geef je gewicht in kilogram met 1 decimaal en druk op 'Enter': ", invoerGebruiker);

        bodyMassIndex = berekenBMI(lengteInCm,gewichtInKilo);

        // output
        toonResultaat(bodyMassIndex);
    }

    public static int vragenOmGebruikerInput (String vraag, Scanner sc){
        int input;

        System.out.println(vraag);
        input = sc.nextInt();

        return input;
    }

    public static double vragenOmGebruikerInputDouble (String vraag, Scanner sc){
        double input;

        System.out.println(vraag);
        input = sc.nextDouble();

        return input;
    }

    public static double berekenBMI(int lengte, double gewicht){
        double bmi;
        bmi = gewicht / ((lengte*lengte)/10000);

        return bmi;
    }

    public static void toonResultaat(double mpBmi) {
        System.out.println("Jouw BMI is: " + mpBmi);
    }
}



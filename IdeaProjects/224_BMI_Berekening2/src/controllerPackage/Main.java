package controllerPackage;

import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);
    /*

     */

    public static void main(String[] args) {
        int gewichtInKilo;
        int lengteInCm;
        double bmi;
        String gezondGewicht;

        lengteInCm = invoerGebruikerInt("Wat is je lengte in centimeters?");
        gewichtInKilo = invoerGebruikerInt("Wat is je gewicht in kilogram?");
        bmi = berekenBMI(lengteInCm, gewichtInKilo);
        gezondGewicht = isIemandGezond(bmi);

        System.out.println("Jouw BMI is: " + bmi + " " + gezondGewicht);
    }

    public static int invoerGebruikerInt(String vraag) {
        int getalInt;

        System.out.println(vraag);
        getalInt = scanner.nextInt();

        return getalInt;
    }

    public static double berekenBMI(int lengteCm, int gewichtKg) {
        // input
        double lengteInMeter;
        double bmi;
        double bmiAfgerond;
        double bmiAfgerond2;

        // verwerking
        lengteInMeter = ((double) lengteCm) / 100;
        bmi = gewichtKg / (Math.pow(lengteInMeter, 2));
        bmiAfgerond = (Math.round(bmi * 10));
        bmiAfgerond2 = bmiAfgerond / 10;

        // output
        return bmiAfgerond2;
    }

    public static String isIemandGezond(double bmi) {
        /*
        BMI	Categorie
        tot 18,5	Ondergewicht
        18,5 – 25,0	Gezond gewicht
        25,0 – 30,0	Overgewicht
        meer dan 30,0	Obesitas
        */
        String gezond = "";
        final float GRENS_ONDERGEWICHT = 18.5F;
        final int GRENS_OVERGEWICHT = 25;
        final int GRENS_OBEES = 30;

        if (bmi < GRENS_ONDERGEWICHT) {
            gezond = "(Ondergewicht)";
        } else if (bmi >= GRENS_ONDERGEWICHT && bmi < GRENS_OVERGEWICHT) {
            gezond = "(Gezond gewicht)";
        } else if (bmi >= GRENS_OVERGEWICHT && bmi < GRENS_OBEES) {
            gezond = "(Overgewicht)";
        } else {
            gezond = "(Obesitas)";
        }

        return gezond;
    }
}

package controllerPackage;

import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);
    static int BTW_HOOG = 21;
    static int BTW_LAAG = 6;

    public static void main(String[] args) {
        /*
        Beschrijving
Schrijf een applicatie die de verkoopprijs berekent van een product. De verkoopprijs wordt berekend op basis van de inkoopprijs van een product en de winstmarge.
Zie hier een voorbeeld van input/output van deze applicatie. Input die de gebruiker invoert is schuin en onderstreept.
Inkoopprijs: 70,80
Winstmarge (in %): 15

Verkoopprijs exclusief BTW : 81.41999999999999
Verkoopprijs inclusief 6% BTW: 86.30519999999999
Verkoopprijs inclusief 21% BTW: 98.51819999999998
         */

        // input
        double ingevoerdeInkoopprijs;
        double verkoopprijsExclBtw;
        double verkoopprijsInclBtw6;
        double verkoopprijsInclBtw21;
        int ingevoerdeWinstmarge;

        // verwerking -> verkoopprijs = inkoopprijs x winstmarge x btw percentage
        System.out.println("Inkoopprijs:");
        ingevoerdeInkoopprijs = scanner.nextDouble();
        System.out.println("Winstmarge (in %): ");
        ingevoerdeWinstmarge = scanner.nextInt();
        verkoopprijsExclBtw = berekenenVerkoopprijsExcl(ingevoerdeInkoopprijs, ingevoerdeWinstmarge);
        verkoopprijsInclBtw6 = berekenenVerkoopprijsIncl(BTW_LAAG,verkoopprijsExclBtw);
        verkoopprijsInclBtw21 = berekenenVerkoopprijsIncl(BTW_HOOG, verkoopprijsExclBtw);

        // output
        System.out.println("Verkoopprijs exclusief BTW : " + verkoopprijsExclBtw);
        System.out.println("Verkoopprijs exclusief BTW : " + verkoopprijsInclBtw6);
        System.out.println("Verkoopprijs exclusief BTW : " + verkoopprijsInclBtw21);
    }

    public static double berekenenVerkoopprijsExcl(double inkoopprijs, int winstmarge) {
        // input
        double winstmargeDecimaalGetal;
        double verkoopprijs;

        // verwerking -> verkoopprijs = inkoopprijs x winstmarge
        winstmargeDecimaalGetal = (((double) winstmarge) / 100) + 1;
        verkoopprijs = inkoopprijs * winstmargeDecimaalGetal;

        // output
        return verkoopprijs;
    }

    // in feite is onderstaand dezelfde berekening die je maakt als hierboven. kan dus 2x zelfde methode aanroepen en hernoemen
    public static double berekenenVerkoopprijsIncl(int btwPercentage, double prijsExcl){
        // input
        double verkoopprijsInclBTW;

        // verwerking
        verkoopprijsInclBTW = prijsExcl * ((((double) btwPercentage) /100)+1);

        // output
        return verkoopprijsInclBTW;
    }
}

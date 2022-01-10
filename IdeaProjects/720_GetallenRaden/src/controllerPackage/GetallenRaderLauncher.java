package controllerPackage;

import java.util.Arrays;
import java.util.Scanner;

public class GetallenRaderLauncher {
    public final static int AANTAL = 3;

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int aantalCorrectGetallen;
        boolean nietGeraden = true;
        int aantalKeerRaden = 0;
        // genereer de te raden getallen
        int[] teRadenGetallen = genereerGetallen();

        // vraag en registreer de getallen van de gebruiker in een array
        int[] gebruikerGetallen = new int[AANTAL];
        while (nietGeraden) {
            aantalCorrectGetallen = 0;
            System.out.printf("Geef %d verschillende getallen tussen 1 en 10, gescheiden door spaties: ", AANTAL);
            for (int i = 0; i < AANTAL ; i++) {
                gebruikerGetallen[i] = input.nextInt();
            }
            aantalKeerRaden++;
            for (int i = 0; i < AANTAL; i++) {
                if (komtVoorIn(gebruikerGetallen[i], teRadenGetallen)) {
                    aantalCorrectGetallen++;
                }
            }
            if (aantalCorrectGetallen == AANTAL) {
                nietGeraden = false;
            }
            System.out.println("Aantal correcte getallen = " + aantalCorrectGetallen);
        }
        System.out.println();
        System.out.printf("U heeft %d keer geraden.\n", aantalKeerRaden);

        System.out.println("De te raden getallen waren:");
        Arrays.sort(teRadenGetallen);
        for (int i = 0; i < AANTAL ; i++) {
            System.out.print(" " + teRadenGetallen[i]);
        }
        System.out.println();

    }

    public static int[] genereerGetallen() {
        int[] rij = new int[AANTAL];
        // bepaal eerste getal random
        rij[0] = (int) (10 * Math.random()) + 1;
        // bepaal alle volgende getallen random, maar check op voorkomen in getallen daarvoor
        for (int i = 1; i < AANTAL ; i++) {
            rij[i] = (int) (10 * Math.random()) + 1;
            // check tov voorgaande getallen of het voorkomt, anders opnieuw door teller 'i' terug te zetten. Dit is een 'sub-loop'
            for (int j = 0; j < i; j++) {
                if (rij[j] == rij[i]) {
                    i--;
                }
            }
        }
        return rij;
    }

    public static boolean komtVoorIn(int zoekgetal, int[] lijst) {
        // check de lijst
        for (int i = 0; i < lijst.length ; i++) {
            // zodra het getal voorkomt return je true, en dan stopt de methode
            if(lijst[i] == zoekgetal) {
                return true;
            }
        }
        // als het getal niet voorkomt dan kom je hier en return false
        return false;
    }
}

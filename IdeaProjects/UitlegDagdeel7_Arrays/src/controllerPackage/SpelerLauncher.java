package controllerPackage;

import java.util.Scanner;

// doel: bijhouden lijst spelers
public class SpelerLauncher {

    public static void main(String[] args) {
        // Doel:

        // Input
        String[] namenVanSpelers = new String[10];
        Scanner scanner = new Scanner(System.in);

        // Verwerking
        // vraag gebruiker namen vd spelers
        // vul gegeven naam in in het array
        for (int i = 0; i < namenVanSpelers.length; i++) {
            System.out.println("Geef naam van de " + i + "e speler:");
            String gegevenNaam = scanner.nextLine();
            namenVanSpelers[i] = gegevenNaam;
        }

        // Output
        // print array
        System.out.println("Ingevoerde spelers zijn:");
        printArrayMetFor(namenVanSpelers);
        System.out.println("\n");
        printArrayMetForEach(namenVanSpelers);

    }

    public static void printArrayMetFor(String[] hetArray) {
        // loop door array
        for (int i = 0; i < hetArray.length; i++) {
            // print nummer en naam van speler
            if (hetArray[i] != null){
                System.out.println("Nummer: " + i + "\tNaam:" + hetArray[i]);
            }
        }

    }

    public static void printArrayMetForEach(String[] hetArray) {
        // zelfde maar met foreach loop: voor elke String s die in het array zit, doe ik {} Hierbij niet belangrijk
        // welke speler (dus welke index)
        for (String s : hetArray) {
            // print alleen naam van speler
            System.out.println(s);
        }
    }

    // Zou je blance velden (dus coach heeft geen speler ingevoerd) willen skippen, zet je een if statement in de
    // printfunctie (zie eerste loop)
}

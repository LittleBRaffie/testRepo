package controllerPackage;

import java.util.Random;
import java.util.Scanner;

public class Arrays {
    static Scanner scanner = new Scanner(System.in);
    static Random random = new Random();

    public static void main(String[] args) {
        int aantalGetallen;
        int hoogsteGetal;

        System.out.println("Hoeveel getallen wil je opslaan?");
        aantalGetallen = scanner.nextInt();

        System.out.println("Wat is de hoogste waarde dat een getal mag zijn.");
        hoogsteGetal = scanner.nextInt();

        int[] arrayGetallen = new int[aantalGetallen];

        for (int i = 0; i < aantalGetallen; i++) {
            arrayGetallen[i] = random.nextInt(hoogsteGetal);
            System.out.println(arrayGetallen[i]);
        }
    }
}

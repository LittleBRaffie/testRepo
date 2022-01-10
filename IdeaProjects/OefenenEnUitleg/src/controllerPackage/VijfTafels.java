package controllerPackage;

import java.util.Scanner;

public class VijfTafels { // Dit is oefening 5.1 van het practicum!
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        // doel: Gebruiker geeft aan welke tafel wordt getoond en hoeveel getallen hiervan. Erna kan de gebruiker ervoor kiezen dit voor een andere
        // tafel te doen.

        // input


        // verwerking
        herhaalVraag();

        // output

    }

    public static int invoerGebruikerInt(String vraag){
        // input
        int getal;

        //verwerking
        System.out.println(vraag);
        getal = scanner.nextInt();

        // output
        return getal;
    }

    public static void tafelBerekenenGetalX (int GetalX, int aantalKeerVermenigvuldigen) {
        // doel: input wordt weergegeven als tafel

        // input
        int uitkomst;

        // verwerking
        System.out.println("De tafel van " + GetalX + ":");
        for (int i = 0; i < aantalKeerVermenigvuldigen; i++) { //ivm array jezelf aanleren om vanaf 0 te werken. kon ook i = 1 | i <= 10 | i * GetalX
            uitkomst = (i+1) * GetalX;
            System.out.printf("%6s", uitkomst + "\t"); //uitlijnen via %6s (rechts uitlijnen, geen probleem inspringen) maar kan ook met \t (links uitlijnen)
            if ((i + 1) % 5 == 0){
                System.out.print("\n");
            }
        }

        // output
        System.out.println("\n");
    }

    public static void herhaalVraag(){
        // doel:

        // input
        int ingevoerdeTafel;
        int ingevoerdeAantalGetallen;
        boolean nogEenKeer = true;

        // verwerking
        // methodes om gebruikerinput op te slaan (Int) en dit getal gebruiken om de tafel te laten zien
        ingevoerdeTafel = invoerGebruikerInt("Welke tafel wilt u printen?");
        ingevoerdeAantalGetallen = invoerGebruikerInt("Hoeveel getallen wilt u printen?");
        tafelBerekenenGetalX(ingevoerdeTafel, ingevoerdeAantalGetallen);

        while (nogEenKeer){
            ingevoerdeTafel = invoerGebruikerInt("Welke tafel wilt u printen? (0 = stoppen)");
            if(ingevoerdeTafel == 0){
                break;
            }
            ingevoerdeAantalGetallen = invoerGebruikerInt("Hoeveel getallen wilt u printen?");
            tafelBerekenenGetalX(ingevoerdeTafel, ingevoerdeAantalGetallen);
        }

        // output
    }
}


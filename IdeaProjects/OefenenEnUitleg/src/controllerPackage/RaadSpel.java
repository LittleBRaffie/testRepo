package controllerPackage;


import java.util.Random;
import java.util.Scanner;

public class RaadSpel {
    // scanner en random classe objecten aanmaken
    static Scanner scanner = new Scanner(System.in);
    static Random randomGetal = new Random();


    public static void main(String[] args) {
        // Doel: Schrijf een programma dat een willekeurig getal van 0 – 100 genereert.
        //De gebruiker kan herhaaldelijk een nummer intoetsen, net zo lang tot hij het gegenereerde nummer heeft geraden.
        //Na elke incorrecte gok geeft het programma aan of het getal te hoog of te laag was.
        //Daarnaast geeft het programma aan of hoe ver je ongeveer in de buurt zit (25+ = ver ernaast, 10+ = ernaast, 10- = bijna).

        // input
        // variabelen aanmaken, randomnummer is 0-99, dus +1
        int antwoordGebruiker = 0;
        int gegenereerdeGetal = randomGetal.nextInt(99);
        gegenereerdeGetal = gegenereerdeGetal+1;
        int aantalPogingen = 0;
        System.out.println(gegenereerdeGetal);


        // verwerking
        System.out.println("Voer een getal is van 1 t/m 100 en druk op 'Enter'.\nWil je stoppen, type dan '0'.");
        // while loop zodat gebruiker kan blijven proberen als het getal niet goed is
        while (antwoordGebruiker != gegenereerdeGetal){
            antwoordGebruiker = scanner.nextInt();

            // heeft de speler geen zin meer, kan altijd 0 ingevoerd worden om te stoppen
            if (antwoordGebruiker == 0){
                break;
            }

            // indien antwoord niet tussen 0 en 100 geeft, wordt opnieuw om input gevraagd (dit telt niet mee in het aantal pogingen)
            while (antwoordGebruiker < 0 || antwoordGebruiker > 100){
                System.out.println("Foute invoer. Kies een getal tussen de 1 en de 100.");
                antwoordGebruiker = scanner.nextInt();
            }

            // is antwoord geen 0, dan telt het als een poging
            aantalPogingen++;

            // als antwoord correct is, zie je dat, zo niet, zie je dit ook en krijg je een hint.
            if (gegenereerdeGetal == antwoordGebruiker){
                System.out.println("Correct!");
            } else if (gegenereerdeGetal > antwoordGebruiker){
                System.out.println("Helaas was je antwoord niet goed. Probeer het opnieuw.");
                System.out.println("Het getal is hoger dan je laatste antwoord.");
                //2e hint volgt hoe ver het getal ernaast ligt
            } else {
                System.out.println("Helaas was je antwoord niet goed. Probeer het opnieuw.");
                System.out.println("Het getal is lager dan je laatste antwoord.");
                //2e hint volgt hoe ver het getal ernaast ligt
                //KAN DIT VIA METHODE? IS HERHALING VOORGAANDE HINT
            }
        }

        // output
        // resultaat wordt altijd getoond, ook als de speler stopt
        if(antwoordGebruiker==gegenereerdeGetal){
            System.out.println("Het getal was: " + gegenereerdeGetal + ".\nJe antwoord was dus goed na "+aantalPogingen+" keer proberen.");
        } else {
            System.out.println("Helaas, je hebt opgegeven na "+aantalPogingen+" keer proberen. Het getal was: "+gegenereerdeGetal+".");
        }
    }

}

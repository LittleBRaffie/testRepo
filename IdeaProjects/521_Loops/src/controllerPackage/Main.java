package controllerPackage;

import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        /*
Beschrijving
In deze serie opdrachten ga je loops gebruiken, meestal de for-loop. Je gebruikt deze in verschillende methodes. Elke methode kun je testen door in de main() method de methode aan te roepen. Dit kan soms rechtstreeks, als de methode zelf iets print. Dit kan binnen een println() methode om het resultaat te tonen. Het kan ook door de returnwaarde van de methode eerst op te slaan in een variabele en dan die variabele in een println() methode te gebruiken.
Elke opdracht beschrijft wat je moet doen. Je ziet ook een voorbeeld van input en output. Input die de gebruiker invoert is schuin en onderstreept.

Sterrenrij
Schrijf een methode die een willekeurig aantal asterisken print. De methode heeft als signature public static void toonRijSterren (int mpAantal). Roep de methode aan in je main methode en run je project.
* * * * * * * *

Sterrenvierkant
Schrijf een methode die een sterrenvierkant van asterisken print van willekeurige grootte. De methode heeft als signature public static void toonSterrenVierkant (int mpAantal). Maak gebruik van de methode die een sterrenrij van asterisken print. Test je methode in de main:
* * * * * *
* * * * * *
* * * * * *
* * * * * *
* * * * * *
* * * * * *

Character rij
Schrijf een methode die een rij van een aantal characters print. Je moet aan de methode het character meegeven en het aantal.
De signature van de methode is public static void toonCharRij(char mpKarakter, int mpAantal). Vraag in de main methode de gebruiker om een character en toon dit vijf keer achter elkaar.
Welke karakter wil je dit keer gebruiken? &
Hoevaak wil je het zien? 9
&&&&&&&&&

Optellen tot aan 1000
Schrijf een loop die alle getallen vanaf 1 bij elkaar optelt (dus 1 + 2 + 3 + 4 + ……) en stopt als de som groter is is dan 1000. Tel ook hoeveel getallen je dan bij elkaar opgeteld hebt.

Optellen tot aan een bovengrens
Schrijf een methode die alle getallen vanaf 1 bij elkaar optelt tot aan een meegegeven bovengrens en dan het aantal getallen dat je hebt opgeteld teruggeeft.
De signature van de methode is public static int telAantalTeSommerenGetallen(int mpGrens).
Tot hoeveel moeten we optellen? 2000
De eerste 62 getallen bij elkaar zijn net geen 2000.

         */

        // Doel:

        // Input
        int aantal;
        int getallenOpgeteld;

        // Verwerking
        aantal = invoerGebruikerInt("Hoeveel sterren?");
        toonSterrenVierkant(aantal);

        System.out.println("Welke karakter wil je dit keer gebruiken?");
        char teken = scanner.next().charAt(0);
        toonCharRij(teken, aantal);

        optellenTot100();

        aantal = invoerGebruikerInt("Tot welk getal wil je getallen optellen?");
        getallenOpgeteld = telAantalTeSommerenGetallen(aantal);
        System.out.println(getallenOpgeteld);

        // Output

    }

    // methode om int van gebruiker te vragen
    public static int invoerGebruikerInt(String vraag) {
        System.out.println(vraag);
        return scanner.nextInt();
    }

    public static void toonRijSterren(int mpAantal) {
        for (int i = 0; i < mpAantal; i++) {
            System.out.print(" * ");
        }
    }

    public static void toonSterrenVierkant (int aantal){
        for (int i = 0; i <aantal; i++) {
            toonRijSterren(aantal);
            System.out.println("\n");
        }
    }

    public static void toonCharRij(char mpKarakter, int mpAantal){
        for (int i = 0; i < mpAantal; i++) {
            System.out.print(mpKarakter);
        }
    }

    public static int optellenTot100(){
        int som = 0;
        int aantalGetallen = 0;
        for (int i = 0; i < 100; i++) {
            aantalGetallen = i+1;
            som = som + (i+1);
            if (som > 1000){
                break;
            }
        }
        System.out.println("Som: " + som + "\nAantal getallen: " + aantalGetallen);
        return aantalGetallen;
    }

    public static int telAantalTeSommerenGetallen(int mpGrens){
        int i = 1;
        int som = 0;
        while (mpGrens > som){
            i++;
            som = som + i;
        }
        return i;
    }
}

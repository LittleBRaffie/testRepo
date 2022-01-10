package controllerPackage;

import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);
    /*
    Beschrijving
Schrijf een applicatie om docenten te helpen met het analyseren van tentamenresultaten. De applicatie vraagt allereerst om het aantal cijfers dat de docent wil invoeren. Hierna voert de docent de cijfers in. Vervolgens toont het programma het aantal cijfers, het gemiddelde cijfer, het aantal voldoende en het hoogste cijfer.
Hieronder een voorbeeld van input/output van deze applicatie. Input die de gebruiker invoert is schuin en onderstreept.
Hoeveel cijfers wilt u invoeren? 0
  Aantal cijfers moet groter zijn dan 0!
Hoeveel cijfers wilt u invoeren? 12
Cijfer student 1: 5,8
Cijfer student 2: 9,1
Cijfer student 3: 3,5
Cijfer student 4: 6
Cijfer student 5: 5,1
Cijfer student 6: 8
Cijfer student 7: 7,2
Cijfer student 8: 4,9
Cijfer student 9: 9,3
Cijfer student 10: 7,7
Cijfer student 11: 5
Cijfer student 12: 6,2

Aantal cijfers   : 12
Gemiddelde cijfer: 6.5
Aantal voldoendes: 8
Hoogste cijfer   : 9.3
Stappenplan
1.	Vraag de gebruikers om het aantal cijfers en lees dit in. Test of dit getal groter is dan 0. Zo niet, vraag net zo lang om invoer tot het ingevoerde aantal groter dan 0 is.
2.	Declareer en creëer, nadat je het aantal hebt ingelezen, een array om de cijfers in op te slaan. De lengte van de array moet gelijk zijn aan het aantal cijfers dat de gebruiker heeft opgegeven.
3.	Lees de cijfers van alle studenten in.
4.	Bereken en print vervolgens het aantal cijfers, het gemiddelde cijfer, het aantal voldoendes en het hoogste cijfer.
Tips
a.	Zie boek §7.2.1 en 7.2.2 voor het declareren en creëren van arrays.
b.	§ 7.2.6 bevat veel nuttige voorbeelden van het verwerken van arrays. Gebruik deze paragraaf bij stap 3 en 4.

     */

    public static void main(String[] args) {

        // Doel:

        // Input
        int aantalCijfers;
        double somCijfers = 0.0;
        double gemiddeldeCijfer = 0.0;
        int aantalVoldoendes = 0;
        double hoogsteCijfer = 0.0;

        // Verwerking
        // gebruiker vragen hoeveel cijfers ingevoerd moeten worden
        aantalCijfers = invoerGebruikerInt("Hoeveel cijfers wilt u invoeren?");
        while (aantalCijfers == 0) {
            aantalCijfers = invoerGebruikerInt("Aantal cijfers moet groter zijn dan 0!\nHoeveel cijfers wilt u invoeren?");
        }

        // invoeren van de cijfers, som meteen berekent
        double[] cijfers = new double[aantalCijfers];
        for (int i = 0; i < aantalCijfers; i++) {
            cijfers[i] = invoerGebruikerDouble("Cijfer student " + (i + 1));
            somCijfers = somCijfers + cijfers[i];
            if (cijfers[i]>5.5){
                aantalVoldoendes++;
            }
            if (cijfers[i]>hoogsteCijfer){
                hoogsteCijfer = cijfers[i];
            }
        }
        // berekening aantal, gemiddelde, voldoendes en hoogste cijfer
        gemiddeldeCijfer = somCijfers / aantalCijfers;
        gemiddeldeCijfer = ((double) Math.round(gemiddeldeCijfer*10))/10.0;



        System.out.println(somCijfers);
        System.out.println(aantalVoldoendes);

        // Output
        System.out.printf("%-17s%1s%-5s","Aantal cijfers",":",aantalCijfers);
        System.out.println("");
        System.out.printf("%-17s%1s%-5s","Gemiddelde cijfer",":",gemiddeldeCijfer);
        System.out.println("");
        System.out.printf("%-17s%1s%-5s","Aantal voldoendes",":",aantalVoldoendes);
        System.out.println("");
        System.out.printf("%-17s%1s%-5s","Hoogste cijfer",":",hoogsteCijfer);
        System.out.println("");
    }

    public static int invoerGebruikerInt(String vraag) {
        System.out.println(vraag);
        return scanner.nextInt();

    }

    public static double invoerGebruikerDouble(String vraag) {
        System.out.println(vraag);
        return scanner.nextDouble();
    }

    public static void demo() {

        // Doel:

        // Input

        // Verwerking

        // Output

    }
}

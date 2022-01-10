package controllerPackage;

import java.util.Scanner;

public class Opdracht322 {
    static Scanner scanner = new Scanner(System.in);
    static final String VAK = "Datastructures";

    public static void main(String[] args) {
	/*
	Cijfer theorie van de vakken Datastructures
De theorie van het tweedejaars vak Datastructures van de opleiding tot Software Engineering in de voltijd variant worden getentamineerd met twee deeltoetsen.
Voor de normering van het theoriedeel van dit vak gelden de volgende regels.
•	Een deeltoets is voldoende als het aantal punten >= 12 is.
•	Het cijfer dat daarbij hoort is: (aantal punten) / 2.
•	Een deeltoets is onvoldoende als het aantal punten < 12 is.
•	Het cijfer dat daarbij hoort is: (aantal punten - 1.5) / 2.
•	Alleen als beide deeltoetsen voldoende zijn gemaakt, dan krijgt de student een voldoende voor het vak. Het eindcijfer is dan het gemiddelde van de beide voldoendes.
•	Als een van beide deeltoetsen onvoldoende is gemaakt, dan is het eindcijfer de onvoldoende voor die deeltoets.
•	Als beide deeltoetsen onvoldoende zijn gemaakt, dan is het eindcijfer het gemiddelde van de beide onvoldoendes.
Stappenplan

e.	Toon nu de resultaten per vak op het scherm. Gebruik de escape sequence “\t” (zie boek § 4.3) om de uitlijning van de uitvoer netjes te maken.
f.	Zorg dat het eindcijfer wordt afgerond op één decimaal.

Input/Output
Zie hier een voorbeeld van input/output van deze applicatie. Input die de gebruiker invoert is schuin en onderstreept.
Voer behaalde punten in voor het vak Datastructures:
Datastructures Deeltoets 1: 14
Datastructures Deeltoets 2: 11

Cijfer Datastructures Deeltoets 1: 7.0			Voldoende
Cijfer Datastructures Deeltoets 2: 4.75		Onvoldoende

Je hebt een onvoldoende voor het vak Datastructures.
Je cijfer is 4.8

	 */

        // input
        double eindcijfer;
        double eindcijferAfgerond;
        int puntenDeelToets1;
        int puntenDeelToets2;
        double cijferToets1;
        double cijferToets2;
        boolean voldoendeToets1;
        boolean voldoendeToets2;
        String voldoende1 = "onvoldoende";
        String voldoende2 = "onvoldoende";
        String voldoende;

        // verwerking
        //invoer gebruiker voor behaalde punten
        System.out.println("Voer behaalde punten in voor het vak Datastructures:");
        System.out.println("Datastructures Deeltoets 1:");
        puntenDeelToets1 = scanner.nextInt();
        System.out.println("Datastructures Deeltoets 2:");
        puntenDeelToets2 = scanner.nextInt();

        //aanroepen methodes om punten om te zetten in cijfer en (on)voldoende
        cijferToets1 = berekeningToets(puntenDeelToets1);
        cijferToets2 = berekeningToets(puntenDeelToets2);
        voldoendeToets1 = berekeningVoldoende(puntenDeelToets1);
        voldoendeToets2 = berekeningVoldoende(puntenDeelToets2);

        if (voldoendeToets1) {
            voldoende1 = "voldoende";
        }
        if (voldoendeToets2) {
            voldoende2 = "voldoende";
        }

        if (voldoendeToets1 && voldoendeToets2) {
            // beide toetsen voldoende dus geslaagd, eindcijfer gemiddelde
            eindcijfer = (cijferToets1 + cijferToets2) / 2;
            voldoende = "voldoende";
        } else if (voldoendeToets1 == false || voldoendeToets2 == false) {
            //1 toets onvoldoende, dus niet geslaagd, eindcijfer laagste cijfer
            voldoende = "onvoldoende";
            if (cijferToets1 >= cijferToets2) {
                eindcijfer = cijferToets2;
            } else {
                eindcijfer = cijferToets1;
            }
        } else {
            voldoende = "onvoldoende";
            eindcijfer = (cijferToets1 + cijferToets2) / 2;
        }

        eindcijferAfgerond = ((double) Math.round(eindcijfer*10))/10;

        // output
        System.out.println("Cijfer Datastructures Deeltoets 1:\t" + cijferToets1 + "\t" + voldoende1);
        System.out.println("Cijfer Datastructures Deeltoets 2:\t" + cijferToets2 + "\t" + voldoende2);
        System.out.println("\n");
        System.out.println("Je hebt een " + voldoende + " voor het vak Datastructures.");
        System.out.println("Je cijfer is " + eindcijferAfgerond);
    }

    public static double berekeningToets(int puntenAantal) {
        // input
        double cijfer;

        // verwerking
        if (puntenAantal >= 12) {
            cijfer = (double) puntenAantal / 2;
        } else {
            cijfer = ((double) puntenAantal - 1.5) / 2;
        }

        // output
        return cijfer;
    }

    public static boolean berekeningVoldoende(int puntenAantal) {
        // input
        boolean isVoldoende;

        // verwerking
        if (puntenAantal >= 12) {
            isVoldoende = true;
        } else {
            isVoldoende = false;
        }

        // output
        return isVoldoende;
    }

    // input

    // verwerking

    // output

}

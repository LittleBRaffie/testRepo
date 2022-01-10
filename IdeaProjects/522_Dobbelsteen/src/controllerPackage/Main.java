package controllerPackage;

import java.util.Random;
import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);
    static Random random = new Random();

    /*
    Beschrijving
Schrijf een applicatie die herhaaldelijk een dobbelsteen gooit totdat zes wordt gegooid. Na iedere worp moet de waarde afgedrukt worden als een “ASCII tekening” (zie voorbeeld). Bij de start van de applicatie moet de gebruiker gevraagd worden welk karakter gebruikt moet worden als oog van de dobbelsteen in de ASCII tekening.
Hier volgen twee voorbeelden van input/output van deze applicatie. Input die de gebruiker invoert is schuin en onderstreept.
In het eerste voorbeeld wordt achtereenvolgens 2 en 6 gegooid.
Welk karakter moet ik gebruiken voor het oog: *

*

  *

* *
* *
* *
In het tweede voorbeeld wordt achtereenvolgens 5, 5, 3 en 6 gegooid.
Welk karakter moet ik gebruiken voor het oog: #

# #
 #
# #

# #
 #
# #

#
 #
  #

# #
# #
# #

Hints
1.	Schrijf eerst in pseudo-code op wat je programma moet doen, voordat je gaat programmeren.
2.	De Scanner class heeft geen methode nextChar(). Maar je kan wel een String inlezen en vervolgens het eerste karakter daarvan opvragen (zie boek § 4.4.6).
3.	Gebruik Math.random() om een worp te simuleren (zie boek § 3.7 en § 4.2).

     */

    public static void main(String[] args) {

        // Doel: Figuur tekenen met ingegeven symbool ahv dobbelsteenworp

        // Input
        char symbool;
        int dobbelworp = 0;
        String tekening = "";

        // Verwerking
        // vragen gebruiker welk symbool
        System.out.println("Welk karakter moet ik gebruiken voor het oog:");
        symbool = scanner.next().charAt(0);

        while (dobbelworp != 6) {
            dobbelworp = dobbelsteenGooien();
            tekenenAantalOgenDobbelworp(dobbelworp, symbool);
            System.out.println(tekening);
        }

        // Output
    }

    public static int dobbelsteenGooien() {

        // Doel: methode die een dobbelworp simuleert

        // Input
        int dobbelworp;

        // Verwerking
        dobbelworp = random.nextInt(6) + 1;

        // Output
        return dobbelworp;
    }

    public static void tekenenAantalOgenDobbelworp(int dobbelworp, char teken) {
        // Doel: tekening maken ahv int in parameter

        // Input
        String bovenOnderZijde = "-----------";
        String geenStip = "|         |";
        String linksStip = "|  "+teken+"      |";
        String middenStip = "|    "+teken+"    |";
        String rechtsStip = "|      "+teken+"  |";
        String tweeStippen = "|  "+teken+"   "+teken+"  |";


        // Verwerking
        switch (dobbelworp){
            case 1:
                System.out.println(bovenOnderZijde + "\n"+geenStip+ "\n"+middenStip+ "\n"+geenStip+ "\n"+bovenOnderZijde+ "\n");
                break;
            case 2:
                System.out.println(bovenOnderZijde+ "\n"+linksStip+ "\n"+geenStip+ "\n"+rechtsStip+ "\n"+bovenOnderZijde+ "\n");
                break;
            case 3:
                System.out.println(bovenOnderZijde+ "\n"+linksStip+ "\n"+middenStip+ "\n"+rechtsStip+ "\n"+bovenOnderZijde+ "\n");
                break;
            case 4:
                System.out.println(bovenOnderZijde+ "\n"+tweeStippen+ "\n"+geenStip+ "\n"+tweeStippen+ "\n"+bovenOnderZijde+ "\n");
                break;
            case 5:
                System.out.println(bovenOnderZijde+ "\n"+tweeStippen+ "\n"+middenStip+ "\n"+tweeStippen+ "\n"+bovenOnderZijde+ "\n");
                break;
            case 6:
                System.out.println(bovenOnderZijde+ "\n"+tweeStippen+ "\n"+tweeStippen+ "\n"+tweeStippen+ "\n"+bovenOnderZijde+ "\n");
                break;
        }

        // Output
    }
}

package controllerPackage;

import java.util.Scanner;

public class TicTacToeLauncher {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        // maak speelbord --> zie scanner

        // spelbord van 3 rijen bij 3 kolommen
        char[][] spelbord = new char[3][3]; //eerste is aantal rijen, 2e kolommen
        //char[][] onregelmatigSpelbord = new char[][];

        char gegevenChar;

        // vraag om character
        System.out.println("Geef symbool voor het spelbord: ");
        String gegevenCharAlsString = scanner.nextLine();
        gegevenChar = gegevenCharAlsString.charAt(0);

        // vul spelbord met een char
        //vulSpelerbordMetEeenChar(spelbord, gegevenChar);

        // create leeg spelbord
        leegSpelerbord(spelbord);

        // print spelbord
        //printSpelbord(spelbord);
        //printSpelbordFormat(spelbord);

        // print leeg spelbord
        printSpelbord(spelbord);
        //spelerKiestPositie(spelbord,1,3);

        //
        //onregelmatigSpelbord = maakOnregelmatigSpelbord();
        //vulSpelbordMetEenChar(onregelmatigSpelbord,gegevenChar);
        //printSpelbord(onregelmatigSpelbord);
    }

    public static void vulSpelbordMetEenChar(char[][] mijnSpelbord, char gegevenChar) {
        for (int rij = 0; rij < mijnSpelbord.length; rij++) {
            for (int kolom = 0; kolom < mijnSpelbord[rij].length; kolom++) {
                // vul vakje met meegegeven char
                mijnSpelbord[rij][kolom] = gegevenChar;
            }
        }
    }

    public static String maakHorizontaleLijn(char[][] hetSpelbord) {
        String lijn = "";
        for (int kolom = 0; kolom < hetSpelbord[0].length; kolom++) {
            lijn = lijn + " - ";
        }
        return lijn;
    }

    public static void printSpelbord(char[][] hetSpelbord) {
        String lijn = maakHorizontaleLijn(hetSpelbord);
        System.out.println(lijn);
        for (int rij = 0; rij < hetSpelbord.length; rij++) {
            for (int kolom = 0; kolom < hetSpelbord[rij].length; kolom++) {
                //System.out.println(hetSpelbord[i][j]); --> nu komen alle symbolen op nieuwe regels, maar willen een
                // 3x3 veld dus teken voor jezelf uit wat je wil hebben en gebruik printf (f = format)
                System.out.print("|" + hetSpelbord[rij][kolom]);
            }
            System.out.print("|\n" + lijn + "\n");
        }
    }

    public static void printSpelbordFormat(char[][] hetSpelbord) {
        String lijn = "-------------";
        System.out.println(lijn + "\n");
        for (int rij = 0; rij < hetSpelbord.length; rij++) {
            for (int kolom = 0; kolom < hetSpelbord.length; kolom++) {
                //oefenen met f print functie
                System.out.printf("| %c ", hetSpelbord[rij][kolom]);
            }
            System.out.println("|\n");
        }
        System.out.println(lijn);
    }

    public static void leegSpelerbord(char[][] mijnSpelbord) {
        char leeg = ' ';
        for (int rij = 0; rij < mijnSpelbord.length; rij++) {
            for (int kolom = 0; kolom < mijnSpelbord.length; kolom++) {
                // vul vakje spatie
                mijnSpelbord[rij][kolom] = leeg;
            }
        }
    }

    public static void spelerKiestPositie(char[][] ticTacToeSpelbord, int rij, int kolom, char gegevenChar) {

    }

    public static char[][] maakOnregelmatigSpelbord() {
        // maak array voor de rijen
        final int MAX_AANTAL_RIJEN_OF_KOLOMMEN = 10;

        int randomAantalRijen = (int) (Math.random() * MAX_AANTAL_RIJEN_OF_KOLOMMEN + 1);
        char[][] randomSpelbord = new char[randomAantalRijen][];

        // vullen array met random aantal rijen
        for (int rij = 0; rij < randomAantalRijen; rij++) {
            // bepaal aantal random kollommen (per rij)
            int randomAantalKolommen = (int) (Math.random() * MAX_AANTAL_RIJEN_OF_KOLOMMEN + 1);
            // binnen loop array aanmaken met random aantal kolommen
            char[] charArrayMetRandomAantalKolommen = new char[randomAantalKolommen];
            // toevoegen aan randomSpelBord
            randomSpelbord[rij] = charArrayMetRandomAantalKolommen;

        }

        return randomSpelbord;
    }

    /*
    VOORBEELD ERIK
    package controller;

public class TicTacToeLauncher {

    public static void main(String[] args) {
        // voor de demo: onregelmatig spelbord
        char[][] onregelmatigBord = maakOnregelmatigSpelbord();
        // vul spelbord
        vulSpelbordMetEenCharacter(onregelmatigBord, '@');
        // print het random array
        printSpelbord(onregelmatigBord);


//        // maak spelbord
//        Scanner scanner = new Scanner(System.in);
//        // spelbord van 3 rijen bij 3 kolommen
//        char[][] spelbord = new char[6][4];
//        char gegevenCharacter;
//        //
//        // vraag om character
//        System.out.println("geef character voor het spelbord: ");
//        String gegevenCharacterAlsString = scanner.nextLine();
//        gegevenCharacter = gegevenCharacterAlsString.charAt(0);
//
//        // vul spelbord met een character
//        vulSpelbordMetEenCharacter(spelbord,gegevenCharacter);
//
//        // print spelbord
//        printSpelbord(spelbord);


    }

    public static void vulSpelbordMetEenCharacter(char[][] mijnSpelbord, char gegevenCharacter) {
        for (int rij = 0; rij < mijnSpelbord.length; rij++) {
            for (int kolom = 0; kolom < mijnSpelbord[rij].length; kolom++) {
                // vul vakje met meegegeven character
                mijnSpelbord[rij][kolom] = gegevenCharacter;
            }
        }
    }

    public static void printSpelbord(char[][] hetSpelbord) {
        // bepaal maximum aantal kolommen die voorkomt in het array
        int maximumAantalKolommen = bepaalMaximaalAantalKolommen(hetSpelbord);

        printTopEnBottomLijn(maximumAantalKolommen);

//        System.out.print("| | | |\n");
//        System.out.print("| | | |\n");
//        System.out.print("| | | |\n");
        for (int rij = 0; rij < hetSpelbord.length; rij++) {
            //System.out.print("| | | |\n");
            for (int kolom = 0; kolom < hetSpelbord[rij].length; kolom++) {
                //System.out.print("| ");
                System.out.print("|");
                System.out.print(hetSpelbord[rij][kolom]);
            }
            System.out.print("|\n");
        }

        //System.out.print(" _ _ _ \n");
        printTopEnBottomLijn(maximumAantalKolommen);
    }


    public static int bepaalMaximaalAantalKolommen(char[][] array){
        int maximum = 0;
        // loop door alle rijen
        for(int i=0;i<array.length;i++){
            // kijk of de lengte van de rij groter is dan het maximum tot nu toe.
            int lengteVanRij = array[i].length;
            if(lengteVanRij > maximum){
                maximum = lengteVanRij;
            }
        }
        return maximum;
    }

    public static void printTopEnBottomLijn(int aantalKolommen) {
        //System.out.print(" _ _ _ \n");
        for (int kolom = 0; kolom < aantalKolommen; kolom++) {
            System.out.print(" _");
        }
        System.out.print(" \n");
    }

    public static char[][] maakOnregelmatigSpelbord() {
        // maak array voor de rijen
        final int MAX_AANTAL_RIJEN_OF_KOLOMMEN = 10;

        int randomAantalRijen = (int) ((Math.random() * MAX_AANTAL_RIJEN_OF_KOLOMMEN) + 1);
        char[][] randomSpelbord = new char[randomAantalRijen][];

        // vullen array met random aantal rijen
        for (int rij = 0; rij < randomSpelbord.length; rij++) {
            // bepaal random aantal kolommen
            int randomAantalKolommen = (int) ((Math.random() * MAX_AANTAL_RIJEN_OF_KOLOMMEN) + 1);
            // aanmaken array met random aantal kolommen
            char[] charArrayMetRandomAantalKolommen = new char[randomAantalKolommen];
            // toevoegen aan randomSpelBord
            randomSpelbord[rij] = charArrayMetRandomAantalKolommen;
        }
        //
        return randomSpelbord;
    }

}

     */
}




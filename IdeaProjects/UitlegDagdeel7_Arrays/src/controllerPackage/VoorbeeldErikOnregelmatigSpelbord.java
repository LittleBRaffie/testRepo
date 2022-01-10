package controllerPackage;

public class VoorbeeldErikOnregelmatigSpelbord {

    public static void main(String[] args) {
        // voor de demo: onregelmatig spelbord
        char[][] onregelmatigBord = maakOnregelmatigSpelbord();
        // vul spelbord
        vulSpelbordMetEenCharacter(onregelmatigBord, '@');
        // print het random array
        printSpelbord(onregelmatigBord);
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

        for (int rij = 0; rij < hetSpelbord.length; rij++) {
            for (int kolom = 0; kolom < hetSpelbord[rij].length; kolom++) {
                //System.out.print("| ");
                System.out.print("|");
                System.out.print(hetSpelbord[rij][kolom]);
            }
            System.out.print("|\n");
        }

        printTopEnBottomLijn(maximumAantalKolommen);
    }


    public static int bepaalMaximaalAantalKolommen(char[][] array) {
        int maximum = 0;
        // loop door alle rijen
        for (int i = 0; i < array.length; i++) {
            // kijk of de lengte van de rij groter is dan het maximum tot nu toe.
            int lengteVanRij = array[i].length;
            if (lengteVanRij > maximum) {
                maximum = lengteVanRij;
            }
        }
        return maximum;
    }

    public static void printTopEnBottomLijn(int aantalKolommen) {
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



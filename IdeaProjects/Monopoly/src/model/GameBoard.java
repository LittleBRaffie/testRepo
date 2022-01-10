package model;

public class GameBoard {
    //region INPUT
    static final int AANTAL_SPEELVELDEN_OP_SPELBORD = 40;
    static String[] speelbord = new String[AANTAL_SPEELVELDEN_OP_SPELBORD];

    public static String[] creerenSpeelbord() {
        speelbord[0] = "Start"; // salaris ontvang €200
        speelbord[1] = "Dorpsstraat"; // Ons dorp, kost €60
        speelbord[2] = "Algemeen fonds";
        speelbord[3] = "Brink"; // Ons dorp, kost €60
        speelbord[4] = "Inkomstenbelasting"; // betaal -€200
        speelbord[5] = "Station Zuid"; // Stations, kost €200
        speelbord[6] = "Steenstraat"; // Arnhem, kost €100
        speelbord[7] = "Ketelstaart"; // Arnhem, kost €100
        speelbord[8] = "Velperplein"; // Arnhem, kost €120
        speelbord[9] = "Gevangenis"; // kan ook op bezoek zijn? gevangenis apart?
        speelbord[10] = "Bartiljorisstraat"; // Haarlem, kost €140
        speelbord[11] = "Electriciteitscentrale"; // betaal -€150
        speelbord[12] = "Zuidweg"; // Haarlem, kost €140
        speelbord[13] = "Houtstraat"; // Haarlem, kost €160
        speelbord[14] = "Station West"; // Stations, kost €200
        speelbord[15] = "";
        speelbord[16] = "";
        speelbord[17] = "";
        speelbord[18] = "";
        speelbord[19] = "";
        speelbord[20] = "";
        speelbord[21] = "";
        speelbord[22] = "";
        speelbord[23] = "";
        speelbord[24] = "";
        speelbord[25] = "";
        speelbord[26] = "";
        speelbord[27] = "";
        speelbord[28] = "";
        speelbord[29] = "";
        speelbord[30] = "";
        speelbord[31] = "";
        speelbord[32] = "";
        speelbord[33] = "";
        speelbord[34] = "";
        speelbord[35] = "";
        speelbord[36] = "";
        speelbord[37] = "";
        speelbord[38] = "";
        speelbord[39] = "";

        return speelbord;
    }

    //endregion

    //region VERWERKING
    //region Constructors

    //endregion
    //region GetSet

    //endregion
    //region Functies
    public static void tekenenHorizontaleLijn(){
        String horizontaleLijn = "-";
        for (int lijn = 0; lijn < (5*27); lijn++) {
            System.out.print(horizontaleLijn);
        }
        System.out.println();
    }

    public static void tekenenSpelbord(String[] bord){
        // Doel: speelbord tekenen op 4 rijen en tonen string is 'vakje'

        // Input = speelbord + grafische elementen (25 posities voor de string)

        String verticaleLijn = "|";
        // Verwerking = for loop door velden speelbord
        tekenenHorizontaleLijn();
        for (int vakje = 0; vakje < bord.length; vakje++) {
            System.out.printf("%1s %-23s %1s", verticaleLijn, bord[vakje], verticaleLijn);
            if ((vakje+1) % 5 == 0){
                System.out.println();
                for (int i = 0; i < 5; i++) {
                    System.out.printf("%1s %-23s %1s", verticaleLijn, "test", verticaleLijn);
                }
            }
            if ((vakje+1) % 5 == 0){
                System.out.println();
                for (int i = 0; i < 5; i++) {
                    System.out.printf("%1s %-23s %1s", verticaleLijn, "array3", verticaleLijn);
                }
            }

            if ((vakje+1) % 5 == 0){
                System.out.println();
                tekenenHorizontaleLijn();
            }
        }
        // Output = printen bord
    }

    //endregion
    //endregion

    //region OUTPUT

    //endregion
}

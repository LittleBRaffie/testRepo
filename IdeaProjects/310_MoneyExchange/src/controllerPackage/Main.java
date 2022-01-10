package controllerPackage;

import java.util.Scanner;

public class Main {
    // GOED LEZEN OPDRACHT WAS ALLEDRIE LATEN ZIEN, NIET KEUZE MAKEN!
    static final double KOERSDOLLAR = 1.23843;
    static final double KOERSPOND = 0.88459;
    static final double KOERSYEN = 134.64711;
    static Scanner invoerGebruiker = new Scanner(System.in);
    static String gekozenValuta = "";

    public static void main(String[] args) {
        // input
        int teWisselenBedrag;
        double ingewisseldBedrag;

        // verwerking
        teWisselenBedrag = welkBedragInwisselen();
        ingewisseldBedrag = koersBerekenen(teWisselenBedrag);
        toonAlleKoersen(teWisselenBedrag);

        // output
        System.out.println("U wilt € " + teWisselenBedrag + ",- inwisselen. \nU krijgt hiervoor: " + ingewisseldBedrag + " " + gekozenValuta + ".");

    }

    public static int invoerGebruiker(String vraag) {
        // input
        int invoerInt;

        // verwerking
        System.out.println(vraag);
        invoerInt = invoerGebruiker.nextInt();

        // output

        return invoerInt;
    }

    public static int welkBedragInwisselen() {
        // input
        int inTeWisselenBedrag;

        // verwerking
        inTeWisselenBedrag = invoerGebruiker("Welk bedrag wilt u wisselen? Geef een bedrag in hele euro's.");

        if (inTeWisselenBedrag < 0) {
            do {
                inTeWisselenBedrag = invoerGebruiker("Helaas kan dit bedrag niet gewisseld worden, voer een positief, heel bedrag in euro's in.");
            } while (inTeWisselenBedrag < 0);
        }

        // output
        return inTeWisselenBedrag;
    }

    public static double koersBerekenen(int bedragInEuro) {
        // input - 1 = dollar, 2 = pond, 3 = yen
        double koers = 0.0;
        int bedragInEuroCenten = bedragInEuro * 100;
        double bedragInVreemdeValuta;
        int keuzeGebruiker;
        System.out.println("Dit zijn de koersen:\n1)\t1 Dollar = 1.23843 euro;\n2)\t1 Pond = 0.88459 euro;\n3)\t1 Yen = 134.64711 euro;\n");

        // verwerking
        // gebruiker om keuze vragen welke valuta en dmv switch statement koers bepalen
        keuzeGebruiker = invoerGebruiker("Welke valuta wilt u terug krijgen? Typ het overeenkomstige nummer.");

        while (keuzeGebruiker < 1 || keuzeGebruiker > 3) {
            keuzeGebruiker = invoerGebruiker("Onjuiste invoer. Voer een getal in tussen de 1 en de 3.");
        }

        switch (keuzeGebruiker) {
            case 1:
                koers = KOERSDOLLAR;
                gekozenValuta = "Dollar";
                break;
            case 2:
                koers = KOERSPOND;
                gekozenValuta = "Pond";
                break;
            case 3:
                koers = KOERSYEN;
                gekozenValuta = "Yen";
                break;
            // default is nvt ivm while loop
        }

        // ahv gekozen koers het ingegeven bedrag wisselen en weer terugzetten op euro ipv centen
        bedragInVreemdeValuta = Math.round(bedragInEuroCenten * koers);

        // output
        return bedragInVreemdeValuta / 100.0;
    }

    public static void toonAlleKoersen(int bedragInEuro) {
        //input
        int bedragInEuroCenten;
        double wisselkoersDollar;
        double wisselkoersPond;
        double wisselkoersYen;

        // verwerking
        bedragInEuroCenten = bedragInEuro * 100;
        wisselkoersDollar = Math.round(bedragInEuroCenten * KOERSDOLLAR) / 100;
        wisselkoersPond = Math.round(bedragInEuroCenten * KOERSPOND) / 100;
        wisselkoersYen = Math.round(bedragInEuroCenten * KOERSYEN) / 100;

        // output
        //nvt, void, alleen printen
        System.out.println("In te wisselen bedrag = " + bedragInEuro + "\n" +
                "\nU krijgt hiervoor" + wisselkoersDollar + " Dollar. (Koers 1.23843)" +
                "\nU krijgt hiervoor" + wisselkoersPond + "Pond. (Koers 0.88459)" +
                "\nU krijgt hiervoor" + wisselkoersYen + " Yen. (Koers 134.64711)");
    }

    /*
    b.	Deze bedragen 1,5%, met een minimum van 2 euro per transactie en een maximum van 15 euro per transactie. Schrijf voor het berekenen van de transactiekosten een methode die op basis van het in te wisselen bedrag in euro’s de kosten berekent en teruggeeft (returned).
Zorg dat de invoer en uitvoer van het programma er als volgt uitziet:
In te wisselen bedrag (alleen gehele getallen): 100

De transactiekosten bedragen 2.0 Euro.
We rekenen daarom 98 Euro voor u om.
U krijgt hiervoor 121 Dollar. (Koers 1.23843)
U krijgt hiervoor 87 Pond. (Koers 0.88459)
U krijgt hiervoor 13195 Yen. (Koers 134.64711)

     */

    public static double berekenTransactiekosten(int bedragInEuro) {
        // input
        (double) bedragInEuro = bedragInEuro;
        double transactiekosten;

        // verwerking
        transactiekosten = bedragInEuro * 0, 015;

        if (transactiekosten <= 2) {
            transactiekosten = 2.0;
            bedragInEuro = bedragInEuro - transactiekosten;
        } else if (transactiekosten >= 15) {
            transactiekosten = 15.0)
            bedragInEuro = bedragInEuro - transactiekosten;
        } else {
            bedragInEuro = bedragInEuro - transactiekosten;
        }

        // output
        System.out.println("De transactiekosten bedragen " + transactiekosten + " Euro.");

        return transactiekosten;
    }
}

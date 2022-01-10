package controllerPackage;

import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);
    static final double KOERS_DOLLAR = 1.23843;
    static final double KOERS_POND = 0.88459;
    static final double KOERS_YEN = 134.64711;

    public static void main(String[] args) {
	/*
	Beschrijving
a.	Schrijf een programma dat uitrekent hoeveel buitenlandse valuta een klant krijgt voor zijn euro’s. In het programma wordt voor de volgende valuta het bedrag uitgerekend:

b.	Voor het wisselen moet de klant transactiekosten betalen. Deze bedragen 1,5%, met een minimum van 2 euro per transactie en een maximum van 15 euro per transactie. Schrijf voor het berekenen van de transactiekosten een methode die op basis van het in te wisselen bedrag in euro’s de kosten berekent en teruggeeft (returned).
Zorg dat de invoer en uitvoer van het programma er als volgt uitziet:
In te wisselen bedrag (alleen gehele getallen): 100

De transactiekosten bedragen 2.0 Euro.
We rekenen daarom 98 Euro voor u om.
U krijgt hiervoor 121 Dollar. (Koers 1.23843)
U krijgt hiervoor 87 Pond. (Koers 0.88459)
U krijgt hiervoor 13195 Yen. (Koers 134.64711)
Tips
•	Rond het uiteindelijke bedrag (na aftrek van de transactiekosten) af op een geheel getal.
•	Voor gevorderden: Schrijf voor het omrekenen een methode die op basis van het bedrag in euro’s en de koers het juiste bedrag in de andere valuta uitrekent.

	 */

        // input
        int teWisselenBedrag;
        double bedragDollar;
        double bedragPond;
        double bedragYen;
        double teBetalenTransactiekosten;
        int restantTeWisselenBedrag;
        int bedragDollarHeel;
        int bedragPondHeel;
        int bedragYenHeel;

        // verwerking
        // vragen input gebruiker
        System.out.println("In te wisselen bedrag (alleen gehele getallen): ");
        teWisselenBedrag = scanner.nextInt();

        //omzetten van bedrag in de 3 koersen met 3x dezelfde methode (zonder transactiekosten)
        bedragDollar = omrekenenValuta(teWisselenBedrag, KOERS_DOLLAR);
        bedragPond = omrekenenValuta(teWisselenBedrag, KOERS_POND);
        bedragYen = omrekenenValuta(teWisselenBedrag, KOERS_YEN);

        //methode aanroepen om transactiekosten te bepalen
        teBetalenTransactiekosten = berekenenTransactiekosten(teWisselenBedrag);

        //methode aanroepen om het overgebleven bedrag aan te roepen
        restantTeWisselenBedrag = berekenenBedragNaTransactiekosten(teWisselenBedrag, teBetalenTransactiekosten);

        //zelfde methode aanroepen als eerst, alleen nu met het nieuwe bedrag, dus uitkomsten incl transactiekosten
        //getallen worden hier afgerond op hele euro via Math.round
        bedragDollarHeel = (int) Math.round(omrekenenValuta(restantTeWisselenBedrag, KOERS_DOLLAR));
        bedragPondHeel = (int) Math.round(omrekenenValuta(restantTeWisselenBedrag, KOERS_POND));
        bedragYenHeel = (int) Math.round(omrekenenValuta(restantTeWisselenBedrag, KOERS_YEN));

        // output
        //weergave opdracht a
        System.out.println("U krijgt hiervoor " + bedragDollar + " Dollar. (Koers 1.23843)");
        System.out.println("U krijgt hiervoor " + bedragPond + " Pond. (Koers 0.88459)");
        System.out.println("U krijgt hiervoor " + bedragYen + " Yen. (Koers 34.64711)");

        //weergave opdracht b
        System.out.println("U krijgt hiervoor " + bedragDollarHeel + " Dollar. (Koers 1.23843)");
        System.out.println("U krijgt hiervoor " + bedragPondHeel + " Pond. (Koers 0.88459)");
        System.out.println("U krijgt hiervoor " + bedragYenHeel + " Yen. (Koers 34.64711)");

    }

    public static double omrekenenValuta(int bedragInEuro, double koers) {
        // input
        double bedragInEuroCenten;
        int vreemdeValutaInCenten;
        double vreemdeValuta;

        // verwerking - omzetten bedrag in centen, dat afronden als int en weer terug naar double voor 2 decimalen
        bedragInEuroCenten = ((double) bedragInEuro) * 100;
        vreemdeValutaInCenten = (int) Math.round(bedragInEuroCenten * koers);
        vreemdeValuta = (double) vreemdeValutaInCenten / 100;

        // output
        return vreemdeValuta;
    }

    public static double berekenenTransactiekosten(int bedragEuro) {
        // input
        double transactiekosten;

        // verwerking - kosten = 1,5% van bedrag, min. 2 euro en max. 15 euro
        transactiekosten = bedragEuro * 0.015;

        if (transactiekosten < 2) {
            transactiekosten = 2.0;
        }
        if (transactiekosten > 15) {
            transactiekosten = 15.0;
        }

        // output
        System.out.println("De transactiekosten bedragen " + transactiekosten + " Euro.");
        return transactiekosten;
    }

    public static int berekenenBedragNaTransactiekosten(int oorspronkelijkBedragEuro, double bedragTransactiekosten) {
        // input
        double bedragNaKosten;
        int bedragAfgerond;

        // verwerking
        //bedragen van elkaar aftrekken, afronden en casten naar int (geheel getal)
        bedragNaKosten = ((double) oorspronkelijkBedragEuro - bedragTransactiekosten);
        bedragAfgerond = (int) Math.round(bedragNaKosten);

        // output
        System.out.println("We rekenen daarom " + bedragAfgerond + " Euro voor u om.");
        return bedragAfgerond;
    }
}

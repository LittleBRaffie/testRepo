package controllerPackage;

import java.util.Random;
import java.util.Scanner;

public class Main {
    static public Scanner scanner = new Scanner(System.in);
    static public Random random = new Random();

    /*
    Als laatste oefenopdracht ga je een spelletje programmeren: Getallen raden. Voor deze opdracht heb je alle stof nodig
    die je tijdens dit blok hebt geleerd. Lees voordat je begint de gehele opdracht goed door.

Beschrijving
De te programmeren applicatie genereert drie verschillende random getallen tussen 1 en 10. De gebruiker kan vervolgens
herhaaldelijk raden welke getallen dit zijn. Bij elke poging geeft de applicatie terug hoeveel getallen de gebruiker correct
heeft geraden. Heeft de gebruiker alle drie de getallen goed, dan geeft de applicatie terug hoeveel pogingen de gebruiker
nodig had om de getallen te raden.

Stappenplan
1.	Schrijf een methode die een array van 3 verschillende random getallen tussen 1 en 10 genereert. Geef de methode als
signatuur:
public static int[] genereerGetallen()
2.	Schrijf een methode met de volgende signatuur:
public static boolean komtVoorIn(int mpZoekgetal, int[] mpLijst)
Deze methode geeft true terug als het zoekgetal in de lijst voorkomt en false als het zoekgetal niet in de lijst voorkomt.

Nu je deze methodes af hebt, kun je beginnen met het schrijven van de main methode:

3.	Maak een array van 3 verschillende random getallen met behulp van de methode genereerGetallen.

Stap 4 en 5 moeten herhaald worden totdat de gebruiker alle drie de getallen correct heeft geraden.

4.	Vraag de gebruiker om drie verschillende gehele getallen tussen 1 en 10, gescheiden door een spatie. Lees deze getallen
in. Je hoeft niet te controleren of de invoer van de gebruiker correct is.

5.	Bepaal hoeveel getallen de gebruiker correct heeft geraden. Gebruik hierbij de methode komtVoorIn. De volgorde waarin
de gebruiker de getallen ingeeft is niet van belang. Druk het aantal correct geraden getallen af.

Nadat de gebruiker alle drie de getallen correct heeft volgen de laatste stappen:

6.	Bepaal hoeveel pogingen de gebruiker nodig had om de 3 getallen te raden en druk dit af.
7.	Druk de te raden getallen uit de array af.

Tips
•	Er zijn diverse manieren om te zorgen dat de drie getallen die de methode genereerGetallen teruggeeft verschillend zijn.
Een eenvoudige manier is om net zo lang drie getallen te genereren tot de getallen verschillend zijn. Een andere manier is
om een array met daarin de nummers 1 tot en met 10 aan te maken, deze te shuffelen en vervolgens de eerste drie elementen
van de array te gebruiken, zoals bij het voorbeeld Deck of Cards in § 7.4 in het boek.
•	Het is wel zo netjes om de gegeneerde getallen in oplopende volgorde weer te geven.  Hiervoor kun je de sort methode uit
de Array Class gebruiken (zie § 7.12 in het boek).

Outputvoorbeeld
Voor de duidelijkheid zijn in het outputvoorbeeld op de volgende pagina de gegevens die de gebruiker heeft ingevoerd schuin
en onderstreept. Jouw programma hoeft dus niets schuin en onderstreept af te drukken.

Geef 3 verschillende getallen tussen 1 en 10, gescheiden door spaties: 1 2 3
Aantal correcte getallen = 1
Geef 3 verschillende getallen tussen 1 en 10, gescheiden door spaties: 4 5 6
Aantal correcte getallen = 1
Geef 3 verschillende getallen tussen 1 en 10, gescheiden door spaties: 7 8 9
Aantal correcte getallen = 1
Geef 3 verschillende getallen tussen 1 en 10, gescheiden door spaties: 4 1 7
Aantal correcte getallen = 1
Geef 3 verschillende getallen tussen 1 en 10, gescheiden door spaties: 5 1 8
Aantal correcte getallen = 2
Geef 3 verschillende getallen tussen 1 en 10, gescheiden door spaties: 5 1 9
Aantal correcte getallen = 1
Geef 3 verschillende getallen tussen 1 en 10, gescheiden door spaties: 5 2 7
Aantal correcte getallen = 0
Geef 3 verschillende getallen tussen 1 en 10, gescheiden door spaties: 6 1 8
Aantal correcte getallen = 3

U heeft 8 keer geraden.
De te raden getallen waren: 1 6 8

     */

    public static void main(String[] args) {

        // Doel: Mastermind met getallen. App genereert 3 random nummers. Gebruiker probeert deze te raden. Na elke poging
        // geeft app aan hoeveel getallen goed zijn. Wanneer alle getallen geraden zijn, geeft de app aan in hoeveel
        // pogingen dit is gehaald.

        // Input
        // Aantal finals voor aantallen/grenzen (kunnen ook nog variabel gemaakt worden, bijv. via spelerinput)
        final int AANTAL_GETALLEN = 3;
        final int BOVENGRENS = 10;
        // Array met 3 verschillende getallen
        int[] randomGetallenReeks = new int[AANTAL_GETALLEN];
        // Array invoer speler
        int[] ingevoerdeGetallenReeksSpeler = new int[AANTAL_GETALLEN];
        // aantal goed geraden getallen
        int aantalGoedeGetallenInReeks = 0;
        // Aantal pogingen
        int aantalPogingen = 0;

        // Verwerking
        // Maak array 3 random getallen
        randomGetallenReeks = creeerXRandomGetallen(AANTAL_GETALLEN, BOVENGRENS);
        // Herhaal onderstaande 3 stappen totdat alle getallen zijn geraden
        while (aantalGoedeGetallenInReeks < AANTAL_GETALLEN){
            // Vraag spelerinput
            ingevoerdeGetallenReeksSpeler = leesIngevoerdeGetallenUit(AANTAL_GETALLEN);
            // Check input met getallen
            aantalGoedeGetallenInReeks = checkOfGetallenVoorkomen(ingevoerdeGetallenReeksSpeler,randomGetallenReeks);
            // Geef feedback
            System.out.println("Aantal correcte getallen = "+aantalGoedeGetallenInReeks);
            aantalPogingen++;
        }

        // Output
        // Print aantal pogingen
        System.out.print("U heeft " + aantalPogingen + " keer geraden.");
        // Print de getallen
        printenArrayGetallen("\nDe te raden getallen waren: ", randomGetallenReeks);
    }

    public static int spelerInvoerInt() {
        // Doel: ingave en return int door speler

        // Input - getal
        int getal;

        // Verwerking - ingave door speler
        getal = scanner.nextInt();

        // Output
        return getal;
    }

    public static int[] leesIngevoerdeGetallenUit(int aantalGetallen) {
        // Doel: invoeren + opslaan van x getallen

        // Input - vraag + aantal getallen + array ingevoerde getallen
        System.out.println("Geef 3 verschillende getallen tussen 1 en 10, gescheiden door spaties en druk op 'Enter': ");
        int[] getallen = new int[aantalGetallen];

        // Verwerking - loop per getal invoeren en opslaan
        for (int i = 0; i < aantalGetallen; i++) {
            getallen[i] = spelerInvoerInt();
        }

        // Output
        return getallen;
    }

    public static int genereerRandomGetal(int bovengrens) {
        // Doel: genereer 1 random getal tussen 1 en 10

        // Input - getal
        int randomGetal;

        // Verwerking - genereer getal 1-10
        randomGetal = random.nextInt(bovengrens) + 1;

        // Output
        return randomGetal;
    }

    public static int[] creeerXRandomGetallen(int aantalGetallen, int bovenGrens) {
        // Doel: creeer array met x aantal getallen

        // Input - array + aantal getallen + getal
        int getal;
        int[] arrayGetallen = new int[aantalGetallen];

        // Verwerking - loop om getallen op te slaan + methode genereer getallen + check op dubbele getallen
        arrayGetallen[0] = genereerRandomGetal(bovenGrens);

        for (int i = 1; i < aantalGetallen; i++) {
            arrayGetallen[i] = genereerRandomGetal(bovenGrens);
            for (int j = 0; j < i; j++) {
                if (arrayGetallen[i]==arrayGetallen[j]){
                    i--;
                    break;
                }
            }

        }

//        // FOR LOOP WAARBIJ DUBBELE GETALLEN VOORKOMEN
//        for (int i = 1; i < aantalGetallen; i++) {
//            arrayGetallen[i] = genereerRandomGetal(bovenGrens);
//        }

        // Output
        return arrayGetallen;
    }

    public static int checkOfGetallenVoorkomen(int[] getallenInvoer, int[] getallenOplossing) {
        // Doel: check of getallen van 1 array voorkomen in de andere array

        // Input
        int aantalCorrecteGetallen = 0;

        // Verwerking
        for (int i = 0; i < getallenInvoer.length; i++) {
            for (int j = 0; j < getallenOplossing.length; j++) {
                if (getallenOplossing[i] == getallenInvoer[j]){
                    aantalCorrecteGetallen++;
                }
            }

        }

        // Output
        return aantalCorrecteGetallen;
    }

    public static void printenArrayGetallen(String vraag, int[] arrayGetallen) {
        // Doel: printen van een array met x aantal getallen

        // Input
        System.out.print(vraag);

        // Verwerking
        for (int i = 0; i < arrayGetallen.length; i++) {
            System.out.print(arrayGetallen[i] + " ");
        }

        // Output
    }

    public static void demo() {
        // Doel:

        // Input

        // Verwerking

        // Output

    }
}

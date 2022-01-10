package controllerPackage;

import java.util.Scanner;

public class Main {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        //toonSterrenVierkant();
        //toonWoordVijfKeer(invoerGebruiker("Typ een woord en druk op 'Enter'."));
        //aantalEurosVerdelen();
        berekenWisselgeld(invoerGebruikerDouble("Met dit bedrag betaal ik: "),invoerGebruikerDouble("Hoeveel kost dit?"));
        berekenWisselgeldAfgerond(invoerGebruikerDouble("Met dit bedrag betaal ik: "),invoerGebruikerDouble("Hoeveel kost dit?"));
    }

    public static double berekenWisselgeldAfgerond(double mpTeBetalen, double mpBetaald){
        // input
        double wisselgeld;
        double wisselgeldAfgerondFactor5;
        double wisselgeldAfgerond5Centen;

        // verwerking
        // methode voor wisselgeld wordt aangeroepen, erna x20 en afgerond (want er passen 20 stuivers in een euro) en tenslotte weer /20
        wisselgeld = berekenWisselgeld(mpTeBetalen, mpBetaald);
        wisselgeldAfgerondFactor5 = Math.round(wisselgeld * 20);
        wisselgeldAfgerond5Centen = wisselgeldAfgerondFactor5 / 20;

        // output
        System.out.println("Afgerond op 5 centen is dit: € " + wisselgeldAfgerond5Centen);
        return wisselgeldAfgerond5Centen;
    }

    public static double berekenWisselgeld(double mpTeBetalen, double mpBetaald){
        // input
        double wisselgeld;
        double wisselgeldAfgerond;
        double wisselgeldAfgerond2Decimalen;

        // verwerking
        // omdat Math.round niet goed afrond, eerst omzetten in centen (x100), dan afronden en dan weer terug naar hele euro's (/100)
        wisselgeld = mpTeBetalen - mpBetaald;
        wisselgeldAfgerond = Math.round(wisselgeld*100);
        wisselgeldAfgerond2Decimalen = wisselgeldAfgerond/100;

        // output
        System.out.println("Het wisselgeld is: € " + wisselgeldAfgerond2Decimalen);
        System.out.println("Het wisselgeld is: € " + wisselgeld);
        return wisselgeldAfgerond2Decimalen;
    }

    public static void aantalEurosVerdelen(){
        // input
        int aantalPax;
        int aantalEuros;
        int aantalEurosPP;
        int restant;

        // verwerking
        // gebruiker vragen om aantal pax en euros
        aantalEuros = invoerGebruikerInt("Hoeveel euromunten wil je verdelen?");
        aantalPax = invoerGebruikerInt("Met hoeveel personen?");

        // berekening verdeling en restant
        aantalEurosPP = aantalEuros / aantalPax;
        restant = aantalEurosPP % aantalPax;

        //output
        System.out.println("Als je "+aantalEuros+" euromunten verdeeld over "+aantalPax+" mensen dan krijgt ieder "+aantalEurosPP+" munten en blijven er "+restant+" over.");
    }

    public static int invoerGebruikerInt(String vraag){
        int ingevoerdeGetal;
        System.out.println(vraag);

        ingevoerdeGetal = sc.nextInt();

        return ingevoerdeGetal;
    }

    public static double invoerGebruikerDouble(String vraag){
        double ingevoerdeGetal;
        System.out.println(vraag);

        ingevoerdeGetal = sc.nextDouble();

        return ingevoerdeGetal;
    }

    public static String invoerGebruiker(String vraag){
        String ingevoerdeWoord;
        System.out.println(vraag);

        ingevoerdeWoord = sc.nextLine();

        return ingevoerdeWoord;
    }

    public static void toonWoordVijfKeer(String woord){
        for (int i = 0; i < 5;i++){
            System.out.print(woord);
            System.out.println("");
        }
    }

    public static void toonSterrenVierkant() {
        toonSterren();
        toonSterren();
        toonSterren();
        toonSterren();
    }

    public static void toonSterren(){
        System.out.println("****");
    }
}

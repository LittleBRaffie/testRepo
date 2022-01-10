package controllerPackage;

import java.util.Scanner;

public class Main {
    // Input = variabelen beschikbaar in meerdere methoden + eenmalig scanner ivm geheugen
    static Scanner scanner = new Scanner(System.in);
    static final double AANTAL_K_CAL_PER_STAP = 0.03;
    static String[] dagenVanDeWeek = {"maandag", "dinsdag", "woensdag", "donderdag", "vrijdag", "zaterdag", "zondag"};

    public static void main(String[] args) {
        // Doel: Stappenteller-tool waarbij gebruiker per dag invoert hoeveel stappen hij/zij gelopen heeft en een doel
        // voor zichzelf zet. De tool geeft dan het totaal, gemiddelden, aantal verbrande calorien en of het doel op
        // bepaalde dagen niet gehaald is.

        // Input
        // Standaard tekst weergeven met info over mijzelf
        System.out.println("\nDit programma is gemaakt door Ralf Wingen, klas 'Make IT Work', studentnummer 497112.\n");
        // Doel van de week
        int doelAantalStappenPerDag = 0;
        // Array met aantal dagen vd week (in klasse) + stappen per dag + kCal per dag
        int[] stappenPerDag = new int[dagenVanDeWeek.length]; // zelfde lengte als dagen van de week
        double[] kCalPerDag = new double[dagenVanDeWeek.length]; // zelfde lengte als dagen van de week
        // totalen aantal stappen + kCal
        int totaalAantalStappenPerWeek = 0;
        double totaalAantalKCalPerWeek = 0.0;
        // gemiddelden stappen + kCal
        double gemiddeldeAantalStappenPerDag = 0.0;
        double gemiddeldeAantalKCalPerDag = 0.0;
        // tekst voor wel/niet behalen doel
        String doelGehaald = "";

        // Verwerking
        // vragen + invoeren doel per dag en check minimaal 5.000
        doelAantalStappenPerDag = invoerGebruikerInt("Hoeveel stappen wil je minimaal lopen per dag?");
        while (doelAantalStappenPerDag < 5000) {
            System.out.println("\t\tStel je doel hoger, minimaal 5.000 stappen per dag!");
            doelAantalStappenPerDag = invoerGebruikerInt("Hoeveel stappen wil je minimaal lopen per dag?");
        }

        // gebruiker vragen om gevens per dag in te voeren en dit te verrekenen/op te slaan
        System.out.println("Voer het aantal stappen per dag in: ");
        for (int dag = 0; dag < dagenVanDeWeek.length; dag++) {
            // vragen + invoeren stappen per dag + opslaan array + toevoegen totaal aantal stappen
            stappenPerDag[dag] = invoerGebruikerInt("\t\t" + dagenVanDeWeek[dag] + ": ");
            totaalAantalStappenPerWeek = totaalAantalStappenPerWeek + stappenPerDag[dag];
            // in zelfde loop ook meteen omrekenen kCal per dag + opslaan array + toevoegen totaal kCal
            kCalPerDag[dag] = uitrekenenAantalKCalPerDag(stappenPerDag[dag]);
            totaalAantalKCalPerWeek = totaalAantalKCalPerWeek + kCalPerDag[dag];
        }
        // afronden kCal per week
        totaalAantalKCalPerWeek = afrondenDoubles(totaalAantalKCalPerWeek);

        // uitrekenen gemiddelden stappen + kCal
        gemiddeldeAantalStappenPerDag = (double) totaalAantalStappenPerWeek / dagenVanDeWeek.length;
        gemiddeldeAantalKCalPerDag = totaalAantalKCalPerWeek / dagenVanDeWeek.length;
        // afronden stappen 2 decimalen
        gemiddeldeAantalStappenPerDag = afrondenDoubles(gemiddeldeAantalStappenPerDag);
        gemiddeldeAantalKCalPerDag = afrondenDoubles(gemiddeldeAantalKCalPerDag);

        // bepalen of doel gehaald is
        doelGehaald = bepalenDoelBehaald(doelAantalStappenPerDag, stappenPerDag);

        // Output = totaal stappen + totaal kCal + gemiddeld stappen + gemiddeld kCal + doel gehaald printen
        System.out.println("\nJe hebt deze week in totaal " + totaalAantalStappenPerWeek + " stappen gelopen.");
        System.out.println("Je hebt hiermee " + totaalAantalKCalPerWeek + " kCal verbrand.");
        System.out.println("Je hebt per dag gemiddeld " + gemiddeldeAantalStappenPerDag + " stappen gelopen.");
        System.out.println("Je hebt hiermee per dag gemiddeld " + gemiddeldeAantalKCalPerDag + " kCal verbrand.");
        System.out.println(doelGehaald);
    }

    public static int invoerGebruikerInt(String vraag) {
        // Doel: Vragen en opslaan getal input van gebruiker

        // Input = vraag + getal
        System.out.print(vraag);
        int getal = 0;

        // Verwerking = uitlezen int invoer
        getal = scanner.nextInt();

        // Output = teruggeven getal
        return getal;

    }

    public static double uitrekenenAantalKCalPerDag(int stappen) {
        // Doel: Aantal ingevoerde stappen (int) omzetten naar aantal verbruikte kCal

        // Input = kCal + stappen
        double kCal = 0.0;

        // Verwerking = 1 stap = 0.03 kCal + afronden 2 decimalen
        kCal = AANTAL_K_CAL_PER_STAP * stappen;
        kCal = afrondenDoubles(kCal);

        // Output = teruggave aantal kCal;
        return kCal;
    }

    public static String bepalenDoelBehaald(int doel, int[] stappenPerDag) {
        // Doel: kijken naar aantal stappen per dag en dit vergelijken het met dagdoel. Afhankelijk van resultaat
        // verschillende uitvoer geven.

        // Input = uitslag + doel + stappen per dag + tijdelijke string voor dagen niet gehaald + boolean als check
        String uitslag = "";
        String dagenNietGehaald = "";
        boolean isDoelGehaald = true;

        // Verwerking
        // loop met if statement voor check per dag
        for (int dag = 0; dag < stappenPerDag.length; dag++) {
            if (stappenPerDag[dag] < doel){
                dagenNietGehaald = dagenNietGehaald + dagenVanDeWeek[dag] + " ";
                isDoelGehaald = false;
            }
        }
        // if statement met boolean of doel gehaald is
        if (isDoelGehaald){
            uitslag = "Je hebt alle dagen genoeg gelopen, ga zo door!";
        } else {
            uitslag = "Je hebt te weinig stappen gelopen op: "+dagenNietGehaald;
        }

        // Output
        return uitslag;
    }

    public static double afrondenDoubles(double decimaalGetal){
        // Doel: afronden double op 2 decimalen

        // Input = double

        // Verwerking = afronden via Math.round (eerst x100, dan afronden, dan /100.0 voor resultaat als double
        decimaalGetal = (Math.round(decimaalGetal * 100)) / 100.0;

        // Output = double 2 decimalen
        return decimaalGetal;
    }
}

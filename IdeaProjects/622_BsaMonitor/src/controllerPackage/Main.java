package controllerPackage;

import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);
    static boolean bsa = false;
    static final double VOLDOENDE = 5.5;
    static final String BSA_POSITIEF = "positief";
    static final String BSA_NEGATIEF = "negatief";

    /*
    Inleiding
Tijdens de opleiding op de Hogeschool van Amsterdam krijg een student cijfers voor de vakken en projecten die hij of zij volgt.
Aan het eind van jaar 1 krijgt iedere student een bindend studieadvies (BSA). Een BSA kan negatief of positief zijn. Is het BSA
positief dan is het mogelijk om de opleiding te vervolgen. Bij een negatief BSA is het niet mogelijk om de opleiding te
vervolgen aan de Hogeschool van Amsterdam. Een student ontvangt een negatief BSA als hij of zij aan het einde van het eerste
jaar van inschrijving minder dan 50 studiepunten heeft behaald uit de propedeuse.
Je kunt een applicatie schrijven waarbij een student de behaalde cijfers in semester 1 invoert, waarna die student een
overzicht krijgt van de studievoortgang. Tevens kan de applicatie voorspellen of de student een positief of negatief BSA zal
krijgen.
Ieder vak/project heeft een naam en een hoeveelheid studiepunten. Deze studiepunten ontvang je wanneer je alle bij het vak
behorende toetsen (tentamen, opdrachten etc.) haalt.
De volgende tabel geeft een overzicht van de vakken en projecten die studenten  in semester 1 gemeenschappelijk hebben:
Vak	Studiepunten
Project Fasten Your Seatbelts	12
Programming	3
7.5Databases	3
Personal Skills	2
Project Skills	2

Daarnaast heeft elke richting nog twee vakken van 3 punten in semester 1. Voor studenten van de richting Software Engineering
zijn dat de vakken OOP1 en User Interaction.
Stappenplan
a.	Maak een nieuw Java project in IntelliJ genaamd “BsaMonitor”.
b.	Declareer de volgende drie arrays. Maak ze de juiste lengte, alle drie even groot.
1.	Een array vakNamen waarin de namen van vakken en projecten komen. Vul de array met de namen van de vakken en projecten
die bij de richting SE horen in semester 1.
2.	Een array vakPunten waarin voor ieder vak de studiepunten van de vakken en projecten staan. Vul deze array met de juiste
studiepunten, dus:
als vakNamen[1] = “Programming” dan vakPunten[1] = 3, omdat je met het vak Programming 3 studiepunten kunt verdienen.
3.	Een array vakCijfers, waarin je de cijfers die je voor elk vak behaalt zult opslaan.
c.	Gebruik de Scanner Class om de gebruiker voor ieder vak zijn/haar behaalde cijfer in te laten voeren. Gebruik een for-loop
en sla de ingevoerde cijfers op in de array vakCijfers. Zorg ervoor dat de gebruiker alleen geldige cijfers (tussen de 1.0 en
de 10.0) kan invoeren.
d.	Nadat de gebruiker de cijfers heeft ingevoerd kan het programma bepalen hoeveel studiepunten je hebt gehaald voor ieder
vak/project, gebaseerd op het aantal studiepunten dat je kan verdienen en het cijfer dat je hebt gehaald (of hoopt te halen).
Je krijgt de bij het vak/project behorende studiepunten als je cijfer groter of gelijk is aan 5,5. Gebruik weer een for-loop
en sla de bij elk vak behaalde studiepunten op in de array vakPunten. Tel alle behaalde studiepunten bij elkaar op en sla ook
deze op.
e.	Toon nu de resultaten per project of vak op het scherm. Gebruik dit keer de System.out.printf methode (zie boek § 4.6) om
de uitlijning van de uitvoer netjes te maken.
f.	Toon tenslotte het aantal behaalde studiepunten. Als het aantal behaalde studiepunten kleiner is dan 5/6 van het totaal,
dan moet de volgende melding worden afgedrukt: “PAS OP: je ligt op schema voor een negatief BSA!”.
Input/Output
Zie hier een voorbeeld van input/output van deze applicatie voor de richting BIM. Input die de gebruiker invoert is schuin en
onderstreept.
Voer behaalde cijfers in:
Fasten Your Seatbelts: 7,5
Programming: 5,5
User Interaction: 8,1
Personal Skills: 7
Project Skills: 5
OOP 1: 8
Databases: 5,4

Vak/project: Fasten Your Seatbelts	Cijfer: 7.5	Behaalde punten: 12
Vak/project: Programming	Cijfer: 5.5	Behaalde punten: 3
Vak/project: User Interaction	Cijfer: 8.1	Behaalde punten: 3
Vak/project: Personal Skills	Cijfer: 7.0	Behaalde punten: 2
Vak/project: Project Skills	Cijfer: 5.0	Behaalde punten: 0
Vak/project: OOP 1	Cijfer: 8.0	Behaalde punten: 3
Vak/project: Databases	Cijfer: 5.4	Behaalde punten: 0

Totaal behaalde studiepunten: 23/28
PAS OP: je ligt op schema voor een negatief BSA!

     */

    public static void main(String[] args) {
        // Doel: applicatie waarbij 1 student cijfers invoert voor 7 vakken.
        // App rekent dit om in: 1) punten per vak 2) totaal punten en 3) BSA-voorspelling.

        // Input
        // 4 arrays (vak, standaardpunten, cijfer, behaalde punten)
        String[] vakken = {"Fasten Your Seatbelts", "Programming", "User Interaction", "Personal Skills", "Project Skills", "OOP 1", "Databases"};
        int[] teBehalenPuntenPerVak = {12, 3, 3, 2, 2, 3, 3};
        double[] cijfersPerVakVanStudent = new double[vakken.length];
        int[] puntenPerVakVanStudent = new int[vakken.length];
        int totaalBehaaldePunten;

        // Verwerking
        // invoer punten
        cijfersPerVakVanStudent = invoerStudentCijfers(vakken);
        // omrekenen cijfer -> punten
        puntenPerVakVanStudent = uitrekenenAantalStudiePuntenViaCijfers(cijfersPerVakVanStudent, teBehalenPuntenPerVak);
        // uitrekenen totaal punten
        totaalBehaaldePunten = uitrekenenTotaalBehaaldePunten(puntenPerVakVanStudent);
        // omzetten punten -> BSA

        // Output
        // print per vak cijfer + punten
        // print totaal punten
        // print BSA
        printenArray(vakken, cijfersPerVakVanStudent, puntenPerVakVanStudent);
        System.out.println("Totaal behaalde studiepunten: " + totaalBehaaldePunten);
        berekenenUitslagBsa(totaalBehaaldePunten, teBehalenPuntenPerVak);

    }

    public static double invoerGebruikerDouble(String vraag) {
        System.out.println(vraag);
        return scanner.nextDouble();
    }

    public static double[] invoerStudentCijfers(String[] vragen) {
        // Doel: methode die x aantal keer vraagt om invoer van een cijfer per vak

        // Input - array + vragen om input
        System.out.println("Voer behaalde cijfers in (met een komma):");
        double[] ingevoerdeCijfers = new double[vragen.length];

        // Verwerking - elke invoer opslaan in array
        for (int i = 0; i < vragen.length; i++) {
            ingevoerdeCijfers[i] = invoerGebruikerDouble(vragen[i]);
        }

        // Output - return ingevulde array
        return ingevoerdeCijfers;
    }

    public static int[] uitrekenenAantalStudiePuntenViaCijfers(double[] behaaldeCijfers, int[] punten) {
        // Doel: omzetten van een cijfer in het wel/niet halen van de studiepunten

        // Input - array cijfers + voldoende bij 5,5 + array studiepunten + array behaalde punten
        int[] behaaldePunten = new int[behaaldeCijfers.length];

        // Verwerking - voldoende = toekenning studiepunten
        for (int i = 0; i < behaaldeCijfers.length; i++) {
            if (behaaldeCijfers[i] >= VOLDOENDE) {
                behaaldePunten[i] = punten[i];
            }
        }

        // Output - return array met punten
        return behaaldePunten;

    }

    public static int uitrekenenTotaalBehaaldePunten(int[] punten) {
        // Doel: uitrekenen totaal behaalde studiepunten

        // Input - totaal + array punten
        int totaalPunten = 0;

        // Verwerking - loop door punten en tel op
        for (int i = 0; i < punten.length; i++) {
            totaalPunten = totaalPunten + punten[i];
        }

        // Output - return totaal
        return totaalPunten;
    }

    public static void berekenenUitslagBsa(int totaalPunten, int[] maxPunten) {
        // Doel: ahv totaal behaalde punten uitrekenen wat bsa wordt + printen

        // Input - totaal punten + uitslag + max punten
        int maxAantalPunten = uitrekenenTotaalBehaaldePunten(maxPunten);

        // Verwerking - geslaagd bij > 5/6e van totaal punten (28)
        if (totaalPunten > (maxAantalPunten * 5 / 6)) {
            bsa = true;
        } else {
            bsa = false;
            System.out.println("PAS OP: je ligt op schema voor een negatief BSA!");
        }

        // Output
        //PAS OP: je ligt op schema voor een negatief BSA!

    }

    public static void printenArray(String[] tePrintenVakken, double[] tePrintenCijfers, int[] tePrintenPunten) {
        // Doel:

        // Input

        // Verwerking
        for (int i = 0; i < tePrintenCijfers.length; i++) {
            System.out.printf("%-13s %-25s %-8s %3.1f %-17s %-2d", "Vak/project: ", tePrintenVakken[i], "Cijfer: ", tePrintenCijfers[i],
                    "Behaalde punten: ", tePrintenPunten[i]);
//            System.out.println("Vak/project: "+tePrintenVakken[i]+"Cijfer: " + tePrintenCijfers[i]+"Behaalde punten: "+ tePrintenPunten[i]);

        }

        // Output
        //Vak/project: Fasten Your Seatbelts	Cijfer: 7.5	Behaalde punten: 12

    }


}

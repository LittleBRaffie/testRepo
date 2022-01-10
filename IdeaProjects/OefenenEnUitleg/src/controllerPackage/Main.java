package controllerPackage;

import java.util.Random;
import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);
    static Random random = new Random();

    public static void main(String[] args) {
        /*
        VASTE STRUCTUUR
        0) doel
        1) input
        2) verwerking
        3) output

        PRIMITIEVE DATA TYPEN
        byte = 8 bit -->
        short = 16 bit - Gehele getallen
        int = 32 bit
        long = 64 bit
        float = 32 bit - decimale getallen
        double = 64 bit
        boolean = 16 bit - true/false
        char = 8 bit - letter
        Een bit = 0 of 1

        NON PRIMITIEVE DATA TYPEN = REFERENCE TYPES
        String = object voor tekst
        Array = ook object vandaar dat je deze ook moet aanroepen TYPE[] naamArray = new TYPE[MAX AANTAL] --> aantal moet je vooraf definiëren
        List = is flexibele Array als je geen max aantal weet (API)
        Classes

        OPERATOREN
        Modules = % -->     i % 2 == 0      Dit betekent dat als i deelbaar is door 2 en het restant nul is, de boolean true is (m.a.w. het is een even getal)

        STRUCTUUR JAVA
        Programma -> (Modules) -> (JDK) -> Package -> Class -> Method -> Data typen of Method

        SHORT CUTS
        Ctrl-Shift-L = lay out mooi maken
        spvm = shortcut main method
        sout = shortcut System.out.print...
        for i = for-loop
        ctr ? = geselecteerde tekst als 'comment' markeren

        TERMEN
        -   Overloading = methode die beschikbaar is met meerdere variaties (input van parameters in zowel aantal als type)
                Bijv.
                System.out.println() --> kunt met String, int, long, Object, array etc. invoeren
        -   Refactor = herzien/aanpassen van je code
                Bijv.
                Rename van een term
                Waardes vervangen door Variablen

        2 VERSCHILLENDE KLASSEN
        instance class = klasse die je pas kunt gebruiken als je deze geïnitieerd is (bijv. Scanner)
            Scanner mijnScanner; = constructor
            mijnScanner = new Scanner (parameter); --> eerst Object aanmaken
            mijnScanner.methode --> verwijzing naar referentie van de klasse om methode aan te roepen (=object.methode, bijv. mijnScanner.nextInt(); )
        static class = is klasse die je altijd kunt gebruiken (bijv. Math)
            Math.methode --> verwijzing naar klasse om methode aan te roepen (= Class.methode, bijv. Math.round(); )

        EXCEPTION HANDLING
        String s = "   1551556k    "; --> random String
        s = s.trim(); --> methode die spaties aan zijkanten weg haalt, deze gooit wel exeption (zie je in omschrijving)
        boolean valid = true;

        try { --> testen op integer, indien er interne fout optreed, springt de code naar 'catch', zo niet, wordt code tussen {} gedaan
            int i = Integer.valueOf(s); --> static methode van class Inter om te kijken of er int instaan
        } catch (Exception e1) { --> testen op float
            try {
                float f = Float.parseFloat(s); --> static methode van class Float om te kijken of er float instaan
            } catch (Exception e2) {
                valid = false; --> indien er
            }
        }

        return valid; --> als er geen interne foutmelding (Exception) optreed, wordt dit uitgevoerd. Zo kun je kijken of de String (bijv. input) de correcte data bevat

        NOTE: Zoek functies op die je niet weet, bijv. Interger.valueOf of String.trim

        LAYOUT & FUNCTIONS
        %...variabele       = uitlijnen van String/int/char: bij "%6s" = String is 6 posities groot het aantal posities (rechts). Dit kan ook ander getal zijn, of negatief (links uitlijnen)
        %...f               = weergave float/double in String met x-aantal decimalen: "%4.1f" is getal met 4 posities waarvan 1 achter de komma (indien meer posities, nog steeds 1 achter de komma)
        %...d               = uitlijnen van int: werkt zelfde als String
        printf              = deze printfunctie gebruik je om bovenstaand drie gebruiken: printf("%8s", variabele) printf("String..%3.2...", double variabele)
        Integer.MAX_VALUE   = max getal dat in een int kan, voor als je bij een loop terugtelt
        Collection.min      = minimale value van een list (statische klasse)
        Arrays.asList       = omzetten van array in list (statische klasse)
        Arrays.sort         = sorteren van een array, makkelijk voor hoogste of laagste getal van de array
        Math.pow (a, b)     = voor machtverheffen, double a ^ double b (statische klasse)
        //TODO ...          = to do voor jezelf invullen (zie balk onderin)
        \                   = begin voor speciale input, bijv. \t = tab, \n = enter, \u = invoeren unicode (4 cijfers/getallen erna)

        LOOPS & ARRAYS
        * Wen jezelf aan om altijd op 0 te beginnen ipv 1 (arrays beginnen namelijk ook altijd bij 0)!

        GEHEUGEN
        scope   = tot waar data beschikbaar is (binnen methode, binnen classe etc)
        stack   = beperkt geheugen waar variabele met vaste ruimte wordt opgeslagen (bijv. de naam van een array)
        heap    = groter geheugen waar de omvang van een item nog kan groeien (bijv. wat de daadwerkelijke items in een array zijn, een String is groter dan een char)
        Belangrijk om te weten waar iets staat, want dit moet je wissen (Java doet dit automatisch, C of C++ niet). Als je geheugen volloopt, crasht je operating system
        */

    }

}


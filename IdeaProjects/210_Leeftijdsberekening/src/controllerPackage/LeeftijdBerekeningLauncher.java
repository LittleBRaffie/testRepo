package controllerPackage;

import java.util.Scanner;

public class LeeftijdBerekeningLauncher {
    static final int HUIDIGJAAR= 2021;
    static final int LEEFTIJDSGRENS = 50;

    public static void main(String[] args) {
	// write your code here
        // input - definiëren van de gevraagde variabelen en scanner object aanmaken
        Scanner invoerGebruiker = new Scanner(System.in);
        String naam;
        int invoerGeboortejaar;
        int berekendeLeeftijd;


        // verwerking - vragen om input aan de gebruiker en deze opslaan
        System.out.println("Wat is uw volledige naam? Type deze in en druk op 'Enter'.");
        naam = invoerGebruiker.nextLine();
        System.out.println("Wat is uw geboortejaar? Type deze in (4 cijfers) en druk op 'Enter'.");
        invoerGeboortejaar = invoerGebruiker.nextInt();

        //berekenen van de leeftijd
        berekendeLeeftijd = berekenenLeeftijd(invoerGeboortejaar);

        // output - eindtekst met weergave leeftijd
        if (berekendeLeeftijd >= LEEFTIJDSGRENS){
            System.out.println("Beste " + naam + ",\nEind 2021 zal je " + berekendeLeeftijd + " jaar zijn. Je ziet er nog goed uit voor je leeftijd!");
        } else {
            System.out.println("Beste " + naam + ",\nEind 2021 zal je " + berekendeLeeftijd + " jaar zijn. Geniet nog even van het leven!");//eigenlijk "Je bent nog lang niet toe aan pensioen"
        }

    }

    public static int berekenenLeeftijd (int geboortejaar){
        // methode voor berekenen van de leeftijd wanneer het geboortejaar wordt ingegeven
        int leeftijd;
        leeftijd = HUIDIGJAAR - geboortejaar;

        return leeftijd;
    }

}

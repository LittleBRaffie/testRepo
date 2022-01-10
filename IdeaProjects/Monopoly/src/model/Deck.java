package model;

import java.util.ArrayList;
import java.util.Collections;

public class Deck {
    //region INPUT
//    private static final int NUMBER_OF_CARDS = 16;
    private static final String TYPE_IS_CHANCE = "Kans";
    private static final String TYPE_IS_FUND = "Fonds";
    ArrayList<Card> deck = new ArrayList<>();

    //endregion

    //region VERWERKING
    //region Constructors
    public Deck(String type) {
        if (type.equals(TYPE_IS_CHANCE)){
            createDeckOfChanceCards();
        } else if (type.equals(TYPE_IS_FUND)){
            createDeckOfFundCards();
        }
    }

    //endregion
    //region GetSet

    //endregion
    //region Functies
    public void createDeckOfChanceCards() {
        // Doel: vullen van deck met kanskaarten
        deck.add(new CardChance("kaart 1","krijg iets"));
        deck.add(new CardChance("",""));
        deck.add(new CardChance("",""));
        deck.add(new CardChance("",""));
        deck.add(new CardChance("kaart 5","betaal iets"));
        deck.add(new CardChance("",""));
        deck.add(new CardChance("",""));
        deck.add(new CardChance("",""));
        deck.add(new CardChance("",""));
        deck.add(new CardChance("10","doe iets"));
        deck.add(new CardChance("",""));
        deck.add(new CardChance("",""));
        deck.add(new CardChance("",""));
        deck.add(new CardChance("",""));
        deck.add(new CardChance("",""));
        deck.add(new CardChance("16","laatste kans"));
    }

    public void createDeckOfFundCards() {
        // Doel: vullen van deck met kanskaarten
        deck.add(new CardFund("","bla"));
        deck.add(new CardFund("",""));
        deck.add(new CardFund("3",""));
        deck.add(new CardFund("",""));
        deck.add(new CardFund("",""));
        deck.add(new CardFund("6",""));
        deck.add(new CardFund("",""));
        deck.add(new CardFund("",""));
        deck.add(new CardFund("9",""));
        deck.add(new CardFund("",""));
        deck.add(new CardFund("",""));
        deck.add(new CardFund("",""));
        deck.add(new CardFund("13","helaas"));
        deck.add(new CardFund("",""));
        deck.add(new CardFund("",""));
        deck.add(new CardFund("kaart 16","helaas, gevangenis"));
    }

    public void shuffleDeck(){
        Collections.shuffle(this.deck);
    }

    public void printDeckOfAllCards(){
        for (Card card : deck) {
            System.out.println(card);
        }
    }

    //endregion
    //endregion

    //region OUTPUT
    @Override
    public String toString() {
        return "Deck{" +
                "deck=" + deck +
                '}';
    }

    //endregion
}

package model;

public abstract class Card {
    //region INPUT
    private String naam;
    private String opdracht;

    //endregion

    //region VERWERKING
    //region Constructors
    public Card(String naam, String opdracht) {
        this.naam = naam;
        this.opdracht = opdracht;
    }

    //endregion
    //region GetSet

    //endregion
    //region Functies

    //endregion
    //endregion

    //region OUTPUT
    @Override
    public String toString() {
        return "Kaart {naam='" + naam + "', opdracht='" + opdracht + "'}.";
    }

    //endregion
}

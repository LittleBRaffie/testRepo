package model;

public class CardFund extends Card{
    //region INPUT
    private String type;

    //endregion

    //region VERWERKING
    //region Constructors

    public CardFund(String naam, String opdracht) {
        super(naam, opdracht);
        this.type = "Algemeen Fonds";
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
        return super.toString()+"{type='" + type + "'}.";
    }

    //endregion

}
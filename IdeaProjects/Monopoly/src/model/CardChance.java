package model;

public class CardChance extends Card{
    //region INPUT
    private String type;

    //endregion

    //region VERWERKING
    //region Constructors

    public CardChance(String naam, String opdracht) {
        super(naam, opdracht);
        this.type = "Kanskaart";
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

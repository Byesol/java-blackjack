public class Card {

    private final CardType cardType;
    private final CardShape shape;

    public Card(CardType cardType, CardShape shape) {
        this.cardType = cardType;
        this.shape = shape;
    }

    public CardType getType() {
        return cardType;
    }

    public CardShape getShape() {
        return shape;
    }
}

public class Card {

    private final CardType number;
    private final CardShape shape;

    public Card(CardType number, CardShape shape) {
        this.number = number;
        this.shape = shape;
    }

    public CardType getNumber() {
        return number;
    }

    public CardShape getShape() {
        return shape;
    }
}

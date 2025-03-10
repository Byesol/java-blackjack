public class Card {

    private final CardType number;
    private final String shape;

    public Card(CardType number, String shape) {
        this.number = number;
        this.shape = shape;
    }

    public CardType getNumber() {
        return number;
    }

    public String getShape() {
        return shape;
    }
}

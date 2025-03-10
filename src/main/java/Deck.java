import java.util.List;

public class Deck {

    private final List<Card> cards;

    public Deck(List<Card> cards) {
        this.cards = cards;
    }

    public int size() {
        return cards.size();
    }
}

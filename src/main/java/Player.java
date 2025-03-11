public class Player {

    private final String name;
    private final ReceivedCard receivedCard = new ReceivedCard();

    public Player(String name) {
        validateNameLength(name);
        this.name = name;
    }

    private void validateNameLength(String name) {

        if ((name.length() >= 6) || (name.length() < 2)) {
            throw new IllegalArgumentException();
        }
    }

    public String getName() {
        return name;
    }

    public void putCard(Card card) {
        receivedCard.receiveCard(card);
    }

    public ReceivedCard getReceivedCard() {
        return receivedCard;
    }
}

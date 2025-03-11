public class Dealer {

    private final ReceivedCard receivedCard = new ReceivedCard();

    public void putCard(Card card) {
        receivedCard.receiveCard(card);
    }

    public ReceivedCard getReceivedCard() {
        return receivedCard;
    }

    public void firstPutCard(Card card1, Card card2) {
        receivedCard.receiveCard(card1);
        receivedCard.receiveCard(card2);
    }

    public void drawUntilLimit(Deck deck) {
        while (receivedCard.calculatePoint() <= 16) {
            receivedCard.receiveCard(deck.drawCard());
        }
    }
}

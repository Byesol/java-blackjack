import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class ReceivedCard {

    private final List<Card> receivedCard = new ArrayList<>();

    public void receiveCard(Card card) {
        receivedCard.add(card);
    }

    public int size() {
        return receivedCard.size();
    }

    public List<Card> getListReceiveCard() {
        return receivedCard;
    }

    public int calculatePoint() {
        int aceCount = getAceCount();
        int cardSum = calculateDefaultPoint();
        int plusPoint = calculatePlusPoint(aceCount, cardSum);
        return cardSum + plusPoint;
    }

    private static int calculatePlusPoint(int aceCount, int cardSum) {
        return IntStream.range(0, aceCount)
                .reduce(0, (sum, i) -> (cardSum + sum <= 11) ? sum + 10 : sum);
    }

    private int calculateDefaultPoint() {
        return receivedCard.stream()
                .mapToInt(card ->
                        card.getType().getCardPoint()
                )
                .sum();
    }

    private int getAceCount() {
        return (int) receivedCard.stream()
                .filter(card -> card.getType().equals(CardType.ONE))
                .count();
    }


    public boolean isBust() {
        if (calculatePoint() > 21) {
            return true;
        }
        return false;
    }
}

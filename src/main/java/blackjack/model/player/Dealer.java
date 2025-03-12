package blackjack.model.player;


import blackjack.model.card.Card;

public class Dealer extends Player {
    public static final int ACE_THRESHOLD = 16;

    public boolean drewUnderThereshold(Card card) {
        if (calculatePoint() <= ACE_THRESHOLD) {
            getReceivedCards().receive(card);
            return true;
        }
        return false;

    }
}

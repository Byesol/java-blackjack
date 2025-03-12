package blackjack.model.game;

import blackjack.model.player.Dealer;
import blackjack.model.player.Participant;
import blackjack.model.player.Participants;
import blackjack.model.player.Player;
import java.util.Deque;
import java.util.LinkedList;

public class BlackJackGame {

    private final Deck deck;
    private final Participants participants;
    private final Dealer dealer;
    private final Deque<Participant> readyQueue;

    public BlackJackGame(DeckInitializer deckInitializer, Dealer dealer, Participants participants) {
        this.deck = deckInitializer.generateDeck();
        this.participants = participants;
        this.dealer = dealer;
        this.readyQueue = new LinkedList<>(participants.getParticipants());
    }

    public void initializeGame() {
        participants.getParticipants()
                .forEach(this::putTowCard);
        putTowCard(dealer);
    }

    private void putTowCard(Player player) {
        player.putCard(deck.drawCard());
        player.putCard(deck.drawCard());
    }

    public void receiveCard(boolean isReceive) {
        if (isReceive) {
            readyQueue.getFirst().putCard(deck.drawCard());
            return;
        }
        readyQueue.poll();
    }

    public Participant getCurrentTurnParticipant() {
        return readyQueue.getFirst();
    }

    public boolean drewDealerCards() {
        return dealer.drewUnderThereshold(deck.drawCard());
    }

    public boolean hasReady() {
        return !readyQueue.isEmpty();
    }

    public void skipTurn() {
        readyQueue.poll();
    }
}

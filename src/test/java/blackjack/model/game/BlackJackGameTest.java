package blackjack.model.game;

import static org.assertj.core.api.Assertions.assertThat;

import blackjack.model.player.Dealer;
import blackjack.model.player.Participant;
import blackjack.model.player.Participants;
import java.util.List;
import org.junit.jupiter.api.Test;

class BlackJackGameTest {

    @Test
    void 게임이_시작하면_모든_플레이어에게_카드를_두장씩_배분한다() {
        // given
        Dealer dealer = new Dealer();
        Participant participant1 = new Participant("벡터");
        Participant participant2 = new Participant("한스");
        Participants participants = new Participants(List.of(participant1, participant2));
        DeckInitializer deckInitializer = new DeckInitializer();

        // when
        BlackJackGame blackJackGame = new BlackJackGame(deckInitializer, dealer, participants);
        blackJackGame.initializeGame();

        // then
        assertThat(dealer.getReceivedCards().size()).isEqualTo(2);
        assertThat(participant1.getReceivedCards().size()).isEqualTo(2);
        assertThat(participant2.getReceivedCards().size()).isEqualTo(2);

    }

    @Test
    void 참여자가_카드를_받는다() {
        // given
        Dealer dealer = new Dealer();
        Participant participant1 = new Participant("벡터");
        Participant participant2 = new Participant("한스");
        Participants participants = new Participants(List.of(participant1, participant2));
        DeckInitializer deckInitializer = new DeckInitializer();

        // when
        BlackJackGame blackJackGame = new BlackJackGame(deckInitializer, dealer, participants);
        blackJackGame.receiveCard(true);
        blackJackGame.receiveCard(true);

        // then
        assertThat(participant1.getReceivedCards().size()).isEqualTo(2);
    }

    @Test
    void 참여자가_카드를_받지_않는다() {
        // given
        Dealer dealer = new Dealer();
        Participant participant1 = new Participant("벡터");
        Participant participant2 = new Participant("한스");
        Participants participants = new Participants(List.of(participant1, participant2));
        DeckInitializer deckInitializer = new DeckInitializer();

        // when
        BlackJackGame blackJackGame = new BlackJackGame(deckInitializer, dealer, participants);
        blackJackGame.receiveCard(true);
        blackJackGame.receiveCard(false);

        // then
        assertThat(participant1.getReceivedCards().size()).isEqualTo(1);
        assertThat(blackJackGame.getCurrentTurnParticipant()).isEqualTo(participant2);
    }

    @Test
    void 딜러에게_카드를_추가한다() {
        // given
        Dealer dealer = new Dealer();
        Participant participant1 = new Participant("벡터");
        Participant participant2 = new Participant("한스");
        Participants participants = new Participants(List.of(participant1, participant2));
        DeckInitializer deckInitializer = new DeckInitializer();

        // when
        BlackJackGame blackJackGame = new BlackJackGame(deckInitializer, dealer, participants);
        blackJackGame.drewDealerCards();

        // then
        assertThat(dealer.getReceivedCards().size()).isEqualTo(1);
    }


}

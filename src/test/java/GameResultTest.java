import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class GameResultTest {
    private Dealer dealer;
    private Player player1;
    private Player player2;
    private Players players;
    private BlackJackGame blackJackGame;

    @BeforeEach
    void setUp() {
        dealer = new Dealer();
        player1 = new Player("벡터");
        player2 = new Player("벡터2");
        List<Player> listPlayers = new ArrayList<>(List.of(player1, player2));
        players = new Players(listPlayers);
        blackJackGame = new BlackJackGame(dealer, players);
    }

    @Test
    @DisplayName("딜러와 플레이어를 통해 게임을 생성한다")
    void BlackJackGameTest() {
        assertThat(blackJackGame).isNotNull();
    }

    @Test
    @DisplayName("맨 처음 카드를 나눠준다.")
    void setGameTest() {
        blackJackGame.setGame(DeckInitializer.generateDeck());
        assertThat(players.getPlayers().getFirst().getReceivedCard().size()).isEqualTo(2);
        assertThat(dealer.getReceivedCard().size()).isEqualTo(2);
    }

    @Test
    @DisplayName("딜러는 16이하면 더 받고 17이상이면 더 받는다.")
    void decideResultTest() {
        Deck deck = DeckInitializer.generateDeck();
        blackJackGame.dealerTurn(deck);
        assertThat(dealer.getReceivedCard().calculatePoint()).isGreaterThan(16);
    }

    @Test
    @DisplayName("플레이어와 딜러의 승패를 결정한다. -  둘 다 bust x")
    void decidePlayerWin() {
        Card card1 = new Card(CardType.ONE, CardShape.SPADE);
        Card card2 = new Card(CardType.ONE, CardShape.SPADE);
        Card card3 = new Card(CardType.NINE, CardShape.SPADE);
        dealer.putCard(card1);
        dealer.putCard(card2);
        player1.putCard(card3);
        GameResult isWin = GameResult.decidePlayerWin(player1, dealer);
        assertThat(isWin).isEqualTo(GameResult.LOSE);
    }

    @Test
    @DisplayName("플레이어와 딜러의 승패를 결정한다. -  둘 다 bust x, 플레이어승")
    void decidePlayerWin2() {
        Card card1 = new Card(CardType.ONE, CardShape.SPADE);
        Card card2 = new Card(CardType.ONE, CardShape.SPADE);
        Card card3 = new Card(CardType.NINE, CardShape.SPADE);
        player1.putCard(card1);
        player1.putCard(card2);
        dealer.putCard(card3);
        GameResult isWin = GameResult.decidePlayerWin(player1, dealer);
        assertThat(isWin).isEqualTo(GameResult.WIN);
    }

    @Test
    @DisplayName("플레이어와 딜러의 승패를 결정한다. -  플레이어 버스트, 딜러승")
    void decidePlayerWin3() {
        Card card1 = new Card(CardType.JACK, CardShape.SPADE);
        Card card2 = new Card(CardType.JACK, CardShape.SPADE);
        Card card3 = new Card(CardType.JACK, CardShape.SPADE);

        Card card4 = new Card(CardType.ONE, CardShape.SPADE);
        Card card5 = new Card(CardType.NINE, CardShape.SPADE);
        player1.putCard(card1);
        player1.putCard(card2);
        player1.putCard(card3);
        dealer.putCard(card3);
        GameResult isWin = GameResult.decidePlayerWin(player1, dealer);
        assertThat(isWin).isEqualTo(GameResult.LOSE);
    }


    @Test
    @DisplayName("플레이어와 딜러의 승패를 결정한다. -  딜러 버스트,플레이어 승")
    void decidePlayerWin4() {
        Card card1 = new Card(CardType.JACK, CardShape.SPADE);
        Card card2 = new Card(CardType.JACK, CardShape.SPADE);
        Card card3 = new Card(CardType.JACK, CardShape.SPADE);

        Card card4 = new Card(CardType.ONE, CardShape.SPADE);
        Card card5 = new Card(CardType.NINE, CardShape.SPADE);
        player1.putCard(card1);

        dealer.putCard(card1);
        dealer.putCard(card2);
        dealer.putCard(card3);
        GameResult isWin = GameResult.decidePlayerWin(player1, dealer);
        assertThat(isWin).isEqualTo(GameResult.WIN);
    }


    @Test
    @DisplayName("플레이어와 딜러의 승패를 결정한다. -  플레이어 버스트, 딜러 버스트, 딜러 승")
    void decidePlayerWin5() {
        Card card1 = new Card(CardType.JACK, CardShape.SPADE);
        Card card2 = new Card(CardType.JACK, CardShape.SPADE);
        Card card3 = new Card(CardType.JACK, CardShape.SPADE);

        Card card4 = new Card(CardType.ONE, CardShape.SPADE);
        Card card5 = new Card(CardType.NINE, CardShape.SPADE);
        player1.putCard(card1);
        player1.putCard(card2);
        player1.putCard(card3);
        dealer.putCard(card1);
        dealer.putCard(card2);
        dealer.putCard(card3);
        GameResult isWin = GameResult.decidePlayerWin(player1, dealer);
        assertThat(isWin).isEqualTo(GameResult.LOSE);
    }

    @Test
    @DisplayName("플레이어들과 딜러의 승패를 결정해 결과를 반환한다.")
    void testMethodNameHere() {
        // given
        Card card1 = new Card(CardType.JACK, CardShape.SPADE);
        Card card2 = new Card(CardType.JACK, CardShape.SPADE);
        Card card3 = new Card(CardType.JACK, CardShape.SPADE);
        Card card4 = new Card(CardType.ONE, CardShape.SPADE);
        Card card5 = new Card(CardType.NINE, CardShape.SPADE);
        player1.putCard(card1);
        player1.putCard(card2);
        player1.putCard(card3);
        player2.putCard(card4);
        player2.putCard(card4);
        player2.putCard(card5);
        dealer.putCard(card3);
        Map<Player, GameResult> playersResult = blackJackGame.resultOfPlayers();
        // when
        // then
        assertThat(playersResult.get(player1)).isEqualTo(GameResult.LOSE);
        assertThat(playersResult.get(player2)).isEqualTo(GameResult.WIN);
    }
}

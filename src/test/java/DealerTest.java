import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class DealerTest {

    @Test
    @DisplayName("딜러는 카드를 받을 수 있다.")
    void dealerTest() {
        // given
        Dealer dealer = new Dealer();
        Card card = new Card(CardType.TWO, CardShape.SPADE);
        dealer.putCard(card);
        // then
        assertThat(dealer.getReceivedCard().size()).isEqualTo(1);
    }

    @Test
    @DisplayName("딜러는 시작할 때 두 개의 카드를 받는다.")
    void dealerStartTest() {
        // given
        Dealer dealer = new Dealer();
        Card card1 = new Card(CardType.TWO, CardShape.SPADE);
        Card card2 = new Card(CardType.JACK, CardShape.SPADE);
        dealer.firstPutCard(card1, card2);
        // then
        assertThat(dealer.getReceivedCard().size()).isEqualTo(2);
    }

    @Test
    @DisplayName("딜러의 차례 때 딜러는 16이하면 카드를 더 받고 17이상이면 멈춘다.")
    void dealerStopTest() {
        // given
        Dealer dealer = new Dealer();
        Card card1 = new Card(CardType.TWO, CardShape.SPADE);
        Card card2 = new Card(CardType.TWO, CardShape.SPADE);
        Card card3 = new Card(CardType.THREE, CardShape.SPADE);
        Card card4 = new Card(CardType.TEN, CardShape.SPADE);

        Deck deck = new Deck(List.of(card1, card2, card3, card4));
        dealer.drawUntilLimit(deck);
        // then
        assertThat(dealer.getReceivedCard().calculatePoint()).isGreaterThan(16);

    }

    @Test
    @DisplayName("딜러는 버스트한다")
    void dealerBustTest() {
        // given
        Dealer dealer = new Dealer();
        Card card1 = new Card(CardType.TWO, CardShape.SPADE);
        Card card2 = new Card(CardType.JACK, CardShape.SPADE);
        Card card3 = new Card(CardType.JACK, CardShape.SPADE);
        dealer.putCard(card1);
        dealer.putCard(card2);
        dealer.putCard(card3);
        boolean isBust = dealer.isBust();

        // then
        assertThat(isBust).isTrue();

    }


}

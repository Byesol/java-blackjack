import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

public class ReceivedCardTest {

    @Test
    @DisplayName("덱으로부터 카드를 받아서 패에 추가한다.")
    void getCardFromDeck() {
        // given
        ReceivedCard receivedCard = new ReceivedCard();
        Card card = new Card(CardType.ONE, CardShape.SPADE);
        // when
        receivedCard.receiveCard(card);
        // then
        assertThat(receivedCard.size()).isEqualTo(1);
    }

    @Test
    @DisplayName("패의 점수를 계산한다.")
    void calculatePointTest() {

        // given
        Card card1 = new Card(CardType.ONE, CardShape.SPADE);
        Card card2 = new Card(CardType.ONE, CardShape.SPADE);
        Card card3 = new Card(CardType.NINE, CardShape.SPADE);
        ReceivedCard receivedCard = new ReceivedCard();
        receivedCard.receiveCard(card1);
        receivedCard.receiveCard(card2);
        receivedCard.receiveCard(card3);
        // when
        int point = receivedCard.calculatePoint();
        // then
        assertThat(point).isEqualTo(21);
    }

    @Nested
    @DisplayName("에이스 카드의 점수를 올바르게 계산한다")
    class acePointTest {
        @Test
        void countAcePointTest() {
            // given
            Card card1 = new Card(CardType.ONE, CardShape.SPADE);
            Card card2 = new Card(CardType.ONE, CardShape.SPADE);
            ReceivedCard receivedCard = new ReceivedCard();
            receivedCard.receiveCard(card1);
            receivedCard.receiveCard(card2);
            // when
            int point = receivedCard.calculatePoint();
            // then
            assertThat(point).isEqualTo(12);
        }

        @Test
        void countAcePointTest2() {
            // given
            Card card1 = new Card(CardType.ONE, CardShape.SPADE);
            Card card2 = new Card(CardType.TEN, CardShape.SPADE);
            ReceivedCard receivedCard = new ReceivedCard();
            receivedCard.receiveCard(card1);
            receivedCard.receiveCard(card2);
            // when
            int point = receivedCard.calculatePoint();
            // then
            assertThat(point).isEqualTo(21);
        }

    }

    @Test
    void countAcePointTest() {
        // given
        Card card1 = new Card(CardType.ONE, CardShape.SPADE);
        Card card2 = new Card(CardType.ONE, CardShape.SPADE);
        ReceivedCard receivedCard = new ReceivedCard();
        receivedCard.receiveCard(card1);
        receivedCard.receiveCard(card2);
        // when
        int point = receivedCard.calculatePoint();

        // then
        assertThat(point).isEqualTo(12);
    }

    @Test
    @DisplayName("카드가 버스트되는지 확인")
    void cardBustTest() {
        // given
        Card card1 = new Card(CardType.TWO, CardShape.SPADE);
        Card card2 = new Card(CardType.JACK, CardShape.SPADE);
        Card card3 = new Card(CardType.JACK, CardShape.SPADE);
        ReceivedCard receivedCard = new ReceivedCard();
        receivedCard.receiveCard(card1);
        receivedCard.receiveCard(card2);
        receivedCard.receiveCard(card3);
        boolean isBust = receivedCard.isBust();
        // when

        // then
        assertThat(isBust).isEqualTo(true);
    }
}

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class DeckTest {

    @Test
    @DisplayName("카드로 이루어진 덱이 있다. ")
    void deckTest() {
        // given
        Card card1 = new Card(CardType.ONE, CardShape.SPADE);
        Card card2 = new Card(CardType.ONE, CardShape.SPADE);
        Card card3 = new Card(CardType.ONE, CardShape.SPADE);
        Deck deck = new Deck(List.of(card1, card2, card3));
        // when

        // then
        assertThat(deck.size()).isEqualTo(3);
    }

    @Test
    @DisplayName("덱에서 카드를 드로우할 수 있다.")
    void drawCardTest() {
        Deck deck = DeckInitializer.generateDeck();
        Card card = deck.drawCard();
        assertThat(card).isNotNull();
    }

    @Test
    @DisplayName("덱에서 카드를 드로우하면 덱의 카드가 줄어든다.")
    void drawDeckTest() {
        Deck deck = DeckInitializer.generateDeck();
        Card card = deck.drawCard();
        assertThat(deck.size()).isEqualTo(51);
    }
}

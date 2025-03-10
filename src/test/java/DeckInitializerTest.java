import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class DeckInitializerTest {
    @Test
    @DisplayName("덱에는 52장의 카드가 있다.")
    void deckInitializerTest() {
        // given
        Deck deck = DeckInitializer.generateDeck();
        // then
        assertThat(deck.size()).isEqualTo(52);
    }

    @Test
    @DisplayName("덱은 생성되고 셔플된다.")
    void testMethodNameHere() {
        // given
        Deck deck1 = DeckInitializer.generateDeck();
        Deck deck2 = DeckInitializer.generateDeck();
        // then
        assertThat(deck1).isNotEqualTo(deck2);
    }
}

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class PlayerTest {

    @Test
    void playerTest() {
        // given when
        Player player = new Player("벡터");
        // then
        assertThat(player.getName()).isEqualTo("벡터");
    }

    @Test
    @DisplayName("이름 글자수 제한")
    void playerNameLengthTest() {
        // given
        String name1 = "벡";
        String name2 = "아아아아아아";
        // then
        assertThatThrownBy(() -> new Player(name1));
        assertThatThrownBy(() -> new Player(name2));
    }

    @Test
    @DisplayName("플레이어는 카드를 받을 수 있다.")
    void testMethodNameHere() {
        // given
        Player player = new Player("벡터");
        Card card = new Card(CardType.TWO, CardShape.SPADE);
        // when

        player.putCard(card);

        // then
        assertThat(player.getReceivedCard().size()).isEqualTo(1);
    }

    @Test
    void isBustTest() {
        // given
        Player player = new Player("벡터");
        Card card1 = new Card(CardType.JACK, CardShape.SPADE);
        Card card2 = new Card(CardType.JACK, CardShape.SPADE);
        Card card3 = new Card(CardType.JACK, CardShape.SPADE);
        // when

        player.putCard(card1);
        player.putCard(card2);
        player.putCard(card3);
        boolean isBust = player.isBust();

        // then
        assertThat(isBust).isTrue();
    }
}

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CardTest {

    @Test
    @DisplayName("카드에는 숫자가 있다")
    void cardNumberTest() {
        // given
        Card card = new Card(CardType.ONE, CardShape.HEART);
        //then
        assertThat(card.getNumber()).isEqualTo(CardType.ONE);
    }

    @Test
    @DisplayName("카드에는 문양이 있다")
    void cardShapeTest() {
        Card card = new Card(CardType.ONE, CardShape.CLOVER);

        // when
        CardShape cardShape = card.getShape();

        // then
        assertThat(cardShape).isEqualTo(CardShape.CLOVER);
    }

    @Test
    @DisplayName("카드 숫자에는 글자 카드가 존재한다")
    void SpecialNumberCardTest() {
        // given
        Card card = new Card(CardType.KING, CardShape.SPADE);
        CardType cardShape = card.getNumber();
        // when

        // then
        assertThat(cardShape).isEqualTo(CardType.KING);
    }


}

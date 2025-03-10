import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CardTest {

    @Test
    @DisplayName("카드에는 숫자가 있다")
    void cardNumberTest() {
        // given
        Card card = new Card(1, "CLOVER");
        //then
        assertThat(card.getNumber()).isEqualTo(1);
    }

    @Test
    @DisplayName("카드에는 문양이 있다")
    void cardShapeTest() {
        Card card = new Card(1, "CLOVER");

        // when
        String cardShape = card.getShape();

        // then
        assertThat(cardShape).isEqualTo("CLOVER");
    }

}

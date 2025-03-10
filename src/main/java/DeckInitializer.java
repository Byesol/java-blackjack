import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class DeckInitializer {

    public static Deck generateDeck() {

        List<Card> cards = Arrays.stream(CardType.values())
                .flatMap(cardType -> Arrays.stream(CardShape.values()).map(cardShape ->
                                new Card(cardType, cardShape)
                        )
                )
                .collect(Collectors.toList());
        Collections.shuffle(cards);

        return new Deck(cards);
    }
}

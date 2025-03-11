import java.util.HashMap;
import java.util.Map;

public class BlackJackGame {

    private Dealer dealer;
    private Players players;

    public BlackJackGame(Dealer dealer, Players players) {
        this.dealer = dealer;
        this.players = players;
    }

    public void setGame(Deck deck) {
        dealer.firstPutCard(deck.drawCard(), deck.drawCard());
        players.getPlayers()
                .forEach(player -> {
                    player.firstPutCard(deck.drawCard(), deck.drawCard());
                });

    }

    public void dealerTurn(Deck deck) {
        dealer.drawUntilLimit(deck);
    }


    public Map<Player, GameResult> resultOfPlayers() {
        Map<Player, GameResult> resultMap = new HashMap<>();
        players.getPlayers()
                .forEach(player -> {
                    GameResult gameResult = GameResult.decidePlayerWin(player, dealer);
                    resultMap.put(player, gameResult);
                });
        return resultMap;
    }
}

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

    public boolean decidePlayerWin(Player player, Dealer dealer) {
        int playerPoint = player.getReceivedCard().calculatePoint();
        int dealerPoint = dealer.getReceivedCard().calculatePoint();
        if (player.isBust()) {
            return false;
        }
        if (dealer.isBust()) {
            return true;
        }
        if (playerPoint > dealerPoint) {
            return true;
        }
        return false;


    }
}

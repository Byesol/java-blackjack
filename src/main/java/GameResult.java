public enum GameResult {
    WIN,
    LOSE,
    DRAW,
    BLACKJACK;

    public static GameResult decidePlayerWin(Player player, Dealer dealer) {
        int playerPoint = player.getReceivedCard().calculatePoint();
        int dealerPoint = dealer.getReceivedCard().calculatePoint();
        if (player.isBust()) {
            return GameResult.LOSE;
        }
        if (dealer.isBust()) {
            return GameResult.WIN;
        }
        if (playerPoint > dealerPoint) {
            return GameResult.WIN;
        }
        if (playerPoint < dealerPoint) {
            return GameResult.LOSE;
        }
        return GameResult.DRAW;


    }


}

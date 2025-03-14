import java.util.stream.Collectors;

public class OutputView {

    public void outputFirstTurn(Dealer dealer, Players players) {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("딜러와 %s에게 2장을 나누었습니다.\n",
                players.getPlayers().stream()
                        .map(Player::getName)
                        .collect(Collectors.joining(","))));
    }

    public void dealerCardResult(Dealer dealer) {
        System.out.println(String.format("딜러 : %s",
                dealer.getReceivedCard().getListReceiveCard().stream()
                        .map(c->c.getType().getCardType() +c.getShape().getCardShape())
                        .collect(Collectors.joining())
                ));
    }

//        ```angular2html
//        딜러와 pobi, jason에게 2장을 나누었습니다.
//        딜러카드: 3다이아몬드
//        pobi카드: 2하트, 8스페이드
//        jason카드: 7클로버, K스페이드
//```
    }
}

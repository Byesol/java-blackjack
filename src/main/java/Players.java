import java.util.List;
import java.util.stream.Collectors;

public class Players {
    private final List<Player> players;

    // 기존 Player 리스트를 받는 생성자
    public Players(List<Player> players) {
        this.players = players;
    }

    // 정적 팩토리 메서드 추가
    public static Players from(List<String> strings) {
        return new Players(strings.stream()
                .map(Player::new)
                .collect(Collectors.toList()));
    }

    public List<Player> getPlayers() {
        return players;
    }
}

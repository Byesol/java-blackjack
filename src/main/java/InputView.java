import java.util.List;
import java.util.Scanner;

public class InputView {

    private static Scanner SCANNER = new Scanner(System.in);

    public List<String> inputPlayers() {
        System.out.println(String.format("플레이어 입력해라"));
        String input = SCANNER.nextLine();


    }
}

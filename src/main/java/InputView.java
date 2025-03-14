import java.util.Scanner;

public class InputView {

    private static Scanner SCANNER = new Scanner(System.in);

    public String inputPlayers() {
        System.out.println(String.format("플레이어 입력해라"));
        return SCANNER.nextLine();
    }
}

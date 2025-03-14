public class BlackJackController {

    private final OutputView outputView;
    private final InputView inputView;


    public BlackJackController(OutputView outputView, InputView inputView) {
        this.outputView = outputView;
        this.inputView = inputView;
    }

    public void run() {
        String input =   inputView.inputPlayers();
        Dealer dealer = new Dealer();
        BlackJackGame blackJackGame = new BlackJackGame()
    }

}

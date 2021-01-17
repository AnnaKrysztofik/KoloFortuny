import main.GameManager;
import main.models.Player;
import main.providers.PhraseProvider;
import main.ui.UIInterface;
import main.ui.UserInterface;
import main.wheelManager.WheelManager;
import main.wheelOfFortunePuzzleBoard.WheelOfFortunePuzzleBoard;

public class Main {
    public static void main(String[] args) {

        PhraseProvider phraseProvider = new PhraseProvider();
        UIInterface ui = new UserInterface();
        WheelOfFortunePuzzleBoard wheelOfFortunePuzzleBoard = new WheelOfFortunePuzzleBoard(phraseProvider);
        WheelManager wheelManager = new WheelManager();

        Player gracz1 = new Player("Kasia", 0);
        Player gracz2 = new Player("Basia", 0);

        GameManager gameManager = new GameManager(ui, wheelOfFortunePuzzleBoard, wheelManager, gracz1, gracz2);

        gameManager.courseOfTheGame();
    }
}





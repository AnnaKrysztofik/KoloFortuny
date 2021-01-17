package test;

import main.GameManager;
import main.models.Player;
import main.models.WheelModel;
import main.providers.PhraseProvider;
import main.providers.PhraseProviderFake;
import main.ui.UIInterface;
import main.ui.UserInterfaceFake;
import main.wheelManager.WheelManagerFake;
import main.wheelManager.WheelManagerInterface;
import main.wheelOfFortunePuzzleBoard.WheelOfFortunePuzzleBoard;
import main.wheelOfFortunePuzzleBoard.WheelOfFortunePuzzleBoardInterface;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class GameManagerTest {

    UIInterface ui = new UserInterfaceFake();
    Player current = new Player("Ania",0);
    PhraseProvider phraseProvider = new PhraseProviderFake();
    WheelOfFortunePuzzleBoardInterface phrase = new WheelOfFortunePuzzleBoard(phraseProvider);
    WheelManagerInterface wheelManager = new WheelManagerFake();

    @Test
    public void countPointsForLetterL(){
        // Arrange
        var letter = "L";
        var chose = new WheelModel(false, false, 1000,"");
        GameManager gameManager = new GameManager(ui, phrase, wheelManager, current, new Player(), phraseProvider, current);

        // Act
        gameManager.contestant(letter, chose);
        // Assert
        assertEquals(1000,current.getPoints());
    }
    @Test
    public void countPointsForLetterA(){
        // Arrange
        var letter = "A";
        var chose = new WheelModel(false, false, 100,"");
        GameManager gameManager = new GameManager(ui, phrase, wheelManager, current, new Player(), phraseProvider, current);

        // Act
        gameManager.contestant(letter, chose);
        // Assert
        assertEquals(400,current.getPoints());
    }
    @Test
    public void countPointsForBankrupt(){
        // Arrange
        var letter = "L";
        var chose = new WheelModel(true, false, 0,"");
        GameManager gameManager = new GameManager(ui, phrase, wheelManager, current, new Player(), phraseProvider, current);

        // Act
        gameManager.contestant(letter, chose);
        // Assert
        assertEquals(0,current.getPoints());
    }
    @Test
    public void countPointsForStop(){
        // Arrange
        var letter = "L";
        var chose = new WheelModel(true, false, 0,"");
        Player player = new Player("Kasia", 400);
        GameManager gameManager = new GameManager(ui, phrase, wheelManager, player, new Player(), phraseProvider, player);

        // Act
        gameManager.contestant(letter, chose);
        // Assert
        assertEquals(400,player.getPoints());
    }


}
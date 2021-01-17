package test;

import main.GameManager;
import main.wheelManager.WheelManagerFake;
import main.wheelManager.WheelManagerInterface;
import main.models.WheelModel;
import main.models.Player;
import org.junit.Assert;
import org.junit.Test;
import main.wheelOfFortunePuzzleBoard.WheelOfFortunePuzzleBoard;
import main.wheelOfFortunePuzzleBoard.WheelOfFortunePuzzleBoardInterface;
import main.providers.PhraseProvider;
import main.providers.PhraseProviderFake;
import main.ui.UIInterface;
import main.ui.UserInterfaceFake;

import java.util.List;

import static org.junit.Assert.*;

public class GameManagerTest {

    @Test
    public void player1IsCurrentAtTheBeginning_Test()
    {
        // Arrange
        UIInterface ui = new UserInterfaceFake();
        WheelManagerInterface wheelManager = new WheelManagerFake();
        WheelOfFortunePuzzleBoardInterface gameBoard = new WheelOfFortunePuzzleBoard(new PhraseProvider());
        Player player1 = new Player("Ania", 0);
        Player player2 = new Player("Jacek", 0);

        // Act
        GameManager gameManager = new GameManager(ui, gameBoard, wheelManager, player1, player2);

        // Assert
        Assert.assertEquals(player1, gameManager.getCurrent());
    }

    @Test
    public void stopScenario_Test()
    {
        // Arrange
        PhraseProvider phraseProvider = new PhraseProviderFake();
        UserInterfaceFake ui = new UserInterfaceFake();
        WheelManagerFake wheelManagerFake = new WheelManagerFake();
        WheelOfFortunePuzzleBoard wheelOfFortunePuzzleBoard = new WheelOfFortunePuzzleBoard(phraseProvider);
        Player player1 = new Player("Ania", 100);
        Player player2 = new Player("Jacek", 0);

        ui.setWheelOrGuess(List.of(1, 2));
        ui.setPhrase("ALA MA KOTA");
        wheelManagerFake.setWheelModel(List.of(
                new WheelModel(true, false, 0,"BANKRUT")));

        GameManager gameManager = new GameManager(ui, wheelOfFortunePuzzleBoard, wheelManagerFake, player1, player2);

        // Act
        gameManager.courseOfTheGame();

        // Assert
        assertEquals(player2, gameManager.getCurrent());
        assertEquals(0, player1.getPoints());


    }

    @Test
    public void vowelScenario_Test()
    {
        // Arrange
        var phraseProvider2 = new PhraseProviderFake();
        UserInterfaceFake ui2 = new UserInterfaceFake();
        WheelManagerFake koloManager2 = new WheelManagerFake();
        WheelOfFortunePuzzleBoard wheelOfFortunePuzzleBoard2 = new WheelOfFortunePuzzleBoard(phraseProvider2);
        Player player3 = new Player("Ania", 0);
        Player player4 = new Player("Jacek", 0);

        ui2.setWheelOrGuess(List.of(1, 1, 2));
        ui2.setLetters(List.of("L","A"));
        ui2.setPhrase("ALA MA KOTA");

        koloManager2.setWheelModel(List.of(
                new WheelModel(false, false, 1000,""),
                new WheelModel(false, false, 1000,"")));

        GameManager gameManager2 = new GameManager(ui2, wheelOfFortunePuzzleBoard2, koloManager2, player3, player4);

        // Act
        gameManager2.courseOfTheGame();

        // Assert
        assertEquals(player3, gameManager2.getCurrent());
        assertEquals(800, player3.getPoints());
    }

}
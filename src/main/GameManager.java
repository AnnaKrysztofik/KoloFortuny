package main;

import main.models.Player;
import main.models.WheelModel;
import main.providers.PhraseProvider;
import main.ui.UIInterface;
import main.ui.UserInterface;
import main.wheelManager.WheelManager;
import main.wheelManager.WheelManagerInterface;
import main.wheelOfFortunePuzzleBoard.WheelOfFortunePuzzleBoard;
import main.wheelOfFortunePuzzleBoard.WheelOfFortunePuzzleBoardInterface;

public class GameManager {

    private UIInterface ui;
    private WheelOfFortunePuzzleBoardInterface phrase;
    private WheelManagerInterface wheel;
    private Player player1;
    private Player player2;
    private PhraseProvider phraseProvider;
    private Player current;

    public GameManager(UIInterface ui, WheelOfFortunePuzzleBoardInterface phrase, WheelManagerInterface wheel, Player player1, Player player2, PhraseProvider phraseProvider, Player current) {
        this.ui = ui;
        this.phrase = phrase;
        this.wheel = wheel;
        this.player1 = player1;
        this.player2 = player2;
        this.phraseProvider = phraseProvider;
        this.current = current;
    }

    public GameManager() {
        player1 = new Player();
        player2 = new Player();

        this.phraseProvider = new PhraseProvider();
        this.phrase = new WheelOfFortunePuzzleBoard(phraseProvider);
        this.wheel = new WheelManager();
        this.ui = new UserInterface();
     }



    private void nextPlayer()
    {
        if (current == player1)
            current = player2;
        else current = player1;
    }

    public void courseOfTheGame()
    {
        ui.displayTheSplashScreen();
        ui.yoursName(player1, player2);
        current = player1;

        ui.displayGameBoard(phrase.buildViewModel());
        boolean isGameEnd = false;
        do {
            ui.displayThePlayer(current.buildViewModel());
            int spinOrGuess = ui.chooseWheelOrGuess();
            switch (spinOrGuess) {

                case UserInterface.WYBOR_KRECE_KOLEM:
                    spinning();
                    break;

                case UserInterface.WYBOR_ZGADUJE:
                    isGameEnd = guessPhrase();
                    break;
            }
        } while (!isGameEnd);
    }

    private void spinning()
    {
        WheelModel chose = wheel.spinTheWheelOfFortune();

        if (chose.getIsStop()) {
            stop();
            return;
        }

        if (chose.getIsBankrupt()) {
            bankrupt();
            return;
        }

        wheelService(chose);
    }

    private boolean guessPhrase()
    {
        String guessed = ui.guessThePhrase();

        if (phrase.guessPhrase(guessed.toUpperCase())) {
            endOfFirstRound();
            return true;
        }
        nextPlayer();
        return false;
    }

    public void endOfFirstRound()
    {
        TheBestResult.checkAndSave(player1);
        TheBestResult.checkAndSave(player2);

        ui.endOfFirstRound(player1, player2);
        ui.displayRecord(TheBestResult.readResult());

    }

    private void stop()
    {
        ui.displayStatement(Dictionary.TRACISZ_RUCH_MSG);
        nextPlayer();
    }

    private void bankrupt()
    {
        ui.displayStatement(Dictionary.TRACISZ_PUNKTY_MSG);
        current.setPoints(0);
        ui.displayPoints(current.buildViewModel());
        nextPlayer();
    }
    private void wheelService(WheelModel chose)
    {
        ui.displayWheelElement(chose.buildViewModel());
        ui.displayStatement(Dictionary.PODAJ_LITERE_MSG);
        String letter = ui.getTheLetter();

        if (phrase.checkVowel(letter))
        {
            buyVowel(letter);
        }
        else {

            contestant(letter, chose);
        }
    }

    private void buyVowel(String letter)
    {
        if (current.getPoints() < 200)
        {
            ui.displayStatement(Dictionary.NIE_MASZ_PUNKTOW_MSG);
            nextPlayer();
        }
        if (current.getPoints() >= 200)
        {
            if (phrase.insert(letter))
            {
                phrase.addToList(letter);
                ui.displayGameBoard(phrase.buildViewModel());
                current.addPoints(-200);
                ui.displayPoints(current.buildViewModel());
                if (phrase.win()) endOfFirstRound();
            }
            else nextPlayer();
        }
    }

    public void  contestant(String letter, WheelModel chose)
    {
        if (phrase.insert(letter))
        {
            phrase.addToList(letter);
            ui.displayGameBoard(phrase.buildViewModel());
            current.addPoints(phrase.howManyTimes(letter) * chose.getValue());
            ui.displayPoints(current.buildViewModel());

            if (phrase.win())
                endOfFirstRound();
        }
        else nextPlayer();
    }

    public Player getCurrent() {
        return current;
    }


}




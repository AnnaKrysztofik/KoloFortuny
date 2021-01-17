package main.ui;

import main.models.Player;
import main.viewModels.WheelElementViewModel;
import main.viewModels.PasswordViewModel;
import main.viewModels.UserViewModel;

public interface UIInterface {

    void displayTheSplashScreen();
    String getTheLetter();
    void displayGameBoard(PasswordViewModel viewModel);
    void displayWheelElement(WheelElementViewModel viewModel);
    void displayStatement(String message);
    void displayThePlayer(UserViewModel viewModel);
    void displayPoints(UserViewModel viewModel);
    int chooseWheelOrGuess();
    String guessThePhrase();
    void endOfFirstRound(Player player1, Player player2);
    void displayRecord(Player najlepszyPlayer);
    void yoursName(Player player1, Player player2);
    void name(String which, Player player);
}

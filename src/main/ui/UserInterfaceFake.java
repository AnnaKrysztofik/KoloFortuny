package main.ui;

import main.models.Player;
import main.viewModels.WheelElementViewModel;
import main.viewModels.PasswordViewModel;
import main.viewModels.UserViewModel;

import java.util.List;
import java.util.Scanner;

public class UserInterfaceFake implements UIInterface {

    private List<Integer> wheelOrGuess;
    private Integer idx;

    private List<String> letters;
    private Integer idxLetters;

    private String phrase;

    @Override
    public int chooseWheelOrGuess() {

        return wheelOrGuess.get(idx++);
    }

    @Override
    public String guessThePhrase() {
        return phrase;
    }

    @Override
    public void displayTheSplashScreen() {

    }

    @Override
    public String getTheLetter() {
        return letters.get(idxLetters++);
    }

    @Override
    public void displayGameBoard(PasswordViewModel viewModel) {

    }

    @Override
    public void displayWheelElement(WheelElementViewModel viewModel) {

    }

    @Override
    public void displayStatement(String statement) {

    }

    @Override
    public void displayThePlayer(UserViewModel viewModel) {

    }

    @Override
    public void displayPoints(UserViewModel viewModel) {

    }

    @Override
    public void endOfFirstRound(Player player1, Player player2) {

    }

    @Override
    public void displayRecord(Player theBestPlayer) {

    }

    public void setWheelOrGuess(List<Integer> wheelOrGuess) {
        this.wheelOrGuess = wheelOrGuess;
        this.idx = 0;
    }

    public void setPhrase(String phrase) {
        this.phrase = phrase;
    }

    public void setLetters(List<String> letters) {
        this.letters = letters;
        this.idxLetters = 0;
    }

    @Override
    public void yoursName(Player player1, Player player2){
        name("pierwszego", player1);
        name("drugiego", player2);
    }


    @Override
    public void name(String which, Player player){
        System.out.println("Podaj imię " + which + " gracza:");
        Scanner scanner = new Scanner(System.in);
        player.setName(scanner.next());
    }
}

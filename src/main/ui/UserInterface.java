package main.ui;

import main.models.Player;
import main.viewModels.WheelElementViewModel;
import main.viewModels.PasswordViewModel;
import main.viewModels.UserViewModel;

import java.util.Scanner;
import java.util.stream.IntStream;


public class UserInterface implements UIInterface {

    public static final int WYBOR_KRECE_KOLEM = 1;
    public static final int WYBOR_ZGADUJE = 2;

    @Override
    public void displayTheSplashScreen() {
        System.out.println("___ KOLO FORTUNY ___");
    }

    @Override
    public String getTheLetter() {
        return new Scanner(System.in).next().toUpperCase();
    }

    @Override
    public void displayGameBoard(PasswordViewModel viewModel) {
        StringBuilder stringBuilder = new StringBuilder();

        IntStream.range(0, viewModel.getPhrase().length())
                .mapToObj(i -> viewModel.getPhrase().substring(i, i + 1))
                .forEach(c -> {
                    if (c.equals(" ")) stringBuilder.append("   ");
                    else stringBuilder.append("┌").append("─").append("┐");
                });

        stringBuilder.append("\n\r");

        IntStream.range(0, viewModel.getPhrase().length())
                .mapToObj(i -> viewModel.getPhrase().substring(i, i + 1))
                .forEach(c -> {
                    if (c.equals(" ")) stringBuilder.append("   ");
                    else stringBuilder.append("│").append(c).append("│");
                });

        stringBuilder.append("\n\r");

        IntStream.range(0, viewModel.getPhrase().length())
                .mapToObj(i -> viewModel.getPhrase().substring(i, i + 1))
                .forEach(c -> {
                    if (c.equals(" ")) stringBuilder.append("   ");
                    else stringBuilder.append("└").append("─").append("┘");
                });

        System.out.println("KATEGORIA: " + viewModel.getCategory());
        System.out.println(stringBuilder.toString());
    }

    @Override
    public void displayWheelElement(WheelElementViewModel viewModel) {
        System.out.println("Wylosowałeś " + viewModel.getScreenValue());
    }

    @Override
    public void displayStatement(String statement) {
        System.out.println(statement);
    }

    @Override
    public void displayThePlayer(UserViewModel viewModel) {
        System.out.println("Ruch gracza     ______ " + viewModel.getUserName() + " ______");
        System.out.println("Stan konta: " + viewModel.getPoints());
    }

    @Override
    public void displayPoints(UserViewModel viewModel) {
        System.out.println("Stan konta: " + viewModel.getPoints());
    }

    @Override
    public int chooseWheelOrGuess() {
        System.out.println("ZAKRĘĆ KOŁEM (1)         lub            ODGADNIJ HASŁO  (2)");
        return new Scanner(System.in).nextInt();
    }

    @Override
    public String guessThePhrase() {
        System.out.println("Odgadnij hasło: ");
        return new Scanner(System.in).nextLine();
    }

    @Override
    public void endOfFirstRound(Player player1, Player player2) {
        System.out.println("Koniec pierwszej rundy ");
        System.out.println("Stan konta gracza " + player1.getName() + " : " + player1.getPoints());
        System.out.println("Stan konta gracza " + player2.getName() + " : " + player2.getPoints());
    }

    @Override
    public void displayRecord(Player theBestPlayer) {
        System.out.println("Rekord: " + theBestPlayer.getPoints() + "    " + theBestPlayer.getName());
    }
}

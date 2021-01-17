package main.wheelOfFortunePuzzleBoard;

import main.viewModels.PasswordViewModel;

public interface WheelOfFortunePuzzleBoardInterface {

    int howManyTimes(String letter);
    boolean insert(String letter);
    boolean win();
    void addToList(String letter);
    boolean guessPhrase(String guessPhrase);
    boolean checkVowel(String letter);
    void setPhrase(String phrase);
    PasswordViewModel buildViewModel();
}

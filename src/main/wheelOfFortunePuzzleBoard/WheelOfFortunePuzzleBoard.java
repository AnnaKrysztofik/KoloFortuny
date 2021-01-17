package main.wheelOfFortunePuzzleBoard;

import main.models.PhraseModel;
import main.providers.PhraseProvider;
import main.viewModels.PasswordViewModel;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class WheelOfFortunePuzzleBoard implements WheelOfFortunePuzzleBoardInterface {

    private String phrase;
    private String category;
    List<String> guessedLetters;
    private PhraseProvider phraseProvider;
    private  static final List<String> vowels = List.of("A", "E", "O", "Y", "I", "U");;

    public WheelOfFortunePuzzleBoard(PhraseProvider phraseProvider) {
        this.phraseProvider = phraseProvider;
        PhraseModel phraseModel = phraseProvider.generatePhrase();
        this.phrase = phraseModel.getPhrase();
        this.category = phraseModel.getCategory();
        guessedLetters = new ArrayList<>();
    }

    @Override
    public int howManyTimes(String letter) {

        if (this.phrase == null || letter.equals(" "))
            return 0;

        return (int) IntStream.range(0, phrase.length())
                .mapToObj(i -> phrase.substring(i, i + 1))
                .filter(i -> i.equals(letter))
                .count();
    }

    @Override
    public boolean insert(String letter) {
        if (phrase.contains(letter) && !guessedLetters.contains(letter)) return true;
        else return false;
    }

    @Override
    public boolean win(){
      return  IntStream.range(0, phrase.length())
                .mapToObj(i -> phrase.substring(i, i + 1))
              .filter(i->!i.equals(" "))
                .allMatch(i->guessedLetters.contains(i));
    }

     @Override
     public void addToList(String letter){
         guessedLetters.add(letter);
    }

    @Override
    public boolean guessPhrase(String guessPhrase)
    {
        if (phrase.equals(guessPhrase.toUpperCase())) return true;
        else return false;
    }

    @Override
    public boolean checkVowel(String letter){
        return vowels.contains(letter.toUpperCase());
    }

    @Override
    public void setPhrase(String phrase) {
        this.phrase = phrase;
    }

    @Override
    public PasswordViewModel buildViewModel()
    {
        StringBuilder stringBuilder = new StringBuilder();

        IntStream.range(0, phrase.length())
                .mapToObj(i -> phrase.substring(i, i + 1))
                .forEach(c -> {
                    if (guessedLetters.contains(c)) stringBuilder.append(c);
                    else if (c.equals(" ")) stringBuilder.append(" ");
                    else stringBuilder.append("_");
                });

        return new PasswordViewModel(stringBuilder.toString(), this.category);
    }
   }


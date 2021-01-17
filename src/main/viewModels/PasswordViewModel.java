package main.viewModels;

/*
    Opisuje plansze z haslem i kategoria
 */
public class PasswordViewModel {

    //Haslo w postaci np. A_A _A ___A
    private String phrase;
    private String category;

    public PasswordViewModel(String phrase, String category) {
        this.phrase = phrase;
        this.category = category;
    }

    public String getPhrase() {
        return phrase;
    }

    public String getCategory() {
        return category;
    }
}

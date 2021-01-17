package main.models;

public class PhraseModel {
    private String phrase;
    private String category;

    public PhraseModel(String category, String phrase){
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

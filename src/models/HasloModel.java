package models;

public class HasloModel {
    private String haslo;
    private String kategoria;

    public HasloModel(String kategoria, String haslo){
        this.haslo = haslo;
        this.kategoria = kategoria;

    }


    public String getHaslo() {
        return haslo;
    }

    public String getKategoria() {
        return kategoria;
    }
}

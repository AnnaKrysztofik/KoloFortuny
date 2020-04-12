package ui;

import models.Gracz;
import viewModels.ElementKolaViewModel;
import viewModels.HasloViewModel;
import viewModels.UserViewModel;

import java.util.List;

public class UserInterfaceFake implements UIInterface {

    private List<Integer> zakrecZgaduj;
    private Integer idx;

    private List<String> literki;
    private Integer idxLiterki;

    private String haslo;

    @Override
    public int pobierzZakrecZgaduj() {

        return zakrecZgaduj.get(idx++);
    }

    @Override
    public String pobierzOdgadnijHaslo() {
        return haslo;
    }

    @Override
    public void wyswietlEkranPowitalny() {

    }

    @Override
    public String pobierzLiterke() {
        return literki.get(idxLiterki++);
    }

    @Override
    public void wyswietlPlansze(HasloViewModel viewModel) {

    }

    @Override
    public void wyswietlElementKola(ElementKolaViewModel viewModel) {

    }

    @Override
    public void wyswietlKomunikat(String komunikat) {

    }

    @Override
    public void wyswietlGracza(UserViewModel viewModel) {

    }

    @Override
    public void wyswietlStanKontaGracza(UserViewModel viewModel) {

    }

    @Override
    public void wyswietlKoniecPierwszejRundy(Gracz gracz1, Gracz gracz2) {

    }

    @Override
    public void wyswietlRekord(Gracz najlepszyGracz) {

    }

    public void setZakrecZgaduj(List<Integer> zakrecZgaduj) {
        this.zakrecZgaduj = zakrecZgaduj;
        this.idx = 0;
    }

    public void setHaslo(String haslo) {
        this.haslo = haslo;
    }

    public void setLiterki(List<String> literki) {
        this.literki = literki;
        this.idxLiterki = 0;
    }
}

package ui;

import models.Gracz;
import viewModels.ElementKolaViewModel;
import viewModels.HasloViewModel;
import viewModels.UserViewModel;

public interface UIInterface {

    void wyswietlEkranPowitalny();
    String pobierzLiterke();
    void wyswietlPlansze(HasloViewModel viewModel);
    void wyswietlElementKola(ElementKolaViewModel viewModel);
    void wyswietlKomunikat(String komunikat);
    void wyswietlGracza(UserViewModel viewModel);
    void wyswietlStanKontaGracza(UserViewModel viewModel);
    int pobierzZakrecZgaduj();
    String pobierzOdgadnijHaslo();
    void wyswietlKoniecPierwszejRundy(Gracz gracz1, Gracz gracz2);
    void wyswietlRekord(Gracz najlepszyGracz);
}

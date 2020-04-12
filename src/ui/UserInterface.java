package ui;

import models.Gracz;
import viewModels.ElementKolaViewModel;
import viewModels.HasloViewModel;
import viewModels.UserViewModel;

import java.util.Scanner;
import java.util.stream.IntStream;


public class UserInterface implements UIInterface {

    public static final int WYBOR_KRECE_KOLEM = 1;
    public static final int WYBOR_ZGADUJE = 2;

    @Override
    public void wyswietlEkranPowitalny() {
        System.out.println("___ KOLO FORTUNY ___");
    }

    @Override
    public String pobierzLiterke() {
        return new Scanner(System.in).next().toUpperCase();
    }

    @Override
    public void wyswietlPlansze(HasloViewModel viewModel) {
        StringBuilder stringBuilder = new StringBuilder();

        IntStream.range(0, viewModel.getHaslo().length())
                .mapToObj(i -> viewModel.getHaslo().substring(i, i + 1))
                .forEach(c -> {
                    if (c.equals(" ")) stringBuilder.append("   ");
                    else stringBuilder.append("┌").append("─").append("┐");
                });

        stringBuilder.append("\n\r");

        IntStream.range(0, viewModel.getHaslo().length())
                .mapToObj(i -> viewModel.getHaslo().substring(i, i + 1))
                .forEach(c -> {
                    if (c.equals(" ")) stringBuilder.append("   ");
                    else stringBuilder.append("│").append(c).append("│");
                });

        stringBuilder.append("\n\r");

        IntStream.range(0, viewModel.getHaslo().length())
                .mapToObj(i -> viewModel.getHaslo().substring(i, i + 1))
                .forEach(c -> {
                    if (c.equals(" ")) stringBuilder.append("   ");
                    else stringBuilder.append("└").append("─").append("┘");
                });

        System.out.println("KATEGORIA: " + viewModel.getKategoria());
        System.out.println(stringBuilder.toString());
    }

    @Override
    public void wyswietlElementKola(ElementKolaViewModel viewModel) {
        System.out.println("Wylosowałeś " + viewModel.getScreenValue());
    }

    @Override
    public void wyswietlKomunikat(String komunikat) {
        System.out.println(komunikat);
    }

    @Override
    public void wyswietlGracza(UserViewModel viewModel) {
        System.out.println("Ruch gracza     ______ " + viewModel.getUserName() + " ______");
        System.out.println("Stan konta: " + viewModel.getStanKonta());
    }

    @Override
    public void wyswietlStanKontaGracza(UserViewModel viewModel) {
        System.out.println("Stan konta: " + viewModel.getStanKonta());
    }

    @Override
    public int pobierzZakrecZgaduj() {
        System.out.println("ZAKRĘĆ KOŁEM (1)         lub            ODGADNIJ HASŁO  (2)");
        return new Scanner(System.in).nextInt();
    }

    @Override
    public String pobierzOdgadnijHaslo() {
        System.out.println("Odgadnij hasło: ");
        return new Scanner(System.in).nextLine();
    }

    @Override
    public void wyswietlKoniecPierwszejRundy(Gracz gracz1, Gracz gracz2) {
        System.out.println("Koniec pierwszej rundy ");
        System.out.println("Stan konta gracza " + gracz1.getImie() + " : " + gracz1.getstanKonta());
        System.out.println("Stan konta gracza " + gracz2.getImie() + " : " + gracz2.getstanKonta());
    }

    @Override
    public void wyswietlRekord(Gracz najlepszyGracz) {
        System.out.println("Rekord: " + najlepszyGracz.getstanKonta() + "    " + najlepszyGracz.getImie());
    }
}

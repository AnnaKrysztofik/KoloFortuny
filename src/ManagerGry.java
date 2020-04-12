import kolomanager.KoloManagerInterface;
import models.ElementKolaModel;
import models.Gracz;
import planszahaslo.PlanszaHasloInterface;
import ui.UIInterface;
import ui.UserInterface;

public class ManagerGry {

    private UIInterface ui;
    private PlanszaHasloInterface haslo;
    private KoloManagerInterface kolo;
    private Gracz gracz1;
    private Gracz gracz2;

    private Gracz current;

    public ManagerGry(UIInterface ui, PlanszaHasloInterface planszaHaslo, KoloManagerInterface koloManager, Gracz gracz1, Gracz gracz2)
    {
        this.haslo = planszaHaslo;
        this.kolo = koloManager;
        this.gracz1 = gracz1;
        this.gracz2 = gracz2;
        this.current = gracz1;
        this.ui = ui;
     }

    private void nextPlayer()
    {
        if (current == gracz1)
            current = gracz2;
        else current = gracz1;
    }

    public void przebiegGry()
    {
        ui.wyswietlEkranPowitalny();
        ui.wyswietlPlansze(haslo.buildViewModel());
        boolean isGameEnd = false;
        do {
            ui.wyswietlGracza(current.buildViewModel());
            int zakrecZgaduj = ui.pobierzZakrecZgaduj();
            switch (zakrecZgaduj) {

                case UserInterface.WYBOR_KRECE_KOLEM:
                    krecenieKolem();
                    break;

                case UserInterface.WYBOR_ZGADUJE:
                    isGameEnd = zgadujeHaslo();
                    break;
            }
        } while (!isGameEnd);
    }

    private void krecenieKolem()
    {
        ElementKolaModel wybor = kolo.zakrecKolem();

        if (wybor.getIsStop()) {
            obslugaStop();
            return;
        }

        if (wybor.getIsBankrut()) {
            obslugaBankrut();
            return;
        }

        obslugaWartosciKola(wybor);
    }

    private boolean zgadujeHaslo()
    {
        String odganiete = ui.pobierzOdgadnijHaslo();

        if (haslo.wygranaOdgadnijHaslo(odganiete.toUpperCase())) {
            koniecPierwszejRundy();
            return true;
        }
        nextPlayer();
        return false;
    }

    public void koniecPierwszejRundy()
    {
        NajlepszyWynik.checkAndSave(gracz1);
        NajlepszyWynik.checkAndSave(gracz2);

        ui.wyswietlKoniecPierwszejRundy(gracz1, gracz2);
        ui.wyswietlRekord(NajlepszyWynik.odczytajWynik());

    }

    private void obslugaStop()
    {
        ui.wyswietlKomunikat(Dictionary.TRACISZ_RUCH_MSG);
        nextPlayer();
    }

    private void obslugaBankrut()
    {
        ui.wyswietlKomunikat(Dictionary.TRACISZ_PUNKTY_MSG);
        current.setstanKonta(0);
        ui.wyswietlStanKontaGracza(current.buildViewModel());
        nextPlayer();
    }
    private void obslugaWartosciKola(ElementKolaModel wybor)
    {
        ui.wyswietlElementKola(wybor.buildViewModel());
        ui.wyswietlKomunikat(Dictionary.PODAJ_LITERE_MSG);
        String literka = ui.pobierzLiterke();

        if (haslo.czySamogoska(literka))
        {
            wykupienieSamogloski(literka);
        }
        else {

            podanieSpolgloski(literka, wybor);
        }
    }

    private void wykupienieSamogloski(String literka)
    {
        if (current.getstanKonta() < 200)
        {
            ui.wyswietlKomunikat(Dictionary.NIE_MASZ_PUNKTOW_MSG);
            nextPlayer();
        }
        if (current.getstanKonta() >= 200)
        {
            if (haslo.czyWstaw(literka))
            {
                haslo.dodajDoListy(literka);
                ui.wyswietlPlansze(haslo.buildViewModel());
                current.dodajstanKonta(-200);
                ui.wyswietlStanKontaGracza(current.buildViewModel());
                if (haslo.wygrana()) koniecPierwszejRundy();
            }
            else nextPlayer();
        }
    }

    public void podanieSpolgloski(String literka, ElementKolaModel wybor)
    {
        if (haslo.czyWstaw(literka))
        {
            haslo.dodajDoListy(literka);
            ui.wyswietlPlansze(haslo.buildViewModel());
            current.dodajstanKonta(haslo.ileRazy(literka) * wybor.getValue());
            ui.wyswietlStanKontaGracza(current.buildViewModel());

            if (haslo.wygrana())
                koniecPierwszejRundy();
        }
        else nextPlayer();
    }

    public Gracz getCurrent() {
        return current;
    }
}




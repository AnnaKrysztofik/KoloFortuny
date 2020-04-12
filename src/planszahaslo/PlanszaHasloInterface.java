package planszahaslo;

import viewModels.HasloViewModel;

public interface PlanszaHasloInterface {

    int ileRazy(String literka);
    boolean czyWstaw(String literka);
    boolean wygrana();
    void dodajDoListy(String literka);
    boolean wygranaOdgadnijHaslo(String odgadnijHaslo);
    boolean czySamogoska(String literka);
    void setHaslo(String haslo);
    HasloViewModel buildViewModel();
}

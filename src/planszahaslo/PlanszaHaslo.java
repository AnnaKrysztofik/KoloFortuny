package planszahaslo;

import models.HasloModel;
import providers.HasloProvider;
import providers.HasloProviderInterface;
import viewModels.HasloViewModel;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class PlanszaHaslo implements PlanszaHasloInterface {

    private String haslo;
    private String kategoria;
    List<String> LiterkiOdgadniete;
    private HasloProviderInterface hasloProvider;
    private  static final List<String> samogloski = List.of("A", "E", "O", "Y", "I", "U");;

    public PlanszaHaslo(HasloProviderInterface hasloProvider) {
        this.hasloProvider = hasloProvider;
        HasloModel hasloModel = hasloProvider.generujHaslo();
        this.haslo = hasloModel.getHaslo();
        this.kategoria = hasloModel.getKategoria();
        LiterkiOdgadniete = new ArrayList<>();
    }

    @Override
    public int ileRazy(String literka) {

        if (this.haslo == null || literka.equals(" "))
            return 0;

        return (int) IntStream.range(0, haslo.length())
                .mapToObj(i -> haslo.substring(i, i + 1))
                .filter(i -> i.equals(literka))
                .count();
    }

    @Override
    public boolean czyWstaw(String literka) {
        if (haslo.contains(literka) && !LiterkiOdgadniete.contains(literka)) return true;
        else return false;
    }

    @Override
    public boolean wygrana(){
      return  IntStream.range(0, haslo.length())
                .mapToObj(i -> haslo.substring(i, i + 1))
              .filter(i->!i.equals(" "))
                .allMatch(i->LiterkiOdgadniete.contains(i));
    }

     @Override
     public void dodajDoListy(String literka){
         LiterkiOdgadniete.add(literka);
    }

    @Override
    public boolean wygranaOdgadnijHaslo(String odgadnijHaslo)
    {
        if (haslo.equals(odgadnijHaslo.toUpperCase())) return true;
        else return false;
    }

    @Override
    public boolean czySamogoska(String literka){
        return samogloski.contains(literka.toUpperCase());
    }

    @Override
    public void setHaslo(String haslo) {
        this.haslo = haslo;
    }

    @Override
    public HasloViewModel buildViewModel()
    {
        StringBuilder stringBuilder = new StringBuilder();

        IntStream.range(0, haslo.length())
                .mapToObj(i -> haslo.substring(i, i + 1))
                .forEach(c -> {
                    if (LiterkiOdgadniete.contains(c)) stringBuilder.append(c);
                    else if (c.equals(" ")) stringBuilder.append(" ");
                    else stringBuilder.append("_");
                });

        return new HasloViewModel(stringBuilder.toString(), this.kategoria);
    }
   }


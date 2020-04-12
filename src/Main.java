import kolomanager.KoloManager;
import kolomanager.KoloManagerInterface;
import models.Gracz;
import planszahaslo.PlanszaHaslo;
import planszahaslo.PlanszaHasloInterface;
import providers.HasloProvider;
import providers.HasloProviderInterface;
import ui.UIInterface;
import ui.UserInterface;

import java.io.FileNotFoundException;

public class Main {
    public static void main(String[] args) {

        HasloProvider hasloProvider = new HasloProvider();
        UIInterface ui = new UserInterface();
        PlanszaHaslo planszaHaslo = new PlanszaHaslo(hasloProvider);
        KoloManager koloManager = new KoloManager();

        Gracz gracz1 = new Gracz("Ania", 0);
        Gracz gracz2 = new Gracz("Jacek", 0);

        ManagerGry managerGry = new ManagerGry(ui, planszaHaslo, koloManager, gracz1, gracz2);

        managerGry.przebiegGry();
    }
}





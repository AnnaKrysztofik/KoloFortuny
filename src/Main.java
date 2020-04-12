import kolomanager.KoloManager;
import models.Gracz;
import planszahaslo.PlanszaHaslo;
import providers.HasloProvider;
import ui.UIInterface;
import ui.UserInterface;

public class Main {
    public static void main(String[] args) {

        HasloProvider hasloProvider = new HasloProvider();
        UIInterface ui = new UserInterface();
        PlanszaHaslo planszaHaslo = new PlanszaHaslo(hasloProvider);
        KoloManager koloManager = new KoloManager();

        Gracz gracz1 = new Gracz("Piotr", 0);
        Gracz gracz2 = new Gracz("Paweł", 0);

        ManagerGry managerGry = new ManagerGry(ui, planszaHaslo, koloManager, gracz1, gracz2);

        managerGry.przebiegGry();
    }
}





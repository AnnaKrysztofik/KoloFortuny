import kolomanager.KoloManagerFake;
import kolomanager.KoloManagerInterface;
import models.ElementKolaModel;
import models.Gracz;
import org.junit.Test;
import planszahaslo.PlanszaHaslo;
import planszahaslo.PlanszaHasloInterface;
import providers.HasloProvider;
import providers.HasloProviderFake;
import providers.HasloProviderInterface;
import ui.UIInterface;
import ui.UserInterfaceFake;

import java.util.List;

import static org.junit.Assert.*;

public class ManagerGryTest {

    @Test
    public void gracz1IsCurrentAtTheBeggining_Test()
    {
        // Arrange
        UIInterface ui = new UserInterfaceFake();
        KoloManagerInterface koloManager = new KoloManagerFake();
        PlanszaHasloInterface planszaHaslo = new PlanszaHaslo(new HasloProvider());
        Gracz gracz1 = new Gracz("Ania", 0);
        Gracz gracz2 = new Gracz("Jacek", 0);

        // Act
        ManagerGry managerGry = new ManagerGry(ui, planszaHaslo, koloManager, gracz1, gracz2);

        // Assert
        assertEquals(gracz1, managerGry.getCurrent());
    }

    @Test
    public void stopScenario_Test()
    {
        // Arrange
        HasloProviderInterface hasloProvider = new HasloProviderFake();
        UserInterfaceFake ui = new UserInterfaceFake();
        KoloManagerFake koloManager = new KoloManagerFake();
        PlanszaHaslo planszaHaslo = new PlanszaHaslo(hasloProvider);
        Gracz gracz1 = new Gracz("Ania", 100);
        Gracz gracz2 = new Gracz("Jacek", 0);

        ui.setZakrecZgaduj(List.of(1, 2));
        ui.setHaslo("ALA MA KOTA");
        koloManager.setElementKolaModel(List.of(
                new ElementKolaModel(true, false, 0,"BANKRUT")));

        ManagerGry managerGry = new ManagerGry(ui, planszaHaslo, koloManager, gracz1, gracz2);

        // Act
        managerGry.przebiegGry();

        // Assert
        assertEquals(gracz2, managerGry.getCurrent());
        assertEquals(0, gracz1.getstanKonta());
    }

    @Test
    public void samogloskaScenario_Test()
    {
        // Arrange
        HasloProviderInterface hasloProvider = new HasloProviderFake();
        UserInterfaceFake ui = new UserInterfaceFake();
        KoloManagerFake koloManager = new KoloManagerFake();
        PlanszaHaslo planszaHaslo = new PlanszaHaslo(hasloProvider);
        Gracz gracz1 = new Gracz("Ania", 0);
        Gracz gracz2 = new Gracz("Jacek", 0);

        ui.setZakrecZgaduj(List.of(1, 1, 2));
        ui.setLiterki(List.of("L","A"));
        ui.setHaslo("ALA MA KOTA");

        koloManager.setElementKolaModel(List.of(
                new ElementKolaModel(false, false, 1000,""),
                new ElementKolaModel(false, false, 1000,"")));

        ManagerGry managerGry = new ManagerGry(ui, planszaHaslo, koloManager, gracz1, gracz2);

        // Act
        managerGry.przebiegGry();

        // Assert
        assertEquals(gracz1, managerGry.getCurrent());
        assertEquals(800, gracz1.getstanKonta());
    }
}
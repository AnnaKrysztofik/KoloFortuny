package planszahaslo;

import org.junit.Before;
import org.junit.Test;
import planszahaslo.PlanszaHaslo;
import providers.HasloProvider;
import viewModels.HasloViewModel;

import java.util.List;

import static org.junit.Assert.*;

public class PlanszaHasloTest {

    PlanszaHaslo planszaHaslo;
    List<String> listaLiterek;

    @Before
    public void setup() {
        planszaHaslo = new PlanszaHaslo(new HasloProvider());
    }

    @Test
    public void ileRazy_should_return_iloscWystapienDanejLiteryWHasle_Test() {
        // Arrange
        planszaHaslo.setHaslo("kjhkffgd a lrd ffd aaa");

        // Act
        int result = planszaHaslo.ileRazy("a");

        // Assert
        assertEquals(4, result);
    }

    @Test
    public void ileRazy_should_return_iloscWystapienDanejLiteryWHasleDuzeLitery_Test() {
        // Arrange
        planszaHaslo.setHaslo("kjhkffgd A lrd ffd aAaa");

        // Act
        int result = planszaHaslo.ileRazy("a");

        // Assert
        assertEquals(3, result);
    }

    @Test
    public void ileRazy_should_return_iloscWystapienDanejLiteryWHasleHasloJestNull_Test() {
        // Arrange
        planszaHaslo.setHaslo(null);

        // Act
        int result = planszaHaslo.ileRazy("g");

        // Assert
        assertEquals(0, result);
    }

    @Test
    public void ileRazy_should_return_zeroWhenSpacje_Test() {
        // Arrange
        planszaHaslo.setHaslo("kjhkffgd A lrd ffd aAaa");

        // Act
        int result = planszaHaslo.ileRazy(" ");

        // Assert
        assertEquals(0, result);
    }


    @Test
    public void czyLiterka_should_return_TakJesliZawiera_Test() {
        // Arrange
        planszaHaslo.setHaslo("ala");

        // Act
        boolean result = planszaHaslo.czyWstaw("b");

        // Assert
        assertEquals(false, result);
    }

    @Test
    public void czyJestWygrana_Test() {

        // Arrange


        planszaHaslo.setHaslo("ala");
        planszaHaslo.dodajDoListy("a");
        planszaHaslo.dodajDoListy("l");
        // Act
        boolean result = planszaHaslo.wygrana();

        // Assert
        assertEquals(true, result);

    }

    @Test
    public void czyJestWygrana_should_return_false_Test() {

        // Arrange
        planszaHaslo.setHaslo("ala");
        planszaHaslo.dodajDoListy("a");

        // Act
        boolean result = planszaHaslo.wygrana();

        // Assert
        assertFalse(result);
    }

    /*
    Scenario 1:
        Bez odgadnietych literek
     */
    @Test
    public void buildViewModel_scenario_1_Test() {
        // Arrange
        planszaHaslo.setHaslo("ALA MA KOTA");

        // Act
        HasloViewModel result = planszaHaslo.buildViewModel();

        // Assert
        assertEquals("___ __ ____", result.getHaslo());
    }

    /*
    Scenario 2:
        Z odgadnieta literka
 */
    @Test
    public void buildViewModel_scenario_2_Test() {
        // Arrange
        planszaHaslo.setHaslo("ALA MA KOTA");
        planszaHaslo.dodajDoListy("A");

        // Act
        HasloViewModel result = planszaHaslo.buildViewModel();

        // Assert
        assertEquals("A_A _A ___A", result.getHaslo());
    }

    @Test
    public void wygrana_listaZawieraWszystkieLiterki_Test() {
        // Arrange
        planszaHaslo.setHaslo("KOTA");
        planszaHaslo.dodajDoListy("A");
        planszaHaslo.dodajDoListy("K");
        planszaHaslo.dodajDoListy("O");
        planszaHaslo.dodajDoListy("T");

        // Act
        Boolean result = planszaHaslo.wygrana();


        // Assert
        assertTrue(result);


    }
    @Test
    public void wygrana_listaZawieraWszystkieLiterkiZeSpacja_Test() {
        // Arrange
        planszaHaslo.setHaslo("KOTA K");
        planszaHaslo.dodajDoListy("A");
        planszaHaslo.dodajDoListy("K");
        planszaHaslo.dodajDoListy("O");
        planszaHaslo.dodajDoListy("T");

        // Act
        Boolean result = planszaHaslo.wygrana();


        // Assert
        assertTrue(result);


    }
    @Test
    public void wygrana_listaZawieraNieWszystkieLiterki_Test() {
        // Arrange
        planszaHaslo.setHaslo("KOTA K");
        planszaHaslo.dodajDoListy("A");
        planszaHaslo.dodajDoListy("K");
        planszaHaslo.dodajDoListy("O");

        // Act
        Boolean result = planszaHaslo.wygrana();


        // Assert
        assertFalse(result);


    }
    @Test
    public void wygrana_listaZawieraNieWszystkieLiterkiFalse_Test() {
        // Arrange
        planszaHaslo.setHaslo("KOTA KI");
        planszaHaslo.dodajDoListy("A");
        planszaHaslo.dodajDoListy("K");
        planszaHaslo.dodajDoListy("O");
        planszaHaslo.dodajDoListy("T");

        // Act
        Boolean result = planszaHaslo.wygrana();


        // Assert
        assertFalse(result);


    }

    @Test
    public void odgadnijHasloPoprawne_Test(){
        // Arrange
        planszaHaslo.setHaslo("ALA MA KOTA");

        // Act
        Boolean result = planszaHaslo.wygranaOdgadnijHaslo("ALA MA KOTA");

        // Assert
        assertTrue(result);
    }

    @Test
    public void odgadnijHasloPoprawneMalelitery_Test(){
        // Arrange
        planszaHaslo.setHaslo("ALA MA KOTA");

        // Act
        Boolean result = planszaHaslo.wygranaOdgadnijHaslo("ala ma kota");

        // Assert
        assertTrue(result);
    }

    @Test
    public void odgadnijHasloFalse_Test(){
        // Arrange
        planszaHaslo.setHaslo("ALA MA KOTA");

        // Act
        Boolean result = planszaHaslo.wygranaOdgadnijHaslo("ala ma pasa");

        // Assert
        assertFalse(result);
    }

    @Test
    public void czySamogloskaA_Test(){
        // Arrange

        // Act
        Boolean result = planszaHaslo.czySamogoska("A");

        // Assert
        assertTrue(result);
    }
    @Test
    public void czySamogloskaa_Test(){
        // Arrange

        // Act
        Boolean result = planszaHaslo.czySamogoska("a");

        // Assert
        assertTrue(result);
    }
    @Test
    public void czySamogloskaB_Test(){
        // Arrange

        // Act
        Boolean result = planszaHaslo.czySamogoska("B");

        // Assert
        assertFalse(result);
    }




}
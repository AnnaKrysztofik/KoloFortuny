package kolomanager;

import kolomanager.KoloManager;
import models.ElementKolaModel;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;


public class KoloManagerTest {

    List<Integer> expectedValues = Arrays.asList(0, 100, 200, 300, 400, 500);

    @Test
    public void zakrecKolem_should_return_valueFromGivenScope()
    {
        // Arrange
        KoloManager koloManager = new KoloManager();

        // Act
        ElementKolaModel result = koloManager.zakrecKolem();

        // Assert
        assertTrue(expectedValues.contains(result.getValue()));
    }

    @Test
    public void zakrecKolem_should_return_propperString()
    {
        // Arrange
        KoloManager koloManager = new KoloManager();

        // Act
        ElementKolaModel result = koloManager.zakrecKolem();

        // Assert
        if(!result.getIsBankrut() && !result.getIsStop())
            assertEquals("+" + result.getValue(), result.getNazwa());

        if(result.getIsBankrut()) {
            assertEquals("******** BANKRUT **************", result.getNazwa());
            assertEquals(0, result.getValue());
        }

        if(result.getIsStop()) {
            assertEquals("******* STOP ****************", result.getNazwa());
            assertEquals(0, result.getValue());
        }
    }
}
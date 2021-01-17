package test;

import main.wheelManager.WheelManager;
import main.models.WheelModel;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;


public class WheelManagerTest {

    List<Integer> expectedValues = Arrays.asList(0, 100, 200, 300, 400, 500);

    @Test
    public void spinTheWheel_should_return_valueFromGivenScope()
    {
        // Arrange
        WheelManager wheelManager = new WheelManager();

        // Act
        WheelModel result = wheelManager.spinTheWheelOfFortune();

        // Assert
        assertTrue(expectedValues.contains(result.getValue()));
    }

    @Test
    public void spinTheWheel_should_return_propperString()
    {
        // Arrange
        WheelManager wheelManager = new WheelManager();

        // Act
        WheelModel result = wheelManager.spinTheWheelOfFortune();

        // Assert
        if(!result.getIsBankrupt() && !result.getIsStop())
            assertEquals("+" + result.getValue(), result.getName());

        if(result.getIsBankrupt()) {
            assertEquals("******** BANKRUT **************", result.getName());
            assertEquals(0, result.getValue());
        }

        if(result.getIsStop()) {
            assertEquals("******* STOP ****************", result.getName());
            assertEquals(0, result.getValue());
        }
    }
}
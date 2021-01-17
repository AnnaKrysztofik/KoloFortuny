package test;

import org.junit.Before;
import org.junit.Test;
import main.providers.PhraseProvider;
import main.viewModels.PasswordViewModel;
import main.wheelOfFortunePuzzleBoard.WheelOfFortunePuzzleBoard;

import java.util.List;

import static org.junit.Assert.*;

public class WheelModelOfFortunePuzzleBoardTest {

    WheelOfFortunePuzzleBoard wheelOfFortunePuzzleBoard;
    List<String> listOfLetters;

    @Before
    public void setup() {
        wheelOfFortunePuzzleBoard = new WheelOfFortunePuzzleBoard(new PhraseProvider());
    }

    @Test
    public void ileRazy_should_return_iloscWystapienDanejLiteryWHasle_Test() {
        // Arrange
        wheelOfFortunePuzzleBoard.setPhrase("kjhkffgd a lrd ffd aaa");

        // Act
        int result = wheelOfFortunePuzzleBoard.howManyTimes("a");

        // Assert
        assertEquals(4, result);
    }

    @Test
    public void howManyTimes_should_return_iloscWystapienDanejLiteryWHasleDuzeLitery_Test() {
        // Arrange
        wheelOfFortunePuzzleBoard.setPhrase("kjhkffgd A lrd ffd aAaa");

        // Act
        int result = wheelOfFortunePuzzleBoard.howManyTimes("a");

        // Assert
        assertEquals(3, result);
    }

    @Test
    public void howMany_should_return_iloscWystapienDanejLiteryWHasleHasloJestNull_Test() {
        // Arrange
        wheelOfFortunePuzzleBoard.setPhrase(null);

        // Act
        int result = wheelOfFortunePuzzleBoard.howManyTimes("g");

        // Assert
        assertEquals(0, result);
    }

    @Test
    public void howMany_should_return_zeroWhenSpacje_Test() {
        // Arrange
        wheelOfFortunePuzzleBoard.setPhrase("kjhkffgd A lrd ffd aAaa");

        // Act
        int result = wheelOfFortunePuzzleBoard.howManyTimes(" ");

        // Assert
        assertEquals(0, result);
    }


    @Test
    public void czyLiterka_should_return_TakJesliZawiera_Test() {
        // Arrange
        wheelOfFortunePuzzleBoard.setPhrase("ala");

        // Act
        boolean result = wheelOfFortunePuzzleBoard.insert("b");

        // Assert
        assertEquals(false, result);
    }

    @Test
    public void czyJestWygrana_Test() {

        // Arrange


        wheelOfFortunePuzzleBoard.setPhrase("ala");
        wheelOfFortunePuzzleBoard.addToList("a");
        wheelOfFortunePuzzleBoard.addToList("l");
        // Act
        boolean result = wheelOfFortunePuzzleBoard.win();

        // Assert
        assertEquals(true, result);

    }

    @Test
    public void czyJestWygrana_should_return_false_Test() {

        // Arrange
        wheelOfFortunePuzzleBoard.setPhrase("ala");
        wheelOfFortunePuzzleBoard.addToList("a");

        // Act
        boolean result = wheelOfFortunePuzzleBoard.win();

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
        wheelOfFortunePuzzleBoard.setPhrase("ALA MA KOTA");

        // Act
        PasswordViewModel result = wheelOfFortunePuzzleBoard.buildViewModel();

        // Assert
        assertEquals("___ __ ____", result.getPhrase());
    }

    /*
    Scenario 2:
        Z odgadnieta literka
 */
    @Test
    public void buildViewModel_scenario_2_Test() {
        // Arrange
        wheelOfFortunePuzzleBoard.setPhrase("ALA MA KOTA");
        wheelOfFortunePuzzleBoard.addToList("A");

        // Act
        PasswordViewModel result = wheelOfFortunePuzzleBoard.buildViewModel();

        // Assert
        assertEquals("A_A _A ___A", result.getPhrase());
    }

    @Test
    public void wygrana_listaZawieraWszystkieLiterki_Test() {
        // Arrange
        wheelOfFortunePuzzleBoard.setPhrase("KOTA");
        wheelOfFortunePuzzleBoard.addToList("A");
        wheelOfFortunePuzzleBoard.addToList("K");
        wheelOfFortunePuzzleBoard.addToList("O");
        wheelOfFortunePuzzleBoard.addToList("T");

        // Act
        Boolean result = wheelOfFortunePuzzleBoard.win();


        // Assert
        assertTrue(result);


    }
    @Test
    public void wygrana_listaZawieraWszystkieLiterkiZeSpacja_Test() {
        // Arrange
        wheelOfFortunePuzzleBoard.setPhrase("KOTA K");
        wheelOfFortunePuzzleBoard.addToList("A");
        wheelOfFortunePuzzleBoard.addToList("K");
        wheelOfFortunePuzzleBoard.addToList("O");
        wheelOfFortunePuzzleBoard.addToList("T");

        // Act
        Boolean result = wheelOfFortunePuzzleBoard.win();


        // Assert
        assertTrue(result);


    }
    @Test
    public void wygrana_listaZawieraNieWszystkieLiterki_Test() {
        // Arrange
        wheelOfFortunePuzzleBoard.setPhrase("KOTA K");
        wheelOfFortunePuzzleBoard.addToList("A");
        wheelOfFortunePuzzleBoard.addToList("K");
        wheelOfFortunePuzzleBoard.addToList("O");

        // Act
        Boolean result = wheelOfFortunePuzzleBoard.win();


        // Assert
        assertFalse(result);


    }
    @Test
    public void wygrana_listaZawieraNieWszystkieLiterkiFalse_Test() {
        // Arrange
        wheelOfFortunePuzzleBoard.setPhrase("KOTA KI");
        wheelOfFortunePuzzleBoard.addToList("A");
        wheelOfFortunePuzzleBoard.addToList("K");
        wheelOfFortunePuzzleBoard.addToList("O");
        wheelOfFortunePuzzleBoard.addToList("T");

        // Act
        Boolean result = wheelOfFortunePuzzleBoard.win();


        // Assert
        assertFalse(result);


    }

    @Test
    public void odgadnijHasloPoprawne_Test(){
        // Arrange
        wheelOfFortunePuzzleBoard.setPhrase("ALA MA KOTA");

        // Act
        Boolean result = wheelOfFortunePuzzleBoard.guessPhrase("ALA MA KOTA");

        // Assert
        assertTrue(result);
    }

    @Test
    public void odgadnijHasloPoprawneMalelitery_Test(){
        // Arrange
        wheelOfFortunePuzzleBoard.setPhrase("ALA MA KOTA");

        // Act
        Boolean result = wheelOfFortunePuzzleBoard.guessPhrase("ala ma kota");

        // Assert
        assertTrue(result);
    }

    @Test
    public void odgadnijHasloFalse_Test(){
        // Arrange
        wheelOfFortunePuzzleBoard.setPhrase("ALA MA KOTA");

        // Act
        Boolean result = wheelOfFortunePuzzleBoard.guessPhrase("ala ma pasa");

        // Assert
        assertFalse(result);
    }

    @Test
    public void czySamogloskaA_Test(){
        // Arrange

        // Act
        Boolean result = wheelOfFortunePuzzleBoard.checkVowel("A");

        // Assert
        assertTrue(result);
    }
    @Test
    public void czySamogloskaa_Test(){
        // Arrange

        // Act
        Boolean result = wheelOfFortunePuzzleBoard.checkVowel("a");

        // Assert
        assertTrue(result);
    }
    @Test
    public void czySamogloskaB_Test(){
        // Arrange

        // Act
        Boolean result = wheelOfFortunePuzzleBoard.checkVowel("B");

        // Assert
        assertFalse(result);
    }




}
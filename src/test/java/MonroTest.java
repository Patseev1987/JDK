import org.example.sem6.ParadoxMonroGame;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

public class MonroTest {

    @ParameterizedTest
    @CsvSource(value = {"1,2", "2,3", "1,3"})
    public void getPresenterChoiceTestPositive(int value1, int value2) {
        ParadoxMonroGame paradoxMonroGame = new ParadoxMonroGame(100, true);
        assertTrue(paradoxMonroGame.getNewDoor(value1, value2) != value1);
        assertTrue(paradoxMonroGame.getNewDoor(value1, value2) != value2);
    }

    @Test
    void getAnswerTestPositiveTrue() {
        String wrightAnswer = "Gamer played 100 times with door changing.\n" +
                "Gamer won 70 times (70%).\n" +
                "Gamer lost 30 times (30%).\n";
        ParadoxMonroGame paradoxMonroGame = new ParadoxMonroGame(100, true);
        PrintStream oldPrintStream = System.out;
        ByteArrayOutputStream newPrintStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(newPrintStream));
        paradoxMonroGame.getAnswer(100, 70, 30, true);
        String result = newPrintStream.toString();
        System.setOut(oldPrintStream);
        assertEquals(result, wrightAnswer);
    }

    @Test
    void getAnswerTestNegativeTrue() {
        String wrightAnswer = "Gamer played 100 times without door changing.\n" +
                "Gamer won 70 times (70%).\n" +
                "Gamer lost 30 times (30%).\n";
        ParadoxMonroGame paradoxMonroGame = new ParadoxMonroGame(100, true);
        PrintStream oldPrintStream = System.out;
        ByteArrayOutputStream newPrintStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(newPrintStream));
        paradoxMonroGame.getAnswer(100, 70, 30, true);
        String result = newPrintStream.toString();
        System.setOut(oldPrintStream);
        assertNotEquals(result, wrightAnswer);
    }

    @Test
    void getAnswerTestPositiveFalse() {
        String wrightAnswer = "Gamer played 100 times without door changing.\n" +
                "Gamer won 70 times (70%).\n" +
                "Gamer lost 30 times (30%).\n";
        ParadoxMonroGame paradoxMonroGame = new ParadoxMonroGame(100, false);
        PrintStream oldPrintStream = System.out;
        ByteArrayOutputStream newPrintStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(newPrintStream));
        paradoxMonroGame.getAnswer(100, 70, 30, false);
        String result = newPrintStream.toString();
        System.setOut(oldPrintStream);
        assertEquals(result, wrightAnswer);
    }


    @Test
    void getAnswerTestNegativeFalse() {
        String wrightAnswer = "Gamer played 100 times with door changing.\n" +
                "Gamer won 70 times (70%).\n" +
                "Gamer lost 30 times (30%).\n";
        ParadoxMonroGame paradoxMonroGame = new ParadoxMonroGame(100, false);
        PrintStream oldPrintStream = System.out;
        ByteArrayOutputStream newPrintStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(newPrintStream));
        paradoxMonroGame.getAnswer(100, 70, 30, false);
        String result = newPrintStream.toString();
        System.setOut(oldPrintStream);
        assertNotEquals(result, wrightAnswer);
    }
}

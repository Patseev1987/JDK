import org.example.sem6.ParadoxMonroGame;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class MonroTest {

    @ParameterizedTest
    @CsvSource(value = {"1,2","2,3","1,3"})
    public void getPresenterChoiceTestPositive(int value1, int value2){
        ParadoxMonroGame paradoxMonroGame = new ParadoxMonroGame(100, true);
        assertTrue(paradoxMonroGame.getPresenterChoice(value1,value2)!=value1);
        assertTrue(paradoxMonroGame.getPresenterChoice(value1,value2)!=value2);
    }
}

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import seminars.third.hw.MainHW;

public class MainHWTest {

    private MainHW mainHW;

    @BeforeEach
    void setup() {
        MainHW mainHW = new MainHW();
    }

    @Test
    void evenOddNumber() {
        Assertions.assertTrue(mainHW.evenOddNumber(2));
        Assertions.assertFalse(mainHW.evenOddNumber(3));
    }

    @Test
    void numberInInterval() {
        Assertions.assertTrue(mainHW.numberInInterval(26));
        Assertions.assertFalse(mainHW.numberInInterval(1));
    }
}

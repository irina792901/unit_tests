import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import seminars.third.hw.MainHW;

public class MainHWTest {
    private MainHW mainHW;

    @BeforeEach
    void setup() {
        mainHW = new MainHW();
    }

    @Test
    void evenOddNumber() {
        Assertions.assertTrue(mainHW.evenOddNumber(2));
        Assertions.assertFalse(mainHW.evenOddNumber(3));
    }

    @ParameterizedTest
    @CsvSource({"26, true", "50, true", "99, true",
            "-50, false", "24, false", "25, false",
            "100, false", "101, false", "2000, false"})
    void numberInInterval(int number, boolean result) {
        Assertions.assertEquals(result, mainHW.numberInInterval(number));
    }
}

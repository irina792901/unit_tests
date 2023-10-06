import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.junit.jupiter.api.Assertions.*;
import seminars.third.tdd.MoodAnalyser;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

public class MoodAnalyserTest {
    private MoodAnalyser moodAnalyser;

    @BeforeEach
    void setup() {
        moodAnalyser = new MoodAnalyser();
    }

    @ParameterizedTest
    @ValueSource(strings = {"Хорошо проделанная работа приносит радость",
            "Солнышко светит весело, и от этого становится тепло на душе",
            "Так все замечательно получилось, что улыбка сама наползает"})
    void findHappyPhrase(String word) {
        assertThat(moodAnalyser.analyseMood(word)).isEqualTo("HAPPY");
    }

    @ParameterizedTest
    @ValueSource(strings = {"Катится слеза по щеке",
            "Печаль затаилась в её глазах",
            "Пришла грусть и печаль"})
    void findSadPhrase(String word) {
        assertThat(moodAnalyser.analyseMood(word)).isEqualTo("SAD");
    }

    @ParameterizedTest
    @ValueSource(strings = {"Всё нормально",
            "Абсолютно ничего не происходит",
            "Ничего так и не случилось"})
    void findNeutralPhrase(String word) {
        assertThat(moodAnalyser.analyseMood(word)).isEqualTo("NEUTRAL");
    }
}

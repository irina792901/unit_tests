package seminars.third.tdd;

import java.util.Arrays;
import java.util.List;

public class MoodAnalyser {
    List<String> happyPhrases = Arrays.asList("хорош", "весел", "улыб");
    List<String> sadPhrases = Arrays.asList("груст", "печаль", "слез");

    /**
     * @apiNote в случае обнаружения во фразе радостных и грустных эмоций
     * метод покажет радость
     * @param message фраза
     * @return эмоция "Happy", "SAD" или "NEUTRAL"
     */
    public String analyseMood(String message) {
        message = message.toLowerCase();
        for (String word : happyPhrases) {
            if (message.contains(word)) return "HAPPY";
        }
        for (String word : sadPhrases) {
            if (message.contains(word)) return "SAD";
        }
        return "NEUTRAL";
    }
}
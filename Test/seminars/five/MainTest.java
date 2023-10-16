import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static java.util.Collections.*;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.junit.Assert.assertEquals;

import seminars.five.number.*;
import seminars.five.user.UserRepository;
import seminars.five.user.UserService;

public class MainTest {
    //5.1
    @Test
    public void testGenerateRandomNumbers() {
// Проверяем, что список чисел генерируется корректно
        List<Integer> numbers = RandomNumberModule.generateRandomNumbers(10);
        assertEquals(10, numbers.size());
    }

    @Test
    public void testGenerateRandomNumbersNegativeCount() {
// Проверяем, что при передаче отрицательного значения возвращается пустой список
        assertThatThrownBy(() -> RandomNumberModule.generateRandomNumbers(-5)).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    public void testModulesIntegration() {
// Генерируем список случайных чисел
        List<Integer> numbers = RandomNumberModule.generateRandomNumbers(10);
// Ищем максимальное число в списке
        int maxNumber = MaxNumberModule.findMaxNumber(numbers);
// Проверяем, что максимальное число найдено корректно
        assertEquals(Optional.ofNullable(max(numbers)), Optional.of(maxNumber));
    }
    //5.2
    @Test
    public void testGetUserName() {
// Создаем экземпляры классов UserService и UserRepository
        UserRepository userRepository = new UserRepository();
        UserService userService = new UserService(userRepository);

// Вызываем метод getUserName и проверяем ожидаемый результат
        String result = userService.getUserName(123);
        assertEquals("User 123", result);
    }
    //5.3

}

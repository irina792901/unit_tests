package seminars.fourth.weather;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions.*;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

class WeatherReporterTest {
    @Test
    public void testWeatherReporter() {
        // Arrange
        // Создаем мок для WeatherService
        WeatherService mockWeatherService = mock(WeatherService.class);
        // Определяем поведение мока. Когда метод getCurrentTemperature() будет вызван,
        // он вернет 25
        when(mockWeatherService.getCurrentTemperature()).thenReturn(15);
        // Создаем объект класса WeatherReporter, передаем ему в конструктор наш мок
        // Вызываем метод generateReport()
        // Проверяем, что отчет содержит ожидаемую информацию о температуре
        WeatherReporter reporter = new WeatherReporter(mockWeatherService);
        // Act
        String res = reporter.generateReport();
        // Assert
        Assertions.assertEquals("Текущая температура: 15 градусов.", res);
        verify(mockWeatherService, times(1)).getCurrentTemperature();
    }
}
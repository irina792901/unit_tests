package seminars.fourth.hotel;


import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;

class BookingServiceTest {
    @Test
    public void testBookingService() {
        // Создание мока
        HotelService mockHotelService = mock(HotelService.class);
        // Определение поведения мока
        when(mockHotelService.isRoomAvailable(2)).thenReturn(true);
        //--------------С У П Е Р М Е Т О Д   от преподавателя--------------
        //when(mockHotelService.isRoomAvailable(anyInt())).thenAnswer(i -> (Integer) i.getArgument(0) % 2 == 0);
        //------------------------------------------------------------------
        // Создание экземпляра тестируемого класса с подставленным моком
        BookingService bookingService = new BookingService(mockHotelService);
        // Проверка метода bookRoom() с номером комнаты, который является доступным (четным)
        assertTrue(bookingService.bookRoom(2));
        // Проверка метода bookRoom() с номером комнаты, который является недоступным (нечетным)
        assertFalse(bookingService.bookRoom(3));
        verify(mockHotelService, times(1)).isRoomAvailable(2);
        // Проверка, что метод isRoomAvailable() вызывается два раза
        //---------------для суперметода------------------
        //   verify(mockHotelService, times(2)).isRoomAvailable(anyInt());
        //------------------------------------------------
    }
}



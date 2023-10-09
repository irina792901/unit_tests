package hw;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import seminars.fourth.book.Book;
import seminars.fourth.book.BookRepository;
import seminars.fourth.book.BookService;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

public class BookServiceWithInjectMockTest {
    @Mock
    BookRepository bookRepository;
    @InjectMocks
    BookService bookService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testFindBookById() {
        Mockito.when(bookRepository.findById("123")).thenReturn(new Book("123", "Test title", "Test author"));
        Book result = bookService.findBookById("123");
        assertEquals("Test title", result.getTitle());
        assertEquals("Test author", result.getAuthor());
    }
    @Test
    public void testFindAllBooks() {
        when(bookRepository.findAll()).thenReturn(List.of(new Book("123", "Test Book", "Test Author")));
        List<Book> result = bookService.findAllBooks();
        assertEquals(1, result.size());
        assertEquals("Test Book", result.get(0).getTitle());
        assertEquals("Test Author", result.get(0).getAuthor());
    }


}

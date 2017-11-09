package books;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

public class BookApiTest {

	@Test
	public void testFindBooksBySearchNormal() {
		ArrayList<Book> books = BookApi.findBooksBySearch("java programming", 0, 5);
		assertEquals(books.size(), 5);
		assertEquals(BookApi.findBooksBySearch("random", 0).get(1), BookApi.findBooksBySearch("random").get(1));
		assertEquals(BookApi.findBooksBySearch("Hallo", 0, 15).get(6), BookApi.findBooksBySearch("Hallo", 5, 2).get(1));
	}
	
	@Test
	public void testFindBookBySearchIncorrectInput() {
		
	}

}

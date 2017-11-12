package books;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

public class BookApiTest {

	@Test
	public void testFindBooksBySearchNormal() {
		ArrayList<Book> books = BookApi.findBooksBySearch("java programming", 0, 5);
		assertEquals(books.size(), 5);
		}
	
	@Test
	public void testFindBookBySearchNormalMaxResults() {
		assertEquals(BookApi.findBooksBySearch("random", 0).get(1), BookApi.findBooksBySearch("random").get(1));
	}
	
	@Test
	public void testFindBookBySearchNormalIndex() {
		assertEquals(BookApi.findBooksBySearch("Hallo", 0, 15).get(6), BookApi.findBooksBySearch("Hallo", 5, 2).get(1));
	}
	
	@Test
	public void testFindBookBySearchIncorrectInput() {
		assertNull(BookApi.findBooksBySearch(""));
	}
	
	@Test
	public void testFindBookBySearchIncorrectInputIndex() {
		assertNull(BookApi.findBooksBySearch("Random", -1));
		assertNull(BookApi.findBooksBySearch("Random", 5000000));
	}
	
	@Test
	public void testFindBookBySearchIncorrectInputMaxResults() {
		assertNull(BookApi.findBooksBySearch("Random", 5, -1));
		assertNull(BookApi.findBooksBySearch("Random", 5, 0));
	}
	
	@Test
	public void testFindBookByIdNormal() {
		Book book1 = BookApi.findBookById("iWPeqljHNcoC");
		Book book2 = BookApi.findBookById("iWPeqljHNcoC");
		assertEquals(book1, book2);
	}
	
	@Test
	public void testFindBookByIdIncorrectInput() {
		assertNull(BookApi.findBookById("abcde"));
		assertNull(BookApi.findBookById(""));
		assertNull(BookApi.findBookById(null));
	}
	
	@Test
	public void testGetMaxResulstsNormal() {
		assertTrue(BookApi.getMaxResults("Grass") > 1);
	}
	@Test
	public void testGetMaxResultsIncorrectInput() {
		assertEquals(-1, BookApi.getMaxResults(""));
	}
}

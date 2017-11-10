package books;

import java.util.ArrayList;

/**
 * This class cannot be instantiated, but instead provides access to static methods to create Book objects by
 * searching the Google Books Api for specific searchterms (a.k.a. a query) or an id.
 * 
 * @author Robrecht Blancquaert
 */
public abstract class BookApi extends BookApiConnection{
	/**
	 * Search for a book with the given id.
	 * 
	 * @param id  The id to search for.
	 * @return A book object with the given id, or null if none was found.
	 */
	public static Book findBookById(String id) {
		if(id == null  || id.length() == 0) {
			return null;
		}
		return BookApiConnection.getBookById(id);
	}
	
	/**
	 * Search for books that are relevant to the searchterms in the Google Books Api.
	 * 
	 * @param searchterms  The query that should be searched for.
	 * @param index  Determines how many books are skipped when searching.
	 * @param resultSize  This sets the maximum size of the returned list.
	 * @return A list of Books correlating to the searchterms.
	 */
	public static ArrayList<Book> findBooksBySearch(ArrayList<String> searchterms, int index, int resultSize) {
		if (searchterms == null || index < 0 || resultSize < 1  || searchterms.size() == 0) {
			return null;
		}
		int totalNulls = 0;
		for(String s : searchterms) {
			if(s.length() == 0) {
				totalNulls++;
			}
		}
		if(totalNulls == searchterms.size()) {
			return null;
		}
		return BookApiConnection.searchBooks(searchterms, index, resultSize);
	}
	
	/**
	 * @see #findBooksBySearch(ArrayList, int, int) with resultSize = 20.
	 */
	public static ArrayList<Book> findBooksBySearch(ArrayList<String> searchterms, int index) {
		if (searchterms == null || index < 0  || searchterms.size() == 0) {
			return null;
		}
		int totalNulls = 0;
		for(String s : searchterms) {
			if(s.length() == 0) {
				totalNulls++;
			}
		}
		if(totalNulls == searchterms.size()) {
			return null;
		}
		return BookApiConnection.searchBooks(searchterms, index);
	}
	
	/**
	 * @see #findBooksBySearch(ArrayList, int, int) with index = 0 and resultSize = 20.
	 */
	public static ArrayList<Book> findBooksBySearch(ArrayList<String> searchterms) {
		if (searchterms == null  || searchterms.size() == 0) {
			return null;
		}
		int totalNulls = 0;
		for(String s : searchterms) {
			if(s.length() == 0) {
				totalNulls++;
			}
		}
		if(totalNulls == searchterms.size()) {
			return null;
		}
		return BookApiConnection.searchBooks(searchterms);
	}
	
	/**
	 * @see #findBooksBySearch(ArrayList, int, int)
	 */
	public static ArrayList<Book> findBooksBySearch(String searchterms, int index, int resultSize) {
		if (searchterms == null || index < 0 || resultSize < 1  || searchterms.length() == 0) {
			return null;
		}
		ArrayList<String> searchtermsList = new ArrayList<String>();
		searchtermsList.add(searchterms);
		return BookApiConnection.searchBooks(searchtermsList, index, resultSize);
	}
	
	/**
	 * @see #findBooksBySearch(ArrayList, int, int) with resultSize = 20.
	 */
	public static ArrayList<Book> findBooksBySearch(String searchterms, int index) {
		if (searchterms == null || index < 0  || searchterms.length() == 0) {
			return null;
		}
		ArrayList<String> searchtermsList = new ArrayList<String>();
		searchtermsList.add(searchterms);
		return BookApiConnection.searchBooks(searchtermsList, index);
	}
	
	/**
	 * @see #findBooksBySearch(ArrayList, int, int) with index = 0 and resultSize = 20.
	 */
	public static ArrayList<Book> findBooksBySearch(String searchterms) {
		if (searchterms == null || searchterms.length() == 0) {
			return null;
		}
		ArrayList<String> searchtermsList = new ArrayList<String>();
		searchtermsList.add(searchterms);
		return BookApiConnection.searchBooks(searchtermsList);
	}
	
	/**
	 * Searches for books with relevance to the searchterms on the Google Books Api and returns how many were found.
	 * 
	 * @param searchterms  The query that should be searched for.
	 * @return The amount of books that were found.
	 */
	public static int getMaxResults(ArrayList<String> searchterms) {
		if (searchterms == null  || searchterms.size() == 0) {
			return -1;
		}
		int totalNulls = 0;
		for(String s : searchterms) {
			if(s.length() == 0) {
				totalNulls++;
			}
		}
		if(totalNulls == searchterms.size()) {
			return -1;
		}
		return BookApiConnection.getResultsSize(searchterms);
	}

	/**
	 * @see #maxResults(ArrayList)
	 */
	public static int getMaxResults(String searchterms) {
		if (searchterms == null  || searchterms.length() == 0) {
			return -1;
		}
		ArrayList<String> searchtermsList = new ArrayList<String>();
		searchtermsList.add(searchterms);
		return BookApiConnection.getResultsSize(searchtermsList);
	}
}

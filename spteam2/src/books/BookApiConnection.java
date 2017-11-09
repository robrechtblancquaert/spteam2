package books;

import java.io.IOException;
import java.util.ArrayList;

import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import org.json.*;

/**
 * The BookApiConnection class will use the <a href="https://developers.google.com/books/docs/v1/reference/">Google Books Api</a>
 * to generate Book objects from search parameters, as they are found on the Google Books Store.
 * Note: in this class "volume" is used to refer to the JSON format in which we get a book from the
 * Google Book Api, while "Book" refers to the Book class. The class is only used inside the package, it provides
 * functionality to the Book class.
 * This class uses {@link okhttp3} (<a href="http://square.github.io/okhttp/"> okhttp </a>
 * and org.json {@link org.json} (<a href="https://mvnrepository.com/artifact/org.json/json"> org.json </a>).
 * 
 * 
 * @author Robrecht Blancquaert
 */
class BookApiConnection {
	
	/**
	 * This variable dictates how many Book objects you want to have returned when you use the {@link #searchBooks(ArrayList)}
	 * method.
	 * High values may lead to long wait times, default value of 20 is recommended.
	 * If you want more results, you could keep the maxResults the same, but run the {@link #searchBooks(ArrayList)}
	 * method multiple times, while changing the {@link #startIndex} variable;
	 */
	private int maxResults = 20;
	
	/**
	 * The startIndex variable changes from which index {@link #searchBooks(ArrayList)} starts to return books.
	 * For example: if you already have the first 20 books of a certain search term (with {@link #maxResults} on 20),
	 * this variable will give you the next 20, if it's value is 20.
	 */
	private int startIndex = 0;
	
	protected BookApiConnection() {}
	
	/**
	 * This method will search for books correlated with the search terms. If no books were found the returned
	 * list will be empty.
	 * 
	 * @param searchterms  The list of terms to search for.
	 * @param index  Determines how many books are skipped when searching.
	 * @param resultSize This sets the maximum size of the returned list.
	 * @return A list of book objects, correlated with the search terms.
	 */
	static ArrayList<Book> searchBooks(ArrayList<String> searchterms, int index, int resultSize) {
		BookApiConnection ac = new BookApiConnection();
		ac.maxResults = resultSize;
		ac.startIndex = index;
		String searchParameterValue = new String();
		for(String s : searchterms) {
			searchParameterValue += s.trim() + " ";
		}
		searchParameterValue = searchParameterValue.trim();
		ArrayList<String> volumeList = ac.getVolumeList(searchParameterValue);
		ArrayList<Book> books = new ArrayList<Book>();
		for(String s : volumeList) {
			Book book = ac.formBookFromVolume(s);
			books.add(book);
		}
		return books;
	}
	
	/**
	 * @see #searchBooks(ArrayList, int, int), with resultSize = 20.
	 */
	static ArrayList<Book> searchBooks(ArrayList<String> searchterms, int index) {
		return searchBooks(searchterms, index, 20);
	}
	
	/**
	 * @see #searchBooks(ArrayList, int, int), with index = 0 and resultSize = 20.
	 */
	static ArrayList<Book> searchBooks(ArrayList<String> searchterms) {
		return searchBooks(searchterms, 0, 20);
	}
	
	/**
	 * This method will search for a book with a specific id, unique to each volume on the Google Book Store.
	 * 
	 * @param id  The id of the book you want to find.
	 * @return A Book object with the given id, or null if no volume was found with given id.
	 */
	static Book getBookById(String id) {
		BookApiConnection ac = new BookApiConnection();
		return ac.formBookFromVolume(ac.getVolumeById(id));
	}
	
	/**
	 * This method gets a raw text volume from the Google Books Api, with the given id.
	 * {@link okhttp3} was used to make the https get request.
	 * 
	 * @param id  The id of the volume that you want to get.
	 * @return A String containing information of the volume, or null if no volume was found.
	 */
	private String getVolumeById(String id) {
		HttpUrl url = new HttpUrl.Builder()
				.scheme("https")
				.host("www.googleapis.com")
				.addPathSegment("books")
				.addPathSegment("v1")
				.addPathSegment("volumes")
				.addPathSegment(id)
				.addQueryParameter("projection", "lite")
				.build();
		String body = urlGetRequest(url.toString());
		return body;
	}
	
	/**
	 * This method gets a raw text list of volumes from the Google Books Api, that correlate with the
	 * given search parameter.
	 * It uses {@link #startIndex} and {@link #maxResults} to determine which and how many volumes to get.
	 * {@link okhttp3} was used to make the https get request.
	 * 
	 * @param searchParameterValue  The String for which the Google Books Api should find correlated volumes.
	 * @return A list of raw text volumes, or null if no valid volume was found.
	 */
	private ArrayList<String> getVolumeList(String searchParameterValue) {
		ArrayList<String> volumeBodies = new ArrayList<String>();
		int index = 0;
		while(index < maxResults)
		{
			HttpUrl url = new HttpUrl.Builder()
					.scheme("https")
					.host("www.googleapis.com")
					.addPathSegment("books")
					.addPathSegment("v1")
					.addPathSegment("volumes")
					.addQueryParameter("q", searchParameterValue)
					.addQueryParameter("maxResults", String.valueOf(maxResults - index))
					.addQueryParameter("startIndex", String.valueOf(startIndex + index))
					.addQueryParameter("projection", "lite")
					.build();
			
			ArrayList<String> partialResponse = null;
			partialResponse = deconstructVolumeList(urlGetRequest(url.toString()));
			if(partialResponse == null) {
				return volumeBodies;
			}
			volumeBodies.addAll(partialResponse);
			index += partialResponse.size();
		}
		return volumeBodies;
	}
	
	/**
	 * This method is used to determine how many total results there will be for any given query of searchterms
	 * to the Google Books Api.
	 * 
	 * @param searchterms  The searchterms you want to know the amount of results for.
	 * @return The amount of results.
	 */
	static int getResultsSize(ArrayList<String> searchterms) {
		String searchParameterValue = new String();
		for(String s : searchterms) {
			searchParameterValue += s.trim() + " ";
		}
		searchParameterValue = searchParameterValue.trim();
		
		HttpUrl url = new HttpUrl.Builder()
				.scheme("https")
				.host("www.googleapis.com")
				.addPathSegment("books")
				.addPathSegment("v1")
				.addPathSegment("volumes")
				.addQueryParameter("q", searchParameterValue)
				.addQueryParameter("maxResults", "1")
				.addQueryParameter("startIndex", "0")
				.addQueryParameter("projection", "lite")
				.build();
		
		BookApiConnection ac = new BookApiConnection();
		String response = ac.urlGetRequest(url.toString());
		JSONObject j = new JSONObject(response);
		int r = j.getInt("totalItems");
		return r;
	}
	
	/**
	 * This method converts a singular JSON String of a volume list into a list of Strings, each
	 * containing the raw text body of a single volume.
	 * 
	 * @param jsonBody  A JSON String containing a list of volumes.
	 * @return A list of JSON Strings, with in each String a volume. Returns null if body parameter wasn't well formed.
	 */
	private ArrayList<String> deconstructVolumeList(String jsonBody) {
		JSONObject volumeList = new JSONObject(jsonBody);
		JSONArray jsonVolumes = null;
		try {
			jsonVolumes = volumeList.getJSONArray("items");
		} catch(JSONException e) {
			return null;
		}
		ArrayList<String> volumes = new ArrayList<String>();
		for(Object j : jsonVolumes) {
			volumes.add(j.toString());
		}
		return volumes;
	}
	
	/**
	 * This method will request the body of the webpage of the given url.
	 * 
	 * @param url  The url of the get request.
	 * @return A String of the code of the webpage, or null if url couldn't be resolved.
	 */
	private String urlGetRequest(String url){	
		OkHttpClient client = new OkHttpClient();
		Request request = new Request.Builder()
	      .url(url)
	      .build();
		Response response;
		try {
			response = client.newCall(request).execute();
			return response.body().string();
		} catch (IOException e) {
			return null;
		} catch (NullPointerException e) {
			return null;
		}
	}
	
	/**
	 * This method will turn a JSON volume into a Book object.
	 * 
	 * @param volume  The JSON volume you want to convert into a Book object.
	 * @return A book object with the information of the given volume.
	 */
	private Book formBookFromVolume(String volume) {
		if(volume == null) {
			return null;
		}
		Book book = new Book(null);
		
		JSONObject jsonVolume = new JSONObject(volume);
		book.setId(jsonVolume.getString("id"));
		book.setTitle(jsonVolume.getJSONObject("volumeInfo").getString("title"));
		return book;
	}
}

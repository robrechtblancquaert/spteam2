package books;

import java.io.IOException;
import java.util.ArrayList;

public class Book {
	
	private String id;
	private String title;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	
	public Book(String title) {
		this.title = title;
	}
	
	@Override
	public String toString() {
		return "Book [title=" + title + ", id=" + id + "]";
	}
	
	public static void main(String[] args) throws IOException {
		ArrayList<String> terms = new ArrayList<String>();
		terms.add("java");
		terms.add("programming");
		System.out.println(BookApi.findBooksBySearch(terms));
		System.out.println(BookApiConnection.getResultsSize(terms));
		//iWPeqljHNcoC
		System.out.println(BookApi.findBookById("iWPeqljHNcoC"));
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((title == null) ? 0 : title.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Book other = (Book) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (title == null) {
			if (other.title != null)
				return false;
		} else if (!title.equals(other.title))
			return false;
		return true;
	}
}
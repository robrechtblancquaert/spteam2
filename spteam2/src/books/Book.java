package books;

import java.io.Serializable;

import database.DatabaseObject;

public class Book implements DatabaseObject{
	private String id;
	private String title;
	private String authors;
	private String description;
	private String isbn;

	public Book() {}
	public Book(String bookId, String title, String authors, String description, String isbn) {
		super();
		this.id = bookId;
		this.title = title;
		this.authors = authors;
		this.description = description;
		this.isbn = isbn;
	}
	
	public String getId() {
		return id;
	}
	public void setId(String bookId) {
		this.id = bookId;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getAuthors() {
		return authors;
	}
	public void setAuthors(String authors) {
		this.authors = authors;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getIsbn() {
		return isbn;
	}
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	
	@Override
	public String toString() {
		return "Book [id=" + id + ", title=" + title + ", authors=" + authors + ", description=" + description
				+ ", isbn=" + isbn + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
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
		return true;
	}
	
	@Override
	public Serializable getSId() {
		return getId();
	}
	@Override
	public void setSId(Serializable id) {
		setId((String) id);
	}
}

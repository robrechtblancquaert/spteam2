package training;

import java.io.Serializable;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.HashSet;
import java.util.Set;

import books.Book;
import books.BookApi;
import database.Dao;
import database.DatabaseObject;
import employee.Certification;
import employee.Employee;
import employee.EmployeeApi;
import employee.EncodeImage;
import maps.Location;

public class Training implements DatabaseObject{
		private int id;
		private String name;
		private String description;
		private String location;
		private Calendar date;
		private Set<Book> books = new HashSet<Book>();
		private Set<Employee> participants = new HashSet<Employee>();
		private Set<Survey> surveys = new HashSet<Survey>();
		private int userid;
		
		public Training() {}
		public Training(String name, String description, String location, Calendar date, Set<Employee> participants) {
			super();
			this.name = name;
			this.description = description;
			this.location = location;
			this.date = date;
			this.participants = participants;
		}

		public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public String getDescription() {
			return description;
		}
		public void setDescription(String description) {
			this.description = description;
		}
		public String getLocation() {
			return location;
		}
		public void setLocation(String location) {
			this.location = location;
		}
		public Calendar getDate() {
			return date;
		}
		public void setDate(Calendar date) {
			this.date = date;
		}
		public Set<Book> getBooks() {
			return books;
		}
		public void setBooks(Set<Book> books) {
			this.books = books;
		}
		public Set<Employee> getParticipants() {
			return participants;
		}
		public void setParticipants(Set<Employee> participants) {
			this.participants = participants;
		}
		public Set<Survey> getSurveys() {
			return surveys;
		}
		public void setSurveys(Set<Survey> surveys) {
			this.surveys = surveys;
		}	
		public int getUserid() {
			return userid;
		}
		public void setUserid(int userid) {
			this.userid = userid;
		}
		
		public static void main(String[] args) {
			Training training = new Training();
			training.setName("AllEmployeesTest");
			Set<Book> books = new HashSet<Book>();
			books.add(BookApi.findBooksBySearch("java").get(0));
			books.add(BookApi.findBooksBySearch("c++").get(1));
			books.add(BookApi.findBooksBySearch("python").get(4));
			books.add(BookApi.findBooksBySearch("ruby").get(2));
			//training.setBooks(books);
			Calendar calendar = new GregorianCalendar(2018, 2, 1, 12, 30);
			training.setDate(calendar);
			training.setDescription("This is a test with a lot of employees and books.");
			Location location = new Location();
			location.setAddress("Rotselaar");
			location.formatAddress();
			training.setLocation(location.toString());
			Set<Employee> participants = EmployeeApi.getEmployee(null);
			training.setParticipants(participants);
			Dao<Training> daoTraining = new Dao<Training>(Training.class);
			daoTraining.save(training);
		}
		@Override
		public Serializable getSId() {
			return getId();
		}
		@Override
		public void setSId(Serializable id) {
			setId((int) id);
		}
}

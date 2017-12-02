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
import employee.EncodeImage;
import maps.Location;

public class Training implements DatabaseObject{
		private int id;
		private String name;
		private String description;
		private Location location;
		private Calendar date;
		private Set<Book> books = new HashSet<Book>();
		private Set<Employee> participants = new HashSet<Employee>();
		private Set<Survey> surveys = new HashSet<Survey>();
		
		public Training() {}
		public Training(String name, String description, Location location, Calendar date, Set<Employee> participants) {
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
		public Location getLocation() {
			return location;
		}
		public void setLocation(Location location) {
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
		
		public static void main(String[] args) {
			Training training = new Training();
			Set<Book> books = new HashSet<Book>();
			books.add(BookApi.findBooksBySearch("java").get(0));
			books.add(BookApi.findBooksBySearch("c++").get(1));
			training.setBooks(books);
			Calendar calendar = new GregorianCalendar(2017, 11, 5, 12, 30);
			training.setDate(calendar);
			training.setDescription("This is a test");
			Location location = new Location();
			location.setAddress("170 nijverheidskaai brussels belgium");
			location.formatAddress();
			training.setLocation(location);
			training.setName("test");
			Set<Employee> participants = new HashSet<Employee>();
			Employee e = new Employee(57, "Robrecht", "admin");
			Set<Certification> certifications = new HashSet<Certification>();
			certifications.add(new Certification("test", "testcertification", EncodeImage.encode("C:\\Users\\Robrecht Blancquaert\\Documents\\SoftwareProject17-18\\project\\documents\\UML.png"), calendar));
			e.setCertifications(certifications);
			participants.add(e);
			participants.add(new Employee(20187, "Scott", "user"));
			training.setParticipants(participants);
			Set<Survey> surveys = new HashSet<Survey>();
			Survey survey = new Survey("testsurvey");
			survey.setEmployeeid(57);
			surveys.add(survey);
			training.setSurveys(surveys);
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

package gui;

import java.time.LocalDate;
import java.time.Period;

import javafx.beans.property.SimpleStringProperty;
import javafx.scene.image.Image;

//DUMMY DATA VOOR TABEL
public class Person {
	private SimpleStringProperty firstName, lastName, departement, function;
	private LocalDate birthday,joinedDate;
	private Image photo;
	
	
	public Person(String firstName, String lastName, LocalDate birthday,String departement, String function, LocalDate joinedDate) {
		super();
		this.firstName = new SimpleStringProperty(firstName);
		this.lastName = new SimpleStringProperty(lastName);
		this.birthday = birthday;
		this.departement = new SimpleStringProperty(departement);
		this.function = new SimpleStringProperty(function);
		this.joinedDate = joinedDate;
		//photo = new Image("@../../../../../../Desktop/softproject/imageplaceholder.png");
	}
	
	
	public Person(String firstName, String lastName, LocalDate birthday,String departement, String function, LocalDate joinedDate, Image photo) {
		super();
		this.firstName = new SimpleStringProperty(firstName);
		this.lastName = new SimpleStringProperty(lastName);
		this.birthday = birthday;
		this.departement = new SimpleStringProperty(departement);
		this.function = new SimpleStringProperty(function);
		this.joinedDate = joinedDate;
		//this.photo = photo;
	}
	
	//source Jaret Wright
		public Image getImage()
		{
			return photo;
		}
		//source Jaret Wright
		public void setImage(Image newPicture)
		{
			this.photo = newPicture;
		}

	public String getFirstName() {
		return firstName.get();
	}

	public void setFirstName(SimpleStringProperty firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName.get();
	}

	public String getDepartement() {
		return departement.get();
	}

	public void setDepartement(SimpleStringProperty departement) {
		this.departement = departement;
	}

	public String getFunction() {
		return function.get();
	}

	public void setFunction(SimpleStringProperty function) {
		this.function = function;
	}

	public LocalDate getJoinedDate() {
		return joinedDate;
	}

	public void setJoinedDate(LocalDate joinedDate) {
		this.joinedDate = joinedDate;
	}

	public void setLastName(SimpleStringProperty lastName) {
		this.lastName = lastName;
	}

	public LocalDate getBirthday() {
		return birthday;
	}

	public void setBirthday(LocalDate birthday) {
		this.birthday = birthday;
	}
		
	public int getAge()
	{
		return Period.between(birthday, LocalDate.now()).getYears();
	}
	
	
	
	
	

}

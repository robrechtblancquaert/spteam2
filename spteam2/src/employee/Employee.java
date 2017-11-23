package employee;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import database.DatabaseObject;

public class Employee implements DatabaseObject{
	private int id;
	private String name;
	private String role;
	private Set<Certification> certifications = new HashSet<Certification>();
	
	public Employee() {}
	public Employee(int id, String name, String role) {
		super();
		this.name = name;
		this.role = role;
		this.id = id;
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
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public Set<Certification> getCertifications() {
		return certifications;
	}
	public void setCertifications(Set<Certification> certifications) {
		this.certifications = certifications;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
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
		Employee other = (Employee) obj;
		if (id != other.id)
			return false;
		return true;
	}
	
	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", role=" + role + ", certifications=" + certifications + "]";
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

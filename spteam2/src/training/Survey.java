package training;

import java.io.Serializable;

import database.DatabaseObject;

public class Survey implements DatabaseObject{
	private int id;
	private String content;
	private int employeeid;
	
	public Survey() {}
	public Survey(String content) {
		super();
		this.content = content;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public int getEmployeeid() {
		return employeeid;
	}
	public void setEmployeeid(int employeeid) {
		this.employeeid = employeeid;
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
		Survey other = (Survey) obj;
		if (id != other.id)
			return false;
		return true;
	}
	
	@Override
	public String toString() {
		return "Survey [id=" + id + ", content=" + content + ", employeeid=" + employeeid + "]";
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

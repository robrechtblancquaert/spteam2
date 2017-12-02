package database;

import java.io.Serializable;

public interface DatabaseObject {
	public abstract Serializable getSId();
	public abstract void setSId(Serializable id);
}

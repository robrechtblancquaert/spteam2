package gui;

public class DuplicateControllerException extends Exception {

	public DuplicateControllerException() {
		super("Cannot create more than one instance of this controller.");
	}

}

package gui;

public abstract class Controller {
	public abstract void start();
	public abstract void refresh();
	public void stop() {
		MainController.get().removeController(this);
	}
}

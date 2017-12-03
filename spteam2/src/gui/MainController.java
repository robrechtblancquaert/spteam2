package gui;

import java.util.HashSet;

public class MainController {
	private static MainController mc = null;
	private MainController() {}
	public static MainController get() {
		if(mc == null) mc = new MainController();
		return mc;
	}
	
	private HashSet<Controller> controllers = new HashSet<Controller>();
	
	public void addController(Controller c) {
		controllers.add(c);
		c.start();
	}
	public void removeController(Controller c) {
		controllers.remove(c);
	}
}

import java.awt.EventQueue;
import main.view.Main;
// import main.view.components.InterfaceWithAppbar;

public class App {

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main frame = new Main("Course stack");
					// Main.setContent(new InterfaceWithAppbar());
					frame.setVisible(true);

				} catch (Exception e) {
					e.printStackTrace();
				}

			}
		});
	}
}
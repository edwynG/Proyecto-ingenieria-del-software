import java.awt.EventQueue;

import main.view.Main;

public class App {

	public static void main(String[] args) {

		EventQueue.invokeLater(new Runnable() {
			// se utiliza para asegurar que las actualizaciones de la interfaz de usuario
			// se realicen en el hilo de despacho de eventos (EDT)correcto.
			public void run() {
				try {
					Main frame = new Main("Course stack");
					frame.setVisible(true);

				} catch (Exception e) {
					e.printStackTrace();
				}

			}
		});
	}
}
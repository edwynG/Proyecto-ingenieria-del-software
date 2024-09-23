package main.view.components.proponentComponents.Components;

import javax.swing.JOptionPane;

import main.view.Main;
import main.view.components.InterfaceWithAppbar;

public class ActionsProponent {
    public void actionsButtonViewMore() {
        JOptionPane.showMessageDialog(Main.WINDOW, "Datos no disponibles", "Ver más", JOptionPane.INFORMATION_MESSAGE);
    }

    public void actionsButtonCourseWithAval() {
        JOptionPane.showMessageDialog(Main.WINDOW, "Lo sentimos opción no disponible.", "Cursos con aval",
                JOptionPane.INFORMATION_MESSAGE);
    }

    public void actionsButtonCourseFormulation() {
        InterfaceWithAppbar.ProponentDesing.createCourseFormulation();
    }

    public void actionsSubmitProposal() {
        JOptionPane.showMessageDialog(Main.WINDOW, "Lo sentimos opción no disponible.", "Formulación de curso", JOptionPane.INFORMATION_MESSAGE);
    }
}

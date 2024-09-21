package main.view.components.proponentComponents.Components;

import javax.swing.JOptionPane;

import main.view.Main;

public class ActionsProponent {
    public void ButtonViewMore() {
        JOptionPane.showMessageDialog(Main.WINDOW, "Datos no disponibles", "Ver más", JOptionPane.INFORMATION_MESSAGE);
    }

    public void actionsButtonCourseWithAval() {
        JOptionPane.showMessageDialog(Main.WINDOW, "Lo sentimos opción no disponible.", "Cursos con aval",
                JOptionPane.INFORMATION_MESSAGE);
    }

    public void actionsButtonProposeCourse() {
        JOptionPane.showMessageDialog(Main.WINDOW, "Lo sentimos opción no disponible.", "Proponer curso",
                JOptionPane.INFORMATION_MESSAGE);
    }
}

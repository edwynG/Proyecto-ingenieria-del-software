package main.view.components.proponentComponents;

import javax.swing.JOptionPane;

import main.view.Main;
import main.view.components.InterfaceWithAppbar;
import main.view.components.proponentComponents.Components.viewMorePanelComponents.ViewMorePanel;
import raven.glasspanepopup.GlassPanePopup;

public class ActionsProponent {
    public void actionsButtonViewMore() {
        GlassPanePopup.showPopup(new ViewMorePanel());
    }

    public void actionsButtonCourseWithAval() {
        InterfaceWithAppbar.ProponentDesing.createCourseWithAval();

    }

    public void actionsButtonCourseFormulation() {
        InterfaceWithAppbar.ProponentDesing.createCourseFormulation();
    }

    public void actionsSubmitProposal() {
        JOptionPane.showMessageDialog(Main.WINDOW, "Lo sentimos opción no disponible.", "Formulación de curso",
                JOptionPane.INFORMATION_MESSAGE);
    }

    public void actionsDownload() {
        JOptionPane.showMessageDialog(Main.WINDOW, "Lo sentimos opción no disponible.", "Descarga",
                JOptionPane.INFORMATION_MESSAGE);
    }

    public void actionsUploadDocument() {
        JOptionPane.showMessageDialog(Main.WINDOW, "Lo sentimos opción no disponible.", "Carga de documento",
                JOptionPane.INFORMATION_MESSAGE);
    }
}

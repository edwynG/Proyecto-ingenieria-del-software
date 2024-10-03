package main.view.components.proponentComponents;

import java.util.ArrayList;

import javax.swing.JOptionPane;

import main.view.Main;
import main.view.components.InterfaceWithAppbar;
import main.view.components.commonComponents.ActionsInterface;
import main.view.components.commonComponents.CardMessage;
import main.view.components.proponentComponents.Components.viewMorePanelComponents.ViewMorePanel;
import raven.glasspanepopup.GlassPanePopup;

public class ActionsProponent extends ActionsInterface {

    public void actionsButtonViewMore() {
        GlassPanePopup.showPopup(new ViewMorePanel());
    }

    public void actionsButtonCourseWithAval() {
        InterfaceWithAppbar.ProponentDesing.createCourseWithAval();

    }

    public void actionsButtonCourseFormulation() {
        InterfaceWithAppbar.ProponentDesing.createCourseFormulation();
    }

    public void actionsSubmitProposal(ArrayList<String> data) {
        if (!isValidData(data)) {
            return;
        }
        if (Main.getUserControl().proposeCourse(data)) {
            CardMessage pane = new CardMessage("Propuesta exitosa!!", "Se ha realizado la propuesta.");
            pane.settWidthCard(400);
            pane.setHeightCard(240);
            GlassPanePopup.showPopup(pane);
            return;
        }
        CardMessage pane = new CardMessage("Hubo un problema", "Lo sentimos, no se pudo registrar la propuesta.");
        pane.settWidthCard(400);
        pane.setHeightCard(240);
        GlassPanePopup.showPopup(pane);
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

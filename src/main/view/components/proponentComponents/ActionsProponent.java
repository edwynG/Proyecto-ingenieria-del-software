package main.view.components.proponentComponents;

import java.awt.Color;
import java.util.ArrayList;

import main.Env;
import main.view.Main;
import main.view.components.InterfaceWithAppbar;
import main.view.components.commonComponents.ActionsInterface;
import main.view.components.commonComponents.CardMessage;
import main.view.components.proponentComponents.Components.viewMorePanelComponents.ViewMorePanel;
import raven.glasspanepopup.GlassPanePopup;

public class ActionsProponent extends ActionsInterface {

    @Override
    public void actionsUploadDocument(Integer id, String path, String type) {
        if (path == null || type == null || id == null) {
            return;
        }
        Boolean status = false;
        System.out.println(path);
        switch (type) {
            case Env.TYPE_UPLOAD_COSTOS:
                status = Main.getProponentControl().uploadDocumentCostos(id, path);
                break;
            case Env.TYPE_UPLOAD_SCHEDULE:
                status = Main.getProponentControl().uploadDocumentSchedule(id, path);
                break;
            case Env.TYPE_UPLOAD_LETTER_OF_COMMITENT:
                status = Main.getProponentControl().uploadDocumentLetterOfCommitment(id, path);
                break;
            case Env.TYPE_UPLOAD_LETTER_OF_INTENT:
                status = Main.getProponentControl().uploadDocumentLetterOfIntent(id, path);
                break;

            default:
                break;
        }

        if (!status) {
            CardMessage pane = new CardMessage("Lo sentimos", "No se pudo subir el archivo.");
            pane.setColorTitle(Color.RED);
            GlassPanePopup.showPopup(pane);
            return;
        }
        CardMessage pane = new CardMessage("Actualizado", "Archivo subido exitosamente.");
        pane.setColorTitle(Color.GREEN);
        GlassPanePopup.showPopup(pane);

    }

    public void actionsButtonViewMore(Integer id) {
        GlassPanePopup.showPopup(new ViewMorePanel(id));
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
        if (Main.getProponentControl().proposeCourse(data)) {
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

}

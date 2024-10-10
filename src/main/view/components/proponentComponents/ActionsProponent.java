package main.view.components.proponentComponents;

import java.awt.Color;
import java.util.ArrayList;

import main.Env;
import main.view.Main;
import main.view.components.InterfaceWithAppbar;
import main.view.components.commonComponents.ActionsInterface;
import main.view.components.proponentComponents.Components.viewMorePanelComponents.ViewMorePanel;
import raven.glasspanepopup.GlassPanePopup;

public class ActionsProponent extends ActionsInterface {

    @Override
    public void actionsUploadDocument(Integer id, String path, String type) {
        if (path == null || type == null || id == null) {
            return;
        }
        
        Boolean status = false;
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
            informationPanePopup("Lo sentimos", "No se pudo subir el archivo.");
            return;
        }
        informationPanePopup("Actualizado", "Archivo subido exitosamente.", Color.GREEN);

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
        Integer width = 400;
        Integer heigth = 240;
        if (Main.getProponentControl().proposeCourse(data)) {
            informationPanePopup("Propuesta exitosa!!", "Se ha realizado la propuesta.",Color.GREEN, width, heigth);
            InterfaceWithAppbar.ProponentDesing.createCourseFormulation();
            return;
        }
        informationPanePopup("Hubo un problema", "Lo sentimos, no se pudo registrar la propuesta.",  width, heigth);

    }

}

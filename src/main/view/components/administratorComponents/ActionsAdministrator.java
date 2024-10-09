package main.view.components.administratorComponents;

import java.awt.Color;

import main.Env;
import main.view.Main;
import main.view.components.commonComponents.ActionsInterface;
import main.view.components.commonComponents.CardMessage;
import raven.glasspanepopup.GlassPanePopup;

public class ActionsAdministrator extends ActionsInterface {

    public void evaluateProposal(Integer id, String result) {
        Main.getAdminControl().evaluateProposal(id, result);
    }

    @Override
    public void actionsUploadDocument(Integer id, String path, String type) {
        Boolean status = false;
        switch (type) {
            case Env.DOCUMENT_OBSERATIONS:
                status = Main.getAdminControl().uploadObservations(id, path);
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
}

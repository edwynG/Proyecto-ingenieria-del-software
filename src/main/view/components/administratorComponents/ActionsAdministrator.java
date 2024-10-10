package main.view.components.administratorComponents;

import java.awt.Color;

import main.Env;
import main.view.Main;
import main.view.components.commonComponents.ActionsInterface;

public class ActionsAdministrator extends ActionsInterface {

    public void evaluateProposal(Integer id, String result) {
        if (wasEvaluated(id)) {
            return;
        }
        if (Main.getAdminControl().evaluateProposal(id, result)) {
            informationPanePopup("Actualizado", "La evaluación ha sido exisitosa.", Color.GREEN);
            return;
        }
        informationPanePopup("Lo sentimos", "No se pudo evaluar la propuesta.", Color.RED);
    }

    @Override
    public void actionsUploadDocument(Integer id, String path, String type) {
        if (wasEvaluated(id)) {
            return;
        }
        Boolean status = false;
        switch (type) {
            case Env.TYPE_UPLOAD_OBSERVATIONS:
                status = Main.getAdminControl().uploadObservations(id, path);
                break;

            default:
                break;
        }

        if (!status) {
            informationPanePopup("Lo sentimos", "No se pudo subir el archivo.", Color.RED);
            return;
        }
        informationPanePopup("Actualizado", "Archivo subido exitosamente.", Color.GREEN);

    }

    private boolean wasEvaluated(Integer id) {
        if (Main.getAdminControl().getValidator().isValidEvaluate(id, Main.getAdminControl().getUser().getId())) {
            return false;
        }
        informationPanePopup("Lo sentimos", "Propuesta evaluada por otro administrador", Color.RED);
        return true;

    }

    
}

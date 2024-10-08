package main.view.components.commonComponents;

import java.awt.Color;
import java.util.ArrayList;
import main.controller.abstractControllers.AbstractUserControl;
import main.model.abstractModels.User;
import main.view.Main;
import main.view.utils.ColorPalette;
import raven.glasspanepopup.GlassPanePopup;

public class ActionsInterface {

    public void actionsDownload(String path, String fileBase64) {
        if (path == null) {
            return;
        }
        if (fileBase64 == null || fileBase64.isEmpty()) {
            CardMessage pane = new CardMessage("Sin documento", "No se han añadido comentarios.");
            pane.setColorTitle(ColorPalette.COLOR_TITLE);
            GlassPanePopup.showPopup(pane);
            return;
        }
        AbstractUserControl user = Main.getAdminControl() == null ? Main.getProponentControl() : Main.getAdminControl();
        user.getTransformfile().transformToFile(fileBase64, path);
        CardMessage pane = new CardMessage("Descargado", "La descarga fue exitosa!!.");
        pane.setColorTitle(Color.green);
        GlassPanePopup.showPopup(pane);
    }

    public void actionsUploadDocument(Integer id, String path, String type) {
        if (path == null || type == null || id == null) {
            return;
        }
        GlassPanePopup.showPopup(new CardMessage("Lo sentimos..", "Esta función no esta disponible."));
    }

    public boolean isValidUser(User user, String titleToIsNotValid, String MessageToIsNotValid) {
        if (user == null) {
            GlassPanePopup.showPopup(
                    new CardMessage(titleToIsNotValid, MessageToIsNotValid));
            return false;
        }
        return true;
    }

    public boolean isValidData(ArrayList<String> data) {
        if (!isValidInput(data)) {
            GlassPanePopup.showPopup(new CardMessage("Oops..", "Aún faltan datos por completar."));
            return false;
        }

        return true;
    }

    private boolean isValidInput(ArrayList<String> data) {
        for (String str : data) {
            if (str == null) {
                return false;
            }
        }

        for (String str : data) {
            if (str.isEmpty()) {
                return false;
            }
        }

        return true;
    }
}

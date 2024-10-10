package main.view.components.commonComponents;

import java.awt.Color;
import java.util.ArrayList;

import main.controller.Validator;
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
            informationPanePopup("Sin documento", "No se han añadido comentarios.", ColorPalette.COLOR_TITLE);
            return;
        }
        AbstractUserControl user = Main.getAdminControl() == null ? Main.getProponentControl() : Main.getAdminControl();
        user.getTransformfile().transformToFile(fileBase64, path);
        informationPanePopup("Descargado", "La descarga fue exitosa!!.", Color.GREEN);
    }

    public void actionsUploadDocument(Integer id, String path, String type) {
        if (path == null || type == null || id == null) {
            return;
        }
        informationPanePopup("Lo sentimos..", "Esta función no esta disponible.");
    }

    public boolean isValidUser(User user, String titleToIsNotValid, String MessageToIsNotValid) {
        if (user == null) {
            informationPanePopup(titleToIsNotValid, MessageToIsNotValid);
            return false;
        }
        return true;
    }

    public boolean isValidData(ArrayList<String> data) {
        if (!isValidInput(data)) {
            informationPanePopup("Oops..", "Aún faltan datos por completar.", Color.RED);
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

    public void informationPanePopup(String title, String message) {
        CardMessage pane = new CardMessage(title, message);
        GlassPanePopup.showPopup(pane);
    }

    public void informationPanePopup(String title, String message, Color color) {
        CardMessage pane = new CardMessage(title, message);
        pane.setColorTitle(color);
        GlassPanePopup.showPopup(pane);
    }

    public void informationPanePopup(String title, String message, Integer width, Integer heigth) {
        CardMessage pane = new CardMessage(title, message);
        pane.settWidthCard(width);
        pane.setHeightCard(heigth);
        GlassPanePopup.showPopup(pane);
    }

    public void informationPanePopup(String title, String message, Color color, Integer width, Integer heigth) {
        CardMessage pane = new CardMessage(title, message);
        pane.setColorTitle(color);
        pane.settWidthCard(width);
        pane.setHeightCard(heigth);
        GlassPanePopup.showPopup(pane);
    }

    public boolean isThisValidEmail(String email) {
        if (new Validator().isThisValidEmail(email)) {
            return true;
        }
        informationPanePopup("Email invalido", "No es un email.");
        return false;

    }

    public boolean isThisValidPassword(String password) {
        if (new Validator().isThisValidPassword(password)) {
            return true;
        }
        informationPanePopup("Contraseña invalida", "Debe tener entre 5 a 20 caracteres alfanumericos.", 400, 240);
        return false;
    }

    public boolean isNumber(String str) {
        if (new Validator().isNumber(str)) {
            return true;
        }
        informationPanePopup("CI invalido", "El id debe ser un numero y tener de 5 a 9 cifras.",380,240);
        return false;
    }
}

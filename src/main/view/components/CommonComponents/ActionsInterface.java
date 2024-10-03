package main.view.components.commonComponents;

import java.util.ArrayList;

import main.model.abstractModels.User;
import raven.glasspanepopup.GlassPanePopup;

public class ActionsInterface {

       public boolean isValidUser(User user,String titleToIsNotValid, String MessageToIsNotValid) {
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

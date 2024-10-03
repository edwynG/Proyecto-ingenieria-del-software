package main.controller;

import java.util.ArrayList;

import main.Env;
import main.controller.abstractControllers.UserControl;
import main.model.abstractModels.User;

public class ProponentControl extends UserControl {

    public ProponentControl(User user) {
        super(user);
    }

    @Override
    public boolean proposeCourse(ArrayList<String> data) {
        ArrayList<String> preparedListToQuery = getTransformfile().tranformToBaseOnlyWidthExt(data,"'");
        String query = String.format(Env.QUERY_REGISTER_PROPOSAL, String.join(",", preparedListToQuery));
        return getManagerDatabase().updateOrInsertData(query);
    }

}

package main.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import main.Env;
import main.controller.abstractControllers.UserControl;
import main.model.TransformFileBinary;
import main.model.abstractModels.User;

public class ProponentControl extends UserControl {

    public ProponentControl(User user) {
        super(user);
    }

    @Override
    public boolean proposeCourse(Map<String, String> form) {
        TransformFileBinary transform = new TransformFileBinary();
        List<String> fields = new ArrayList<>(form.keySet());
        List<String> paths = new ArrayList<>(form.values());
        List<String> registers = new ArrayList<>();

        List<String> ignore = Arrays.asList("Denominacion".toUpperCase(),"TipoDeAdministrador".toUpperCase());
       for (int i = 0; i < fields.size(); i++) {
            String temp = paths.get(i);
            if (!ignore.contains(fields.get(i).toUpperCase())) {
                temp = transform.transformToBase(temp);
            }                
            registers.add(temp);
       }

        String query = String.format(Env.QUERY_REGISTER_PROPOSAL,  "ProponenteID" +","+String.join(",", fields),this. user.getId() +","+ String.join(",", registers));

        return this.managerDatabase.updateOrInsertData(query);

    }
}

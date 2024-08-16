package main.controller;

import java.util.List;
import java.util.Map;
import java.util.ArrayList;

import main.Env;
import main.model.ManagerDatabase;
import main.model.User;

public class SesionControl {
    private User user;
    private ManagerDatabase managerDatabase;

    public SesionControl() {
        this.user = null;
        this.managerDatabase = ManagerDatabase.getManagerDatabase();

    }

    public User loginUser(String email, String password) {
        List<List<String>> registro = this.managerDatabase.getData(String.format(Env.QUERY_LOGIN, email, password));
        if (!registro.isEmpty()) {
            List<String> fields = registro.get(0);
            this.user = new User(Integer.parseInt(fields.get(0)), fields.get(1), fields.get(2), fields.get(3),
                    fields.get(4));
        }
        return this.user;
    }

    public boolean doesTheDataExist(String campo, String dato) {
        return this.managerDatabase.isThereDataInTheQuery(String.format(Env.QUERY_VALIDATE_DATA, campo, dato));
    }

    public User registerProponent(Map<String, String> personalDate, Map<String, String> personalDocument) {
        List<String> fieldsUser = new ArrayList<>(personalDate.keySet());
        List<String> dataUser = new ArrayList<>(personalDate.values());
        List<String> fieldsDocument = new ArrayList<>(personalDocument.keySet());
        List<String> dataDocument = new ArrayList<>(personalDocument.values());

        String user = String.format(Env.QUERY_REGISTER_USER, String.join(",", fieldsUser), String.join(",", dataUser));
        
        String documents = String.format(Env.QUERY_REGISTER_DOCUMENT, "ProponenteID" + "," + String.join(",", fieldsDocument), personalDate.get("ProponenteID") + "," + String.join(",", dataDocument));

        String query = user + documents;
        boolean singIn = managerDatabase.updateOrInsertData(query);

        if (singIn) {
            this.user = new User(Integer.parseInt(personalDate.get("ProponenteID")),personalDate.get("Correo"),personalDate.get("Contraseña"),"Proponente",personalDate.get("TipoDePersona"));
        }
        return this.user;
    };

    public User registerAdmin(Map<String, String> personalDate) {
        List<String> fieldsUser = new ArrayList<>(personalDate.keySet());
        List<String> dataUser = new ArrayList<>(personalDate.values());

        String admin = String.format(Env.QUERY_REGISTER_ADMIN, String.join(",", fieldsUser),String.join(",", dataUser));

        boolean singIn = managerDatabase.updateOrInsertData(admin);

        if (singIn) {
            this.user = new User(Integer.parseInt(personalDate.get("AdministradorID")),personalDate.get("Correo"),personalDate.get("Contraseña"),"Administrador",personalDate.get("TipoDeAdministrador"));
        }
        return this.user;

    }

}

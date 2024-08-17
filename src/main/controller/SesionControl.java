package main.controller;

import java.util.List;
import java.util.Map;
import java.util.ArrayList;

import main.Env;
import main.model.Administrator;
import main.model.ManagerDatabase;
import main.model.Proponent;
import main.model.User;

public class SesionControl {
    private User user;
    private ManagerDatabase managerDatabase;

    public SesionControl() {
        this.user = null;
        this.managerDatabase = ManagerDatabase.getManagerDatabase();
    }

    public User loginUser(String email, String password, String type) {
        String query = Env.QUERY_LOGIN;
        boolean option = type.equalsIgnoreCase("Proponente");

        String table = option ? "Proponentes" : "Administradores";
        query = String.format(query, table, email, password);
      
        List<List<String>> registro = this.managerDatabase.getData(query);
        if (!registro.isEmpty()) {
            List<String> fields = registro.get(0);

            if (option) {
                this.user = new Proponent(Integer.parseInt(fields.get(0)), fields.get(1), fields.get(2), fields.get(3),"Proponente");

            } else {
                this.user = new Administrator(Integer.parseInt(fields.get(0)), fields.get(1), fields.get(2), fields.get(3), "Administrador");

            }
        }

        return this.user;
    }

    public User registerProponent(Map<String, String> data, Map<String, String> documents) {
        List<String> fieldsUser = new ArrayList<>(data.keySet());
        List<String> dataUser = new ArrayList<>(data.values());
        List<String> fieldsDocument = new ArrayList<>(documents.keySet());
        List<String> dataDocument = new ArrayList<>(documents.values());

        String user = String.format(Env.QUERY_REGISTER_USER, String.join(",", fieldsUser), String.join(",", dataUser));

        String document = String.format(Env.QUERY_REGISTER_DOCUMENT,
                "ProponenteID" + "," + String.join(",", fieldsDocument),
                data.get("ProponenteID") + "," + String.join(",", dataDocument));

        String query = user + document;
        boolean singIn = managerDatabase.updateOrInsertData(query);

        if (singIn) {
            this.user = new Proponent(Integer.parseInt(data.get("ProponenteID")), data.get("Correo"),
                    data.get("Contraseña"), "Proponente", data.get("TipoDePersona"));
        }

        return this.user;
    };

    public User registerAdmin(Map<String, String> data) {
        List<String> fieldsUser = new ArrayList<>(data.keySet());
        List<String> dataUser = new ArrayList<>(data.values());

        String admin = String.format(Env.QUERY_REGISTER_ADMIN, String.join(",", fieldsUser),
                String.join(",", dataUser));

        boolean singIn = managerDatabase.updateOrInsertData(admin);
        if (singIn) {
            this.user = new Administrator(Integer.parseInt(data.get("AdministradorID")), data.get("Correo"),
                    data.get("Contraseña"), "Administrador", data.get("TipoDeAdministrador"));
        }

        return this.user;

    }

}

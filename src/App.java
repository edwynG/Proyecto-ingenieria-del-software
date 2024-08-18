import main.controller.AdministratorControl;
import main.controller.SesionControl;
import main.controller.UserControl;
import main.model.User;

import java.util.HashMap;
import java.util.Map;

public class App {
    public static void main(String[] args) throws Exception {
     
        SesionControl user = new SesionControl();
        Map<String, String> datos = new HashMap<>();
        Map<String, String> document = new HashMap<>();

        datos.put("Correo", "'Edwyn@gmail.com'");
        datos.put("Contraseña", "12345");
        datos.put("ProponenteID", "33564312");
        datos.put("TipoDePersona", "'Natural'");

        document.put("RIF", "'RIF'");
        document.put("ISLR", "'ISLR'");
        document.put("Curriculum", "'Curriculum'");
        document.put("TituloUniversitario", "'TituloUniversitario'");
        document.put("RegistroMercantil", "'RegistroMercantil'");

        if (user.registerProponent(datos, document) != null) {
            System.out.println("Usuario registrado");
        } else {
            System.err.println("Usuario no registrado");
        }
        datos.clear();
        datos.put("Correo", "'Edwynjesus30@gmail.com'");
        datos.put("Contraseña", "12345");
        datos.put("AdministradorID", "30326271");
        datos.put("TipoDeAdministrador", "'DU'");
        User admin = user.registerAdmin(datos);
        if (admin != null) {
            System.out.println("Usuario registrado");
            if (user.loginUser("Edwyn@gmail.com", "12345", "Proponente") != null) {
                System.out.println(String.format("Bienvenido a couser stack, %s", admin.getUser()));
            }
            UserControl control = new AdministratorControl(admin);
            System.out.println(control.getProposals());
        } else {
            System.err.println("Usuario no registrado");
        }
    }
}

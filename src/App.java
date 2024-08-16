import java.util.HashMap;
import java.util.Map;

import main.controller.SesionControl;

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
        if (user.registerAdmin(datos) != null) {
            System.out.println("Usuario registrado");
        } else {
            System.err.println("Usuario no registrado");
        }

    }
}

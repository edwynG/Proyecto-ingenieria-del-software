import java.util.HashMap;
import java.util.Map;

import main.controller.AdministratorControl;
import main.controller.ProponentControl;
import main.controller.SesionControl;
import main.model.User;

public class App {
    public static void main(String[] args) throws Exception {
        /*Registro de usuario */
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

        /*Inicio de sesión */
        User admin = user.loginUser("Edwynjesus30@gmail.com","12345","administrador");
        if (admin != null) {
            System.out.println("Administrador ha iniciado sesión");
            AdministratorControl adminControl = new AdministratorControl(admin);
            System.out.println(String.format("Bienvenido %s", adminControl.getUser().getUser()));
        }else{
            System.out.println("Lo sentimos Administrador,no se ha podido iniciar sesión");
        }
        
        User proponet = user.loginUser("Edwyn@gmail.com", "12345", "proponente");
        if (proponet != null) {
            System.out.println("Proponente ha iniciado sesión");
            ProponentControl proponentControl = new ProponentControl(proponet);
            System.out.println(String.format("Bienvenido %s", proponentControl.getUser().getUser()));
        }else{
            System.out.println("Lo sentimos Proponente,no se ha podido iniciar sesión");
        }
    }
}

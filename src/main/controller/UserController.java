package main.controller;

import java.io.File;
import java.util.Scanner;
import javax.swing.JOptionPane;

import main.view.*;

public class UserController {
    public boolean leer(String correo){
        // Fichero del que queremos leer        
		File leerBD = new File("src/main/BDD/bd.txt");
		Scanner s = null;

		try {
			// Leemos el contenido del fichero
			s = new Scanner(leerBD);

			// Leemos linea a linea el fichero
			while (s.hasNextLine()) {
				String dato = s.nextLine(); 	// Guardamos la linea en un String
                String verIU = selecInterfaz(dato, correo); //Obtiene el rol del usuario
                if(verIU != ""){ //Manda al usuario a su interfaz correspondiente
                    if(verIU.equalsIgnoreCase("deu")){
                        new DireccionExtension().setVisible(true);
                        return true;
                    }else if(verIU.equalsIgnoreCase("comision de extension")){
                        System.out.println("Entró");
                        new ComisionExtension().setVisible(true);
                        return true;
                    }else if(verIU.equalsIgnoreCase("consejo de facultad")){
                        new ConsejoDeFacultad().setVisible(true);
                        return true;
                    }else if(verIU.equalsIgnoreCase("coordinacion de extension")){
                        new Coordinacion().setVisible(true);
                        return true;
                    }else if(verIU.equalsIgnoreCase("natural")){
                        new PersonaNatura().setVisible(true);
                        return true;
                    }else if(verIU.equalsIgnoreCase("juridica")){
                        new PersonaJuridic().setVisible(true);
                        return true;
                    }
                }
			}

            JOptionPane.showMessageDialog(null, "Usuario no encontrado");
            return false;

		} catch (Exception ex) {
			System.out.println("Mensaje: " + ex.getMessage());
            return false;
		} finally {
			// Cerramos el fichero tanto si la lectura ha sido correcta o no
			try {
				if (s != null)
					s.close();
                    return false;
			} catch (Exception ex2) {
				System.out.println("Mensaje 2: " + ex2.getMessage());
			}
		}
    }

    public static String selecInterfaz(String dato, String correo){
        String[] array = dato.split(","); //Guarda strings en un array separando por ,
        
        // Recorrer el array para verificar el valor
        for (String element : array) {
            boolean contiene = element.equalsIgnoreCase(correo);
            if(contiene){
                return array[2];
            }
        }
        return "";
    }
}

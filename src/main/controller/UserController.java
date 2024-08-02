package main.controller;

import java.io.File;
import java.util.Scanner;
import javax.swing.JOptionPane;

import main.view.*;

public class UserController {
    public boolean leer(String correo){
        boolean valIU = false;
        // Fichero del que queremos leer        
		File leerBD = new File("src/main/BDD/bd.txt");
		Scanner s = null;

		try {
			// Leemos el contenido del fichero
			s = new Scanner(leerBD);

			// Leemos linea a linea el fichero
			while (s.hasNextLine()) {
                System.out.print("1");
				String dato = s.nextLine(); 	// Guardamos la linea en un String
                String verIU = selecInterfaz(dato, correo); //Obtiene el rol del usuario
                if(verIU != ""){ //Manda al usuario a su interfaz correspondiente
                    if(verIU.equalsIgnoreCase("deu")){
                        new DireccionExtension().setVisible(true);
                        valIU = true;
                        break;
                    }else if(verIU.equalsIgnoreCase("comision de extension")){
                        new ComisionExtension().setVisible(true);
                        valIU = true;
                        break;
                    }else if(verIU.equalsIgnoreCase("consejo de facultad")){
                        new ConsejoDeFacultad().setVisible(true);
                        valIU = true;
                        break;
                    }else if(verIU.equalsIgnoreCase("coordinacion de extension")){
                        new Coordinacion().setVisible(true);
                        valIU = true;
                        break;
                    }else if(verIU.equalsIgnoreCase("proponente")){
                        new ProponentView().setVisible(true);
                        valIU = true;
                        break;
                    }
                }
			}

            if(!valIU){
                JOptionPane.showMessageDialog(null, "Usuario no encontrado");
                return valIU;
            }

		} catch (Exception ex) {
			System.out.println("Mensaje: " + ex.getMessage());
            return valIU;
		} //finally {
			// Cerramos el fichero tanto si la lectura ha sido correcta o no
			/*try {
				if (s != null)
					s.close();
                    return valIU;
			} catch (Exception ex2) {
				System.out.println("Mensaje 2: " + ex2.getMessage());
			}*/
		//}
        return valIU;
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

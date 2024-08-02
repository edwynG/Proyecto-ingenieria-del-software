package main.controller;

import java.io.File;
import java.util.Scanner;
import javax.swing.JOptionPane;

import java.io.FileWriter;

import main.view.*;

public class UserController {
    public boolean leer(String correo, String pw){
        boolean valpw = false;
        boolean valIU = false;
        // Fichero del que queremos leer        
		File leerBD = new File("src/main/BDD/bd.txt");
		Scanner s = null;

		try {
			// Leemos el contenido del fichero
			s = new Scanner(leerBD);

			// Leemos linea a linea el fichero
			while (s.hasNextLine()) {
				String dato = s.nextLine(); 	// Guardamos la linea en un String
                String verIU = selecInterfaz(dato, correo, 2); //Obtiene el rol del usuario
                if(verIU != ""){ //Manda al usuario a su interfaz correspondiente
                    if(verIU.equalsIgnoreCase("deu")){
                        if(selecInterfaz(dato, pw, 3).equals(pw)){
                            new DireccionExtension().setVisible(true);
                            valIU = true;
                            break;
                        }
                    }else if(verIU.equalsIgnoreCase("comision de extension")){
                        if(selecInterfaz(dato, pw, 3).equals(pw)){
                            new ComisionExtension().setVisible(true);
                            valIU = true;
                            break;
                        }
                    }else if(verIU.equalsIgnoreCase("consejo de facultad")){
                        if(selecInterfaz(dato, pw, 3).equals(pw)){
                            new ConsejoDeFacultad().setVisible(true);
                            JOptionPane.showMessageDialog(null, "Contraseña incorrecta.");
                        }
                    }else if(verIU.equalsIgnoreCase("coordinacion de extension")){
                        if(selecInterfaz(dato, pw, 3).equals(pw)){
                            new Coordinacion().setVisible(true);
                            valIU = true;
                            break;
                        }
                    }else if(verIU.equalsIgnoreCase("proponente")){
                        if(selecInterfaz(dato, pw, 3).equals(pw)){
                            new ProponentView().setVisible(true);
                            valIU = true;
                            break;
                        }
                    }
                }
			}

            if(!valIU){
                JOptionPane.showMessageDialog(null, "Datos incorrectos.");
                return valIU;
            }

		} catch (Exception ex) {
			System.out.println("Mensaje: " + ex.getMessage());
            return valIU;
		}
        return valIU;
    }

    public static String selecInterfaz(String dato, String comparar, int i){
        String[] array = dato.split(","); //Guarda strings en un array separando por ,
        
        // Recorrer el array para verificar el valor
        for (String element : array) {
            boolean contiene = element.equalsIgnoreCase(comparar);
            if(contiene){
                return array[i];
            }
        }
        return "";
    }

    public static void escribir(String[] datos){
        /** FORMA 1 DE ESCRITURA **/
        FileWriter guardarDB = null;
        try {
    
            guardarDB = new FileWriter("src/main/BDD/bd.txt", true);
    
            // Escribimos linea a linea en el fichero
            for (String dato : datos) {
                guardarDB.write(dato + "\n");
            }
    
            guardarDB.close();
    
        } catch (Exception ex) {
            System.out.println("Mensaje de la excepción: " + ex.getMessage());
        }
    }
}

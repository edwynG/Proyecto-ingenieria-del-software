package main.model;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Base64;

import main.Env;

public class TransformFileBinary {

    public String transformToBase(String path) {
        String base64 = "";
        try {
            // Convertir la cadena Base64 a un arreglo de bytes
            byte[] filebytes = readFileAsBytes(path);
            // Convierte el arreglo de bytes en a base64
            base64 = convertBytesToBase64(filebytes);
            return base64.trim().replaceAll("\\s+", "");
        } catch (IOException e) {
            System.out.println("Error al convertir el archivo a Base64: ");
            return null;
        }
    }

    public boolean transformToFile(String base64, String route) {
        byte[] fileBytes = null;
        try {
            // Convertir la cadena Base64 a un arreglo de bytes
            fileBytes = convertBase64ABytes(base64);
            // Guardar los bytes en un archivo en la ubicación de destino
            return this.saveBytesAsFile(fileBytes, route);
        } catch (Exception e) {
            System.out.println("Error al convertir la cadena Base64 a un archivo");
            return false;

        }
    }

    private boolean saveBytesAsFile(byte[] bytes, String route) {
        try {
            Path destinationPath = Path.of(route);
            Files.write(destinationPath, bytes);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    private byte[] readFileAsBytes(String pathFile) throws IOException {
        File file = new File(pathFile);
        byte[] buffer = new byte[(int) file.length()];
        FileInputStream fis = new FileInputStream(file);
        fis.read(buffer);
        fis.close();
        return buffer;
    }

    private byte[] convertBase64ABytes(String base64) {
        return Base64.getDecoder().decode(base64);
    }

    private String convertBytesToBase64(byte[] bytes) {
        return Base64.getEncoder().encodeToString(bytes);
    }

    public ArrayList<String> tranformToBaseOnlyWidthExt(ArrayList<String> data, String serialization) {
        ArrayList<String> newList = new ArrayList<>();
        boolean state = true;
        for (String item : data) {
            for (String ext : Env.EXTESIONS_EXT) {
                if (item.contains(ext)) {
                    state = false;
                    newList.add(serialization + transformToBase(item) + serialization);
                    break;
                }
            }

            if (state) {
                if (isNumber(item))
                    newList.add(item);
                else
                    newList.add(serialization + item + serialization);

            }
            state = true;
        }
        return newList;
    }

    private boolean isNumber(String str) {
        try {
            Integer.parseInt(str);
            return true;
        } catch (Exception e) {

        }
        return false;
    }

}

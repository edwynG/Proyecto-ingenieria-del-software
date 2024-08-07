package main.model;

import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class AccessDatabase {
    private String path = "";
    private static Connection db = null;
    private static AccessDatabase singletonDb = null;

    private AccessDatabase(String path) {
        this.path = path;
        File file = new File(path);

        if (file.exists()) {
            System.out.println("Listo!!, Active su conexión a la base de datos.");

        } else {

            System.err.println("Fallo!!, No existe la base de datos.");
            System.out.println("Creando base de datos..");
            createDatabase(path);
            System.out.println("Listo!!, Active su conexión a la base de datos.");

        }

    };

    public static AccessDatabase getSingletonAccess(String path) {
        if (singletonDb == null) {
            singletonDb = new AccessDatabase(path);
        }
        return singletonDb;
    }

    private boolean createDatabase(String path) {
        File file = new File(path);
        new File(EnvConstant.PATH_DATABASE).mkdirs();
      try {
        if (file.createNewFile()) {
            System.out.println("base de datos creada.");
            return true;
        }

      } catch (IOException e) {
      }
        return false;
    }

    public Connection openConnection() {
        try {
            if (db == null || db.isClosed()) {
                db = DriverManager.getConnection("jdbc:sqlite:" + this.path);
            }
        } catch (SQLException e) {
            db = null;
        }
        return db;
    }

    public boolean closeConnection() {
        boolean option = false;
        try {
            if (db != null && !db.isClosed()) {
                db.close();
                option = true;
            }
        } catch (SQLException e) {
            option = false;
        }
        return option;
    }

}

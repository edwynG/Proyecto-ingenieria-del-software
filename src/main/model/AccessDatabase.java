package main.model;

import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import main.Env;

public class AccessDatabase {
    private String sorucePath;
    private Connection db = null;
    private static AccessDatabase singletonDb = null;

    private AccessDatabase(String path, String name) {
        this.sorucePath = path + name;
        File file = new File(path + name);

        if (!file.exists()) {
            System.err.println("Fallo!!, No existe la base de datos.");
            System.out.println("Creando base de datos..");
            createDatabase(path, name);
        }

        System.out.println("Listo!!, Active su conexión a la base de datos.");

    };

    public static AccessDatabase getAccessDatabase(String path, String name) {
        if (singletonDb == null) {
            singletonDb = new AccessDatabase(path, name);
        }
        return singletonDb;
    }

    private boolean createDatabase(String path, String name) {
        File file = new File(path + name);
        new File(path).mkdirs();
        try {
            if (file.createNewFile()) {
                this.createTablesDatabase(Env.CREATE_DATABASE);
                System.out.println("base de datos creada.");
                return true;
            }

        } catch (IOException e) {
            System.err.println("No se pudo crear la base de datos.");
        }
        return false;
    }

    private boolean createTablesDatabase(String query) {
        boolean isSuccess = true;
        Connection conn = this.openConnection();
        Statement statement = null;

        try {
            statement = conn.createStatement();
            statement.executeUpdate(query);

        } catch (SQLException e) {
            isSuccess = false;

        } finally {

            try {
                if (statement != null) {
                    statement.close();
                }
            } catch (SQLException e) {

            }

        }

        this.closeConnection();
        return isSuccess;
    }

    public Connection openConnection() {
        try {
            if (db == null || db.isClosed()) {
                db = DriverManager.getConnection("jdbc:sqlite:" + this.sorucePath);
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

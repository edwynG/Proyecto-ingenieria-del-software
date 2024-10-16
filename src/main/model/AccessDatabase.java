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
        sorucePath = path + name;
        File file = new File(path + name);

        if (!file.exists()) {
            System.err.println("Fallo!!, No existe la base de datos.");
            System.out.println("Creando base de datos..");
            if (createDatabase(path, name)) {
                System.out.println("Listo!!, Active su conexión a la base de datos.");

            }
        }

    };

    public static AccessDatabase getAccessDatabase(String path, String name) {
        if (singletonDb == null) {
            singletonDb = new AccessDatabase(path, name);
        }
        return singletonDb;
    }

    private boolean createDatabase(String path, String name) {
        new File(path).mkdirs();
        File file = new File(path + name);
        try {
            if (file.createNewFile()) {
                if (!createTablesDatabase(Env.CREATE_DATABASE)) {
                    throw new IOException();
                }
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
        Connection conn = openConnection();
        Statement statement = null;

        try {

            statement = conn.createStatement();
            conn.setAutoCommit(false);
            statement.executeUpdate(query);
            conn.commit();

        } catch (SQLException e) {

            isSuccess = false;
            if (conn != null) {
                try {
                    conn.rollback(); // Retroceder cambios
                    System.out.println("Transacción revertida debido a un error");
                } catch (SQLException rollbackEx) {
                    System.err.println("Error al revertir la transacción");
                }
            }

        } finally {

            try {
                if (statement != null) {
                    statement.close();
                }
            } catch (SQLException e) {

            }

        }

        closeConnection();
        return isSuccess;
    }

    public Connection openConnection() {
        try {
            if (db == null || db.isClosed()) {
                db = DriverManager.getConnection("jdbc:sqlite:" + sorucePath);
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

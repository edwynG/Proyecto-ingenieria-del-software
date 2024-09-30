package main.model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import main.Env;

public class ManagerDatabase {
   private AccessDatabase db = null;
   private static ManagerDatabase managerDatabase = null;

   private ManagerDatabase() {
      this.db = AccessDatabase.getAccessDatabase(Env.PATH_DATABASE, Env.NAME_DATABASE);
      System.out.println(
            db != null ? "Gestor de la base de datos activado!!." : "Hubo un error con el gestor de la base de datos.");
   }

   public static ManagerDatabase getManagerDatabase() {
      if (managerDatabase == null) {
         managerDatabase = new ManagerDatabase();
      }

      return managerDatabase;
   }

   private boolean queryStartWith(String query, List<String> strs) {
      String tempQuery = query.trim().toUpperCase();
      for (String str : strs) {
         if (tempQuery.startsWith(str)) {
            return true;
         }
      }
      return false;
   }

   public ArrayList<ArrayList<String>> getData(String query) {
      ArrayList<ArrayList<String>> arrayRegister = new ArrayList<>();

      if (!this.queryStartWith(query, Arrays.asList("SELECT"))) {
         return arrayRegister;
      }

      Connection conn = this.db.openConnection();
      Statement statement = null;
      ResultSet result = null;

      try {
         statement = conn.createStatement();
         result = statement.executeQuery(query);
         int columnCount = result.getMetaData().getColumnCount();

         while (result.next()) {
            ArrayList<String> register = new ArrayList<>();
            for (int i = 1; i <= columnCount; i++) {
               register.add(result.getString(i));
            }

            arrayRegister.add(register);
         }

      } catch (SQLException e) {
         System.err.println("Hubo un error con la consulta.");

      } finally {

         try {
            if (result != null) {
               result.close();
            }
            if (statement != null) {
               statement.close();
            }
         } catch (SQLException e) {

         }

      }

      this.db.closeConnection();
      return arrayRegister;
   }

   public boolean updateOrInsertData(String query) {

      if (!this.queryStartWith(query, Arrays.asList("UPDATE", "INSERT"))) {
         return false;
      }

      boolean isSuccess = true;
      Connection conn = this.db.openConnection();
      Statement statement = null;

      try {
         statement = conn.createStatement();
         statement.execute(Env.QUERY_FOREING_KEY_ON);
         conn.setAutoCommit(false);
         statement.executeUpdate(query);
         conn.commit();
         statement.execute(Env.QUERY_FOREING_KEY_OFF);

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

      this.db.closeConnection();
      return isSuccess;
   }

   public boolean deleteData(String query) {

      if (!this.queryStartWith(query, Arrays.asList("DELETE"))) {
         return false;
      }
      boolean isDelete = true;
      Connection conn = this.db.openConnection();
      Statement statement = null;
      try {

         statement = conn.createStatement();
         statement.execute(Env.QUERY_FOREING_KEY_OFF);
         conn.setAutoCommit(false);
         statement.executeUpdate(query);
         conn.commit();
         statement.execute(Env.QUERY_FOREING_KEY_ON);

      } catch (SQLException e) {
         isDelete = false;
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

      this.db.closeConnection();
      return isDelete;
   }

   public boolean isThereDataInTheQuery(String query) {
      ArrayList<ArrayList<String>> arrayRegister = new ArrayList<>();
      arrayRegister = this.getData(query);
      if (arrayRegister.isEmpty())
         return false;
      return true;
   }

   public ArrayList<String> getNameFields(String table) {
      ArrayList<String> nameFields = new ArrayList<>();

      Connection conn = this.db.openConnection();
      Statement statement = null;
      ResultSet result = null;

      try {
         statement = conn.createStatement();
         result = statement.executeQuery(String.format(Env.QUERY_DATA_TABLE, table));
         while (result.next()) {
            nameFields.add(result.getString("name"));
         }
      } catch (SQLException e) {
         nameFields.clear();
      } finally {

         try {
            if (result != null) {
               result.close();
            }
            if (statement != null) {
               statement.close();
            }
         } catch (SQLException e) {

         }

      }

      this.db.closeConnection();
      return nameFields;
   }
}

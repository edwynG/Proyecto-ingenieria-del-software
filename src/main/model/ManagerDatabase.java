package main.model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ManagerDatabase {
   private AccessDatabase db = null;
   private EnvConstant envConstant = null;

   public ManagerDatabase() {
      this.envConstant = new EnvConstant();
      this.db = AccessDatabase.getSingletonAccess(envConstant.PATH_DATABASE, envConstant.NAME_DATABASE);
      System.out.println(db != null ? "Gestor activado!!." : "Hubo un error con el gestor.");
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

   public List<List<String>> getData(String query) {
      List<List<String>> arrayRegister = new ArrayList<>();
      
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
            List<String> register = new ArrayList<>();
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
         statement.execute("PRAGMA foreign_keys = OFF");
         statement.executeUpdate(query);
         statement.execute("PRAGMA foreign_keys = ON");

      } catch (SQLException e) {
         isDelete = false;
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

}

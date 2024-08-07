import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import main.model.AccessDatabase;
import main.model.EnvConstant;
public class App {
    public static void main(String[] args) throws Exception {
 
       
        AccessDatabase db = AccessDatabase.getSingletonAccess(EnvConstant.PATH_DATABASE + EnvConstant.NAME_DATABASE);
        Connection conn = db.openConnection();
        Statement statement = conn.createStatement();
        try {
            ResultSet result = statement.executeQuery("SELECT * FROM Products WHERE Price <= 10");
            while (result.next()) { 
                System.out.println(result.getString("ProductName"));
                System.out.println(result.getString("Unit"));
                System.out.println("");
            }
        } catch (SQLException e) {
            System.out.println("No hay datos.");
        }
      
        if(db.closeConnection()){
            System.out.println("Cerrado con exito!!");
        }
    }
}

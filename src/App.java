import main.controller.AdministratorControl;
import main.model.Administrator;

public class App {
    public static void main(String[] args) throws Exception {
        AdministratorControl admin = new AdministratorControl(new Administrator(30326271, null, null,null));
        admin.evaluateCourse("Tal", "", 1);
      
    }
}

import main.model.ManagerDatabase;

public class App {
    public static void main(String[] args) throws Exception {
        ManagerDatabase manager = ManagerDatabase.getManagerDatabase();
        ManagerDatabase managersencond = ManagerDatabase.getManagerDatabase();
        System.out.println(manager);
        System.out.println(managersencond);
    }
}

package grupo03;

import grupo03.view.LoginView;

public class Main {
    public static void main(String[] args) {

       System.out.println("Bienvenidos a course stack");
       java.awt.EventQueue.invokeLater(new Runnable() {
        public void run() {
            new LoginView().setVisible(true);
        }
    });
    } 
}
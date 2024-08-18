package main.controller;

import main.Env;
import main.model.TransformFileBinary;
import main.model.User;

public class AdministratorControl extends UserControl {

    public AdministratorControl(User user) {
        super(user);
    }

    @Override
    public boolean evaluateCourse(String assessment, String observations, int id) {
        TransformFileBinary transform = new TransformFileBinary();
        String observation = observations != null && !observations.isEmpty()?transform.transformToBase(observations): null;

        String fields = "PropuestaID,AdministradorID,Observaciones,Resultado";
        String values = Integer.toString(id) + "," + Integer.toString(this.user.getId()) + "," +"'"+ observation+"'" + "," +"'"+ assessment+"'";

        String query = String.format(Env.QUERY_EVALUATE_COURSE_INSERT, fields, values);
        boolean evaluate = this.managerDatabase.updateOrInsertData(query);

        if (!evaluate) {
            System.err.println("Hubo un problema, la propuesta ya ha sido evaluada anteriormente.");
            System.out.println("Actualizando resultado de la propuesta..");

            query = String.format(Env.QUERY_EVALUATE_COURSE_UPDATE, observation, assessment, Integer.toString(id));
            
            boolean UpdateWithoutError = this.managerDatabase.updateOrInsertData(query);
            boolean exists = new ValidatorControl().doesTheDataExist("ResultadosPropuestas", "PropuestaID",Integer.toString(id));

            boolean result = exists && UpdateWithoutError;

            System.out.println(result ? "Propuesta actualizada." : "No se pudo actualizar la propuesta.");
            return result;
        }

        return evaluate;
    }

}

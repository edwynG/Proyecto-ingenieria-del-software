package main.model;

import main.Env;

public class ControlValidator {
    private ManagerDatabase managerDatabase;

    public ControlValidator() {
        managerDatabase = ManagerDatabase.getManagerDatabase();

    }

    public boolean isThereAnProponentIDRegister(Integer id) {
        return managerDatabase.isThereDataInTheQuery(
                String.format(Env.QUERY_VALIDATE_DATA, Env.TABLE_NAME_PROPONENTS, Env.TABLE_FIELD_PROPOENENT_ID,
                        id + ""));

    }

    public boolean isThereAnEmailRegister(String email) {
        return managerDatabase.isThereDataInTheQuery(
                String.format(
                        Env.QUERY_VALIDATE_DATA, Env.TABLE_NAME_PROPONENTS, Env.TABLE_FIELD_EMAIL, "'" + email + "'"))
                || managerDatabase.isThereDataInTheQuery(
                        String.format(Env.QUERY_VALIDATE_DATA, Env.TABLE_NAME_ADMINISTRATORS, Env.TABLE_FIELD_EMAIL,
                                "'" + email + "'"));

    }

    public boolean existResultProposal(Integer id) {
        return managerDatabase.isThereDataInTheQuery(String.format(Env.QUERY_VALIDATE_DATA,
                Env.TABLE_NAME_RESULT_PROPOSAL, Env.TABLE_FIELD_PROPOSAL_ID, id));
    }

    public boolean isAcceptedProposal(Integer id) {
        return managerDatabase.isThereDataInTheQuery(
                String.format(Env.QUERY_VALIDATE_DATA, Env.TABLE_NAME_ALIADO, Env.TABLE_FIELD_PROPOSAL_ID, id));
    }

  
}

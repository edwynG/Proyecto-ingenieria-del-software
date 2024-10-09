package main.controller;

import java.util.ArrayList;

import main.Env;
import main.controller.abstractControllers.AbstractUserControl;
import main.model.abstractModels.User;

public class AdministratorControl extends AbstractUserControl {

    public AdministratorControl(User user) {
        super(user);
    }

    public boolean uploadObservations(Integer id, String path) {
        if (!getValidator().existResultProposal(id)) {
            getManagerDatabase()
                    .updateOrInsertData(String.format(Env.QUERY_REGISTER_RESULT_PROPOSAL, id, getUser().getId()));
        }
        String file = getTransformfile().transformToBase(path);
        return file != null
                ? getManagerDatabase().updateOrInsertData(String.format(Env.QUERY_UPDATE_OBSERVATIONS, file, id))
                : false;
    }

    public boolean evaluateProposal(Integer id, String result) {
        if (!getValidator().existResultProposal(id)) {
            getManagerDatabase()
                    .updateOrInsertData(String.format(Env.QUERY_REGISTER_RESULT_PROPOSAL, id, getUser().getId()));

        }
        if (result.equals(Env.ACCEPT)) {
            createAliado(id);
        }
        if (result.equals(Env.REFUSED)) {
            deleteAliado(id);
        }
        return getManagerDatabase().updateOrInsertData(String.format(Env.QUERY_UPDATE_EVALUATION_PROPOSAL, result, id));

    }

    private boolean createAliado(Integer id) {
        if (getValidator().isAcceptedProposal(id)) {
            return false;
        }

        Integer proponentID = searchProponentForProposalID(id);
        return proponentID == -1 ? false
                : getManagerDatabase().updateOrInsertData(String.format(Env.QUERY_CREATE_ALIADO, proponentID, id));
    }

    private boolean deleteAliado(Integer id) {
        if (!getValidator().isAcceptedProposal(id)) {
            return false;
        }
        return getManagerDatabase().deleteData(String.format(Env.QUERY_DELETE_ALIADO, id));
    }

    public String getFileProposalBase64(Integer id) {
        ArrayList<ArrayList<String>> result = getManagerDatabase()
                .getData(String.format(Env.QUERY_PROPOSAL_PROPOSAL, id));
        return result.isEmpty() ? null : result.getFirst().getFirst();
    }

    public String getFileCredentialsBase64(Integer id) {
        ArrayList<ArrayList<String>> result = getManagerDatabase()
                .getData(String.format(Env.QUERY_PROPOSAL_CREDENTIAL, id));
        return result.isEmpty() ? null : result.getFirst().getFirst();
    }

    public String getFileProbityBase64(Integer id) {
        ArrayList<ArrayList<String>> result = getManagerDatabase()
                .getData(String.format(Env.QUERY_PROPOSAL_PROBITY, id));
        return result.isEmpty() ? null : result.getFirst().getFirst();
    }

    public String getResultProposal(Integer id) {
        ArrayList<ArrayList<String>> result = getManagerDatabase()
                .getData(String.format(Env.QUERY_RESULT_PROPOSAL_RESULT, id));
        return result.isEmpty() ? null : result.getFirst().getFirst();
    }


}

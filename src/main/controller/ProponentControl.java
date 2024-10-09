package main.controller;

import java.util.ArrayList;

import main.Env;
import main.controller.abstractControllers.AbstractUserControl;
import main.model.Proposal;
import main.model.abstractModels.User;

public class ProponentControl extends AbstractUserControl {

    public ProponentControl(User user) {
        super(user);
    }

    public boolean proposeCourse(ArrayList<String> data) {
        ArrayList<String> preparedListToQuery = getTransformfile().tranformToBaseOnlyWidthExt(data, "'");
        String query = String.format(Env.QUERY_REGISTER_PROPOSAL, String.join(",", preparedListToQuery));
        boolean option = getManagerDatabase().updateOrInsertData(query);
        getUser().updateProposalsUser();
        return option;
    }

    public ArrayList<String> getDetailsResultProposal(Integer id) {
        String query = String.format(Env.QUERY_RESULT_PROPOSAL, id + "");
        ArrayList<ArrayList<String>> porposal = getManagerDatabase().getData(query);
        return porposal.isEmpty() ? new ArrayList<>() : porposal.getFirst();

    }

    public String getNameCourse(Integer id) {
        for (Proposal proposal : getProposals()) {
            if (proposal.getProposalId() == id) {
                return proposal.getTitle();
            }
        }
        return null;
    }

    public String getDenomCourse(Integer id) {
        for (Proposal proposal : getProposals()) {
            if (proposal.getProposalId() == id) {
                return proposal.getDenom();
            }
        }
        return null;
    }

    public String getRespUnittCourse(Integer id) {
        for (Proposal proposal : getProposals()) {
            if (proposal.getProposalId() == id) {
                return proposal.getRespUnit();
            }
        }
        return null;
    }

    public ArrayList<Proposal> getCourseWithAval() {
        ArrayList<Proposal> proposals = new ArrayList<>();
        ArrayList<ArrayList<String>> arr = getManagerDatabase()
                .getData(String.format(Env.QUERY_PROPOSAL_WITH_AVAL_ID, getUser().getId()));

        for (int i = 0; i < arr.size(); i++) {
            for (Proposal proposal : getProposals()) {
                if (proposal.getProposalId() == Integer.parseInt(arr.get(i).getFirst())) {
                    proposals.add(proposal);
                }
            }
        }
        return proposals;
    }

    public boolean uploadDocumentCostos(Integer id, String path) {
        String file = getTransformfile().transformToBase(path);
        return file != null ? getManagerDatabase().updateOrInsertData(String.format(Env.QUERY_UPDATE_COSTOS, file, id))
                : false;

    }

    public boolean uploadDocumentSchedule(Integer id, String path) {
        String file = getTransformfile().transformToBase(path);
        return file != null
                ? getManagerDatabase().updateOrInsertData(String.format(Env.QUERY_UPDATE_SCHEDULE, file, id))
                : false;

    }

    public boolean uploadDocumentLetterOfIntent(Integer id, String path) {
        String file = getTransformfile().transformToBase(path);
        return file != null
                ? getManagerDatabase().updateOrInsertData(String.format(Env.QUERY_UPDATE_LETTER_INTENT, file, id))
                : false;

    }

    public boolean uploadDocumentLetterOfCommitment(Integer id, String path) {
        String file = getTransformfile().transformToBase(path);
        return file != null
                ? getManagerDatabase().updateOrInsertData(String.format(Env.QUERY_UPDATE_LETTER_COMMITENT, file, id))
                : false;
    }

}

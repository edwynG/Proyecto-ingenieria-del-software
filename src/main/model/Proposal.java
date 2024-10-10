package main.model;

import java.util.ArrayList;

public class Proposal {
    private Integer proposalId;
    private Integer proponentId;
    private String denom;
    private String title;
    private String objFund;
    private String admGradProfile;
    private String teachStaffProfile;
    private String compCurriculum;
    private String evalStratDuration;
    private String matServRequirements;
    private String costStruct;
    private String annualExecSchedule;
    private String respUnit;

    public Proposal() {

    }

    public Proposal(ArrayList<String> proposal) {
        try {
            // La lista tiene que tener la estructura de la consulta
            proposalId = Integer.parseInt(proposal.get(0));
            proponentId = Integer.parseInt(proposal.get(1));
            title = proposal.get(2);
            denom = proposal.get(3);
            objFund = proposal.get(4);
            admGradProfile = proposal.get(5);
            teachStaffProfile = proposal.get(6);
            compCurriculum = proposal.get(7);
            evalStratDuration = proposal.get(8);
            matServRequirements = proposal.get(9);
            costStruct = proposal.get(10);
            annualExecSchedule = proposal.get(11);
            respUnit = proposal.get(12);

        } catch (Exception e) {
            System.err.println("Error al crear objeto propuesta.");
        }

    }

    @Override
    public String toString() {
        return "Proposal(id=" + getProposalId() + ", " + "proponente=" + getProponentId() +", " +"denominación=" + getDenom() + ", "+ "unidad=" + getRespUnit() +")";
    }

    public String getDenom() {
        return denom;
    }

    public void setDenom(String denom) {
        this.denom = denom;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getObjFund() {
        return objFund;
    }

    public void setObjFund(String objFund) {
        this.objFund = objFund;
    }

    public String getAdmGradProfile() {
        return admGradProfile;
    }

    public void setAdmGradProfile(String admGradProfile) {
        this.admGradProfile = admGradProfile;
    }

    public String getTeachStaffProfile() {
        return teachStaffProfile;
    }

    public void setTeachStaffProfile(String teachStaffProfile) {
        this.teachStaffProfile = teachStaffProfile;
    }

    public String getCompCurriculum() {
        return compCurriculum;
    }

    public void setCompCurriculum(String compCurriculum) {
        this.compCurriculum = compCurriculum;
    }

    public String getEvalStratDuration() {
        return evalStratDuration;
    }

    public void setEvalStratDuration(String evalStratDuration) {
        this.evalStratDuration = evalStratDuration;
    }

    public String getMatServRequirements() {
        return matServRequirements;
    }

    public void setMatServRequirements(String matServRequirements) {
        this.matServRequirements = matServRequirements;
    }

    public String getCostStruct() {
        return costStruct;
    }

    public void setCostStruct(String costStruct) {
        this.costStruct = costStruct;
    }

    public String getAnnualExecSchedule() {
        return annualExecSchedule;
    }

    public void setAnnualExecSchedule(String annualExecSchedule) {
        this.annualExecSchedule = annualExecSchedule;
    }

    public String getRespUnit() {
        return respUnit;
    }

    public void setRespUnit(String respUnit) {
        this.respUnit = respUnit;
    }

    public Integer getProposalId() {
        return proposalId;
    }

    public void setProposalId(Integer proposalId) {
        this.proposalId = proposalId;
    }

    public void setProponentId(Integer proponentId) {
        this.proponentId = proponentId;
    }

    public Integer getProponentId() {
        return proponentId;
    }

}

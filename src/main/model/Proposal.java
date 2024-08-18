package main.model;

import java.util.Map;

public class Proposal {
    private int proposalId;
    private int proponentId;
    private String denom;
    private String objFund;
    private String admGradProfile;
    private String teachStaffProfile;
    private String compCurriculum;
    private String evalStratDuration;
    private String matServRequirements;
    private String costStruct;
    private String annualExecSchedule;
    private String respUnit;
    private String typeAdmin;

    public Proposal(Map<String,String> proposal){
        this.denom = proposal.get("Denominacion");
        this.objFund = proposal.get("ObjetivosYFundamentacion");
        this.admGradProfile = proposal.get("PerfilDeIngresoYEgreso");
        this.teachStaffProfile = proposal.get("PerfilDocente");
        this.compCurriculum = proposal.get("EstructuraCurricularPorCompetencias");
        this.evalStratDuration = proposal.get("EstrategiasDeEvaluacionYDuracion");
        this.matServRequirements= proposal.get("ExigenciasEnMaterialesYservicios");
        this.costStruct = proposal.get("EstructuraDeCostos");
        this.annualExecSchedule = proposal.get("CronogramaDeEjecucionAnual");
        this.respUnit = proposal.get("UnidadResponsable");
        this.proponentId = Integer.parseInt(proposal.get("ProponenteID"));
        this.proposalId = Integer.parseInt(proposal.get("PropuestaID"));
        this.typeAdmin = proposal.get("TipoDeAdministrador");
    }

    public String getDenom() {
        return denom;
    }

    public void setDenom(String denom) {
        this.denom = denom;
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

    public int getProposalId(){
        return this.proposalId;
    }

    public int getProponentId(){
        return this.proponentId;
    }
    public String getTypeAdmin(){
        return this.typeAdmin;
    }
}

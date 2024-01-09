package ma.ensias.a.gl.g1.missioncostcalculationmicroservice.event;

public class MissionReimbursementRequestApprovedEvent {

    private Long missionReimbursementRequestId;

    private Long missionId;

    private Long professorId;
    

    public MissionReimbursementRequestApprovedEvent() {
    }


    public MissionReimbursementRequestApprovedEvent(Long missionReimbursementRequestId, Long missionId, Long professorId) {
        this.missionReimbursementRequestId = missionReimbursementRequestId;
        this.missionId = missionId;
        this.professorId = professorId;
    }


    public Long getMissionReimbursementRequestId() {
        return this.missionReimbursementRequestId;
    }

    public void setMissionReimbursementRequestId(Long missionReimbursementRequestId) {
        this.missionReimbursementRequestId = missionReimbursementRequestId;
    }

    public Long getMissionId() {
        return this.missionId;
    }

    public void setMissionId(Long missionId) {
        this.missionId = missionId;
    }

    public Long getProfessorId() {
        return this.professorId;
    }

    public void setProfessorId(Long professorId) {
        this.professorId = professorId;
    }


    @Override
    public String toString() {
        return "{" +
            " missionReimbursementRequestId='" + getMissionReimbursementRequestId() + "'" +
            ", missionId='" + getMissionId() + "'" +
            ", professorId='" + getProfessorId() + "'" +
            "}";
    }


}
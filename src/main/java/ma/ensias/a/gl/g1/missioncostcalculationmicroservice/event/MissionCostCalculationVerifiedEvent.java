package ma.ensias.a.gl.g1.missioncostcalculationmicroservice.event;

public class MissionCostCalculationVerifiedEvent {
    
    private Long missionCostCalculationId;

    private Long missionId;

    private Long professorId;

    private Double sum;


    public MissionCostCalculationVerifiedEvent() {
    }


    public MissionCostCalculationVerifiedEvent(Long missionCostCalculationId, Long missionId, Long professorId, Double sum) {
        this.missionCostCalculationId = missionCostCalculationId;
        this.missionId = missionId;
        this.professorId = professorId;
        this.sum = sum;
    }



    public Long getMissionCostCalculationId() {
        return this.missionCostCalculationId;
    }

    public void setMissionCostCalculationId(Long missionCostCalculationId) {
        this.missionCostCalculationId = missionCostCalculationId;
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

    public Double getSum() {
        return this.sum;
    }

    public void setSum(Double sum) {
        this.sum = sum;
    }


}

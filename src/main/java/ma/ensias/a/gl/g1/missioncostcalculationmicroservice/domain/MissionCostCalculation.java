package ma.ensias.a.gl.g1.missioncostcalculationmicroservice.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class MissionCostCalculation {

    public enum State {
        CREATED,
        VERIFIED,
        REFUTED
    }

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    private Long missionId;

    private Long professorId;

    private Double amount;

    private State state = State.CREATED;

    public MissionCostCalculation() {}

    public MissionCostCalculation(Long missionId, Long professorId) {
        this.missionId = missionId;
        this.professorId = professorId;
    }


    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
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


    public Double getAmount() {
        return this.amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public State getState() {
        return this.state;
    }

    public void setState(State state) {
        this.state = state;
    }


}

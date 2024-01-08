package ma.ensias.a.gl.g1.missioncostcalculationmicroservice.service;

import java.util.List;
import java.util.Optional;

import ma.ensias.a.gl.g1.missioncostcalculationmicroservice.domain.MissionCostCalculation;

public interface MissionCostCalculationService {
    List<MissionCostCalculation> getAllMissionCostCalculations();
    Optional<MissionCostCalculation> getMissionCostCalculationById(Long id);
    MissionCostCalculation saveMissionCostCalculation(MissionCostCalculation missionCostCalculation);
}

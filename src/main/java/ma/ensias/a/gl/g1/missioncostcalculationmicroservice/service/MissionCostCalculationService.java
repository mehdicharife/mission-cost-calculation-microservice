package ma.ensias.a.gl.g1.missioncostcalculationmicroservice.service;

import java.util.List;
import java.util.Optional;

import ma.ensias.a.gl.g1.missioncostcalculationmicroservice.domain.MissionCostCalculation;
import ma.ensias.a.gl.g1.missioncostcalculationmicroservice.exception.InvalidMissionCostCalculationIdException;

public interface MissionCostCalculationService {
    List<MissionCostCalculation> getAllMissionCostCalculations();
    Optional<MissionCostCalculation> getMissionCostCalculationById(Long id);
    MissionCostCalculation saveMissionCostCalculation(MissionCostCalculation missionCostCalculation);
    MissionCostCalculation verifyMissionCostCalculationById(Long id) throws InvalidMissionCostCalculationIdException;
    MissionCostCalculation refuteMissionCostCalculationById(Long id) throws InvalidMissionCostCalculationIdException;
}

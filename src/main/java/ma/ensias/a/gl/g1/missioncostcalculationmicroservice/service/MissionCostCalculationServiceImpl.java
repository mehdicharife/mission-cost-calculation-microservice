package ma.ensias.a.gl.g1.missioncostcalculationmicroservice.service;

import java.util.List;
import java.util.Optional;

import ma.ensias.a.gl.g1.missioncostcalculationmicroservice.domain.MissionCostCalculation;
import ma.ensias.a.gl.g1.missioncostcalculationmicroservice.repository.MissionCostCalculationRepository;

public class MissionCostCalculationServiceImpl  implements MissionCostCalculationService{
    
    private MissionCostCalculationRepository missionCostCalculationRepository;

    public MissionCostCalculationServiceImpl(MissionCostCalculationRepository missionCostCalculationRepository) {
        this.missionCostCalculationRepository = missionCostCalculationRepository;
    }

    public List<MissionCostCalculation> getAllMissionCostCalculations() {
        return this.missionCostCalculationRepository.findAll();
    }

    public Optional<MissionCostCalculation> getMissionCostCalculationById(Long id) {
        return this.missionCostCalculationRepository.findById(id);
    }

    public MissionCostCalculation saveMissionCostCalculation(MissionCostCalculation missionCostCalculation) {
        return this.missionCostCalculationRepository.save(missionCostCalculation);
    }
}

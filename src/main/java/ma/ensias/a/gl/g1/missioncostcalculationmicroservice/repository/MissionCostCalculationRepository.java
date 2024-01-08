package ma.ensias.a.gl.g1.missioncostcalculationmicroservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import ma.ensias.a.gl.g1.missioncostcalculationmicroservice.domain.MissionCostCalculation;

public interface MissionCostCalculationRepository extends JpaRepository<MissionCostCalculation, Long>{
    
}

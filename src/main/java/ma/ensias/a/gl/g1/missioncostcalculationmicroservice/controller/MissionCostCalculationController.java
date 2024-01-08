package ma.ensias.a.gl.g1.missioncostcalculationmicroservice.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ma.ensias.a.gl.g1.missioncostcalculationmicroservice.domain.MissionCostCalculation;
import ma.ensias.a.gl.g1.missioncostcalculationmicroservice.service.MissionCostCalculationService;

@RestController
@RequestMapping("/mission-cost-calculations")
public class MissionCostCalculationController {

    private MissionCostCalculationService missionCostCalculationService;

    public MissionCostCalculationController(MissionCostCalculationService missionCostCalculationService) {
        this.missionCostCalculationService = missionCostCalculationService;
    }


    @GetMapping
    public List<MissionCostCalculation> getAllMissionCostCalculations() {
        return this.missionCostCalculationService.getAllMissionCostCalculations();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getMissionCostCalculationById(@PathVariable Long id) {
        Optional<MissionCostCalculation> optionalMissionCostCalculation = this.missionCostCalculationService.getMissionCostCalculationById(id);
        if(optionalMissionCostCalculation.isPresent()) {
            return new ResponseEntity<>(optionalMissionCostCalculation.get(), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    
}

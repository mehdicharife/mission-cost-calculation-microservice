package ma.ensias.a.gl.g1.missioncostcalculationmicroservice.service;

import java.util.List;
import java.util.Optional;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import ma.ensias.a.gl.g1.missioncostcalculationmicroservice.domain.MissionCostCalculation;
import ma.ensias.a.gl.g1.missioncostcalculationmicroservice.domain.MissionCostCalculation.State;
import ma.ensias.a.gl.g1.missioncostcalculationmicroservice.event.MissionCostCalculationVerifiedEvent;
import ma.ensias.a.gl.g1.missioncostcalculationmicroservice.exception.InvalidMissionCostCalculationIdException;
import ma.ensias.a.gl.g1.missioncostcalculationmicroservice.repository.MissionCostCalculationRepository;


@Service
public class MissionCostCalculationServiceImpl  implements MissionCostCalculationService{
    
    private MissionCostCalculationRepository missionCostCalculationRepository;

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Value("${missionCostCalculationVerifiedExchangeName}")
    private String missionCostCalculationVerifiedExchangeName;


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


    public MissionCostCalculation verifyMissionCostCalculationById(Long id) throws InvalidMissionCostCalculationIdException {
        Optional<MissionCostCalculation> optionalMissionCostCalculation = this.missionCostCalculationRepository.findById(id);
        if(optionalMissionCostCalculation.isPresent()) {
            MissionCostCalculation missionCostCalculation = optionalMissionCostCalculation.get();
            missionCostCalculation.setState(State.VERIFIED);
            this.missionCostCalculationRepository.save(missionCostCalculation);

            MissionCostCalculationVerifiedEvent event = new MissionCostCalculationVerifiedEvent(
                missionCostCalculation.getId(),
                missionCostCalculation.getMissionId(),
                missionCostCalculation.getProfessorId(),
                missionCostCalculation.getAmount()
            );
            this.rabbitTemplate.convertAndSend(missionCostCalculationVerifiedExchangeName, event);
            
            return missionCostCalculation;
        }

        throw new InvalidMissionCostCalculationIdException(id + " doesn't point to any existing mission cost calculation.");
    }

    
    public MissionCostCalculation refuteMissionCostCalculationById(Long id) throws InvalidMissionCostCalculationIdException {
        Optional<MissionCostCalculation> optionalMissionCostCalculation = this.missionCostCalculationRepository.findById(id);
        if(optionalMissionCostCalculation.isPresent()) {
            MissionCostCalculation missionCostCalculation = optionalMissionCostCalculation.get();
            missionCostCalculation.setState(State.REFUTED);
            this.missionCostCalculationRepository.save(missionCostCalculation);
            return missionCostCalculation;
        }

        throw new InvalidMissionCostCalculationIdException(id + " doesn't point to any existing mission cost calculation.");
    }
}

package ma.ensias.a.gl.g1.missioncostcalculationmicroservice.listener;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import ma.ensias.a.gl.g1.missioncostcalculationmicroservice.domain.Mission;
import ma.ensias.a.gl.g1.missioncostcalculationmicroservice.domain.MissionCostCalculation;
import ma.ensias.a.gl.g1.missioncostcalculationmicroservice.domain.MissionCostCalculator;
import ma.ensias.a.gl.g1.missioncostcalculationmicroservice.event.MissionReimbursementRequestApprovedEvent;
import ma.ensias.a.gl.g1.missioncostcalculationmicroservice.service.MissionCostCalculationService;

@Component
@RabbitListener(queues="${missionReimbursementRequestApprovedQueueName}")
public class MissionReimbursementRequestApprovedEventListener {

    @Autowired
    private MissionCostCalculationService missionCostCalculationService;

    @Autowired
    private RestTemplate restTemplate;

    @Value("${esb}")
    private String esb;

    @RabbitHandler
    public void react(MissionReimbursementRequestApprovedEvent event) {
        MissionCostCalculation missionCostCalculation = new MissionCostCalculation(
            event.getMissionId(),
            event.getProfessorId()
        );

        System.out.println(event);

        //Mission mission = this.restTemplate.getForObject(esb + "missions/" + event.getMissionId(), Mission.class);
        //missionCostCalculation.setAmount(MissionCostCalculator.calculateMissionCost(mission));

        //this.missionCostCalculationService.saveMissionCostCalculation(missionCostCalculation);
    }
    
}

package ma.ensias.a.gl.g1.missioncostcalculationmicroservice.config;

import java.util.HashMap;
import java.util.Map;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.QueueBuilder;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.ClassMapper;
import org.springframework.amqp.support.converter.DefaultClassMapper;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.amqp.core.Binding.DestinationType;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.fasterxml.jackson.databind.ObjectMapper;

import ma.ensias.a.gl.g1.missioncostcalculationmicroservice.event.MissionReimbursementRequestApprovedEvent;

@Configuration
public class RabbitMQConfig {

    @Value("${missionReimbursementRequestApprovedExchangeName}")
    private String reimbursementRequestApprovedExchangeName;

    @Value("${missionReimbursementRequestApprovedQueueName}")
    private String reimbursementRequestApprovedQueueName;


    private String missionCostCalculationVerifiedExchangeName;

    
    @Bean
    public Queue reimbursementRequestApprovedQueue() {
        return QueueBuilder.durable(reimbursementRequestApprovedQueueName).build();
    }

    @Bean
    public Binding reimbursementRequestApprovedBinding(Queue reimbursementRequestApprovedQueue) {
        return new Binding(reimbursementRequestApprovedQueue.getName(),
            DestinationType.QUEUE,
            reimbursementRequestApprovedExchangeName,
            "",
            null
        );
    }

    @Bean
    public FanoutExchange missionCostCalculationExchange() {
        return new FanoutExchange(missionCostCalculationVerifiedExchangeName);
    }



    @Bean
    public ClassMapper classMapper() {
        DefaultClassMapper classMapper = new DefaultClassMapper();
        Map<String, Class<?>> map = new HashMap<>();

        map.put(
        "ma.ensias.gl.gl1.group1.reimbursementrequestmicroservice.event.MissionReimbursementRequestApprovedEvent",
        MissionReimbursementRequestApprovedEvent.class);

        classMapper.setIdClassMapping(map);
        
        return classMapper;
    }


    @Bean
    public MessageConverter messageConverter(ObjectMapper objectMapper, ClassMapper classMapper) {
        Jackson2JsonMessageConverter messageConverter = new Jackson2JsonMessageConverter(objectMapper);
        messageConverter.setClassMapper(classMapper);
        return messageConverter;
    }

    @Bean
    public RabbitTemplate rabbitTemplate(final ConnectionFactory connectionFactory, MessageConverter messageConverter) {
        RabbitTemplate rabbitTemplate = new RabbitTemplate();
        rabbitTemplate.setConnectionFactory(connectionFactory);
        rabbitTemplate.setMessageConverter(messageConverter);
        return rabbitTemplate;
    }

    
}

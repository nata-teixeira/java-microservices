package projeto.natanael.processamento.config;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.amqp.core.Queue;
import tools.jackson.databind.ObjectMapper;


@Configuration
public class RabbitMQConfig {

    @Value("${broker.queue.processamento.name}")
    private String queue;

    @Bean
    public Queue queue(){
        return new Queue(queue, true);
    }



}

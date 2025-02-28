package warehouse.ms_category.app.usecase.messaging.producer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import warehouse.ms_category.core.usecase.messaging.producer.ProducerUseCase;

@Service
public class ProducerUseCaseImpl implements ProducerUseCase {

  @Autowired
  private KafkaTemplate<String, String> kafkaTemplate;

  @Override
  public void execute(String topic, String payload) {
    kafkaTemplate.send(topic, payload);
  }
  
}

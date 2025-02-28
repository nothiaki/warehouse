package warehouse.ms_category.app.usecase.saga;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import warehouse.ms_category.app.shared.JsonManager;
import warehouse.ms_category.core.domain.history.History;
import warehouse.ms_category.core.usecase.messaging.producer.ProducerUseCase;
import warehouse.ms_category.core.usecase.saga.SagaNextUseCase;

@Service
public class SagaNextUseCaseImpl implements SagaNextUseCase {

  @Autowired
  private ProducerUseCase producerUseCase;

  @Autowired
  private JsonManager jsonManager;

  @Value("${spring.kafka.topic.ms-product.process}")
  private String msProductProcess;

  @Override
  public void next(History history) {
    String payload = jsonManager.objectToJson(history);

    producerUseCase.execute(msProductProcess, payload);
  }

}

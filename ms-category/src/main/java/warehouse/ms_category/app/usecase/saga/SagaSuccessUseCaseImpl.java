package warehouse.ms_category.app.usecase.saga;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import warehouse.ms_category.app.shared.JsonManager;
import warehouse.ms_category.core.domain.history.History;
import warehouse.ms_category.core.domain.history.Operation;
import warehouse.ms_category.core.domain.history.Status;
import warehouse.ms_category.core.usecase.messaging.producer.ProducerUseCase;
import warehouse.ms_category.core.usecase.saga.SagaSuccessUseCase;
import warehouse.ms_category.infra.config.kafka.KafkaProperties;

@Service
public class SagaSuccessUseCaseImpl implements SagaSuccessUseCase {

  @Autowired
  private ProducerUseCase producerUseCase;

  @Autowired
  private JsonManager jsonManager;

  @Value(KafkaProperties.MS_PRODUCT_PROCESS)
  private String msProductProcess;

  @Override
  public void execute(History history) {
    history.getOperations().add(
      Operation.builder()
      .source("MS-CATEGORY")
      .status(Status.FINISHED)
      .createdAt(new Date())
      .build()
    );

    String payload = jsonManager.objectToJson(history);

    producerUseCase.execute(msProductProcess, payload);
  }

}

package warehouse.ms_product.app.usecase.saga;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import warehouse.ms_product.app.shared.JsonManager;
import warehouse.ms_product.core.domain.history.History;
import warehouse.ms_product.core.domain.history.Operation;
import warehouse.ms_product.core.domain.history.Status;
import warehouse.ms_product.core.usecase.messaging.producer.ProducerUseCase;
import warehouse.ms_product.core.usecase.saga.SagaSuccessUseCase;
import warehouse.ms_product.infra.config.kafka.KafkaProperties;

public class SagaSuccessUseCaseImpl implements SagaSuccessUseCase {

  @Autowired
  private ProducerUseCase producerUseCase;

  @Value(KafkaProperties.MS_NOTIFY_PROCESS)
  private String msNotifyProcess;

  @Autowired
  private JsonManager jsonManager;

  @Override
  public void execute(History history) {
    history.getOperations().add(
      Operation.builder()
      .source("MS-PRODUCT")
      .status(Status.FINISHED)
      .build()
    );

    String payload = jsonManager.objectToJson(history);

    producerUseCase.execute(msNotifyProcess, payload);
  }

}

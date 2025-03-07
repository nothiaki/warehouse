package warehouse.ms_product.app.usecase.saga;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import warehouse.ms_product.app.shared.JsonManager;
import warehouse.ms_product.core.domain.history.History;
import warehouse.ms_product.core.domain.history.Operation;
import warehouse.ms_product.core.domain.history.Status;
import warehouse.ms_product.core.usecase.messaging.producer.ProducerUseCase;
import warehouse.ms_product.core.usecase.saga.SagaFailUseCase;
import warehouse.ms_product.infra.config.kafka.KafkaProperties;

@Service
public class SagaFailUseCaseImpl implements SagaFailUseCase {

  @Autowired
  private ProducerUseCase producerUseCase;

  @Value(KafkaProperties.MS_CATEGORY_FAIL)
  private String msCategoryFail;

  @Autowired
  private JsonManager jsonManager;

  @Override
  public void execute(History history) {
    history.getOperations().add(
      Operation.builder()
      .source("MS-PRODUCT")
      .status(Status.FAILED)
      .build()
    );

    String payload = jsonManager.objectToJson(history);

    producerUseCase.execute(msCategoryFail, payload);
  }

}

package warehouse.ms_product.app.usecase.messaging.consumer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import warehouse.ms_product.app.shared.JsonManager;
import warehouse.ms_product.core.domain.history.History;
import warehouse.ms_product.core.usecase.messaging.consumer.ConsumerUseCase;
import warehouse.ms_product.core.usecase.product.ProcessProductUseCase;
import warehouse.ms_product.infra.config.kafka.KafkaProperties;

@Service
public class ProductProcessConsumerUseCaseImpl implements ConsumerUseCase {

  @Autowired
  private ProcessProductUseCase processProductUseCase;

  @Autowired
  private JsonManager jsonManager;

  @Override
  @KafkaListener(
    groupId = KafkaProperties.GROUP_ID,
    topics = KafkaProperties.MS_PRODUCT_PROCESS
  )
  public void execute(String payload) {
    History history = jsonManager.jsonToObject(payload, History.class);

    processProductUseCase.execute(history);
  }

}

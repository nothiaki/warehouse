package warehouse.ms_product.app.usecase.messaging.consumer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import warehouse.ms_product.app.shared.JsonManager;
import warehouse.ms_product.core.domain.product.Product;
import warehouse.ms_product.core.usecase.messaging.consumer.ConsumerUseCase;
import warehouse.ms_product.core.usecase.product.CreateProductUseCase;

@Service
public class ConsumerUseCaseImpl implements ConsumerUseCase {

  @Autowired
  private CreateProductUseCase createProductUseCase;

  @Autowired
  private JsonManager jsonManager;

  @Override
  @KafkaListener(
    groupId = "${spring.kafka.consumer.group-id}",
    topics = "${spring.kafka.topic.ms-product.create}"
  )
  public void execute(String payload) {
    Product product = jsonManager.jsonToObject(payload, Product.class);

    createProductUseCase.execute(product);
  }

}

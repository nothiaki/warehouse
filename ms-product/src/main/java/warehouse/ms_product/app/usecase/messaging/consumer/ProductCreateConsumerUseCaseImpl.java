package warehouse.ms_product.app.usecase.messaging.consumer;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import warehouse.ms_product.app.shared.JsonManager;
import warehouse.ms_product.core.domain.product.CreateProductDTO;
import warehouse.ms_product.core.domain.product.Product;
import warehouse.ms_product.core.usecase.messaging.consumer.ConsumerUseCase;
import warehouse.ms_product.core.usecase.product.CreateProductUseCase;
import warehouse.ms_product.infra.config.kafka.KafkaProperties;

@Service
public class ProductCreateConsumerUseCaseImpl implements ConsumerUseCase {

  @Autowired
  private CreateProductUseCase createProductUseCase;

  @Autowired
  private JsonManager jsonManager;

  @Override
  @KafkaListener(
    groupId = KafkaProperties.GROUP_ID,
    topics = KafkaProperties.MS_PRODUCT_CREATE
  )
  public void execute(String payload) {
    CreateProductDTO createProduct = jsonManager.jsonToObject(payload, CreateProductDTO.class);

    createProductUseCase.execute(createProduct.getProducts());
  }

}

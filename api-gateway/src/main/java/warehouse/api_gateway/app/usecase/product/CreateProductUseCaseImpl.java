package warehouse.api_gateway.app.usecase.product;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import warehouse.api_gateway.app.shared.JsonManager;
import warehouse.api_gateway.core.domain.product.Product;
import warehouse.api_gateway.core.domain.product.ProductRequestDTO;
import warehouse.api_gateway.core.usecase.messaging.producer.ProducerUseCase;
import warehouse.api_gateway.core.usecase.product.CreateProductUseCase;
import warehouse.api_gateway.infra.config.kafka.KafkaProperties;

@Service
public class CreateProductUseCaseImpl implements CreateProductUseCase {

  @Autowired
  private ProducerUseCase producerUseCase;

  @Autowired
  private JsonManager jsonManager;

  @Value(KafkaProperties.MS_PRODUCT_CREATE)
  private String msProductCreate;

  @Override
  public List<Product> execute(ProductRequestDTO productRequest) {
    String productStringfied = jsonManager.objectToJson(productRequest);

    producerUseCase.execute(msProductCreate, productStringfied);

    return productRequest.getProducts();
  }
  
}

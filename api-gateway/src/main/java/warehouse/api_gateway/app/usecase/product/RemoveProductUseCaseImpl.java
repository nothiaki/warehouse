package warehouse.api_gateway.app.usecase.product;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import warehouse.api_gateway.app.shared.JsonManager;
import warehouse.api_gateway.core.domain.history.History;
import warehouse.api_gateway.core.domain.history.Operation;
import warehouse.api_gateway.core.domain.history.Status;
import warehouse.api_gateway.core.domain.product.Product;
import warehouse.api_gateway.core.usecase.messaging.producer.ProducerUseCase;
import warehouse.api_gateway.core.usecase.product.RemoveProductUseCase;

public class RemoveProductUseCaseImpl implements RemoveProductUseCase {

  @Value("${spring.kafka.topic.ms-category.process}")
  private String msCategoryProcess;
  
  @Autowired
  private ProducerUseCase producerUseCase;

  @Autowired
  private JsonManager jsonManager;

  @Override
  public void execute(List<Product> products) {
    Operation operation = Operation.builder()
    .source("API-GATEWAY")
    .status(Status.FINISHED)
    .build();

    History history = History.builder()
    .status(Status.PROCCESSING)
    .products(products)
    .build();

    history.getOperations().add(operation);

    String payload = jsonManager.objectToJson(history);

    producerUseCase.execute(msCategoryProcess, payload);
  }

}

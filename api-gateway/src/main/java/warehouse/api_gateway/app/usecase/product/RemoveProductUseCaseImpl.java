package warehouse.api_gateway.app.usecase.product;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import warehouse.api_gateway.app.repository.HistoryRepository;
import warehouse.api_gateway.app.shared.JsonManager;
import warehouse.api_gateway.core.domain.history.History;
import warehouse.api_gateway.core.domain.history.Operation;
import warehouse.api_gateway.core.domain.history.Status;
import warehouse.api_gateway.core.domain.product.Product;
import warehouse.api_gateway.core.usecase.messaging.producer.ProducerUseCase;
import warehouse.api_gateway.core.usecase.product.RemoveProductUseCase;
import warehouse.api_gateway.infra.config.kafka.KafkaProperties;

@Service
public class RemoveProductUseCaseImpl implements RemoveProductUseCase {

  @Value(KafkaProperties.MS_CATEGORY_PROCESS)
  private String msCategoryProcess;
  
  @Autowired
  private ProducerUseCase producerUseCase;

  @Autowired
  private JsonManager jsonManager;

  @Autowired
  private HistoryRepository historyRepository;

  @Override
  public History execute(List<Product> products) {
    Operation operation = Operation.builder()
    .source("API-GATEWAY")
    .status(Status.FINISHED)
    .build();

    History history = History.builder()
    .status(Status.PROCCESSING)
    .products(products)
    .build();

    history.setOperations(new ArrayList<>());
    history.getOperations().add(operation);

    History savedHistory = historyRepository.save(history);

    String payload = jsonManager.objectToJson(savedHistory);

    producerUseCase.execute(msCategoryProcess, payload);

    return savedHistory;
  }

}

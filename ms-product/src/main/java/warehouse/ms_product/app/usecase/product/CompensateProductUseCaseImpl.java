package warehouse.ms_product.app.usecase.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import warehouse.ms_product.app.repository.ProductRepository;
import warehouse.ms_product.core.domain.history.History;
import warehouse.ms_product.core.usecase.product.ProcessProductUseCase;
import warehouse.ms_product.core.usecase.saga.SagaFailUseCase;

@Service
public class CompensateProductUseCaseImpl implements ProcessProductUseCase {

  @Autowired
  private ProductRepository productRepository;

  @Autowired
  private SagaFailUseCase sagaFailUseCase;

  @Override
  public void execute(History history) {

    history.getProducts().forEach(product -> {
      productRepository.save(product);
    });

    sagaFailUseCase.execute(history);
  }
  
}

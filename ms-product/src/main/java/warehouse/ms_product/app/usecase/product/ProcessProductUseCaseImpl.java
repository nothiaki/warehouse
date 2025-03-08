package warehouse.ms_product.app.usecase.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import warehouse.ms_product.app.repository.ProductRepository;
import warehouse.ms_product.core.domain.history.History;
import warehouse.ms_product.core.domain.product.Product;
import warehouse.ms_product.core.usecase.product.ProcessProductUseCase;
import warehouse.ms_product.core.usecase.saga.SagaFailUseCase;
import warehouse.ms_product.core.usecase.saga.SagaSuccessUseCase;

@Service
public class ProcessProductUseCaseImpl implements ProcessProductUseCase {

  @Autowired
  private ProductRepository productRepository;

  @Autowired
  private SagaSuccessUseCase sagaSuccessUseCase;

  @Autowired
  private SagaFailUseCase sagaFailUseCase;


  @Override
  public void execute(History history) {
    try {
      history.getProducts().forEach((product) -> {
        Product existingProduct = productRepository.findByName(product.getName())
        .orElseThrow(() -> new RuntimeException("error while iterate products in ms-product:ProcessProductUseCaseImpl"));

        Long newQuantity = existingProduct.getQuantity() - product.getQuantity();

        existingProduct.setQuantity(newQuantity);
        productRepository.save(existingProduct);
      });

      sagaSuccessUseCase.execute(history);
    } catch (Exception e) {
      sagaFailUseCase.execute(history);
    }
  }
  
}

package warehouse.ms_product.app.usecase.product;

import org.springframework.stereotype.Service;

import warehouse.ms_product.core.domain.product.Product;
import warehouse.ms_product.core.usecase.product.CreateProductUseCase;

@Service
public class CreateProductUseCaseImpl implements CreateProductUseCase {

  @Override
  public void execute(Product product) {
    System.out.println("reach create product execute");
    //TODO: record in database
  }
  
}

package warehouse.ms_product.app.usecase.product;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import warehouse.ms_product.app.repository.ProductRepository;
import warehouse.ms_product.core.domain.product.Product;
import warehouse.ms_product.core.usecase.product.CreateProductUseCase;

@Service
public class CreateProductUseCaseImpl implements CreateProductUseCase {

  @Autowired
  private ProductRepository productRepository;

  @Override
  public void execute(Product product) {
    productRepository.save(
      Product.builder()
      .name(product.getName())
      .quantity(product.getQuantity())
      .category(product.getCategory())
      .createdAt(new Date())
      .build()
    );
  }
  
}

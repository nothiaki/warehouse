package warehouse.ms_product.app.repository;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import warehouse.ms_product.core.domain.product.Product;

public interface ProductRepository extends JpaRepository<Product, UUID> {
  public Optional<Product> findByName(String name);
}

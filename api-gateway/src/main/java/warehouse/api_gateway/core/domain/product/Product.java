package warehouse.api_gateway.core.domain.product;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Embeddable
@Getter
@Setter
@AllArgsConstructor
@Builder
public class Product {

  private String name;
  private Long quantity;
  private String category;

}

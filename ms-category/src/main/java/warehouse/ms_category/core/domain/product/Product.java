package warehouse.ms_category.core.domain.product;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@Builder
public class Product {

  private String name;
  private Long quantity;
  private String category;

}

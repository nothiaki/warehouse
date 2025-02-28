package warehouse.ms_product.core.domain.history;

import java.util.List;
import java.util.UUID;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import warehouse.ms_product.core.domain.product.Product;

@Getter
@Setter
@AllArgsConstructor
@Builder
public class History {

  private UUID id;
  private Status status;
  private List<Product> products;
  private List<Operation> operations;
  
}

package warehouse.api_gateway.core.domain.history;

import java.util.List;
import java.util.UUID;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import warehouse.api_gateway.core.domain.product.Product;

//TODO: this class will be a table in the future
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

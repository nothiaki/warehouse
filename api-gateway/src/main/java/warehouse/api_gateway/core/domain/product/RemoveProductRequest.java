package warehouse.api_gateway.core.domain.product;

import java.util.List;

import lombok.Getter;

@Getter
public class RemoveProductRequest {
  private List<Product> products;
}

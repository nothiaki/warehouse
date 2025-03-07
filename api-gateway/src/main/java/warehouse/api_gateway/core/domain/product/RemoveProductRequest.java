package warehouse.api_gateway.core.domain.product;

import java.util.List;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class RemoveProductRequest {

  private List<Product> products;

}

package warehouse.api_gateway.core.domain.history;

import lombok.AllArgsConstructor;
import lombok.Builder;

@AllArgsConstructor
@Builder
public class Operation {
  
  private String source;
  private Status status;

}

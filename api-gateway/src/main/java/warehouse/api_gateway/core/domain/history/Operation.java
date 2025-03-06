package warehouse.api_gateway.core.domain.history;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Builder;

@Embeddable
@AllArgsConstructor
@Builder
public class Operation {
  
  private String source;
  private Status status;

}

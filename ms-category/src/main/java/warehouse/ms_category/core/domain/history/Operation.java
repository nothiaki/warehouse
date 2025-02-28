package warehouse.ms_category.core.domain.history;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@Builder
public class Operation {
  
  private String source;
  private Status status;

}

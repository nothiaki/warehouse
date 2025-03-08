package warehouse.ms_product.core.domain.history;

import java.util.Date;

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

  private Date createdAt;

}

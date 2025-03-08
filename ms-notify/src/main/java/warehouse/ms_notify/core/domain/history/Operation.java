package warehouse.ms_notify.core.domain.history;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Operation {
  
  private String source;
  private Status status;

  private Date createdAt;

}

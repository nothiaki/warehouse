package warehouse.ms_notify.core.domain.product;

import java.util.Date;
import java.util.UUID;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@Builder
public class Product {

  private UUID id;

  private String name;
  private Long quantity;
  private String category;

  private Date createdAt;

}

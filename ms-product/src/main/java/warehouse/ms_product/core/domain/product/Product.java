package warehouse.ms_product.core.domain.product;

import java.util.Date;
import java.util.UUID;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@Builder
//===
@Entity
@Table(name = "product")
public class Product {

  @Id
  @GeneratedValue
  private UUID id;

  private String name;
  private Long quantity;
  private String category;

  private Date createdAt;

}

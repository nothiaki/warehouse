package warehouse.api_gateway.core.domain.category;

import java.util.Date;
import java.util.List;
import java.util.UUID;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import warehouse.api_gateway.core.domain.product.Product;

@Entity
@Table(name = "category")
//
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Category {

  @Id
  @GeneratedValue
  private UUID id;

  @OneToMany(mappedBy = "category")
  private List<Product> products;

  private String name;
  private Date createdAt;

}

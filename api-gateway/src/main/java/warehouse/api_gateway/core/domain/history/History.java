package warehouse.api_gateway.core.domain.history;

import java.util.List;
import java.util.UUID;

import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import warehouse.api_gateway.core.domain.product.Product;

@Entity
@Table(name = "history")
// ###
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class History {

  @Id
  @GeneratedValue
  private UUID id;

  private Status status;
  @ElementCollection
  private List<Product> products;
  @ElementCollection
  private List<Operation> operations;
  
}

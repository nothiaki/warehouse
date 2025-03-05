package warehouse.ms_notify.core.domain.notify;

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
@Table(name = "notify")
public class Notify {

  @Id
  @GeneratedValue
  private UUID id;

  private String content;
  private Boolean notified;
  private Date createdAt;

}

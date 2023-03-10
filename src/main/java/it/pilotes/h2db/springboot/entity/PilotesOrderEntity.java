package it.pilotes.h2db.springboot.entity;

/*import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;*/
import java.math.BigDecimal;
import java.time.LocalDateTime;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@NoArgsConstructor
@AllArgsConstructor
@ToString
@Getter
@Setter
@EqualsAndHashCode
@Table(name = "pilotes_orders")
@Entity
public class PilotesOrderEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "device_GEN")
  @SequenceGenerator(name = "device_GEN", sequenceName = "device_SEQ")
  @Column(name = "id", nullable = false)
  private Long id;

  @Column(unique = true)
  private BigDecimal orderNumber;

  private String deliveryAddress;

  private Integer pilotesNumber;

  private BigDecimal totalOrderAmount;

  private LocalDateTime createdAt;


  @ManyToOne(cascade= CascadeType.ALL)
  @JoinColumn(name = "customer_id")
  @OnDelete(action = OnDeleteAction.CASCADE)
  private CustomerEntity customerEntity;

}

package it.pilotes.h2db.springboot.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@ToString
@Getter
@Setter
@EqualsAndHashCode
@Table(name = "customer")
@Entity
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "customer_GEN")
    @SequenceGenerator(name = "customer_GEN", sequenceName = "customer_SEQ")
    @Column(name = "id", nullable = false)
    private Long id;
    private String name;
    private String surname;

    @Column(unique=true)
    private String telephone;

    @OneToMany(mappedBy="customer", cascade= CascadeType.ALL, fetch = FetchType.EAGER)
    private List<PilotesOrder> pilotesOrders;
}

package it.pilotes.h2db.springboot.repositry;

import it.pilotes.h2db.springboot.entity.CustomerEntity;
import it.pilotes.h2db.springboot.entity.PilotesOrderEntity;
import java.util.List;
import org.springframework.data.repository.CrudRepository;

public interface CustomerRepository extends CrudRepository<CustomerEntity, Long> {

  CustomerEntity findCustomerEntitiesByTelephone(String telephone);
  List<CustomerEntity> findCustomerEntitiesByNameContains(String customerPartialName);

}

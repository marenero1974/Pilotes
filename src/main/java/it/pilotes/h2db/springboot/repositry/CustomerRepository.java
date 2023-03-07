package it.pilotes.h2db.springboot.repositry;

import it.pilotes.h2db.springboot.entity.CustomerEntity;
import org.springframework.data.repository.CrudRepository;

public interface CustomerRepository extends CrudRepository<CustomerEntity, Long> {

}

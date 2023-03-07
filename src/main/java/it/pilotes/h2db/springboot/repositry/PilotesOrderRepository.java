package it.pilotes.h2db.springboot.repositry;

import it.pilotes.h2db.springboot.entity.PilotesOrderEntity;
import org.springframework.data.repository.CrudRepository;

public interface PilotesOrderRepository extends CrudRepository<PilotesOrderEntity, Long> {

  PilotesOrderEntity findPilotesOrderByCustomerEntityContains(String partialName);

}

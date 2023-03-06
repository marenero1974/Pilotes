package it.pilotes.h2db.springboot.repositry;

import it.pilotes.h2db.springboot.entity.PilotesOrder;
import java.util.UUID;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface PilotesOrderRepository extends CrudRepository<PilotesOrder, Long> {

  PilotesOrder findPilotesOrderByCustomerContains(String partialName);

}

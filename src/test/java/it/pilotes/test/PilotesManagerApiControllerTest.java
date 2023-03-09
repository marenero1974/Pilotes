package it.pilotes.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import it.pilotes.h2db.springboot.config.PilotesConfig;
import it.pilotes.h2db.springboot.controller.PilotesManagerApiController;
import it.pilotes.h2db.springboot.dto.Customer;
import it.pilotes.h2db.springboot.dto.InsertCustomerRequest;
import it.pilotes.h2db.springboot.dto.PilotesOrder;
import it.pilotes.h2db.springboot.repositry.CustomerRepository;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Resource;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;
import org.springframework.transaction.annotation.Transactional;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { PilotesConfig.class }, loader = AnnotationConfigContextLoader.class)
@Transactional
@DirtiesContext
public class PilotesManagerApiControllerTest {

  PilotesManagerApiController toTest = new PilotesManagerApiController();

  @Autowired
  private CustomerRepository customerRepository;


  @Test
  public void testInsertCustomer() {
    InsertCustomerRequest insertCustomerRequest = new InsertCustomerRequest();
    insertCustomerRequest.setName("insertedname");
    insertCustomerRequest.setSurname("insertedsurname");
    insertCustomerRequest.setTelephoneNumber("1");
    List<PilotesOrder> pilotes = new ArrayList<>();
    PilotesOrder pilotesOrder1 = new PilotesOrder();
    pilotesOrder1.setPilotesNumber(5);
    pilotesOrder1.setDeliveryAddress("address");
    pilotes.add(pilotesOrder1);
    insertCustomerRequest.setPilotesOrders(pilotes);
    ResponseEntity<Customer> response =  toTest.insertCustomer(insertCustomerRequest);
    assertNotEquals(null, response);
    assertEquals("insertedname", response.getBody().getName());
  }


}

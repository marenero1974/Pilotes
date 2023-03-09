package it.pilotes.h2db.springboot;


import com.fasterxml.jackson.databind.ObjectMapper;
import it.pilotes.h2db.springboot.dto.InsertCustomerRequest;
import it.pilotes.h2db.springboot.dto.PilotesOrder;
import it.pilotes.h2db.springboot.entity.CustomerEntity;
import it.pilotes.h2db.springboot.entity.PilotesOrderEntity;
import it.pilotes.h2db.springboot.repositry.CustomerRepository;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class PilotesManagerApiControllerTest {

  @Autowired
  private MockMvc mvc;

  @Autowired
  ObjectMapper objectMapper;

  @Autowired
  CustomerRepository customerRepository;


  @BeforeEach
  void setUp() {

  }

  @Test
  public void testInsertCustomerWithCorrectNumberOfPilotes() throws Exception {

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

    mvc.perform(post("/pilotes-manager/customer")
                    .contentType(MediaType.APPLICATION_JSON).content(objectMapper.writeValueAsString(insertCustomerRequest)))
            .andExpect(status().isOk())
            .andExpect(jsonPath("$.name").value("insertedname"))
            .andExpect(jsonPath("$.pilotesOrders.length()").value(1));
  }

  @Test
  public void testInsertCustomerWithIncorrectNumberOfPilotes() throws Exception {
    // When
    InsertCustomerRequest insertCustomerRequest = new InsertCustomerRequest();
    insertCustomerRequest.setName("insertedname");
    insertCustomerRequest.setSurname("insertedsurname");
    insertCustomerRequest.setTelephoneNumber("2");
    List<PilotesOrder> pilotes = new ArrayList<>();
    PilotesOrder pilotesOrder1 = new PilotesOrder();
    pilotesOrder1.setPilotesNumber(1);
    pilotesOrder1.setDeliveryAddress("address");
    pilotes.add(pilotesOrder1);
    insertCustomerRequest.setPilotesOrders(pilotes);

    mvc.perform(post("/pilotes-manager/customer")
                    .contentType(MediaType.APPLICATION_JSON).content(objectMapper.writeValueAsString(insertCustomerRequest)))
            .andExpect(status().isOk())
            .andExpect(jsonPath("$.name").value("insertedname"))
            .andExpect(jsonPath("$.pilotesOrders.length()").value(0));
  }
  
  @Test
  public void testGetAllPilotesOrder() throws Exception {
    CustomerEntity customer = new CustomerEntity();
    customer.setName("name");
    customer.setSurname("surname");
    customer.setTelephone("telephone");
    List<PilotesOrderEntity> pilotesOrderEntityList = new ArrayList<>();
    PilotesOrderEntity pilotesOrderEntity = new PilotesOrderEntity();
    pilotesOrderEntity.setPilotesNumber(5);
    pilotesOrderEntity.setDeliveryAddress("deliveryaddress");
    pilotesOrderEntity.setCreatedAt(LocalDateTime.now());
    pilotesOrderEntity.setOrderNumber(new BigDecimal(calculateRandomOrderNumber(pilotesOrderEntity)));
    pilotesOrderEntity.setTotalOrderAmount(new BigDecimal(1.33*pilotesOrderEntity.getPilotesNumber()));
    pilotesOrderEntityList.add(pilotesOrderEntity);
    customer.setPilotesOrderEntities(pilotesOrderEntityList);
    customerRepository.save(customer);
    mvc.perform(get("/pilotes-manager/orders"))
            .andExpect(status().isOk())
            .andExpect(jsonPath("$.length()").value(1));
    
  }

  private long calculateRandomOrderNumber(PilotesOrderEntity p) {
    long theRandomNum = (long) (Math.random() * Math.pow(6, 6));
    p.setOrderNumber(new BigDecimal(theRandomNum));
    return theRandomNum;
  }

}

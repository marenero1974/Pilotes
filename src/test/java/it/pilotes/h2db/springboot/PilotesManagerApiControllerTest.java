package it.pilotes.h2db.springboot;


import com.fasterxml.jackson.databind.ObjectMapper;
import it.pilotes.h2db.springboot.dto.InsertCustomerRequest;
import it.pilotes.h2db.springboot.dto.PilotesOrder;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.List;

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


  @BeforeEach
  void setUp() {

  }

  @Test
  public void testInsertCustomerWithCorrectNumberOfPilotes() throws Exception {
    // When
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
    insertCustomerRequest.setTelephoneNumber("1");
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

}

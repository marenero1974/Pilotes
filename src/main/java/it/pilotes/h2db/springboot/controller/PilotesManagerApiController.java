package it.pilotes.h2db.springboot.controller;

import it.pilotes.h2db.springboot.dto.Customer;
import it.pilotes.h2db.springboot.dto.InsertCustomerRequest;
import it.pilotes.h2db.springboot.dto.ModifyOrderRequest;
import it.pilotes.h2db.springboot.dto.PilotesOrder;
import it.pilotes.h2db.springboot.entity.CustomerEntity;
import it.pilotes.h2db.springboot.entity.PilotesOrderEntity;
import it.pilotes.h2db.springboot.mapper.CustomerMapper;
import it.pilotes.h2db.springboot.mapper.PilotesMapper;
import it.pilotes.h2db.springboot.repositry.CustomerRepository;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2023-03-07T22:49:10.180210100+01:00[Europe/Rome]")
@Controller
@RequestMapping("${openapi.pilotesManagementApplication.base-path:}")
public class PilotesManagerApiController implements PilotesManagerApi {

  private static Logger logger = LoggerFactory.getLogger(PilotesManagerApiController.class);

  @Autowired
  CustomerRepository customerRepository;


  @Override
  public ResponseEntity<List<PilotesOrder>> getAllPilotesOrders() {
    return null;
  }

  @Override
  public ResponseEntity<List<PilotesOrder>> getAllPilotesOrdersByName(
      String customerPartialName) {
    return null;
  }

  @Override
  public ResponseEntity<Customer> insertCustomer(InsertCustomerRequest insertCustomerRequest) {
    logger.debug("Inserting customer {}", insertCustomerRequest);
    CustomerEntity customerEntity = CustomerMapper.mapToEntity(insertCustomerRequest);
    customerEntity.setPilotesOrderEntities(getOrdersWithNumber(customerEntity));

    CustomerEntity savedCustomer = null;
    try {
      savedCustomer = customerRepository.save(customerEntity);
      logger.info("Customer inserted.");
    } catch (Exception e) {
      logAppError("Error while saving customer", e);
      return ResponseEntity.internalServerError().body(null);
    }

    return ResponseEntity.ok().body(CustomerMapper.mapToDto(savedCustomer));
  }

  @Override
  public ResponseEntity<PilotesOrder> insertPilotesOrder(String customerTelephone,
      String numberOfPilotes, String deliveryAddress) {
    logger.debug("Inserting new order of {} pilotes on the customer: {}", numberOfPilotes,
        customerTelephone);

    if (isValidPilotesNumber())


    try {

      CustomerEntity customerEntity = customerRepository.findCustomerEntitiesByTelephone(
          customerTelephone);
      PilotesOrderEntity pilotesOrderEntity = new PilotesOrderEntity();
      pilotesOrderEntity.setPilotesNumber(new Integer(numberOfPilotes));
      pilotesOrderEntity.setOrderNumber(
          new BigDecimal(calculateRandomOrderNumber(pilotesOrderEntity)));
      pilotesOrderEntity.setDeliveryAddress(deliveryAddress);
      pilotesOrderEntity.setCreatedAt(LocalDateTime.now());
      customerEntity.getPilotesOrderEntities().add(pilotesOrderEntity);
      customerRepository.save(customerEntity);
      return ResponseEntity.ok().body(PilotesMapper.mapToDto(pilotesOrderEntity));

    } catch (Exception e) {
      logAppError("Error while saving customer order", e);
      return ResponseEntity.internalServerError().body(null);
    }
  }


  @Override
  public ResponseEntity<PilotesOrder> modifyPilotesOrder(BigDecimal orderNumber,
      ModifyOrderRequest modifyOrderRequest) {
    return null;
  }

  private void logAppError(String message, Exception e) {
    StringBuilder errorMessage = new StringBuilder();
    errorMessage.append(message);
    errorMessage.append(System.getProperty("line.separator"));
    errorMessage.append(e.getMessage());
    logger.error(errorMessage.toString());
  }

  private List<PilotesOrderEntity> getOrdersWithNumber(CustomerEntity customerEntity) {
    List<PilotesOrderEntity> list = customerEntity.getPilotesOrderEntities()
        .stream()
        .filter(o ->
            // input validation if the number of pilotes is not 5 or
            // 10 or 15 we skip the order
            isValidPilotesNumber(o.getPilotesNumber())
        ).collect(Collectors.toList());
    list.forEach(p -> {
      calculateRandomOrderNumber(p);
    });
    return list;
  }

  private boolean isValidPilotesNumber(PilotesOrderEntity o) {
    return o.getPilotesNumber() == 5
        || o.getPilotesNumber() == 10
        || o.getPilotesNumber() == 15;
  }

  private long calculateRandomOrderNumber(PilotesOrderEntity p) {
    long theRandomNum = (long) (Math.random() * Math.pow(10, 10));
    p.setOrderNumber(new BigDecimal(theRandomNum));
    return theRandomNum;
  }
}

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
import it.pilotes.h2db.springboot.repositry.PilotesOrderRepository;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2023-03-07T22:49:10.180210100+01:00[Europe/Rome]")
@Controller
@RequestMapping("${openapi.pilotesManagementApplication.base-path:}")
public class PilotesManagerApiController implements PilotesManagerApi {

  private static Logger logger = LoggerFactory.getLogger(PilotesManagerApiController.class);

  @Autowired
  CustomerRepository customerRepository;

  @Autowired
  PilotesOrderRepository pilotesOrderRepository;


  @Override
  public ResponseEntity<List<PilotesOrder>> getAllPilotesOrders() {
    List<PilotesOrderEntity> result;
    try {
      result = StreamSupport.stream(pilotesOrderRepository.findAll().spliterator(), false)
          .collect(Collectors.toList());
    } catch (Exception e) {
      logAppError("Error while retrieving all orders", e);
      return ResponseEntity.internalServerError().body(null);
    }
    return ResponseEntity.ok().body(PilotesMapper.mapOrdersToDto(result));
  }

  @Override
  public ResponseEntity<List<PilotesOrder>> getAllPilotesOrdersByName(
      String customerPartialName) {
    List<CustomerEntity> customers;
    List<PilotesOrderEntity> pilotesOrderEntityList = new ArrayList<>();
    try {
      customers = customerRepository.findCustomerEntitiesByNameContains(customerPartialName);
      customers.forEach(cust -> {
        List<PilotesOrderEntity> customerPilotes = cust.getPilotesOrderEntities();
        pilotesOrderEntityList.addAll(customerPilotes);
      });
    } catch (Exception e) {
      logAppError("Error while retrieving all orders by partial customer name", e);
      return ResponseEntity.internalServerError().body(null);
    }
    return ResponseEntity.ok().body(PilotesMapper.mapOrdersToDto(pilotesOrderEntityList));
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

    if (isValidPilotesNumber(new Integer(numberOfPilotes))) {
      return doProcessInsert(customerTelephone, numberOfPilotes, deliveryAddress);
    } else {
      logAppError("Error while saving customer order", new IllegalArgumentException("The number of pilotes in not accepted"));
      return ResponseEntity.internalServerError().body(null);
    }
  }

  private ResponseEntity<PilotesOrder> doProcessInsert(String customerTelephone,
      String numberOfPilotes, String deliveryAddress) {
    try {

      CustomerEntity customerEntity = customerRepository.findCustomerEntitiesByTelephone(
          customerTelephone);
      PilotesOrderEntity pilotesOrderEntity = new PilotesOrderEntity();
      pilotesOrderEntity.setPilotesNumber(new Integer(numberOfPilotes));
      pilotesOrderEntity.setOrderNumber(
          new BigDecimal(calculateRandomOrderNumber(pilotesOrderEntity)));
      pilotesOrderEntity.setDeliveryAddress(deliveryAddress);
      pilotesOrderEntity.setCreatedAt(LocalDateTime.now());
      pilotesOrderEntity.setTotalOrderAmount(new BigDecimal(new Integer(numberOfPilotes)*1.33));
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

    PilotesOrder pilotesOrderReturned = null;
    if (isValidPilotesNumber(modifyOrderRequest.getPilotesNumber())) {
      try {
        PilotesOrderEntity pilotesOrder = pilotesOrderRepository.findByOrderNumber(orderNumber);
        LocalDateTime now = LocalDateTime.now();
        if(pilotesOrder.getCreatedAt().plusMinutes(5).isAfter(now)) {
          pilotesOrder.setDeliveryAddress(modifyOrderRequest.getDeliveryAddress());
          pilotesOrder.setPilotesNumber(modifyOrderRequest.getPilotesNumber());
          pilotesOrderReturned = PilotesMapper.mapToDto(pilotesOrderRepository.save(pilotesOrder));
        } else {
          throw new Exception("Cannot process the mofication of the order because of work in porgress");
        }
      } catch (Exception e) {
        logAppError("Error while modifing customer order", e);
        return ResponseEntity.internalServerError().body(null);
      }
    } else {
      logAppError("Error while modifing customer order: ", new IllegalArgumentException("The number of pilotes is not accepted"));
      return ResponseEntity.internalServerError().body(null);
    }

    return ResponseEntity.ok().body(pilotesOrderReturned);
  }

  private void logAppError(String message, Exception e) {
    StringBuilder errorMessage = new StringBuilder();
    errorMessage.append(message);
    errorMessage.append(" ");
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

  public static boolean isValidPilotesNumber(Integer numberOfPilotes) {
    return numberOfPilotes == 5 || numberOfPilotes == 10 || numberOfPilotes == 15;
  }

  private long calculateRandomOrderNumber(PilotesOrderEntity p) {
    long theRandomNum = (long) (Math.random() * Math.pow(6, 6));
    p.setOrderNumber(new BigDecimal(theRandomNum));
    return theRandomNum;
  }
}

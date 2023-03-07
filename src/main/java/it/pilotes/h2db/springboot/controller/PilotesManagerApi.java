package it.pilotes.h2db.springboot.controller;

import it.pilotes.h2db.springboot.dto.Customer;
import it.pilotes.h2db.springboot.dto.InsertCustomerRequest;
import it.pilotes.h2db.springboot.dto.ModifyOrderRequest;
import it.pilotes.h2db.springboot.dto.PilotesOrder;
import java.math.BigDecimal;
import java.util.List;
import javax.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

public interface PilotesManagerApi {

  @RequestMapping(
      value = "/pilotes-manager/orders/pilotes",
      produces = {"application/json"},
      method = RequestMethod.GET
  )
  ResponseEntity<List<PilotesOrder>> getAllPilotesOrders();

  @RequestMapping(
      value = "/pilotes-manager/orders/pilotes/{customerPartialName}",
      produces = {"application/json"},
      method = RequestMethod.GET
  )
  ResponseEntity<List<PilotesOrder>> getAllPilotesOrdersByName(
      @PathVariable("customerPartialName") String customerPartialName

  );

  @RequestMapping(
      value = "/pilotes-manager/customer",
      produces = {"application/json"},
      consumes = {"application/json"},
      method = RequestMethod.POST
  )
  ResponseEntity<Customer> insertCustomer(

      @Valid @RequestBody InsertCustomerRequest insertCustomerRequest);

  @RequestMapping(
      value = "/pilotes-manager/order/{customerTelephone}/pilotes/{numberOfPilotes}",
      produces = {"application/json"},
      method = RequestMethod.POST
  )
  ResponseEntity<PilotesOrder> insertPilotesOrder(
      @PathVariable("customerTelephone") String customerTelephone,
      @PathVariable("numberOfPilotes") String numberOfPilotes

  );

  @RequestMapping(
      value = "/pilotes-manager/order/pilotes/{orderNumber}",
      produces = {"application/json"},
      consumes = {"application/json"},
      method = RequestMethod.PATCH
  )
  ResponseEntity<PilotesOrder> modifyPilotesOrder(
      @PathVariable("orderNumber") BigDecimal orderNumber,
      @Valid @RequestBody ModifyOrderRequest modifyOrderRequest);
}
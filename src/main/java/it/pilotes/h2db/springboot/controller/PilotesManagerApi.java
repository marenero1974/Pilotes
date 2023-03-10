package it.pilotes.h2db.springboot.controller;

import it.pilotes.h2db.springboot.dto.Customer;
import it.pilotes.h2db.springboot.dto.InsertCustomerRequest;
import it.pilotes.h2db.springboot.dto.ModifyOrderRequest;
import it.pilotes.h2db.springboot.dto.PilotesOrder;
import java.math.BigDecimal;
import java.util.List;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

public interface PilotesManagerApi {

  @RequestMapping(
      value = "/pilotes-manager/orders",
      produces = {"application/json"},
      method = RequestMethod.GET
  )
  ResponseEntity<List<PilotesOrder>> getAllPilotesOrders();

  @RequestMapping(
      value = "/pilotes-manager/orders/{customerPartialName}",
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
      consumes = {"application/json"},
      produces = { "application/json" },
      method = RequestMethod.POST
  )
  ResponseEntity<PilotesOrder> insertPilotesOrder(@PathVariable("customerTelephone") String customerTelephone, @PathVariable("numberOfPilotes") String numberOfPilotes, @NotNull @RequestParam(value = "deliveryAddress", required = true) String deliveryAddress);

  @RequestMapping(
      value = "/pilotes-manager/order/{orderNumber}",
      produces = { "application/json" },
      consumes = { "application/json" },
      method = RequestMethod.PATCH
  )
  ResponseEntity<PilotesOrder> modifyPilotesOrder(@PathVariable("orderNumber") BigDecimal orderNumber, @Valid @RequestBody ModifyOrderRequest modifyOrderRequest);

  @RequestMapping(
      value = "/pilotes-manager/generate-token",

      method = RequestMethod.POST
  )
  ResponseEntity<?> generateJwtToken();

}
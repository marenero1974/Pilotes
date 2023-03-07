package it.pilotes.h2db.springboot.controller;

import java.math.BigDecimal;
import it.pilotes.h2db.springboot.dto.Customer;
import it.pilotes.h2db.springboot.dto.InsertCustomerRequest;
import it.pilotes.h2db.springboot.dto.ModifyOrderRequest;
import it.pilotes.h2db.springboot.dto.PilotesOrder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;
import java.util.List;
import javax.validation.constraints.*;
import javax.validation.Valid;

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
      method = RequestMethod.POST
  )
  ResponseEntity<Customer> insertCustomer(
      @NotNull @RequestParam(value = "input", required = true) InsertCustomerRequest input);

  @RequestMapping(
      value = "/pilotes-manager/order/{customerTelephone}/pilotes/{numberOfPilotes}",
      produces = {"application/json"},
      method = RequestMethod.POST
  )
  ResponseEntity<PilotesOrder> insertPilotesOrder(
      @PathVariable("customerTelephone") String customerTelephone,
      @PathVariable("numberOfPilotes") String numberOfPilotes);

  @RequestMapping(
      value = "/pilotes-manager/order/pilotes/{orderNumber}",
      produces = {"application/json"},
      method = RequestMethod.PATCH
  )
  ResponseEntity<PilotesOrder> modifyPilotesOrder(
      @PathVariable("orderNumber") BigDecimal orderNumber,
      @NotNull @RequestParam(value = "modifyOrderRequest", required = true) ModifyOrderRequest modifyOrderRequest);
}
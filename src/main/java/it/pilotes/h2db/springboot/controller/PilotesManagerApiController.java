package it.pilotes.h2db.springboot.controller;

import it.pilotes.h2db.springboot.dto.Customer;
import it.pilotes.h2db.springboot.dto.InsertCustomerRequest;
import it.pilotes.h2db.springboot.dto.ModifyOrderRequest;
import it.pilotes.h2db.springboot.dto.PilotesOrder;
import it.pilotes.h2db.springboot.entity.CustomerEntity;
import it.pilotes.h2db.springboot.mapper.CustomerMapper;
import it.pilotes.h2db.springboot.repositry.CustomerRepository;
import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.request.NativeWebRequest;
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

        CustomerEntity savedCustomer = null;
        try {
            savedCustomer = customerRepository.save(customerEntity);
            logger.info("Customer inserted.");
        } catch (Exception e) {
            logAppError("Error while saving customer", e);
            return ResponseEntity.internalServerError().body(new Customer());
        }

        return ResponseEntity.ok().body(CustomerMapper.mapToDto(savedCustomer));

    }

    @Override
    public ResponseEntity<PilotesOrder> insertPilotesOrder(String customerTelephone,
        String numberOfPilotes) {
        return null;
    }

    @Override
    public ResponseEntity<PilotesOrder> modifyPilotesOrder(BigDecimal orderNumber,
        ModifyOrderRequest modifyOrderRequest) {
        return null;
    }

    private void logAppError(String message, Exception e) {
        StringBuilder errorMessage = new StringBuilder();
        errorMessage.append(message);
        errorMessage.append(e.getMessage());
        logger.error(errorMessage.toString());
    }
}

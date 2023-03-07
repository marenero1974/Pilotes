package it.pilotes.h2db.springboot.controller;

import it.pilotes.h2db.springboot.dto.Customer;
import it.pilotes.h2db.springboot.dto.InsertCustomerRequest;
import it.pilotes.h2db.springboot.dto.ModifyOrderRequest;
import it.pilotes.h2db.springboot.dto.PilotesOrder;
import java.math.BigDecimal;
import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.request.NativeWebRequest;
import java.util.Optional;
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2023-03-07T18:31:08.579248400+01:00[Europe/Rome]")
@Controller
@RequestMapping("${openapi.pilotesManagementApplication.base-path:}")
public class PilotesManagerApiController implements PilotesManagerApi {


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
    public ResponseEntity<Customer> insertCustomer(InsertCustomerRequest input) {
        return null;
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
}

package it.pilotes.h2db.springboot.mapper;

import it.pilotes.h2db.springboot.dto.Customer;
import it.pilotes.h2db.springboot.dto.InsertCustomerRequest;
import it.pilotes.h2db.springboot.dto.PilotesOrder;
import it.pilotes.h2db.springboot.entity.CustomerEntity;
import it.pilotes.h2db.springboot.entity.PilotesOrderEntity;
import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

public class CustomerMapper {


  public static CustomerEntity mapToEntity(InsertCustomerRequest dto) {
    CustomerEntity customerEntity = null;
    if (dto != null) {
      customerEntity = new CustomerEntity();
      customerEntity.setName(dto.getName());
      customerEntity.setSurname(dto.getSurname());
      customerEntity.setTelephone(dto.getTelephoneNumber());
      CustomerEntity finalCustomerEntity = customerEntity;
      List<PilotesOrderEntity> pilotesOrderEntityList = dto.getPilotesOrders().stream()
          .map(p -> {
            PilotesOrderEntity pilotesOrderEntity = new PilotesOrderEntity();
            pilotesOrderEntity.setCustomerEntity(finalCustomerEntity);
            pilotesOrderEntity.setOrderNumber(p.getOrderNumber());
            pilotesOrderEntity.setPilotesNumber(p.getPilotesNumber());
            pilotesOrderEntity.setDeliveryAddress(p.getDeliveryAddress());
            pilotesOrderEntity.setTotalOrderAmount(new BigDecimal(1.33*p.getPilotesNumber()));
            return pilotesOrderEntity;
          })
          .collect(Collectors.toList());
      customerEntity.setPilotesOrderEntities(pilotesOrderEntityList);
    }
    return customerEntity;
  }

  public static Customer mapToDto(CustomerEntity customerEntity) {
    Customer customerDTO = new Customer();
    if(customerEntity !=null) {
      customerDTO.setName(customerEntity.getName());
      customerDTO.setSurname(customerEntity.getSurname());
      customerDTO.setTelephoneNumber(customerEntity.getTelephone());
      List<PilotesOrder> pilotesOrders = customerEntity.getPilotesOrderEntities()
          .stream()
          .map(o -> {
            PilotesOrder pilotesOrder = new PilotesOrder();
            pilotesOrder.setPilotesNumber(o.getPilotesNumber());
            pilotesOrder.setOrderNumber(o.getOrderNumber());
            pilotesOrder.setDeliveryAddress(o.getDeliveryAddress());
            pilotesOrder.setTotalOrderAmount(o.getTotalOrderAmount());
            return pilotesOrder;
          })
          .collect(Collectors.toList());
      customerDTO.setPilotesOrders(pilotesOrders);
    }
    return customerDTO;
  }

}

package it.pilotes.h2db.springboot.mapper;

import it.pilotes.h2db.springboot.dto.Customer;
import it.pilotes.h2db.springboot.dto.InsertCustomerRequest;
import it.pilotes.h2db.springboot.dto.PilotesOrder;
import it.pilotes.h2db.springboot.entity.CustomerEntity;
import it.pilotes.h2db.springboot.entity.PilotesOrderEntity;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

public class PilotesMapper {


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
            pilotesOrderEntity.setTotalOrderAmount(new BigDecimal(1.33 * p.getPilotesNumber()));
            pilotesOrderEntity.setCreatedAt(LocalDateTime.now());
            return pilotesOrderEntity;

          })
          .collect(Collectors.toList());
      customerEntity.setPilotesOrderEntities(pilotesOrderEntityList);
    }
    return customerEntity;
  }

  public static PilotesOrder mapToDto(PilotesOrderEntity pilotesOrderEntity) {
    PilotesOrder pilotesOrder = new PilotesOrder();
    if (pilotesOrderEntity != null) {
      pilotesOrder.setPilotesNumber(pilotesOrderEntity.getPilotesNumber());
      pilotesOrder.setCreatedAt(pilotesOrderEntity.getCreatedAt());
      pilotesOrder.setDeliveryAddress(pilotesOrderEntity.getDeliveryAddress());
      pilotesOrder.setTotalOrderAmount(pilotesOrderEntity.getTotalOrderAmount());
    }
    return pilotesOrder;
  }

}

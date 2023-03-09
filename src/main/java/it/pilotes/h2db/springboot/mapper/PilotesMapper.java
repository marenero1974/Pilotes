package it.pilotes.h2db.springboot.mapper;

import it.pilotes.h2db.springboot.dto.InsertCustomerRequest;
import it.pilotes.h2db.springboot.dto.PilotesOrder;
import it.pilotes.h2db.springboot.entity.CustomerEntity;
import it.pilotes.h2db.springboot.entity.PilotesOrderEntity;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import static it.pilotes.h2db.springboot.mapper.CustomerMapper.getCustomerEntity;

public class PilotesMapper {


  public static CustomerEntity mapToEntity(InsertCustomerRequest dto) {
      return getCustomerEntity(dto);
  }

  public static PilotesOrder mapToDto(PilotesOrderEntity pilotesOrderEntity) {
    PilotesOrder pilotesOrder = new PilotesOrder();
    if (pilotesOrderEntity != null) {
      pilotesOrder.setOrderNumber(pilotesOrderEntity.getOrderNumber());
      pilotesOrder.setPilotesNumber(pilotesOrderEntity.getPilotesNumber());
      pilotesOrder.setCreatedAt(pilotesOrderEntity.getCreatedAt());
      pilotesOrder.setDeliveryAddress(pilotesOrderEntity.getDeliveryAddress());
      pilotesOrder.setTotalOrderAmount(pilotesOrderEntity.getTotalOrderAmount());
    }
    return pilotesOrder;
  }

  public static List<PilotesOrder> mapOrdersToDto(List<PilotesOrderEntity> input) {
    return input.stream().map(order -> {
      PilotesOrder pilotesOrder = new PilotesOrder();
      pilotesOrder.setOrderNumber(order.getOrderNumber());
      pilotesOrder.setPilotesNumber(order.getPilotesNumber());
      pilotesOrder.setTotalOrderAmount(order.getTotalOrderAmount());
      pilotesOrder.setDeliveryAddress(order.getDeliveryAddress());
      pilotesOrder.setCreatedAt(order.getCreatedAt());

      return pilotesOrder;
    }).collect(Collectors.toList());
}

}

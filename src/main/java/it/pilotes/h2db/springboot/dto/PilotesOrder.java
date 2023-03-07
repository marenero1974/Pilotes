package it.pilotes.h2db.springboot.dto;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import it.pilotes.h2db.springboot.dto.Customer;
import java.math.BigDecimal;
import org.openapitools.jackson.nullable.JsonNullable;
import javax.validation.Valid;
import javax.validation.constraints.*;


@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2023-03-07T18:31:08.579248400+01:00[Europe/Rome]")
public class PilotesOrder   {
  @JsonProperty("orderNumber")
  private BigDecimal orderNumber;

  @JsonProperty("deliveryAddress")
  private String deliveryAddress;

  @JsonProperty("pilotesNumber")
  private Integer pilotesNumber;

  @JsonProperty("totalOrderAmount")
  private BigDecimal totalOrderAmount;

  @JsonProperty("customer")
  private Customer customer;

  /**
   **/
  public PilotesOrder orderNumber(BigDecimal orderNumber) {
    this.orderNumber = orderNumber;
    return this;
  }

  
  @ApiModelProperty(value = "")
  @JsonProperty("orderNumber")
  public BigDecimal getOrderNumber() {
    return orderNumber;
  }
  public void setOrderNumber(BigDecimal orderNumber) {
    this.orderNumber = orderNumber;
  }

  /**
   **/
  public PilotesOrder deliveryAddress(String deliveryAddress) {
    this.deliveryAddress = deliveryAddress;
    return this;
  }

  
  @ApiModelProperty(value = "")
  @JsonProperty("deliveryAddress")
  public String getDeliveryAddress() {
    return deliveryAddress;
  }
  public void setDeliveryAddress(String deliveryAddress) {
    this.deliveryAddress = deliveryAddress;
  }

  /**
   **/
  public PilotesOrder pilotesNumber(Integer pilotesNumber) {
    this.pilotesNumber = pilotesNumber;
    return this;
  }

  
  @ApiModelProperty(value = "")
  @JsonProperty("pilotesNumber")
  public Integer getPilotesNumber() {
    return pilotesNumber;
  }
  public void setPilotesNumber(Integer pilotesNumber) {
    this.pilotesNumber = pilotesNumber;
  }

  /**
   **/
  public PilotesOrder totalOrderAmount(BigDecimal totalOrderAmount) {
    this.totalOrderAmount = totalOrderAmount;
    return this;
  }

  
  @ApiModelProperty(value = "")
  @JsonProperty("totalOrderAmount")
  public BigDecimal getTotalOrderAmount() {
    return totalOrderAmount;
  }
  public void setTotalOrderAmount(BigDecimal totalOrderAmount) {
    this.totalOrderAmount = totalOrderAmount;
  }

  /**
   **/
  public PilotesOrder customer(Customer customer) {
    this.customer = customer;
    return this;
  }

  
  @ApiModelProperty(value = "")
  @JsonProperty("customer")
  public Customer getCustomer() {
    return customer;
  }
  public void setCustomer(Customer customer) {
    this.customer = customer;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    PilotesOrder pilotesOrder = (PilotesOrder) o;
    return Objects.equals(orderNumber, pilotesOrder.orderNumber) &&
        Objects.equals(deliveryAddress, pilotesOrder.deliveryAddress) &&
        Objects.equals(pilotesNumber, pilotesOrder.pilotesNumber) &&
        Objects.equals(totalOrderAmount, pilotesOrder.totalOrderAmount) &&
        Objects.equals(customer, pilotesOrder.customer);
  }

  @Override
  public int hashCode() {
    return Objects.hash(orderNumber, deliveryAddress, pilotesNumber, totalOrderAmount, customer);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class PilotesOrder {\n");
    
    sb.append("    orderNumber: ").append(toIndentedString(orderNumber)).append("\n");
    sb.append("    deliveryAddress: ").append(toIndentedString(deliveryAddress)).append("\n");
    sb.append("    pilotesNumber: ").append(toIndentedString(pilotesNumber)).append("\n");
    sb.append("    totalOrderAmount: ").append(toIndentedString(totalOrderAmount)).append("\n");
    sb.append("    customer: ").append(toIndentedString(customer)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}


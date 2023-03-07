package it.pilotes.h2db.springboot.dto;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import org.openapitools.jackson.nullable.JsonNullable;
import javax.validation.Valid;
import javax.validation.constraints.*;


@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2023-03-07T22:31:07.048105500+01:00[Europe/Rome]")
public class ModifyOrderRequest   {
  @JsonProperty("orderNumber")
  private BigDecimal orderNumber;

  @JsonProperty("deliveryAddress")
  private String deliveryAddress;

  @JsonProperty("pilotesNumber")
  private Integer pilotesNumber;

  /**
   **/
  public ModifyOrderRequest orderNumber(BigDecimal orderNumber) {
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
  public ModifyOrderRequest deliveryAddress(String deliveryAddress) {
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
  public ModifyOrderRequest pilotesNumber(Integer pilotesNumber) {
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


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ModifyOrderRequest modifyOrderRequest = (ModifyOrderRequest) o;
    return Objects.equals(orderNumber, modifyOrderRequest.orderNumber) &&
        Objects.equals(deliveryAddress, modifyOrderRequest.deliveryAddress) &&
        Objects.equals(pilotesNumber, modifyOrderRequest.pilotesNumber);
  }

  @Override
  public int hashCode() {
    return Objects.hash(orderNumber, deliveryAddress, pilotesNumber);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ModifyOrderRequest {\n");
    
    sb.append("    orderNumber: ").append(toIndentedString(orderNumber)).append("\n");
    sb.append("    deliveryAddress: ").append(toIndentedString(deliveryAddress)).append("\n");
    sb.append("    pilotesNumber: ").append(toIndentedString(pilotesNumber)).append("\n");
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


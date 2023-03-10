package it.pilotes.h2db.springboot.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Objects;


@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2023-03-08T11:50:48.479657+01:00[Europe/Rome]")
public class PilotesOrder {
  @JsonProperty("orderNumber")
  private BigDecimal orderNumber;

  @JsonProperty("deliveryAddress")
  private String deliveryAddress;

  @JsonProperty("pilotesNumber")
  private Integer pilotesNumber;

  @JsonProperty("totalOrderAmount")
  private BigDecimal totalOrderAmount;

  @JsonProperty("createdAt")
  private LocalDateTime createdAt;

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
  public PilotesOrder createdAt(LocalDateTime createdAt) {
    this.createdAt = createdAt;
    return this;
  }

  
  @ApiModelProperty(value = "")
  @JsonProperty("createdAt")
  public LocalDateTime getCreatedAt() {
    return createdAt;
  }
  public void setCreatedAt(LocalDateTime createdAt) {
    this.createdAt = createdAt;
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
        Objects.equals(createdAt, pilotesOrder.createdAt);
  }

  @Override
  public int hashCode() {
    return Objects.hash(orderNumber, deliveryAddress, pilotesNumber, totalOrderAmount, createdAt);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class PilotesOrder {\n");
    
    sb.append("    orderNumber: ").append(toIndentedString(orderNumber)).append("\n");
    sb.append("    deliveryAddress: ").append(toIndentedString(deliveryAddress)).append("\n");
    sb.append("    pilotesNumber: ").append(toIndentedString(pilotesNumber)).append("\n");
    sb.append("    totalOrderAmount: ").append(toIndentedString(totalOrderAmount)).append("\n");
    sb.append("    createdAt: ").append(toIndentedString(createdAt)).append("\n");
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


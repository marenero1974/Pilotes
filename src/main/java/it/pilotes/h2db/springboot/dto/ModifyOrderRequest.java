package it.pilotes.h2db.springboot.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import java.util.Objects;


@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2023-03-09T15:04:48.063291800+01:00[Europe/Rome]")
public class ModifyOrderRequest {
  @JsonProperty("deliveryAddress")
  private String deliveryAddress;

  @JsonProperty("pilotesNumber")
  private Integer pilotesNumber;

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
    return Objects.equals(deliveryAddress, modifyOrderRequest.deliveryAddress) &&
        Objects.equals(pilotesNumber, modifyOrderRequest.pilotesNumber);
  }

  @Override
  public int hashCode() {
    return Objects.hash(deliveryAddress, pilotesNumber);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ModifyOrderRequest {\n");
    
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


package it.pilotes.h2db.springboot.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import java.util.List;
import java.util.Objects;


@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2023-03-07T22:31:07.048105500+01:00[Europe/Rome]")
public class InsertCustomerRequest   {
  @JsonProperty("name")
  private String name;

  @JsonProperty("surname")
  private String surname;

  @JsonProperty("telephoneNumber")
  private String telephoneNumber;

  @JsonProperty("pilotesOrders")
  private List<PilotesOrder> pilotesOrders = null;

  /**
   **/
  public InsertCustomerRequest name(String name) {
    this.name = name;
    return this;
  }

  
  @ApiModelProperty(required = true, value = "")
  @JsonProperty("name")
  public String getName() {
    return name;
  }
  public void setName(String name) {
    this.name = name;
  }

  /**
   **/
  public InsertCustomerRequest surname(String surname) {
    this.surname = surname;
    return this;
  }

  
  @ApiModelProperty(required = true, value = "")
  @JsonProperty("surname")
  public String getSurname() {
    return surname;
  }
  public void setSurname(String surname) {
    this.surname = surname;
  }

  /**
   **/
  public InsertCustomerRequest telephoneNumber(String telephoneNumber) {
    this.telephoneNumber = telephoneNumber;
    return this;
  }

  
  @ApiModelProperty(required = true, value = "")
  @JsonProperty("telephoneNumber")
  public String getTelephoneNumber() {
    return telephoneNumber;
  }
  public void setTelephoneNumber(String telephoneNumber) {
    this.telephoneNumber = telephoneNumber;
  }

  /**
   **/
  public InsertCustomerRequest pilotesOrders(List<PilotesOrder> pilotesOrders) {
    this.pilotesOrders = pilotesOrders;
    return this;
  }

  
  @ApiModelProperty(value = "")
  @JsonProperty("pilotesOrders")
  public List<PilotesOrder> getPilotesOrders() {
    return pilotesOrders;
  }
  public void setPilotesOrders(List<PilotesOrder> pilotesOrders) {
    this.pilotesOrders = pilotesOrders;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    InsertCustomerRequest insertCustomerRequest = (InsertCustomerRequest) o;
    return Objects.equals(name, insertCustomerRequest.name) &&
        Objects.equals(surname, insertCustomerRequest.surname) &&
        Objects.equals(telephoneNumber, insertCustomerRequest.telephoneNumber) &&
        Objects.equals(pilotesOrders, insertCustomerRequest.pilotesOrders);
  }

  @Override
  public int hashCode() {
    return Objects.hash(name, surname, telephoneNumber, pilotesOrders);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class InsertCustomerRequest {\n");
    
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    surname: ").append(toIndentedString(surname)).append("\n");
    sb.append("    telephoneNumber: ").append(toIndentedString(telephoneNumber)).append("\n");
    sb.append("    pilotesOrders: ").append(toIndentedString(pilotesOrders)).append("\n");
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


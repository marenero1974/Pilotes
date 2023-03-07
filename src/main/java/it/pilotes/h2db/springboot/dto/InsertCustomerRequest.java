package it.pilotes.h2db.springboot.dto;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.openapitools.jackson.nullable.JsonNullable;
import javax.validation.Valid;
import javax.validation.constraints.*;


@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2023-03-07T18:31:08.579248400+01:00[Europe/Rome]")
public class InsertCustomerRequest   {
  @JsonProperty("name")
  private String name;

  @JsonProperty("surname")
  private String surname;

  @JsonProperty("telephoneNumber")
  private String telephoneNumber;

  @JsonProperty("indirizzo")
  private String indirizzo;

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
  public InsertCustomerRequest indirizzo(String indirizzo) {
    this.indirizzo = indirizzo;
    return this;
  }

  
  @ApiModelProperty(value = "")
  @JsonProperty("indirizzo")
  public String getIndirizzo() {
    return indirizzo;
  }
  public void setIndirizzo(String indirizzo) {
    this.indirizzo = indirizzo;
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
        Objects.equals(indirizzo, insertCustomerRequest.indirizzo);
  }

  @Override
  public int hashCode() {
    return Objects.hash(name, surname, telephoneNumber, indirizzo);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class InsertCustomerRequest {\n");
    
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    surname: ").append(toIndentedString(surname)).append("\n");
    sb.append("    telephoneNumber: ").append(toIndentedString(telephoneNumber)).append("\n");
    sb.append("    indirizzo: ").append(toIndentedString(indirizzo)).append("\n");
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


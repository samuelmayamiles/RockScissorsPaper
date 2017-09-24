package com.smm.rockscissorspaper.controller.responses;

import com.fasterxml.jackson.annotation.JsonInclude;

import org.springframework.stereotype.Component;

/**
 * Class to respond changes in the properties.
 */
@Component
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ConfigurationResponse implements IResponse {

  /**
   * Name of the property.
   */
  private String propertyName;
  /**
   * Value of the property.
   */
  private Integer propertyValue;

  // Constructors
  /**
   * Default Constructor.
   */
  public ConfigurationResponse() {

  }

  /**
   * Parametrised Constructor.
   * @param propertyNewName The property Name.
   * @param propertyNewValue The property Value.
   */
  public ConfigurationResponse(final String propertyNewName,
      final Integer propertyNewValue) {
    this.propertyName = propertyNewName;
    this.propertyValue = propertyNewValue;
  }

  // Getters & Setters
  /**
   * @return the propertyName
   */
  public String getPropertyName() {
    return propertyName;
  }

  /**
   * @param propertyNewName the propertyName to set
   */
  public void setPropertyName(final String propertyNewName) {
    this.propertyName = propertyNewName;
  }

  /**
   * @return the propertyValue
   */
  public Integer getPropertyValue() {
    return propertyValue;
  }

  /**
   * @param propertyNewValue the propertyValue to set
   */
  public void setPropertyValue(final Integer propertyNewValue) {
    this.propertyValue = propertyNewValue;
  }

}

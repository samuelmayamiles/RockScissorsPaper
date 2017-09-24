package com.smm.rockscissorspaper.controller.requests;

import org.springframework.stereotype.Component;

/**
 * Class to request changes in the properties.
 */
@Component
public class ConfigurationRequest implements IRequest {

  /**
   * Name of the property.
   */
  private String propertyName;

  /**
   * Value of the property.
   */
  private Integer propertyValue;

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

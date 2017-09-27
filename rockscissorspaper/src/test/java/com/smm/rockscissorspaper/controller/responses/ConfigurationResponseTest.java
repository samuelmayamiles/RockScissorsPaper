package com.smm.rockscissorspaper.controller.responses;

import com.smm.rockscissorspaper.Mocker;

import org.junit.Assert;
import org.junit.Test;
import org.mockito.InjectMocks;

/**
 * ConfigurationResponse Tests Class.
 */
public class ConfigurationResponseTest extends Mocker {

  /**
   * Class under Test.
   */
  @InjectMocks
  private ConfigurationResponse response = new ConfigurationResponse();

  /**
   * Testing Setter.
   */
  @Test
  public void testSetPropertyName() {
    response.setPropertyName("");

    Assert.assertTrue(response.getPropertyName().equalsIgnoreCase(""));
  }

  /**
   * Testing Setter.
   */
  @Test
  public void testSetPropertyValue() {
    response.setPropertyValue(0);

    Assert.assertTrue(response.getPropertyValue() == 0);
  }

}

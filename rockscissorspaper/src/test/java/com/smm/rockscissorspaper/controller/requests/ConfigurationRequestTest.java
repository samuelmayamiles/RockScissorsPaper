package com.smm.rockscissorspaper.controller.requests;

import com.smm.rockscissorspaper.Mocker;

import org.junit.Assert;
import org.junit.Test;
import org.mockito.InjectMocks;

/**
 * ConfigurationRequest Tests Class.
 */
public class ConfigurationRequestTest extends Mocker {

  /**
   * Class under Test.
   */
  @InjectMocks
  private ConfigurationRequest request = new ConfigurationRequest();

  /**
   * Testing Setter.
   */
  @Test
  public void testSetPropertyName() {
    request.setPropertyName("");

    Assert.assertTrue(request.getPropertyName().equalsIgnoreCase(""));
  }

  /**
   * Testing Setter.
   */
  @Test
  public void testSetPropertyValue() {
    request.setPropertyValue(0);

    Assert.assertTrue(request.getPropertyValue() == 0);
  }

}

package com.smm.rockscissorspaper.services;

import com.smm.rockscissorspaper.Mocker;
import com.smm.rockscissorspaper.configuration.RockScissorsPaperConstants;
import com.smm.rockscissorspaper.controller.responses.IResponse;
import com.smm.rockscissorspaper.exception.RockScissorsPaperException;

import org.junit.Assert;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mockito;

/**
 * ConfigurationService Tests Class.
 */
public class ConfigurationServiceTest extends Mocker {

  /**
   * Class under Test.
   */
  @InjectMocks
  private ConfigurationService service = new ConfigurationService();

  /**
   * Exception for Null Request.
   * @throws RockScissorsPaperException When errors occur.
   */
  @Test(expected = RockScissorsPaperException.class)
  public void testValidateRequestNull() throws RockScissorsPaperException {
    service.validateRequest(null);
  }

  /**
   * Exception for Null Property Name.
   * @throws RockScissorsPaperException When errors occur.
   */
  @Test(expected = RockScissorsPaperException.class)
  public void testValidateRequestPropertyNameNull()
      throws RockScissorsPaperException {
    Mockito.when(mockConfigurationRequest.getPropertyName()).thenReturn(null);

    service.validateRequest(mockConfigurationRequest);
  }

  /**
   * Exception for Empty Property Name.
   * @throws RockScissorsPaperException When errors occur.
   */
  @Test(expected = RockScissorsPaperException.class)
  public void testValidateRequestPropertyNameEmpty()
      throws RockScissorsPaperException {
    Mockito.when(mockConfigurationRequest.getPropertyName()).thenReturn("");

    service.validateRequest(mockConfigurationRequest);
  }

  /**
   * Exception for Null Property Value.
   * @throws RockScissorsPaperException When errors occur.
   */
  @Test(expected = RockScissorsPaperException.class)
  public void testValidateRequestPropertyValueNull()
      throws RockScissorsPaperException {
    Mockito.when(mockConfigurationRequest.getPropertyName()).thenReturn(
        RockScissorsPaperConstants.PROPERTY_ROUNDS);
    Mockito.when(mockConfigurationRequest.getPropertyValue()).thenReturn(null);

    service.validateRequest(mockConfigurationRequest);
  }

  /**
   * Exception for Non Positive Property Value.
   * @throws RockScissorsPaperException When errors occur.
   */
  @Test(expected = RockScissorsPaperException.class)
  public void testValidateRequestPropertyValueNegative()
      throws RockScissorsPaperException {
    Mockito.when(mockConfigurationRequest.getPropertyName()).thenReturn(
        RockScissorsPaperConstants.PROPERTY_ROUNDS);
    Mockito.when(mockConfigurationRequest.getPropertyValue()).thenReturn(0);

    service.validateRequest(mockConfigurationRequest);
  }

  /**
   * Exception for Non Existing Property Value.
   * @throws RockScissorsPaperException When errors occur.
   */
  @Test(expected = RockScissorsPaperException.class)
  public void testPerformOperationsNotDefined()
      throws RockScissorsPaperException {
    Mockito.when(mockConfigurationRequest.getPropertyName()).thenReturn(
        "Not a property");
    Mockito.when(mockConfigurationRequest.getPropertyValue()).thenReturn(1);

    service.performOperations(mockConfigurationRequest, null);
  }

  /**
   * Test Process Request.
   * @throws RockScissorsPaperException When errors occur.
   */
  @Test
  public void testProcessRequest() throws RockScissorsPaperException {
    Mockito.when(mockConfigurationRequest.getPropertyName()).thenReturn(
        RockScissorsPaperConstants.PROPERTY_ROUNDS);
    Mockito.when(mockConfigurationRequest.getPropertyValue()).thenReturn(1);

    IResponse response = service.processRequest(mockConfigurationRequest, null);
    Assert.assertTrue(response != null);
  }

}

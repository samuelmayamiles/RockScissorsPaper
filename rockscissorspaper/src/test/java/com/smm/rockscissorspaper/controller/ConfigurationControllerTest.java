package com.smm.rockscissorspaper.controller;

import com.smm.rockscissorspaper.Mocker;
import com.smm.rockscissorspaper.configuration.RockScissorsPaperConstants;
import com.smm.rockscissorspaper.controller.responses.IResponse;

import org.junit.Assert;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

/**
 * ConfigurationController Tests Class.
 */
public class ConfigurationControllerTest extends Mocker {

  /**
   * Class under Test.
   */
  @InjectMocks
  private ConfigurationController controller = new ConfigurationController();

  /**
   * Error Response returned.
   */
  @Test
  public void testHandleRequestError() {
    ResponseEntity<IResponse> response =
        controller.handleRequest(mockConfigurationRequest);

    Assert.assertTrue(response.getStatusCode() == HttpStatus.BAD_REQUEST);
  }

  /**
   * Normal behaviour.
   */
  @Test
  public void testHandleRequest() {
    Mockito.when(mockConfigurationRequest.getPropertyName()).thenReturn(
        RockScissorsPaperConstants.PROPERTY_ROUNDS);
    Mockito.when(mockConfigurationRequest.getPropertyValue()).thenReturn(1);

    ResponseEntity<IResponse> response =
        controller.handleRequest(mockConfigurationRequest);

    Assert.assertTrue(response.getStatusCode() == HttpStatus.OK);
  }

}

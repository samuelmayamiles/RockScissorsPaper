package com.smm.rockscissorspaper.controller.responses;

import com.smm.rockscissorspaper.Mocker;
import com.smm.rockscissorspaper.configuration.RockScissorsPaperConstants;
import com.smm.rockscissorspaper.exception.RockScissorsPaperException;

import org.junit.Assert;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.springframework.http.HttpStatus;

/**
 * ErrorResponse Tests Class.
 */
public class ErrorResponseTest extends Mocker {

  /**
   * Class under Test.
   */
  @InjectMocks
  private ErrorResponse response = new ErrorResponse();

  /**
   * Test default error.
   */
  @Test
  public void testDefaultError() {
    response = new ErrorResponse(new RockScissorsPaperException(0));

    Assert.assertEquals(response.getHttpStatus(),
        HttpStatus.INTERNAL_SERVER_ERROR);
  }

  /**
   * Test Known error.
   */
  @Test
  public void testKnownError() {
    response =
        new ErrorResponse(new RockScissorsPaperException(
            RockScissorsPaperConstants.CODE_400_VALUE, new Throwable("Error")));

    Assert.assertEquals(response.getHttpStatus(), HttpStatus.BAD_REQUEST);
  }

  /**
   * Testing Setter.
   */
  @Test
  public void testSetStatus() {
    response.setStatus(0);

    Assert.assertTrue(response.getStatus() == 0);
  }

  /**
   * Testing Setter.
   */
  @Test
  public void testSetErrorCode() {
    response.setErrorCode(0);

    Assert.assertTrue(response.getErrorCode() == 0);
  }

  /**
   * Testing Setter.
   */
  @Test
  public void testSetMessage() {
    response.setMessage("");

    Assert.assertTrue(response.getMessage().equalsIgnoreCase(""));
  }

  /**
   * Testing Setter.
   */
  @Test
  public void testSetHttpStatus() {
    response.setHttpStatus(HttpStatus.OK);

    Assert.assertTrue(response.getHttpStatus() == HttpStatus.OK);
  }

}

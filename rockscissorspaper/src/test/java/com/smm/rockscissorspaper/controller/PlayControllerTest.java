package com.smm.rockscissorspaper.controller;

import com.smm.rockscissorspaper.Mocker;
import com.smm.rockscissorspaper.configuration.RockScissorsPaperConstants;
import com.smm.rockscissorspaper.controller.responses.IResponse;
import com.smm.rockscissorspaper.exception.RockScissorsPaperException;

import org.junit.Assert;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

/**
 * PlayController Tests Class.
 */
public class PlayControllerTest extends Mocker {

  /**
   * Class under Test.
   */
  @InjectMocks
  private PlayController controller = new PlayController();

  /**
   * Error Response returned.
   * @throws RockScissorsPaperException When errors occur.
   */
  @Test
  public void testHandleRequestError() throws RockScissorsPaperException {
    Mockito.when(mockPlayService.processRequest(null, null)).thenThrow(
        new RockScissorsPaperException(
            RockScissorsPaperConstants.CODE_400_VALUE));

    ResponseEntity<IResponse> response = controller.handleRequest();

    Assert.assertTrue(response.getStatusCode() == HttpStatus.BAD_REQUEST);
  }

  /**
   * Normal behaviour.
   */
  @Test
  public void testHandleRequest() {

    ResponseEntity<IResponse> response = controller.handleRequest();

    Assert.assertTrue(response.getStatusCode() == HttpStatus.OK);
  }

}

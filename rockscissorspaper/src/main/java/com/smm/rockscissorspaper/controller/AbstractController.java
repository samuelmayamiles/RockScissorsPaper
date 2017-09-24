package com.smm.rockscissorspaper.controller;

import com.smm.rockscissorspaper.controller.responses.ErrorResponse;
import com.smm.rockscissorspaper.controller.responses.IResponse;
import com.smm.rockscissorspaper.exception.RockScissorsPaperException;

import org.springframework.http.ResponseEntity;

/**
 * Encapsulating Class for Controller Classes common functionalities.
 */
public abstract class AbstractController {

  /**
   * Creates an error Response from a thrown RockScissorsPaperException
   * exception.
   * @param exception The triggering RockScissorsPaperException.
   * @return An error Response Entity.
   */
  protected static final ResponseEntity<IResponse> processError(
      final RockScissorsPaperException exception) {
    ErrorResponse response = new ErrorResponse(exception);
    return new ResponseEntity<IResponse>(response, response.getHttpStatus());
  }
}

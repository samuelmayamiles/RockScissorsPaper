package com.smm.rockscissorspaper.services;

import com.smm.rockscissorspaper.controller.requests.IRequest;
import com.smm.rockscissorspaper.controller.responses.IResponse;
import com.smm.rockscissorspaper.exception.RockScissorsPaperException;

/**
 * Encapsulating Interface for Service Classes.
 */
public interface IRockScissorsPaperService {

  /**
   * Caller method to process Requests.
   * @param request The incoming Request.
   * @param operationType The Operation to perform.
   * @return A Response for the Request.
   * @throws RockScissorsPaperException When an error occurs.
   */
  IResponse processRequest(IRequest request, String operationType)
      throws RockScissorsPaperException;

  /**
   * Method to validate Requests.
   * @param request The incoming Request.
   * @throws RockScissorsPaperException When an error occurs.
   */
  void validateRequest(IRequest request) throws RockScissorsPaperException;

  /**
   * Method to execute the Service Operations.
   * @param request The incoming Request.
   * @param operationType The Operation to perform.
   * @return A Response for the Request.
   * @throws RockScissorsPaperException When an error occurs.
   */
  IResponse performOperations(IRequest request, String operationType)
      throws RockScissorsPaperException;
}

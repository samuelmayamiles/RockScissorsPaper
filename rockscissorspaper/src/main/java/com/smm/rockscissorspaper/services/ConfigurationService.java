package com.smm.rockscissorspaper.services;

import com.smm.rockscissorspaper.configuration.RockScissorsPaperConstants;
import com.smm.rockscissorspaper.controller.requests.ConfigurationRequest;
import com.smm.rockscissorspaper.controller.requests.IRequest;
import com.smm.rockscissorspaper.controller.responses.ConfigurationResponse;
import com.smm.rockscissorspaper.controller.responses.IResponse;
import com.smm.rockscissorspaper.exception.RockScissorsPaperException;

import org.springframework.stereotype.Service;

/**
 * Service Class to handle Configuration Requests.
 */
@Service
public class ConfigurationService implements IRockScissorsPaperService {

  /**
   * Method to process a Configuration Request.
   * @param request The incoming Request.
   * @param operationType The Operation to perform.
   * @return A Response for the Request.
   * @throws RockScissorsPaperException When an error occurs.
   */
  public IResponse processRequest(final IRequest request,
      final String operationType) throws RockScissorsPaperException {
    validateRequest(request);
    return performOperations(request, operationType);
  }

  /**
   * Method to validate a Configuration Request.
   * @param request The incoming Request.
   * @throws RockScissorsPaperException When an error occurs.
   */
  public void validateRequest(final IRequest request)
      throws RockScissorsPaperException {
    ConfigurationRequest configurationRequest = (ConfigurationRequest) request;

    if (configurationRequest == null) {
      throw new RockScissorsPaperException(
          RockScissorsPaperConstants.CODE_400_VALUE);
    }

    if (configurationRequest.getPropertyName() == null
        || configurationRequest.getPropertyName().isEmpty()) {
      throw new RockScissorsPaperException(
          RockScissorsPaperConstants.CODE_400_VALUE);
    }

    if (configurationRequest.getPropertyValue() == null
        || configurationRequest.getPropertyValue() <= 0) {
      throw new RockScissorsPaperException(
          RockScissorsPaperConstants.CODE_400_VALUE);
    }
  }

  /**
   * Method to execute the Configuration Operations.
   * @param request The incoming Request.
   * @param operationType The Operation to perform.
   * @return A Response for the Request.
   * @throws RockScissorsPaperException When an error occurs.
   */
  public IResponse performOperations(final IRequest request,
      final String operationType) throws RockScissorsPaperException {
    ConfigurationRequest configurationRequest = (ConfigurationRequest) request;
    String propertyName = configurationRequest.getPropertyName().toLowerCase();

    switch (propertyName) {
      case "rounds":
        PlayService.setGamesToPlay(configurationRequest.getPropertyValue());
        break;
      default:
        throw new RockScissorsPaperException(
            RockScissorsPaperConstants.CODE_400_VALUE);
    }

    return new ConfigurationResponse(configurationRequest.getPropertyName(),
        configurationRequest.getPropertyValue());
  }
}

package com.smm.rockscissorspaper.controller;

import com.smm.rockscissorspaper.controller.requests.ConfigurationRequest;
import com.smm.rockscissorspaper.controller.responses.ConfigurationResponse;
import com.smm.rockscissorspaper.controller.responses.ErrorResponse;
import com.smm.rockscissorspaper.controller.responses.IResponse;
import com.smm.rockscissorspaper.exception.RockScissorsPaperException;
import com.smm.rockscissorspaper.services.ConfigurationService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Class to handle Configuration Requests and Responses.
 */
@RestController
@RequestMapping("/configure")
@Validated
public class ConfigurationController extends AbstractController {

  /**
   * The Configuration Service.
   */
  @Autowired
  private ConfigurationService configurationService;

  /**
   * Handles a Configuration Request.
   * @param request The Configuration Request.
   * @return A Configuration Response.
   */
  @RequestMapping(method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
  @ApiOperation(value = "Change property value.")
  @ApiResponses(value = {
      @ApiResponse(code = 200, message = "Value changed succesfully.", response = ConfigurationResponse.class),
      @ApiResponse(code = 400, message = "Bad Request parameters.", response = ErrorResponse.class) })
  public
      ResponseEntity<IResponse> handleRequest(
          @RequestBody @Valid final ConfigurationRequest request) {

    try {
      return new ResponseEntity<IResponse>(configurationService.processRequest(
          request, null), HttpStatus.OK);
    } catch (RockScissorsPaperException e) {
      return processError(e);
    }
  }
}

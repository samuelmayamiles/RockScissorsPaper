package com.smm.rockscissorspaper.controller;

import com.smm.rockscissorspaper.controller.responses.ErrorResponse;
import com.smm.rockscissorspaper.controller.responses.IResponse;
import com.smm.rockscissorspaper.controller.responses.PlayResponse;
import com.smm.rockscissorspaper.exception.RockScissorsPaperException;
import com.smm.rockscissorspaper.services.PlayService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Class to handle Play Requests and Responses.
 */
@RestController
@RequestMapping("/play")
@Validated
public class PlayController extends AbstractController {

  /**
   * The Play Service.
   */
  @Autowired
  private PlayService playService;

  /**
   * Handles a Play Request.
   * @return A Play Response.
   */
  @RequestMapping(
      method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
  @ApiOperation(
      value = "Launch a Game of Rock, Scissors and Paper.")
  @ApiResponses(
      value = {
          @ApiResponse(
              code = 200, message = "Game Played succesfully.",
              response = PlayResponse.class),
          @ApiResponse(
              code = 500, message = "Internal Server Error",
              response = ErrorResponse.class)})
  public ResponseEntity<IResponse> handleRequest() {

    try {
      return new ResponseEntity<IResponse>(playService.processRequest(null,
          null), HttpStatus.OK);
    } catch (RockScissorsPaperException e) {
      return processError(e);
    }
  }
}

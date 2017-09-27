package com.smm.rockscissorspaper.controller.responses;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.smm.rockscissorspaper.exception.RockScissorsPaperException;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

/**
 * Class to respond when errors occur on Requests.
 */
@Component
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ErrorResponse implements IResponse {

  /**
   * The error status.
   */
  private Integer status;
  /**
   * The error errorCode.
   */
  private Integer errorCode;
  /**
   * The error message.
   */
  private String message;
  /**
   * The error httpStatus.
   */
  @JsonIgnore
  private HttpStatus httpStatus;

  // Constructors
  /**
   * Default Constructor.
   */
  public ErrorResponse() {

  }

  /**
   * Parametrised Constructor.
   * @param exception The RockScissorsPaperException thrown.
   */
  public ErrorResponse(final RockScissorsPaperException exception) {
    this.status = -1;
    this.errorCode = exception.getErrorCode();
    this.message = exception.getMessage();
    this.httpStatus = selectHttpStatus(exception.getErrorCode());
  }

  /**
   * Returns the HttpStatus associated to an errorCode.
   * @param errorCode The error code thrown.
   * @return And HttpStatus for the input errorCode.
   *         HttpStatus.INTERNAL_SERVER_ERROR by default.
   */
  private HttpStatus selectHttpStatus(final Integer errorCode) {
    switch (errorCode) {
      case 400:
        return HttpStatus.BAD_REQUEST;
      default:
        return HttpStatus.INTERNAL_SERVER_ERROR;
    }
  }

  // Getters & Setters
  /**
   * @return the status
   */
  public Integer getStatus() {
    return status;
  }

  /**
   * @param newStatus the status to set
   */
  public void setStatus(final Integer newStatus) {
    this.status = newStatus;
  }

  /**
   * @return the errorCode
   */
  public Integer getErrorCode() {
    return errorCode;
  }

  /**
   * @param newErrorCode the errorCode to set
   */
  public void setErrorCode(final Integer newErrorCode) {
    this.errorCode = newErrorCode;
  }

  /**
   * @return the message
   */
  public String getMessage() {
    return message;
  }

  /**
   * @param newMessage the message to set
   */
  public void setMessage(final String newMessage) {
    this.message = newMessage;
  }

  /**
   * @return the httpStatus
   */
  public HttpStatus getHttpStatus() {
    return httpStatus;
  }

  /**
   * @param newHttpStatus the httpStatus to set
   */
  public void setHttpStatus(final HttpStatus newHttpStatus) {
    this.httpStatus = newHttpStatus;
  }

}

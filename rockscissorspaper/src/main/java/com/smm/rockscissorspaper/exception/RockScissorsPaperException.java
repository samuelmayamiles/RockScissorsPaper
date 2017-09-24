package com.smm.rockscissorspaper.exception;

import com.smm.rockscissorspaper.configuration.RockScissorsPaperConstants;

import java.io.IOException;
import java.util.Properties;

/**
 * Exception Class to handle application errors.
 */
public class RockScissorsPaperException extends Exception {

  /**
   * The serialVersionUID.
   */
  private static final long serialVersionUID = 3418115173867797817L;

  /**
   * The RockScissorsPaperException errorCode.
   */
  private final Integer errorCode;

  // Constructors
  /**
   * Builds a RockScissorsPaperException from a given error code.
   * @param code The code for the RockScissorsPaperException.
   */
  public RockScissorsPaperException(final Integer code) {
    super(getCodeText(code));
    this.errorCode = code;
  }

  /**
   * Builds a RockScissorsPaperException from a given error code and Throwable.
   * @param code The code for the RockScissorsPaperException.
   * @param throwable The encapsulated Throwable.
   */
  public RockScissorsPaperException(final Integer code,
      final Throwable throwable) {
    super(getCodeText(code), throwable);
    this.errorCode = code;
  }

  /**
   * Retrieves the text associated to a given error code.
   * @param code The error code.
   * @return The associated text for the error code.
   */
  public static String getCodeText(final Integer code) {
    String errorMessage;

    try {
      Properties prop = new Properties();
      prop.load(RockScissorsPaperException.class.getClassLoader()
          .getResourceAsStream(RockScissorsPaperConstants.PROPERTIES_LOCATION));
      errorMessage = prop.getProperty("api.error." + code);
    } catch (IOException e) {
      // Properties could not be loaded. Use default value.
      errorMessage = "(Error message could not be retrieved)";
    }
    return errorMessage;
  }

  // Getters & Setters
  /**
   * Get the exception error code.
   * @return the errorCode.
   */
  public final Integer getErrorCode() {
    return errorCode;
  }

}

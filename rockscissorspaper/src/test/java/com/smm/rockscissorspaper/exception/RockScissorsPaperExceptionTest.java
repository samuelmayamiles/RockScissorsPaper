package com.smm.rockscissorspaper.exception;

import org.junit.Assert;
import org.junit.Test;

/**
 * RockScissorsPaperException Class Tests.
 */
public class RockScissorsPaperExceptionTest {

  /**
   * Default Test Error Code.
   */
  private static final Integer DEFAULT_ERROR_CODE = 400;
  /**
   * Default Test Non Existent Error Code.
   */
  private static final Integer DEFAULT_NON_EXISTENT_ERROR_CODE = 1;
  /**
   * Default Test Throwable to use.
   */
  private static final Throwable DEFAULT_THROWABLE = new Throwable("Test");

  /**
   * Test RockScissorsPaperException Integer Constructor.
   */
  @Test
  public void testRockScissorsPaperExceptionInteger() {
    RockScissorsPaperException result =
        new RockScissorsPaperException(DEFAULT_ERROR_CODE);
    Assert.assertTrue(result.getErrorCode() == DEFAULT_ERROR_CODE);
  }

  /**
   * Test RockScissorsPaperException Integer, Throwable Constructor.
   */
  @Test
  public void testRockScissorsPaperExceptionIntegerThrowable() {
    RockScissorsPaperException result =
        new RockScissorsPaperException(DEFAULT_ERROR_CODE, DEFAULT_THROWABLE);
    Assert.assertTrue(result.getErrorCode() == DEFAULT_ERROR_CODE);
    Assert.assertTrue(result.getCause().equals(DEFAULT_THROWABLE));
  }

  /**
   * Test getter for errorCode.
   */
  @Test
  public void testGetErrorCode() {
    RockScissorsPaperException result =
        new RockScissorsPaperException(DEFAULT_ERROR_CODE);
    Assert.assertTrue(result.getErrorCode() == DEFAULT_ERROR_CODE);
  }

  /**
   * Test getter for errorCode.
   */
  @SuppressWarnings("static-access")
  @Test
  public void testGetCodeText() {
    RockScissorsPaperException result =
        new RockScissorsPaperException(DEFAULT_ERROR_CODE);
    Assert.assertTrue(!result.getCodeText(DEFAULT_ERROR_CODE).isEmpty());
  }

  /**
   * Test getter for errorCode.
   */
  @SuppressWarnings("static-access")
  @Test
  public void testGetCodeTextNonExistent() {
    RockScissorsPaperException result =
        new RockScissorsPaperException(DEFAULT_NON_EXISTENT_ERROR_CODE);
    String codeText = result.getCodeText(DEFAULT_NON_EXISTENT_ERROR_CODE);
    Assert.assertTrue(codeText == null);
  }
}

package com.smm.rockscissorspaper.controller.responses;

import com.smm.rockscissorspaper.Mocker;

import org.junit.Assert;
import org.junit.Test;
import org.mockito.InjectMocks;

/**
 * PlayResponse Tests Class.
 */
public class PlayResponseTest extends Mocker {

  /**
   * Class under Test.
   */
  @InjectMocks
  private PlayResponse response = new PlayResponse();

  /**
   * Testing Setter.
   */
  @Test
  public void testSetGame() {
    response.setGame(mockGame);

    Assert.assertTrue(response.getGame().equals(mockGame));
  }

}

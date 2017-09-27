package com.smm.rockscissorspaper.model;

import com.smm.rockscissorspaper.Mocker;

import java.util.LinkedList;

import org.junit.Assert;
import org.junit.Test;
import org.mockito.InjectMocks;

/**
 * Game Tests Class.
 */
public class GameTest extends Mocker {

  /**
   * Class under Test.
   */
  @InjectMocks
  private Game model = new Game();

  /**
   * Testing Setter.
   */
  @Test
  public void testSetRoundsPlayed() {
    model.setRoundsPlayed(0);

    Assert.assertTrue(model.getRoundsPlayed() == 0);
  }

  /**
   * Testing Setter.
   */
  @Test
  public void testSetResults() {
    model.setResults(new LinkedList<GameResult>());

    Assert.assertTrue(model.getResults() != null);
  }

}

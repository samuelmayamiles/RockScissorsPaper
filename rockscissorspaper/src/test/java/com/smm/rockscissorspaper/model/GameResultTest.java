package com.smm.rockscissorspaper.model;

import com.smm.rockscissorspaper.Mocker;

import org.junit.Assert;
import org.junit.Test;
import org.mockito.InjectMocks;

/**
 * GameResult Tests Class.
 */
public class GameResultTest extends Mocker {

  /**
   * Class under Test.
   */
  @InjectMocks
  private GameResult model = new GameResult();

  /**
   * Testing Setter.
   */
  @Test
  public void testPlayer() {
    model.setPlayer("1");

    Assert.assertTrue(model.getPlayer().equalsIgnoreCase("1"));
  }

  /**
   * Testing Setter.
   */
  @Test
  public void testSetVictories() {
    model.setVictories(1);

    Assert.assertTrue(model.getVictories() == 1);
  }

}

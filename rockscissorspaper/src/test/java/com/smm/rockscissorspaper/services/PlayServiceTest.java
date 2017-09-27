package com.smm.rockscissorspaper.services;

import com.smm.rockscissorspaper.Mocker;
import com.smm.rockscissorspaper.controller.responses.IResponse;
import com.smm.rockscissorspaper.controller.responses.PlayResponse;
import com.smm.rockscissorspaper.exception.RockScissorsPaperException;
import com.smm.rockscissorspaper.model.Game;

import org.junit.Assert;
import org.junit.Test;
import org.mockito.InjectMocks;

/**
 * PlayService Tests Class.
 */
public class PlayServiceTest extends Mocker {

  /**
   * Class under Test.
   */
  @InjectMocks
  private PlayService service = new PlayService();

  /**
   * Check No Games.
   * @throws RockScissorsPaperException When errors occur.
   */
  @SuppressWarnings("static-access")
  @Test
  public void testProcessRequestNoGames() throws RockScissorsPaperException {
    service.setGamesToPlay(0);

    IResponse response = service.processRequest(null, null);
    Assert.assertTrue(response != null);

    Game gamePlayed = ((PlayResponse) response).getGame();
    Assert.assertTrue(gamePlayed.getRoundsPlayed() == 0);
  }

  /**
   * Normal behaviour.
   * @throws RockScissorsPaperException When errors occur.
   */
  @SuppressWarnings("static-access")
  @Test
  public void testProcessRequest() throws RockScissorsPaperException {
    IResponse response = service.processRequest(null, null);
    Assert.assertTrue(response != null);

    Game gamePlayed = ((PlayResponse) response).getGame();
    Assert.assertTrue(gamePlayed.getRoundsPlayed() == service.getGamesToPlay());
    Assert.assertTrue(!gamePlayed.getResults().isEmpty());
  }

}

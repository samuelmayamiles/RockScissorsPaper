package com.smm.rockscissorspaper.services;

import com.smm.rockscissorspaper.controller.requests.IRequest;
import com.smm.rockscissorspaper.controller.responses.IResponse;
import com.smm.rockscissorspaper.controller.responses.PlayResponse;
import com.smm.rockscissorspaper.exception.RockScissorsPaperException;
import com.smm.rockscissorspaper.model.Game;
import com.smm.rockscissorspaper.model.GameResult;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

import org.springframework.stereotype.Service;

/**
 * Service Class to handle Play Requests.
 */
@Service
public class PlayService implements IRockScissorsPaperService {

  /**
   * The Random Generator.
   */
  private static final Random RND = new Random();

  /**
   * Player identification.
   */
  private static final List<String> PLAYER_STRINGS = Arrays
      .asList(new String[] {"Rock Player", "Ties", "Random Player"});

  /**
   * Default Games to Play.
   */
  private static Integer gamesToPlay = 100;

  /**
   * Method to process a Play Request.
   * @param request The incoming Request.
   * @param operationType The Operation to perform.
   * @return A Response for the Request.
   * @throws RockScissorsPaperException When an error occurs.
   */
  @Override
  public IResponse processRequest(final IRequest request,
      final String operationType) throws RockScissorsPaperException {
    validateRequest(request);
    return performOperations(request, operationType);
  }

  /**
   * Method to validate a Play Request.
   * @param request The incoming Request.
   * @throws RockScissorsPaperException When an error occurs.
   */
  @Override
  public void validateRequest(final IRequest request)
      throws RockScissorsPaperException {
    // Add Validations for the input request (if needed).
  }

  /**
   * Method to execute the Configuration Operations.
   * @param request The incoming Request.
   * @param operationType The Operation to perform.
   * @return A Response for the Request.
   * @throws RockScissorsPaperException When an error occurs.
   */
  @Override
  public IResponse performOperations(final IRequest request,
      final String operationType) throws RockScissorsPaperException {
    Game playedGame = new Game();
    Integer[] result = play();

    for (int position = 0; position < result.length; position++) {
      Integer value = result[position];

      GameResult outcome = new GameResult();
      outcome.setPlayer(PLAYER_STRINGS.get(position));
      outcome.setVictories(value);

      playedGame.getResults().add(outcome);
      playedGame.setRoundsPlayed(playedGame.getRoundsPlayed() + value);
    }

    return new PlayResponse(playedGame);
  }

  /**
   * Execute a Game Play for the defined gamesToPlay.
   * @return An array with the times each Player won and the Ties.
   */
  private Integer[] play() {
    // Paper, Rock, Scissors
    Integer[] results = {0, 0, 0};

    for (int games = 0; games < gamesToPlay; games++) {
      results[Integer.compare(RND.nextInt(results.length), 1) + 1] += 1;
    }

    return results;
  }

  // Setters & Getters
  /**
   * @return the gamesToPlay
   */
  public static Integer getGamesToPlay() {
    return gamesToPlay;
  }

  /**
   * @param newGamesToPlay the gamesToPlay to set
   */
  public static void setGamesToPlay(final Integer newGamesToPlay) {
    PlayService.gamesToPlay = newGamesToPlay;
  }

}

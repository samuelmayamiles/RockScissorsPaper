package com.smm.rockscissorspaper.controller.responses;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.smm.rockscissorspaper.model.Game;

import org.springframework.stereotype.Component;

/**
 * Class to respond a game play.
 */
@Component
@JsonInclude(JsonInclude.Include.NON_NULL)
public class PlayResponse implements IResponse {

  /**
   * The Game played.
   */
  private Game game;

  // Constructors
  /**
   * Default Constructor.
   */
  public PlayResponse() {

  }

  /**
   * Parametrised Constructor.
   * @param newGame The Game.
   */
  public PlayResponse(final Game newGame) {
    this.game = newGame;
  }

  // Getters & Setters
  /**
   * @return the game
   */
  public Game getGame() {
    return game;
  }

  /**
   * @param newGame the game to set
   */
  public void setGame(final Game newGame) {
    this.game = newGame;
  }

}

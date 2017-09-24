package com.smm.rockscissorspaper.model;

import com.fasterxml.jackson.annotation.JsonInclude;

import org.springframework.stereotype.Component;

/**
 * Class representing the outcome of a Game for a Player.
 */
@Component
@JsonInclude(JsonInclude.Include.NON_NULL)
public class GameResult {

  /**
   * Player identifier.
   */
  private String player = "";
  /**
   * Hits obtained.
   */
  private Integer victories = 0;

  // Getters & Setters
  /**
   * @return the player
   */
  public String getPlayer() {
    return player;
  }

  /**
   * @param newPlayer the player to set
   */
  public void setPlayer(final String newPlayer) {
    this.player = newPlayer;
  }

  /**
   * @return the victories
   */
  public Integer getVictories() {
    return victories;
  }

  /**
   * @param newVictories the victories to set
   */
  public void setVictories(final Integer newVictories) {
    this.victories = newVictories;
  }

}

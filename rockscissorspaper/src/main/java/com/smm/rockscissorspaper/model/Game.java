package com.smm.rockscissorspaper.model;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.LinkedList;
import java.util.List;

import org.springframework.stereotype.Component;

/**
 * Class representing a Game of Rock, Scissors, Paper.
 */
@Component
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Game {

  /**
   * Rounds Played in the Game.
   */
  private Integer roundsPlayed = 0;
  /**
   * Outcome of the Game.
   */
  private List<GameResult> results = new LinkedList<GameResult>();

  // Getters & Setters
  /**
   * @return the roundsPlayed
   */
  public Integer getRoundsPlayed() {
    return roundsPlayed;
  }

  /**
   * @param newRoundsPlayed the roundsPlayed to set
   */
  public void setRoundsPlayed(final Integer newRoundsPlayed) {
    this.roundsPlayed = newRoundsPlayed;
  }

  /**
   * @return the results
   */
  public List<GameResult> getResults() {
    return results;
  }

  /**
   * @param newResults the results to set
   */
  public void setResults(final List<GameResult> newResults) {
    this.results = newResults;
  }

}

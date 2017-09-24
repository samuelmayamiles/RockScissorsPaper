package com.smm.rockscissorspaper;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;

/**
 * RockScissorsPaper SpringBoot Application.
 * @author Samuel Maya Miles
 * @version 1.0.0
 * @since 24/09/2017
 */
@SpringBootApplication
public class RockScissorsPaper implements
    ApplicationListener<ApplicationReadyEvent> {

  /**
   * RockScissorsPaper Application Main entry point.
   * @param args Configuration arguments.
   */
  public static void main(final String[] args) {
    SpringApplication.run(RockScissorsPaper.class, args);
  }

  /**
   * Called when Application is ready.
   * @param arg Fired on Application Ready.
   */
  public final void onApplicationEvent(final ApplicationReadyEvent arg) {
    System.out.println("RockScissorsPaper is up and Runnning...");
  }
}

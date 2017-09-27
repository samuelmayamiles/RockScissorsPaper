package com.smm.rockscissorspaper;

import com.smm.rockscissorspaper.controller.requests.ConfigurationRequest;
import com.smm.rockscissorspaper.model.Game;
import com.smm.rockscissorspaper.services.ConfigurationService;
import com.smm.rockscissorspaper.services.PlayService;

import org.junit.Before;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;
import org.springframework.core.env.Environment;

/**
 * Base Class for Mocking.
 */
public class Mocker {

  /**
   * Mocked Class.
   */
  @Spy
  protected ConfigurationRequest mockConfigurationRequest =
      new ConfigurationRequest();

  /**
   * Mocked Class.
   */
  @Spy
  protected ConfigurationService configurationService;

  /**
   * Mocked Class.
   */
  @Spy
  protected PlayService mockPlayService;

  /**
   * Mocked Class.
   */
  @Mock
  protected Environment mockEnvironment;

  /**
   * Mocked Class.
   */
  @Mock
  protected Game mockGame;

  /**
   * Executed before each Test, initialises the Mocked Classes.
   */
  @Before
  public void init() {
    MockitoAnnotations.initMocks(this);
  }

}

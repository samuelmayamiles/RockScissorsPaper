package com.smm.rockscissorspaper.configuration;

import com.smm.rockscissorspaper.Mocker;

import org.junit.Assert;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

/**
 * RockScissorsPaperConfiguration Tests Class.
 */
public class RockScissorsPaperConfigurationTest extends Mocker {

  /**
   * Class under Test.
   */
  @InjectMocks
  private RockScissorsPaperConfiguration configuration =
      new RockScissorsPaperConfiguration();

  /**
   * Normal behaviour.
   */
  @SuppressWarnings("static-access")
  @Test
  public void testPropertySourcesPlaceholderConfigurer() {
    PropertySourcesPlaceholderConfigurer result =
        configuration.propertySourcesPlaceholderConfigurer();

    Assert.assertTrue(result != null);
  }

}

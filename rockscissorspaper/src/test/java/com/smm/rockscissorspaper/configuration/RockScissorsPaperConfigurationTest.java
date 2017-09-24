package com.smm.rockscissorspaper.configuration;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author Usuario
 */
public class RockScissorsPaperConfigurationTest {

  /**
   * Test PropertySourcesPlaceholderConfigurer Bean creation.
   */
  @SuppressWarnings("static-access")
  @Test
  public void testPropertySourcesPlaceholderConfigurer() {
    RockScissorsPaperConfiguration result =
        new RockScissorsPaperConfiguration();
    Assert.assertTrue(result.propertySourcesPlaceholderConfigurer() != null);
  }

}

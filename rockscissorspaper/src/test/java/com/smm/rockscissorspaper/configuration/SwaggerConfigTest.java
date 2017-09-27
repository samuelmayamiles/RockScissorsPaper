package com.smm.rockscissorspaper.configuration;

import com.smm.rockscissorspaper.Mocker;

import org.junit.Assert;
import org.junit.Test;
import org.mockito.InjectMocks;

import springfox.documentation.spring.web.plugins.Docket;

/**
 * SwaggerConfig Tests Class.
 */
public class SwaggerConfigTest extends Mocker {

  /**
   * Class under Test.
   */
  @InjectMocks
  private SwaggerConfig configuration = new SwaggerConfig();

  /**
   * Normal behaviour.
   */
  @Test
  public void testApi() {
    Docket result = configuration.api();
    Assert.assertTrue(result != null);
  }

}

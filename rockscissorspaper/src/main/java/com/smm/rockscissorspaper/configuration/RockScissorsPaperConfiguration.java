package com.smm.rockscissorspaper.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

/**
 * Class to load the resources from properties file.
 */
@Configuration
@PropertySource("classpath:" + RockScissorsPaperConstants.PROPERTIES_LOCATION)
public class RockScissorsPaperConfiguration {

  /**
   * Overrides the default PropertySourcesPlaceholderConfigurer.
   * @return The new PropertySourcesPlaceholderConfigurer to use.
   */
  @Bean
  public static PropertySourcesPlaceholderConfigurer
      propertySourcesPlaceholderConfigurer() {
    return new PropertySourcesPlaceholderConfigurer();
  }

}

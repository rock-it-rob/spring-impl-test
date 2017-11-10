package prt.rob.springimpltest.provider.random;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import prt.rob.springtestimpl.provider.StringValueProvider;

import java.util.concurrent.ThreadLocalRandom;

/**
 * RandomConfig is a Spring configuration class.
 *
 * @author Rob Benton
 */
@SuppressWarnings("WeakerAccess")
@Configuration
public class RandomConfig
{
  private static final Logger log = LoggerFactory.getLogger(RandomConfig.class.getName());

  /**
   * Gets a {@link StringValueProvider} that returns a random value.
   *
   * @return StringValueProvider
   */
  @Bean
  public StringValueProvider getRandomProvider()
  {
    log.debug("Instantiating Random long implementataion.");
    return () -> String.valueOf(ThreadLocalRandom.current().nextLong());
  }
}

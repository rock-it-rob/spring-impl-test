package prt.rob.springtestimpl.provider.random;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import prt.rob.springtestimpl.provider.StringValueProvider;

import java.util.concurrent.ThreadLocalRandom;

/**
 * RandomConfig is a Spring configuration class.
 *
 * @author Rob Benton
 */
@Configuration
public class RandomConfig
{
  /**
   * Gets a {@link StringValueProvider} that returns a random value.
   *
   * @return StringValueProvider
   */
  @Bean
  public StringValueProvider getRandomProvider()
  {
    return () -> String.valueOf(ThreadLocalRandom.current().nextLong());
  }
}

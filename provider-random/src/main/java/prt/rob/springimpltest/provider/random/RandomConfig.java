package prt.rob.springimpltest.provider.random;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import prt.rob.springtestimpl.provider.StringValueProvider;

import java.util.concurrent.ThreadLocalRandom;

/**
 * RandomConfig is a Spring configuration class.
 *
 * @author Rob Benton
 */
public class RandomConfig
{
  private static final Logger log = LoggerFactory.getLogger(RandomConfig.class.getName());

  /**
   * Gets a {@link StringValueProvider} that returns a random value.
   *
   * @return StringValueProvider
   */
  public StringValueProvider getRandomProvider()
  {
    log.debug("Instantiating Random long implementataion.");
    return () -> String.valueOf(ThreadLocalRandom.current().nextLong());
  }
}

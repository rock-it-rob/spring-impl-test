package prt.rob.springimpltest.provider.random;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import prt.rob.springtestimpl.provider.StringValueProvider;

import java.util.concurrent.ThreadLocalRandom;

/**
 * RandomProvider is a Spring configuration class.
 *
 * @author Rob Benton
 */
public class RandomProvider implements StringValueProvider
{
  private static final Logger log = LoggerFactory.getLogger(RandomProvider.class.getName());

  private String value;

  /**
   * Gets a {@link StringValueProvider} that returns a random value.
   *
   * @return StringValueProvider
   */
  public RandomProvider()
  {
    log.debug("Instantiating Random long implementataion.");
    this.value = String.valueOf(ThreadLocalRandom.current().nextLong());
  }

  @Override
  public String getValue()
  {
    return this.value;
  }
}

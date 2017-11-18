package prt.rob.springimpltest.provider.timestamp;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import prt.rob.springtestimpl.provider.StringValueProvider;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * TimestampProvider is a Spring configuration class providing beans.
 *
 * @author Rob Benton
 */
public class TimestampProvider implements StringValueProvider
{
  private static final Logger log = LoggerFactory.getLogger(TimestampProvider.class.getName());

  private String value;

  @Override
  public String getValue()
  {
    return this.value;
  }

  /**
   * Returns an object which implements the {@link StringValueProvider} by
   * returning the current timestamp as a string.
   *
   * @return StringValueProvider
   */
  public TimestampProvider()
  {
    log.debug("Instantiating Timestamp provider.");
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh24:mm:ss.SSS");
    this.value = sdf.format(new Date());
  }
}

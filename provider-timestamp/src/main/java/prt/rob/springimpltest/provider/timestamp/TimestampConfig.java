package prt.rob.springimpltest.provider.timestamp;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import prt.rob.springtestimpl.provider.StringValueProvider;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * TimestampConfig is a Spring configuration class providing beans.
 *
 * @author Rob Benton
 */
public class TimestampConfig
{
  private static final Logger log = LoggerFactory.getLogger(TimestampConfig.class.getName());

  /**
   * Returns an object which implements the {@link StringValueProvider} by
   * returning the current timestamp as a string.
   *
   * @return StringValueProvider
   */
  public StringValueProvider timestampProvider()
  {
    log.debug("Instantiating Timestamp provider.");
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh24:mm:ss.SSS");
    return () -> sdf.format(new Date());
  }
}

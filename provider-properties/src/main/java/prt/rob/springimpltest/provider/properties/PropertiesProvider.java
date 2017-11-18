package prt.rob.springimpltest.provider.properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.ClassPathResource;
import prt.rob.springtestimpl.provider.StringValueProvider;

import java.io.IOException;
import java.util.Properties;

/**
 * PropertiesProvider is a Spring configuration class.
 *
 * @author Rob Benton
 */
public class PropertiesProvider implements StringValueProvider
{
  private static final Logger log = LoggerFactory.getLogger(PropertiesProvider.class.getName());

  private static final String VALUE_PROPERTY = "provider.string.value";

  private String value;

  @Override
  public String getValue()
  {
    return this.value;
  }

  /**
   * Gets {@link StringValueProvider} implemented by returning a value from a
   * property file. The file is loaded via the
   * <code>Class.getResourceAsStream</code> method so the rules of locating a
   * file follow that method's description. The single argument is provided by
   * the spring configuration xml file.
   *
   * @param fileResource location of the property file providing the value to
   *                     return.
   * @return StringValueProvider
   */
  public PropertiesProvider(ClassPathResource fileResource)
  {
    log.debug("Instantiating Properties value provider using resource: " + fileResource);

    Properties p = new Properties();
    try
    {
      p.load(fileResource.getInputStream());
    } catch (IOException e)
    {
      log.error("Error reading from property file input stream: " + e.getMessage());
    }
    this.value = p.getProperty(VALUE_PROPERTY, "");
  }
}

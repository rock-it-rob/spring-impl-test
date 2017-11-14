package prt.rob.springimpltest.provider.properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import prt.rob.springtestimpl.provider.StringValueProvider;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * PropertiesConfig is a Spring configuration class.
 *
 * @author Rob Benton
 */
@Configuration
@ImportResource("/META-INF/provider-properties-spring.xml")
public class PropertiesConfig
{
  private static final Logger log = LoggerFactory.getLogger(PropertiesConfig.class.getName());

  private static final String VALUE_PROPERTY = "provider.string.value";

  /**
   * Gets {@link StringValueProvider} implemented by returning a value from a
   * property file. The file is loaded via the
   * <code>Class.getResourceAsStream</code> method so the rules of locating a
   * file follow that method's description. The single argument is provided by
   * the spring configuration xml file.
   *
   * @param filepath location of the property file providing the value to
   *                 return.
   * @return
   */
  @Bean
  public StringValueProvider propertiesProvider(@Autowired String filepath)
  {
    log.debug("Instantiating Properties value provider.");

    return () ->
    {
      InputStream is = getClass().getResourceAsStream(filepath);
      Properties p = new Properties();
      try
      {
        p.load(is);
        is.close();
      } catch (IOException e)
      {
        log.error("Could not load value from property file: " + filepath);
      }
      return p.getProperty(VALUE_PROPERTY, "");
    };
  }
}

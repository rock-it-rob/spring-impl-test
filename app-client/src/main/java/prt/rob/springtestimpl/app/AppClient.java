package prt.rob.springtestimpl.app;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import prt.rob.springtestimpl.provider.StringValueProvider;

/**
 * AppClient is the application client for the spring-impl-test project. It
 * executes business logic using the <em>provider-api</em> module without
 * directly including any dependencies on an implementation at compile time. At
 * runtime an implementation must be provided.
 *
 * @author Rob Benton
 */
@SuppressWarnings("WeakerAccess")
public class AppClient
{
  private static final Logger log = LoggerFactory.getLogger(AppClient.class.getName());

  private static final String SPRING_CONTEXT_XML = "classpath:/META-INF/app-client-spring.xml";

  /**
   * Main method.
   *
   * @param args leave empty
   */
  public static void main(String[] args)
  {
    try (
      ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(SPRING_CONTEXT_XML)
    )
    {
      StringValueProvider provider = context.getBean(StringValueProvider.class);
      String value = provider.getValue();
      log.info(value);
    }
  }
}

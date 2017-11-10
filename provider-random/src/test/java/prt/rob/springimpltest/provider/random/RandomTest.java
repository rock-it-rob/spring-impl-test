package prt.rob.springimpltest.provider.random;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import prt.rob.springtestimpl.provider.StringValueProvider;

import static org.junit.jupiter.api.Assertions.*;

/**
 * RandomTest is a JUnit test for this module.
 *
 * @author Rob Benton
 */
@SuppressWarnings("WeakerAccess")
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class RandomTest
{
  private static final String SPRING_CONTEXT_XML = "/META-INF/spring-context.xml";

  private ClassPathXmlApplicationContext context;

  @BeforeAll
  public void beforeAll()
  {
    context = new ClassPathXmlApplicationContext(SPRING_CONTEXT_XML);
  }

  @AfterAll
  public void afterAll()
  {
    context.close();
  }

  /**
   * Gets the value from the provider implementation and assures it is not null.
   */
  @Test
  public void testValue()
  {
    StringValueProvider provider = this.context.getBean(StringValueProvider.class);
    assertNotNull(provider);
    String value = provider.getValue();
    assertNotNull(value);
    assertTrue(value.length() != 0);
  }
}

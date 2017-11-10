package prt.rob.springtestimpl.provider.random;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
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
  private AnnotationConfigApplicationContext context;

  @BeforeAll
  public void beforeAll()
  {
    context = new AnnotationConfigApplicationContext(RandomConfig.class);
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

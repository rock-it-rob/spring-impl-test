package prt.rob.springimpltest.provider.properties;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import prt.rob.springtestimpl.provider.StringValueProvider;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Rob Benton
 */
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class PropertiesTest
{
  private AnnotationConfigApplicationContext context;

  @BeforeAll
  public void beforeAll()
  {
    this.context = new AnnotationConfigApplicationContext(PropertiesConfig.class);
  }

  @AfterAll
  public void afterAll()
  {
    this.context.close();
  }

  /**
   * Tests the value retrieval.
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

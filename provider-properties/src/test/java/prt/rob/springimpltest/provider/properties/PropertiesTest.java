package prt.rob.springimpltest.provider.properties;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import prt.rob.springtestimpl.provider.StringValueProvider;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Rob Benton
 */
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class PropertiesTest
{
    private static final String SPRING_CONTEXT_XML = "provider-properties-spring.xml";

    private ClassPathXmlApplicationContext context;

    @BeforeAll
    public void beforeAll()
    {
        this.context = new ClassPathXmlApplicationContext(SPRING_CONTEXT_XML);
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

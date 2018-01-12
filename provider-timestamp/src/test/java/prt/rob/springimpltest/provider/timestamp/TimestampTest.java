package prt.rob.springimpltest.provider.timestamp;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;
import prt.rob.springtestimpl.provider.StringValueProvider;

import static org.junit.jupiter.api.Assertions.*;

/**
 * TimestampTest is a JUnit test class.
 *
 * @author Rob Benton
 */
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class TimestampTest
{
    private static final String SPRING_CONTEXT_XML = "provider-timestamp-spring.xml";

    private GenericXmlApplicationContext context;

    @BeforeAll
    public void beforeAll()
    {
        this.context = new GenericXmlApplicationContext(SPRING_CONTEXT_XML);
    }

    @AfterAll
    public void afterAll()
    {
        this.context.close();
    }

    /**
     * Test the implementation.
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

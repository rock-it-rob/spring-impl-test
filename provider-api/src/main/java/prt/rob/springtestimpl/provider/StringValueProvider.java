package prt.rob.springtestimpl.provider;

/**
 * StringValueProvider defines the business interface for obtaining a sample
 * string value from an implementation.
 *
 * @author Rob Benton
 */
@FunctionalInterface
public interface StringValueProvider
{
  /**
   * Gets a test value as a String.
   * <p>
   * See the respective implementation for more details on how this value is determined.
   *
   * @return String
   */
  String getValue();
}

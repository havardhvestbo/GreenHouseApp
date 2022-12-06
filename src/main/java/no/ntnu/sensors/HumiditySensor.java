package no.ntnu.sensors;

/**
 * Imitates a humidity sensor placed in a room. The values will be in percent
 */
public class HumiditySensor extends BoundedSensor {
  private static final double NORMAL_GREENHOUSE_HUMIDITY = 80;
  private static final double MIN_GREENHOUSE_HUMIDITY = 50;
  private static final double MAX_GREENHOUSE_HUMIDITY = 95;

  /**
   * Create a sensor which will imitate humidity readings within a greenhouse
   */
  public HumiditySensor() { super(NORMAL_GREENHOUSE_HUMIDITY, MIN_GREENHOUSE_HUMIDITY, MAX_GREENHOUSE_HUMIDITY);
  }
}
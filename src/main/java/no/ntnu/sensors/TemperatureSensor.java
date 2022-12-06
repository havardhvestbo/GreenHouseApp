package no.ntnu.sensors;

/**
 * Imitates a temperature sensor placed in a room
 */
public class TemperatureSensor extends BoundedSensor {
  private static final double NORMAL_GREENHOUSE_TEMPERATURE = 20;
  private static final double MIN_GREENHOUSE_TEMPERATURE = 18;
  private static final double MAX_GREENHOUSE_TEMPERATURE = 24;

  /**
   * Create a sensor which will imitate temperature readings within a room
   */
  public TemperatureSensor() {
    super(NORMAL_GREENHOUSE_TEMPERATURE, MIN_GREENHOUSE_TEMPERATURE, MAX_GREENHOUSE_TEMPERATURE);
  }
}
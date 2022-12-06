package no.ntnu.sensors;

import no.ntnu.server.MqttPublisher;

/**
 * Represents (or imitates) a physical sensor on the platform
 */
public interface Sensor {
  /**
   * Read the current value of the sensor
   * @return The current sensor value
   */
  double readValue();
}

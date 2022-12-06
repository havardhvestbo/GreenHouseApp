package no.ntnu.logic;

/**
 * Provides a variety of enums used by other classes.
 */
public class enums {

  public static final String BROKER = "tcp://129.241.152.12:1883";
  public static final String TEMPERATURE_CLIENT_ID = "group21_temperature_client";
  public static final String TEMPERATURE_SENSOR_ID = "group21_temperature_sensor";
  public static final String HUMIDITY_CLIENT_ID = "group21_humidity_client";
  public static final String HUMIDITY_SENSOR_ID = "group21_Humidity_sensor";
  public static final int QOS = 0;
  public static final String TEMPERATURE_TOPIC = "group21/greenhouse/sensors/temperature";
  public static final String HUMIDITY_TOPIC = "group21/greenhouse/sensors/humidity";
}

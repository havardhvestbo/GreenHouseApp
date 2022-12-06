package no.ntnu;

import no.ntnu.sensors.HumiditySensor;
import no.ntnu.sensors.Sensor;
import no.ntnu.sensors.TemperatureSensor;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SensorTest {

  @Test
  public void sensorProviderTest() {
  SensorProvider sensorProvider = new SensorProvider();
  Sensor t = sensorProvider.getTemperatureSensor();
  Sensor h = sensorProvider.getHumiditySensor();
  TemperatureSensor temp = new TemperatureSensor();
  HumiditySensor humi = new HumiditySensor();
  Assertions.assertEquals(h, humi);
  Assertions.assertEquals(t, temp);
  }
}

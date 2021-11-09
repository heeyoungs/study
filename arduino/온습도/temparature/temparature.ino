#include "DHT.h"

#define DHTPIN 2     // Digital pin connected to the DHT sensor
#define DHTTYPE DHT22   // DHT 22  (AM2302), AM2321
DHT dht(DHTPIN, DHTTYPE);

void setup() {
  Serial.begin(9600);
  Serial.println(F("DHT22 sensor test!"));

  dht.begin();
}

void loop() {
  delay(2000);

  float humidity = dht.readHumidity();
  float temperature = dht.readTemperature();

  if (isnan(humidity) || isnan(temperature)) {
    Serial.println(F("DHT22 sensor error!"));
    return;
  }

  Serial.print(F("Humidity: "));
  Serial.print(humidity);
  Serial.print(F("%  Temperature: "));
  Serial.print(temperature);
  Serial.println();

  float discomfortIndex = (1.8 * temperature) - (0.55 * (1 - humidity / 100.0) * (1.8 * temperature - 26)) + 32;
  Serial.print(F("Discomfort Index: "));
  Serial.print(discomfortIndex);
  Serial.println();  
  Serial.println();  
}

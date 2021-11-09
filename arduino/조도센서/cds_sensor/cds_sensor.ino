int _photoSensorPin = A0;
int _builtInLed = 16;

void setup() {
  Serial.begin(115200);
  pinMode(_builtInLed, OUTPUT);
}

void loop() {

  int cdsValue = analogRead(_photoSensorPin);
  Serial.print("cds = ");
  Serial.println(cdsValue);

  int cdsPercentage = map(cdsValue, 0, 1023, 0, 100);
  if (cdsPercentage < 50)
  {
    digitalWrite(_builtInLed, HIGH); // 어두우면
  }
  else
  {
    digitalWrite(_builtInLed, LOW); // 밝으면
  }
  delay(1000);
}

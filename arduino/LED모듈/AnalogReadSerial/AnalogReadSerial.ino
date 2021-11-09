/*
  AnalogReadSerial

  Reads an analog input on pin 0, prints the result to the Serial Monitor.
  Graphical representation is available using Serial Plotter (Tools > Serial Plotter menu).
  Attach the center pin of a potentiometer to pin A0, and the outside pins to +5V and ground.

  This example code is in the public domain.

  https://www.arduino.cc/en/Tutorial/BuiltInExamples/AnalogReadSerial
*/

// the setup routine runs once when you press reset:
void setup() {
  // initialize serial communication at 9600 bits per second:
  Serial.begin(9600);
  pinMode(A0 ,INPUT);
  pinMode(5, OUTPUT);
  pinMode(4, OUTPUT);
  pinMode(0, OUTPUT);
}

// the loop routine runs over and over again forever:
void loop() {
  // read the input on analog pin 0:
  int sensorValue = analogRead(A0);
  // print out the value you read:
  Serial.println(sensorValue);
  if (sensorValue > 700 ){
    analogWrite(5,255);
    analogWrite(4,0);
    analogWrite(0,0);
  }
  else if(sensorValue < 400 ) {
    analogWrite(4,255);
    analogWrite(5,0);
    analogWrite(0,0);
  }
  else {
    analogWrite(0,255);
    analogWrite(5,0);
    analogWrite(4,0);
  }
  delay(1);        // delay in between reads for stability
}

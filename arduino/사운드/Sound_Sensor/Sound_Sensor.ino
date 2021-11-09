void setup() {
Serial.begin(9600); // setup serial
}
void loop() {
Serial.print("사운드 값 : ");
Serial.println(analogRead(A0));
delay(100);
}


int pir = A0;

void setup() {
  // put your setup code here, to run once:
  Serial.begin(9600);
  pinMode(pir, INPUT);

}

void loop() {
  // put your main code here, to run repeatedly:
  Serial.println(analogRead(pir));
  delay(100);

}

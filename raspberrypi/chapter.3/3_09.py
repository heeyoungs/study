import RPi.GPIO as GPIO
import time

GPIO.setmode(GPIO.BCM)
GPIO.setup(17,GPIO.OUT)
GPIO.setup(18,GPIO.OUT)
GPIO.setup(19,GPIO.OUT)

pwm1=GPIO.PWM(18,1000.0)
pwm1.start(0.0)
pwm2=GPIO.PWM(19,50)
pwm2.start(3.0)

def showMenu():
    print("==<<MENU>>==");
    print("n. 노란색 LED 켜기");
    print("f. 노란색 LED 끄기");
    print("0. 초록색 LED 밝기 00%");
    print("5. 초록색 LED 밝기 50%");
    print("t. 파란색 LED 밝기 100%");
    print("q. Servo 180도");
    print("w. Servo  90도");
    print("e. Servo   0도");
    
showMenu()

try:
    while 1:
        userinput = input(">>>")
        print(input)
        if userinput == "n":
            GPIO.output(17,1)
        elif userinput == "f":
            GPIO.output(17,0)
        elif userinput == "0":
            pwm1.ChangeDutyCycle(0)
        elif userinput == "5":
            pwm1.ChangeDutyCycle(50)
        elif userinput =="t":
            pwm1.ChangeDutyCycle(100)
        elif userinput =="q":
            pwm2.ChangeDutyCycle(11.5)
            time.sleep(1.0)
        elif userinput =="w":
            pwm2.ChangeDutyCycle(7.3)
            time.sleep(1.0)
        elif userinput =="e":
            pwm2.ChangeDutyCycle(2.9)
            time.sleep(1.0)
            
except KeyboardInterrupt:
    pass

pwm1.stop()
pwm2.stop()
GPIO.cleanup()
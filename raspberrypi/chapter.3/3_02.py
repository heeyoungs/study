import RPi.GPIO as GPIO
import time
 
GPIO.setmode(GPIO.BCM)
GPIO.setup(17,GPIO.OUT)

pwm=GPIO.PWM(17,1000)
pwm.start(0)

try:
    while 1:
        userinput=input()
        print(userinput)
        if userinput == "0":
            pwm.ChangeDutyCycle(0)
        elif userinput == "5":
            pwm.ChangeDutyCycle(50)
        elif userinput == "f":
            pwm.ChangeDutyCycle(100)
    
        time.sleep(1.0)
        
except KeyboardInterrupt:
    pass

pwm.stop()
GPIO.cleanup()
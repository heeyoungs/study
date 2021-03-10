import RPi.GPIO as GPIO
import time

GPIO.setmode(GPIO.BCM)

GPIO.setup(17,GPIO.OUT)

try:
    while 1:
        userinput=input()
        print(userinput)
        if userinput == "n":
            GPIO.output(17,1)
        elif userinput == "f":
            GPIO.output(17,0)
except KeyboardInterrupt:
    pass

GPIO.cleanup()
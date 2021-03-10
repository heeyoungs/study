import RPi.GPIO as GPIO
import time

GPIO.setmode(GPIO.BCM)

GPIO.setup(19,GPIO.OUT)

pwm=GPIO.PWM(19,1)
pwm.start(50)

try:
    while 1:
        userinput = input()
        print(userinput)
        
        if userinput == "a":
         pwm.ChangeFrequency(262)
        elif userinput == "s":
         pwm.ChangeFrequency(294)
        elif userinput == "d":
         pwm.ChangeFrequency(330)
        elif userinput == "f":
         pwm.ChangeFrequency(349)
        elif userinput == "g":
         pwm.ChangeFrequency(392)
        elif userinput == "h":
         pwm.ChangeFrequency(440)
        elif userinput == "j":
         pwm.ChangeFrequency(494)
        elif userinput == "k":
         pwm.ChangeFrequency(523)
        
        time.sleep(0.5)
        pwm.ChangeFrequency(1)
        
except KeyboardInterrupt:
    pass

pwm.stop()
GPIO.cleanup()
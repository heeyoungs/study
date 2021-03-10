import RPi.GPIO as GPIO

GPIO.setmode(GPIO.BCM)
GPIO.setup(19,GPIO.OUT)

pwm=GPIO.PWM(19,50)
pwm.start(2.9)

try:
    while 1:
        userinput =input()
        if userinput == "q":
         pwm.ChangeDutyCycle(2.9)
        elif userinput == "w":
         pwm.ChangeDutyCycle(7.3)
        elif userinput == "e":
         pwm.ChangeDutyCycle(11.5)
        
except KeyboardInterrupt:
    pass

pwm.stop()
GPIO.cleanup()
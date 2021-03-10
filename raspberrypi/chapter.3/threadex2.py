import threading
import RPi.GPIO as GPIO
import time

flag_exit=0

GPIO.setmode(GPIO.BCM)
GPIO.setup(18,GPIO.OUT)
GPIO.setup(19,GPIO.OUT)

pwm1=GPIO.PWM(18,50)
pwm1.start(0)

pwm2=GPIO.PWM(19,50)
pwm2.start(0)

def green():
    while 1:
        for i in range (0,101):
            pwm2.ChangeDutyCycle(i)
            time.sleep(0.013)
        for i in range (100,-1,-1):
            pwm2.ChangeDutyCycle(i)
            time.sleep(0.013)
            
        if flag_exit == 1 :break
        
tg=threading.Thread(target=green)
tg.start()

try:
    while 1:
        for i in range(0,101):
            pwm1.ChangeDutyCycle(i)
            time.sleep(0.007)
        for i in range(100,-1,-1):
            pwm1.ChangeDutyCycle(i)
            time.sleep(0.007)
            
except KeyboardInterrupt:
    pass

flag_exit = 1
tg.join()
pwm1.stop()
pwm2.stop()
GPIO.cleanup()
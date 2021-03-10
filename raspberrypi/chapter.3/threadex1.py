import threading
import RPi.GPIO as GPIO
import time

GPIO.setmode(GPIO.BCM)
GPIO.setup(17,GPIO.OUT)
GPIO.setup(27,GPIO.OUT)
GPIO.setup(23,GPIO.OUT)

flag_exit = 0

def green():
    while 1:
     GPIO.output(27,1)
     time.sleep(1.3)
     GPIO.output(27,0)
     time.sleep(1.3)
    
     if flag_exit:break
def blue():
    while 1:
     GPIO.output(23,1)
     time.sleep(1.7)
     GPIO.output(23,0)
     time.sleep(1.7)
    
     if flag_exit:break
    
tg=threading.Thread(target=green)
tg.start()

tb=threading.Thread(target=blue)
tb.start()

try:
    while 1:
        GPIO.output(17,1)
        time.sleep(0.7)
        GPIO.output(17,0)
        time.sleep(0.7)
except KeyboardInterrupt:
    pass

flag_exit=1
tg.join()
tb.join()
GPIO.cleanup()

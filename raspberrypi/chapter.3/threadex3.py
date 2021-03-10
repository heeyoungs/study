import RPi.GPIO as GPIO
import time
import threading

flag_exit=0
GPIO.setmode(GPIO.BCM)
GPIO.setup(17,GPIO.OUT)
GPIO.setup(27,GPIO.OUT)
GPIO.setup(18,GPIO.OUT)
GPIO.setup(19,GPIO.OUT)

pwm_blue=GPIO.PWM(18,100)
pwm_blue.start(0)
pwm_moter=GPIO.PWM(19,50)
pwm_moter.start(2.9)

def green():
  while 1:
    GPIO.output(27,1)
    time.sleep(1.2)
    GPIO.output(27,0)
    time.sleep(1.2)
    
    if flag_exit==1:break
def blue():
    while 1:
        for t in range(0,101):
         pwm_blue.ChangeDutyCycle(t)
         time.sleep(0.02048)
        for t in range(100,-1,-1):
         pwm_blue.ChangeDutyCycle(t)
         time.sleep(0.02048)
        
        if flag_exit==1:break
def moter():
    while 1:
        for i in range(29,116):
         pwm_moter.ChangeDutyCycle(i/10)
         time.sleep(0.0418)
        for i in range(115,28,-1):
         pwm_moter.ChangeDutyCycle(i/10)
         time.sleep(0.0418)
        
        if flag_exit==1:break
tg=threading.Thread(target=green)
tg.start()
tb=threading.Thread(target=blue)
tb.start()
tm=threading.Thread(target=moter)
tm.start()

try:
    while 1:
        GPIO.output(17,1)
        time.sleep(0.6)
        GPIO.output(17,0)
        time.sleep(0.6)
except KeyboardInterrupt:
    pass

flag_exit=1
tg.join()
tb.join()
tm.join()
pwm_blue.stop()
pwm_moter.stop()
GPIO.cleanup()
    
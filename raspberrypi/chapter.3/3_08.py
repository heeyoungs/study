import RPi.GPIO as GPIO
import time
count=0
moter_=0
buttonprev=0
def buttonpress(channel):
    global count
    global moter_
    global buttonprev
    count=count+1
    if count==3:
        count=0
    if count==0:
        moter_=2.9
    elif count==1:
        moter_=7.3
    elif count==2:
        moter_=11.5
    buttonprev=1
GPIO.setmode(GPIO.BCM)
GPIO.setup(19,GPIO.OUT)
GPIO.setup(22,GPIO.IN)
GPIO.add_event_detect(22,GPIO.RISING)
GPIO.add_event_callback(22,buttonpress)
pwm=GPIO.PWM(19,50)
pwm.start(2.9)
try:
    while 1:
        if buttonprev==1:
            print(moter_)
            buttonprev=0
            pwm.ChangeDutyCycle(moter_)
            time.sleep(0.2)
        
except KeyboardInterrupt:
    pass

pwm.stop()
GPIO.cleanup()
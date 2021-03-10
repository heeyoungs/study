import RPi.GPIO as GPIO
import time
import threading

flag_exit=0

count=0
buttonprev=0
redon=0
greenon=0
blueon=0

def buttonpress(channel):
    global count
    global buttonprev
    global redon
    global greenon
    global blueon
    
    count=count+1
    buttonprev=1
    if count==4:
        count=0
    if count%4==1:
        redon=1
    elif count%4==2:
        greenon=1
    elif count%4==3:
        blueon=1
    elif count%4==0:
        redon=0
        greenon=0
        blueon=0

button=22
redl=17
greenl=27
bluel=23
moter=19

GPIO.setmode(GPIO.BCM)

GPIO.setup(moter,GPIO.OUT)
pwm=GPIO.PWM(moter,50)
pwm.start(2.9)
def moterforce():
    while 1:
          userinput=input()
          if userinput=="q":
            pwm.ChangeDutyCycle(2.9)
          elif userinput == "w":
            pwm.ChangeDutyCycle(7.3)
          elif userinput=="e":
            pwm.ChangeDutyCycle(11.5)
          if flag_exit==1: break
            
GPIO.setup(redl,GPIO.OUT)
GPIO.setup(greenl,GPIO.OUT)
GPIO.setup(bluel,GPIO.OUT)

tm=threading.Thread(target=moterforce)
tm.start()

GPIO.setup(button,GPIO.IN)
GPIO.add_event_detect(button,GPIO.RISING)
GPIO.add_event_callback(button,buttonpress)

try:
    while 1:
        if buttonprev==1:
            print(count)
            GPIO.output(redl,redon)
            GPIO.output(greenl,greenon)
            GPIO.output(bluel,blueon)
            buttonprev=0
            
            
except KeyboardInterrupt:
    pass

flag_exit=1
tm.join()

pwm.stop()
GPIO.cleanup()
        
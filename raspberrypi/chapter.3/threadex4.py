import RPi.GPIO as GPIO
import time
import threading

button=22
redl=17
greenl=27
bluel=23
whitel=24
yellowl=18
moter=19

flag_exit=0

GPIO.setmode(GPIO.BCM)
GPIO.setwarnings(0)

GPIO.setup(redl,GPIO.OUT)
GPIO.setup(greenl,GPIO.OUT)
GPIO.setup(bluel,GPIO.OUT)
count=0
buttonprev=0
redon=0
greenon=0
blueon=0
def buttonpress(channel):##1됨
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
GPIO.setup(button,GPIO.IN)
GPIO.add_event_detect(button,GPIO.RISING)
GPIO.add_event_callback(button,buttonpress)
##
GPIO.setup(whitel,GPIO.OUT)
def whiteled():##2됨
    while 1:
      GPIO.output(whitel,1)
      time.sleep(1.2)
      GPIO.output(whitel,0)
      time.sleep(1.2)
    
      if flag_exit==1:break
##
GPIO.setup(yellowl,GPIO.OUT)
pwmy=GPIO.PWM(yellowl,1000)
pwmy.start(0)
def yellowled():##3됨
    while 1:
      for i in range(0,101):
        pwmy.ChangeDutyCycle(i)
        time.sleep(0.02048)
      for i in range(100,-1,-1):
        pwmy.ChangeDutyCycle(i)
        time.sleep(0.02048)
      if flag_exit==1:
          print("종료하려면 아무키나 누르세용~")
          break

##
GPIO.setup(moter,GPIO.OUT)
pwm=GPIO.PWM(moter,50)
pwm.start(2.9)
def moterforce():##4됨
    while 1:                   
       userinput=input()
       if userinput=="q":
            pwm.ChangeDutyCycle(2.9)
       elif userinput == "w":
            pwm.ChangeDutyCycle(7.3)
       elif userinput=="e":
            pwm.ChangeDutyCycle(11.5)
       if flag_exit==1:
           break      
##
tw=threading.Thread(target=whiteled)
tw.start()

ty=threading.Thread(target=yellowled)
ty.start()

tm=threading.Thread(target=moterforce)
tm.start()

try:
    while 1:
        if buttonprev==1:
            print(count)
            buttonprev=0
            GPIO.output(redl,redon)
            GPIO.output(greenl,greenon)
            GPIO.output(bluel,blueon)
        
except KeyboardInterrupt:
    pass


flag_exit=1
tw.join()
ty.join()
tm.join()
pwm.stop()
pwmy.stop()
GPIO.cleanup()
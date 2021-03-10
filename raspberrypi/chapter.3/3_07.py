import RPi.GPIO as GPIO
import time

button_pin=22
buzzer_pin=19

melody=[523,262,294,330,349,392,440,494]##도레미파솔라시도
count=0
switch=0
sound=1
def buttonpress(channel):
    global sound
    global count
    global switch
    switch=1
    count=count+1
    if count==8:
        count=0
    for i in range(0,8):
        if count==i:
            sound=melody[i]

GPIO.setmode(GPIO.BCM)
GPIO.setup(buzzer_pin,GPIO.OUT)
GPIO.setup(button_pin,GPIO.IN)
pwm=GPIO.PWM(buzzer_pin,1)
pwm.start(0)
GPIO.add_event_detect(button_pin,GPIO.RISING)
GPIO.add_event_callback(button_pin,buttonpress)

try:
    while 1:
        if switch==1:
            switch=0
            print(sound)
            pwm.ChangeDutyCycle(50)
            pwm.ChangeFrequency(sound)
            time.sleep(0.5)
            pwm.ChangeDutyCycle(0)
except KeyboardInterrupt:
    pass

pwm.stop()
GPIO.cleanup()

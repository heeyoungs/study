import RPi.GPIO as GPIO
import time

led_pin=17
button_pin=22

count=0
ledon=0
switch=0
def buttonpress(channel):
    global count
    global ledon
    global switch
    switch=1
    count=count+1
    if count==2:
        count=0
    if count==0:
        ledon=0
    elif count==1:
        ledon=1

GPIO.setmode(GPIO.BCM)
GPIO.setup(led_pin,GPIO.OUT)
GPIO.setup(button_pin,GPIO.IN)
GPIO.add_event_detect(button_pin,GPIO.RISING)
GPIO.add_event_callback(button_pin,buttonpress)

try:
    while 1:
        if switch==1:
            print(count)
            switch=0
            GPIO.output(led_pin,ledon)
            time.sleep(0.01)
except KeyboardInterrupt:
    pass

GPIO.cleanup()


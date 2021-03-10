import RPi.GPIO as GPIO

led_pin=17
button_pin=22

count=0
switch=0
light=0
def buttonpress(channel):
    global count
    global switch
    global light
    switch=1
    count=count+1
    if count==3:
        count=0
    if count==0:
        light=0
    elif count==1:
        light=50
    elif count==2:
        light=100

GPIO.setmode(GPIO.BCM)
GPIO.setup(led_pin,GPIO.OUT)

GPIO.setup(button_pin,GPIO.IN)
pwm=GPIO.PWM(led_pin,1000)
pwm.start(0)
GPIO.add_event_detect(button_pin,GPIO.RISING)
GPIO.add_event_callback(button_pin,buttonpress)

try:
    while 1:
        if switch==1:
            switch=0
            pwm.ChangeDutyCycle(light)
except KeyboardInterrupt:
    pass

pwm.stop()
GPIO.cleanup()

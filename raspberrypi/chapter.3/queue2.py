import queue
import RPi.GPIO as GPIO
import time

message=10
mq=queue.Queue(message)

led_state=0
def buttonpress(channel):
    global led_state
    led_state=1 if not led_state else 0
    mq.put(led_state)
    
GPIO.setmode(GPIO.BCM)
GPIO.setup(27,GPIO.IN)
GPIO.setup(22,GPIO.OUT)

GPIO.add_event_detect(27,GPIO.RISING)
GPIO.add_event_callback(27,buttonpress)

try:
    while 1:
        k=mq.get()
        GPIO.output(22,k)
        
except KeyboardInterrupt:
    pass

GPIO.cleanup()
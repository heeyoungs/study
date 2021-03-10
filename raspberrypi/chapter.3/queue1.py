import queue
import threading
import time

How_Many_Message=1
mq=queue.Queue(How_Many_Message)

flag_exit =0
def t1():
    value=0
    
    while 1:
        value=value+1
        mq.put(value)
        time.sleep(0.1)
        
        if flag_exit:break
        
tMQ=threading.Thread(target=t1)
tMQ.start()

try:
    while 1:
        time.sleep(1)
        value=mq.get()
        print("Read Data %d" %value)
        
except KeyboardInterrupt:
    pass

flag_exit=1
tMQ.join()

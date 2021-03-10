# Raspberrypi python3 문법 (9/23)

#### Import

- ``` python
  import RPi.GPIO as GPIO
  ```

  GPIO 입력 출력 기능을 가져옴

- ``` python
  import time
  ```

  시간 기능을 가져옴

- ``` python
  import threading
  ```

  스레드 기능을 가져옴

- ``` python
  import queue
  ```

  메시지 큐 기능을 가져옴

#### GPIO

- ``` python
  GPIO.setmode(GPIO.BOARD)
  ```

  보드 번호를 쓰겠다

- 

  ``` python
  GPIO.setmode(GPIO.BCM)
  ```

  GPIO번호를 쓰겠다

- ``` python
  GPIO.setup("number",GPIO.OUT)
  ```

  출력

- ``` python
  GPIO.setup("number",GPIO.IN)
  ```

  입력

- ``` python
  GPIO.output("number",1 or 0)
  ```

  on or off

- ``` python
  GPIO.input("number")
  ```

   핀으로부터 값을 받아옴

- ``` python
  GPIO.cleanup()
  ```

  초기화

- ``` python
  GPIO.add_event_detect("number",X)
  ```

  - if X == GPIO.RISING : LOW => HIGH 시 interrupt 발생
  - if X == GPIO.FALLING : HIGH => LOW 시 interrupt 발생
  - if X == GPIO.BOTH : 둘 다 일어날시 interrupt 발생

- ``` python
  GPIO.add_event_callback("number","함수")
  ```

  interrupt 발생시 정의해 놓은 함수 값을 반환함 // def "함수"(channel):

#### Pwm

==> 주파수와 출력을 제어하는 함수

- ``` python
  rpi=GPIO.PWM("number",Hz)
  ```

  rpi의 시작 주파수 설정 (Hz>0)

- ``` python
  rpi.start(출력)
  ```

  rpi의 시작 출력 설정 (100>= 출력 >= 0)

- ``` python 
  rpi.ChangeDutyCycle(출력)
  ```

  rpi의 출력 변경

- ``` python
  rpi.ChangeFrequency(Hz)
  ```

  rpi의 주파수 변경

- ``` python
  rpi.stop()
  ```

  초기화

#### Threading

- ``` python
  rpi=threading.Thread(target="함수")
  ```

  함수를 스레드로 받음

- ``` python
  rpi.start()
  ```

  타겟한 함수 스레드 시작

- ``` python
  rpi.join()
  ```

  초기화

#### Queue

- ``` python 
  mq=queue.Queue("숫자")
  ```

  mq는 숫자의 크기를 가진 큐

- ``` python
  mq.put(input)
  ```

  input 값을 mq에 저장함

- ``` python
  mq.get()
  ```

  값을 반환함
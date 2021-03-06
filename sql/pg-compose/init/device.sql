CREATE TABLE IF NOT EXISTS DEVICE (
  DEVICE_ID   VARCHAR(5) NOT NULL PRIMARY KEY,
  DEVICE_ADDR VARCHAR(5) NOT NULL,
  DEVICE_LOC  VARCHAR(5)
);

CREATE TABLE IF NOT EXISTS DEVICE_DATA (
  SEQ BIGSERIAL NOT NULL PRIMARY KEY,
  DD_DEVICE_ID   VARCHAR(5) NOT NULL,
  DD_DEVICE_DATETIME  TIMESTAMP(6) DEFAULT CURRENT_TIMESTAMP,
  DD_DEVICE_DATA DECIMAL NOT NULL,
  CONSTRAINT dd_deviceid_fk FOREIGN KEY(DD_DEVICE_ID) REFERENCES DEVICE(DEVICE_ID)
);


INSERT INTO DEVICE VALUES
('11111', '11111', 'C501'),
('22222', '22222', 'C502'),
('33333', '33333', 'C503'),
('44444', '44444', 'C504'),
('55555', '55555', 'C505');

INSERT INTO DEVICE_DATA (DD_DEVICE_ID, DD_DEVICE_DATETIME, DD_DEVICE_DATA) VALUES 
('11111', DEFAULT, 10),
('22222', DEFAULT, 20),
('33333', DEFAULT, 30),
('44444', DEFAULT, 40),
('55555', DEFAULT, 50),
('11111', DEFAULT, 12),
('22222', DEFAULT, 24),
('33333', DEFAULT, 36),
('44444', DEFAULT, 48),
('55555', DEFAULT, 50),
('11111', DEFAULT, 11),
('22222', DEFAULT, 23),
('33333', DEFAULT, 35),
('44444', DEFAULT, 47),
('55555', DEFAULT, 59),
('11111', DEFAULT, 11),
('22222', DEFAULT, 22),
('33333', DEFAULT, 33),
('44444', DEFAULT, 44),
('55555', DEFAULT, 55),
('11111', DEFAULT, 16),
('22222', DEFAULT, 27),
('33333', DEFAULT, 38),
('44444', DEFAULT, 49),
('55555', DEFAULT, 60),
('11111', DEFAULT, 10),
('22222', DEFAULT, 29),
('33333', DEFAULT, 38),
('44444', DEFAULT, 47),
('55555', DEFAULT, 56),
('11111', DEFAULT, 15),
('22222', DEFAULT, 24),
('33333', DEFAULT, 33),
('44444', DEFAULT, 42),
('55555', DEFAULT, 51),
('11111', DEFAULT, 15),
('22222', DEFAULT, 25),
('33333', DEFAULT, 35),
('44444', DEFAULT, 45),
('55555', DEFAULT, 55),
('11111', DEFAULT, 17),
('22222', DEFAULT, 27),
('33333', DEFAULT, 37),
('44444', DEFAULT, 47),
('55555', DEFAULT, 57),
('11111', DEFAULT, 19),
('22222', DEFAULT, 29),
('33333', DEFAULT, 39),
('44444', DEFAULT, 49),
('55555', DEFAULT, 59),
('11111', DEFAULT, 13),
('22222', DEFAULT, 23),
('33333', DEFAULT, 33),
('44444', DEFAULT, 43),
('55555', DEFAULT, 53);


SELECT DD_DEVICE_ID, COUNT(DD_DEVICE_DATA) ??????, 
       ROUND(SUM(DD_DEVICE_DATA)::DECIMAL, 2) ??????, ROUND(AVG(DD_DEVICE_DATA)::DECIMAL, 2) ??????
  FROM DEVICE_DATA
 GROUP BY DD_DEVICE_ID;


SELECT A.DEVICE_ID, A.DEVICE_LOC,
       SUM(B.DD_DEVICE_DATA) "??????", AVG(B.DD_DEVICE_DATA) ??????
  FROM DEVICE A, DEVICE_DATA B
 WHERE A.DEVICE_ID = B.DD_DEVICE_ID
 GROUP BY A.DEVICE_ID
HAVING SUM(B.DD_DEVICE_DATA) > 280;

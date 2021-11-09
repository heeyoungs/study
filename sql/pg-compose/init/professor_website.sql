CREATE TABLE IF NOT EXISTS PROF_WEBSITE (
    PWCODE	VARCHAR(4) NOT NULL PRIMARY KEY,
    BLOG	VARCHAR(30),
    HOMEPAGE	VARCHAR(30),
    FACEBOOK	VARCHAR(30),
    CONSTRAINT pwcode_fk FOREIGN KEY(PWCODE) REFERENCES PROFESSOR(PCODE)
);

INSERT INTO PROF_WEBSITE VALUES ('P003', 'http://blog.hanbat.ac.kr/cslee', 'http://home.hanbat.ac.kr/cslee', 'http://www.fb.com/cslee');
INSERT INTO PROF_WEBSITE VALUES ('P004', 'http://blog.hanbat.ac.kr/phj', 'http://home.hanbat.ac.kr/phj', 'http://www.fb.com/phj');
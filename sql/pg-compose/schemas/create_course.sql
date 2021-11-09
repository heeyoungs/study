/* 개설과목 테이블 생성 (course.sql) */
CREATE TABLE COURSE (
    CCODE    	VARCHAR(4) NOT NULL PRIMARY KEY,
    CNAME    	VARCHAR(10),
    CTIME    	INTEGER,
    CROOM	VARCHAR(8)
);

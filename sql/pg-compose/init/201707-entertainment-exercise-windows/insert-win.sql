-- Inserting Department Data
INSERT INTO DEPARTMENT VALUES ('D001', '배우', '서울특별시');
INSERT INTO DEPARTMENT VALUES ('D002', '뮤지컬배우', '서울특별시');
INSERT INTO DEPARTMENT VALUES ('D003', '가수(솔로)', '서울특별시');
INSERT INTO DEPARTMENT VALUES ('D004', '가수(그룹)', '서울특별시');
INSERT INTO DEPARTMENT VALUES ('D005', '코미디언', '서울특별시');
INSERT INTO DEPARTMENT VALUES ('D101', '드라마제작', '서울특별시');
INSERT INTO DEPARTMENT VALUES ('D102', '영화제작', '대전광역시');
INSERT INTO DEPARTMENT VALUES ('D103', '음반제작', '수원시');
INSERT INTO DEPARTMENT VALUES ('D104', '예능제작', '서울특별시');
INSERT INTO DEPARTMENT VALUES ('D201', '스태프', NULL);
INSERT INTO DEPARTMENT VALUES ('D301', '임원', '서울특별시');

-- Inserting Employee Role Data
INSERT INTO EMP_ROLE VALUES ('R001', '엔터테이너'), ('R002', '국장'), ('R003', '실장'), ('R004', '대리'), ('R005', '사원'), ('R006', '이사'), ('R007', '사장');

-- Inserting Employee Data
INSERT INTO EMPLOYEE VALUES ('E001', '김민훈', 'E202', 5500, 'R001'), ('E002', '손지민', 'E201', 4500, 'R001'), ('E003', '이순신', 'E203', 9500, 'R001');
INSERT INTO EMPLOYEE VALUES ('E004', '강혁민', 'E201', 3500, 'R001'), ('E005', '옥주인', 'E201', 3500, 'R001'), ('E006', '신승모', 'E202', 7500, 'R001');
INSERT INTO EMPLOYEE VALUES ('E007', '김건훈', 'E202', 7500, 'R001'), ('E008', '소년시대', 'E203', 8500, 'R001'), ('E009', '유재동', 'E203', 8500, 'R001');
INSERT INTO EMPLOYEE VALUES ('E101', '강동민', 'E902', 7500, 'R002'), ('E102', '문성준', 'E902', 7500, 'R002'), ('E103', '한동화', 'E902', 7500, 'R002');
INSERT INTO EMPLOYEE VALUES ('E201', '홍길동', 'E902', 3000, 'R003');
INSERT INTO EMPLOYEE VALUES ('E202', '일지매', 'E101', 2750, 'R004');
INSERT INTO EMPLOYEE VALUES ('E203', '김수현', 'E102', 2750, 'R004');
INSERT INTO EMPLOYEE VALUES ('E204', '신용주', 'E103', 2500, 'R005');
INSERT INTO EMPLOYEE VALUES ('E902', '김형석', 'E901', 4000, 'R006');
INSERT INTO EMPLOYEE VALUES ('E901', '이수민', NULL, 5000, 'R007');

-- Inserting REL_Department Data
INSERT INTO REL_DEPARTMENT VALUES ('E001', 'D001');
INSERT INTO REL_DEPARTMENT VALUES ('E001', 'D002');
INSERT INTO REL_DEPARTMENT VALUES ('E002', 'D001');
INSERT INTO REL_DEPARTMENT VALUES ('E003', 'D001');
INSERT INTO REL_DEPARTMENT VALUES ('E003', 'D003');
INSERT INTO REL_DEPARTMENT VALUES ('E004', 'D001');
INSERT INTO REL_DEPARTMENT VALUES ('E004', 'D002');
INSERT INTO REL_DEPARTMENT VALUES ('E005', 'D002');
INSERT INTO REL_DEPARTMENT VALUES ('E006', 'D003');
INSERT INTO REL_DEPARTMENT VALUES ('E007', 'D003');
INSERT INTO REL_DEPARTMENT VALUES ('E008', 'D004');
INSERT INTO REL_DEPARTMENT VALUES ('E009', 'D005');
INSERT INTO REL_DEPARTMENT VALUES ('E101', 'D102');
INSERT INTO REL_DEPARTMENT VALUES ('E102', 'D102');
INSERT INTO REL_DEPARTMENT VALUES ('E103', 'D103');
INSERT INTO REL_DEPARTMENT VALUES ('E201', 'D201');
INSERT INTO REL_DEPARTMENT VALUES ('E202', 'D201');
INSERT INTO REL_DEPARTMENT VALUES ('E203', 'D201');
INSERT INTO REL_DEPARTMENT VALUES ('E204', 'D201');
INSERT INTO REL_DEPARTMENT VALUES ('E901', 'D201');
INSERT INTO REL_DEPARTMENT VALUES ('E902', 'D301');

-- Inserting Movie Data
INSERT INTO MOVIE VALUES ('MOV01', '모래가 흐르는 바다','A', '2013-01-01', '2013-01-01');
INSERT INTO MOVIE VALUES ('MOV02', '프랜드','18', '2013-01-15', '2013-01-15');
INSERT INTO MOVIE VALUES ('MOV03', '5급 공무원','15', '2013-02-01', '2013-02-01');
INSERT INTO MOVIE VALUES ('MOV04', '사랑','18', '2013-02-01', '2013-02-01');
INSERT INTO MOVIE VALUES ('MOV05', '킬러','18', '2013-02-08', '2013-02-08');
INSERT INTO MOVIE VALUES ('MOV06', '스토커','18', '2013-02-28', '2013-02-28');
INSERT INTO MOVIE VALUES ('MOV07', '더 울버린','15', '2013-07-25', NULL);
INSERT INTO MOVIE VALUES ('MOV08', '여름','15', '2013-07-31', NULL);
INSERT INTO MOVIE VALUES ('MOV09', '봄','A', '2013-03-01', '2013-03-01');
INSERT INTO MOVIE VALUES ('MOV10', '저스트 어 이어','12', '2013-05-01', NULL);

-- Inserting Drama Data
INSERT INTO DRAMA VALUES ('DRM01', '왕의 게임','TG', 'SBC', '2013-01-01');
INSERT INTO DRAMA VALUES ('DRM02', '아이러시','SN', 'KBC', '2013-01-01');
INSERT INTO DRAMA VALUES ('DRM03', '야킹','TG', 'SBC', '2013-02-01');
INSERT INTO DRAMA VALUES ('DRM04', '닥터 호','HNU-E', 'MBS', '2013-02-01');
INSERT INTO DRAMA VALUES ('DRM05', '5급 사무관','SN', 'MBS', '2013-02-15');
INSERT INTO DRAMA VALUES ('DRM06', '그 사람','XTS', 'XTS', '2013-02-15');
INSERT INTO DRAMA VALUES ('DRM07', '여왕의 꿈','HNU-E', 'KBC', '2013-03-15');
INSERT INTO DRAMA VALUES ('DRM08', '머니의 화신','TG', 'SBC', '2013-03-15');
INSERT INTO DRAMA VALUES ('DRM09', '회사의 신','SN', 'MBC', NULL);
INSERT INTO DRAMA VALUES ('DRM10', '수의사','HNU-E', 'XTS', NULL);

-- Inserting Music Data
INSERT INTO MUSIC VALUES ('MSC01', '소년시대 2013', '2013-01-01', 8000, '싱글');
INSERT INTO MUSIC VALUES ('MSC02', '하이퍼주니어 4집', '2013-01-05', 15500, '정규');
INSERT INTO MUSIC VALUES ('MSC03', '이승모 연인', '2013-01-31', 7000, '싱글');
INSERT INTO MUSIC VALUES ('MSC04', '박장현 사랑', '2013-02-01', 7000, '싱글');
INSERT INTO MUSIC VALUES ('MSC05', '김건훈 5집', '2013-02-08', 12500, '정규');
INSERT INTO MUSIC VALUES ('MSC06', '원더우먼 봄', '2013-02-28', 9500, '싱글');
INSERT INTO MUSIC VALUES ('MSC07', '슈퍼맨 안녕', '2013-03-25', 9500, '싱글');
INSERT INTO MUSIC VALUES ('MSC08', '소년시대 4집', '2013-04-01', 13500, '정규');
INSERT INTO MUSIC VALUES ('MSC09', '핑키 러브', '2013-04-01', 10500, '싱글');
INSERT INTO MUSIC VALUES ('MSC10', '신승모 6집', '2013-04-02', 18500, '정규');

-- Inserting PART_MOVIE Data
INSERT INTO PART_MOVIE VALUES ('MOV03', 'E003', '주연', 13500);
INSERT INTO PART_MOVIE VALUES ('MOV03', 'E001', '조연', 7500);
INSERT INTO PART_MOVIE VALUES ('MOV05', 'E002', '단역', 3500);
INSERT INTO PART_MOVIE VALUES ('MOV08', 'E004', '단역', 3500);
INSERT INTO PART_MOVIE VALUES ('MOV09', 'E001', '조연', 8000);
INSERT INTO PART_MOVIE VALUES ('MOV09', 'E004', '단역', 3000);

-- Inserting PART_DRAMA Data
INSERT INTO PART_DRAMA VALUES ('DRM02', 'E003', '주연', 13500);
INSERT INTO PART_DRAMA VALUES ('DRM02', 'E002', '조연', 7500);
INSERT INTO PART_DRAMA VALUES ('DRM02', 'E004', '단역', 3500);
INSERT INTO PART_DRAMA VALUES ('DRM05', 'E001', '주연', 7500);
INSERT INTO PART_DRAMA VALUES ('DRM05', 'E004', '단역', 0);
INSERT INTO PART_DRAMA VALUES ('DRM05', 'E002', '단역', 0);
INSERT INTO PART_DRAMA VALUES ('DRM08', 'E002', '조연', 6500);
INSERT INTO PART_DRAMA VALUES ('DRM10', 'E003', '주연', 15000);

-- Inserting PART_MUSIC Data
INSERT INTO PART_MUSIC VALUES ('MSC01', 'E008', '메인', 8500);
INSERT INTO PART_MUSIC VALUES ('MSC03', 'E003', '피처링', 1500);
INSERT INTO PART_MUSIC VALUES ('MSC04', 'E007', '피처링', 1500);
INSERT INTO PART_MUSIC VALUES ('MSC08', 'E008', '메인', 13500);
INSERT INTO PART_MUSIC VALUES ('MSC10', 'E006', '메인', 15500);

commit;
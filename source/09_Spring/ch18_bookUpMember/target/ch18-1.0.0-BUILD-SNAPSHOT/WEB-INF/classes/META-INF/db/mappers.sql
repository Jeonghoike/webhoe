-- mapper 에 들어갈 query
-- Book.xml id=mainList (신작순서대로 book리스트)
SELECT * FROM BOOK ORDER BY BRDATE;

-- Book.xml id=bookList (책이름 ㄱㄴ순서대로 book리스트 top-N구문)
SELECT *
    FROM (SELECT ROWNUM RN, A.* FROM(SELECT * FROM BOOK ORDER BY BTITLE) A)
    WHERE RN BETWEEN 2 AND 3;
-- Book.xml id=bookList (전체 검색일 경우(책이름, 책저자)
SELECT *
    FROM (SELECT ROWNUM RN, A.* 
        FROM (SELECT * FROM BOOK WHERE BTITLE LIKE '%'||UPPER('S')||'%' OR BINFO LIKE '%'||UPPER('이')||'%' ORDER BY BTITLE DESC) A)
    WHERE RN BETWEEN 2 AND 5;

-- Book.xml id=bookList (책 제목 검색일 경우 BTITLE)
SELECT * 
    FROM (SELECT ROWNUM RN, A.*
        FROM (SELECT * FROM BOOK WHERE BTITLE LIKE '%'||UPPER('S')||'%' ORDER BY BTITLE DESC) A)
    WHERE RN BETWEEN 1 AND 6;

-- Book.xml id=bookList (책 저자 검색일 경우 BWRITER)
SELECT *
    FROM (SELECT ROWNUM RN, A.* 
        FROM(SELECT * FROM BOOK WHERE BWRITER LIKE '%'||UPPER('이')||'%' ORDER BY BTITLE DESC) A)
    WHERE RN BETWEEN 1 AND 6;

-- Book.xml id=totCntBook
SELECT COUNT(*) CNT FROM BOOK;

-- Book.xml id=totCntBook (shcWord all일경우)
SELECT COUNT(*)
    FROM BOOK WHERE BTITLE LIKE '%'||UPPER('S')||'%' OR BINFO LIKE '%'||UPPER('이')||'%' ORDER BY BTITLE DESC;
    
-- Book.xml id=totCntBook (shcWord BTITLE일경우)
SELECT COUNT(*)
    FROM BOOK WHERE BTITLE LIKE '%'||UPPER('J')||'%' ORDER BY BTITLE DESC;
SELECT * FROM BOOK;

-- Book.xml id=totCntBook (shcWord BWRITER일경우)
SELECT COUNT(*)
    FROM BOOK WHERE BWRITER LIKE '%'||UPPER('이')||'%' ORDER BY BTITLE DESC;

-- schItem이 all일 때
SELECT COUNT(*) FROM BOOK WHERE BTITLE LIKE '%'||'S'||'%' OR BINFO LIKE '%'||'S'||'%';

-- Book.xml id=getDetailBook
SELECT * FROM BOOK WHERE BNUM=1;

-- Book.xml id=registerBook (bimg를 둘다 입력할 수도 하나만 입력할 수도 입력안할수도 있음)
INSERT INTO BOOK (bNUM, bTITLE, bWRITER, bRDATE, bIMG1, bINFO)
    VALUES (BOOK_SQ.NEXTVAL, 'SPRING','이홍길',SYSDATE, 'noImg.png','SPRING 개념서');

INSERT INTO BOOK (bNUM, bTITLE, bWRITER, bRDATE, bIMG1, bIMG2, bINFO)
    VALUES (BOOK_SQ.NEXTVAL, '이것뭐냐','왕밤빵',SYSDATE, 'noImg.png', 'noImg.png','이게대체뭘까');

-- Book.xml id=modifyBook
UPDATE BOOK
    SET BTITLE = '자바',
        BWRITER = '김홍',
        BRDATE = SYSDATE,
        BIMG1 = 'noImg.png',
        BINFO = '개념서'
    WHERE BNUM=5;

-- Member.xml id=idConfirm (resultType=int)
SELECT COUNT(*) FROM MEMBER WHERE MID='aaa';
-- Member.xml id=joinMember
INSERT INTO MEMBER VALUES ('bbb','1','김길석','kim@naver.com','03780','서울시 마포구 신촌로 141');
-- Member.xml id=getDetailMember
SELECT * FROM MEMBER WHERE MID = 'bbb';
-- Member.xml id=modifyMember
UPDATE MEMBER SET MPW='1',
                MNAME='신길동',
                MMAIL = 'shin@gmail.com',
                MADDR='서울시 영등포구 신길동 1266',
                MPOST = '07355'
    WHERE MID='bbb';
COMMIT;
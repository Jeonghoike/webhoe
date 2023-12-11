-- mapper 에 들어갈 query
-- Book.xml id=mainList (신작순서대로 book리스트)
SELECT * FROM BOOK ORDER BY BRDATE;

-- Book.xml id=bookList (책이름 ㄱㄴ순서대로 book리스트 top-N구문)
SELECT *
    FROM (SELECT ROWNUM RN, A.* FROM(SELECT * FROM BOOK ORDER BY BTITLE) A)
    WHERE RN BETWEEN 2 AND 3;

-- Book.xml id=totCntBook
SELECT COUNT(*) CNT FROM BOOK;

-- Book.xml id=getDetailBook
SELECT * FROM BOOK WHERE BNUM=1;

-- Book.xml id=registerBook (bimg를 둘다 입력할 수도 하나만 입력할 수도 입력안할수도 있음)
INSERT INTO BOOK (bNUM, bTITLE, bWRITER, bRDATE, bIMG1, bINFO)
    VALUES (BOOK_SQ.NEXTVAL, 'SPRING','이홍길',SYSDATE, 'noImg.png','SPRING 개념서');

INSERT INTO BOOK (bNUM, bTITLE, bWRITER, bRDATE, bIMG1, bIMG2, bINFO)
    VALUES (BOOK_SQ.NEXTVAL, 'SPRING','이홍길',SYSDATE, 'noImg.png', 'noImg.png','SPRING 개념서');

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
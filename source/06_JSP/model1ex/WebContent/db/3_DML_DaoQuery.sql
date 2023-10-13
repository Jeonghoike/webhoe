-- bookDao 들어갈 QUERY

-- 1. 책 등록
INSERT INTO BOOK (bID, bTITLE, bPRICE, bIMAGE1, bIMAGE2, bCONTENT, bDISCOUNT)
    VALUES (BOOK_SEQ.NEXTVAL, 'HTML5',2000,'114.jpg','noImg.png','좋다 ',10);
    
-- 2. 책 목록(PAGING 없이)
SELECT * FROM BOOK ORDER BY BRDATE DESC;

-- 2. 책 목록(PAGING처리 : TOP-N)
SELECT ROWNUM RN, A.*
    FROM (SELECT * FROM BOOK ORDER BY BRDATE DESC) A; -- TOP-N구문의 INLINE VIEW에 들어갈 QUERY
SELECT *
    FROM (SELECT ROWNUM RN, A.*
        FROM (SELECT * FROM BOOK ORDER BY BRDATE DESC) A)
    WHERE RN BETWEEN 1 AND 6; -- DAO에 들어갈 QUERY

-- 3. 등록된 책 갯수
SELECT COUNT(*) CNT FROM BOOK;

-- 4. 책 상세보기(BID로 DTO가져오기)
SELECT * FROM BOOK WHERE BID=1;


SELECT * FROM CUSTOMER;
-- 1. 회원가입시 ID중복체크 : public int confirmID(String id)
SELECT COUNT(*) FROM CUSTOMER WHERE cID = 'aaa';

-- 2. 회원가입 INSERT : public int joinCustomer(CustomerDto dto)
INSERT INTO CUSTOMER (CID, CPW, CNAME, CTEL, CEMAIL, CADDRESS, CBIRTH, CGENDER) 
    VALUES ('aaa','1','홍길동', '010-9999-9999','hong@hong.com','서울', '1995-12-12', 'M');
    
-- 3. 로그인 : public int loginCheck(String id, String pw)
SELECT * FROM CUSTOMER WHERE CID='aaa' AND CPW='1';

-- 4. 로그인 성공시 session에 추가할 회원정보 : public CustomerDto getCustomer(String id)
SELECT * FROM CUSTOMER WHERE CID='aaa' AND CPW='111';

-- 5. 회원정보 수정 : public int modifyCustomer (CustomerDto dto)
UPDATE CUSTOMER 
    SET CPW = '111',
        CNAME = '신길동',
        CTEL = '010-3333-3333',
        CEMAIL = 'shin@shin.com',
        CADDRESS = '파주',
        CBIRTH = '1995-11-11',
        CGENDER = 'M'
    WHERE CID = 'aaa';
    
-- 6. 회원리스트 public ArrayList(CustomerDto> listCustomer(startRow, endRow) : cid순으로 TOP-N
SELECT * 
    FROM(SELECT ROWNUM RN, CID, CPW, CNAME,CEMAIL, CADDRESS 
            FROM(SELECT * FROM CUSTOMER ORDER BY CID DESC) A)
    WHERE RN BETWEEN 1 AND 3;
    
-- 7. 가입한 회원수 public int getCustomerTotalCnt()
SELECT COUNT(*) CNT FROM CUSTOMER;


-- FileBoardDao에 들어갈 query

-- 1. 글목록(startRow ~ endRow까지 fileBoard 리스트)
SELECT F.*, CNAME, CEMAIL 
    FROM FILEBOARD F, CUSTOMER C 
    WHERE F.CID=C.CID
    ORDER BY FGROUP DESC, FSTEP;
SELECT *
    FROM(SELECT ROWNUM RN, A.*
            FROM(SELECT F.*, CNAME, CEMAIL 
                    FROM FILEBOARD F, CUSTOMER C 
                    WHERE F.CID=C.CID
                    ORDER BY FGROUP DESC, FSTEP)A)
    WHERE RN BETWEEN 1 AND 3;
-- 2. 전체 글 갯수
SELECT COUNT(*) CNT FROM FILEBOARD;
-- 3. 글쓰기 : cid(글쓴이id), 글제목, 본문, 첨부파일, 비번, ip (fgroup은 글번호, fstep과 findent는 0)
INSERT INTO FILEBOARD (FID, CID, FTITLE, FCONTENT, FILENAME, FPW, FGROUP, FSTEP, FINDENT, FIP)
    VALUES (FILEBOARD_SEQ.NEXTVAL, 'aaa', '글4', '컨텐츠', NULL, '111', FILEBOARD_SEQ.CURRVAL, 0, 0, '192.0.0.4');
SELECT * FROM FILEBOARD;
-- 4. fid로 조회수 1 올리기
UPDATE FILEBOARD SET FHIT = FHIT + 1 WHERE FID=1;
-- 5. fid로 dto가져오기
SELECT F.*, CNAME, CEMAIL FROM FILEBOARD F, CUSTOMER C 
  WHERE F.CID = C.CID AND FID=1
  ORDER BY fGROUP DESC, fSTEP;
-- 6. 글수정 : 글제목, 본문, 첨부파일, 비번, ip수정
UPDATE FILEBOARD
  SET FTITLE = '바꾼제목',
      FCONTENT = '바꾼본문',
      FILENAME = NULL,
      FPW    = '111',
      FIP    = '127.0.0.1'
  WHERE FID=1;

-- 7. 글삭제(fid, fpw)
COMMIT;
DELETE FROM FILEBOARD WHERE FID=1 AND FPW='111';
ROLLBACK;
SELECT * FROM FILEBOARD;

-- 8. 답변글 쓰기 전단계(엑셀 a단계)
UPDATE FILEBOARD SET FSTEP = FSTEP+1 WHERE FGROUP=1 AND FSTEP>0;
-- 9. 답변글 쓰기
INSERT INTO FILEBOARD (fID, cID, fTITLE, fCONTENT, FILENAME, fPW, 
                fGROUP, fSTEP, fINDENT, fIP)
        VALUES (FILEBOARD_SEQ.NEXTVAL, 'ccc', '글1-1','냉무',null,'111',
                1, 1, 1, '192.168.0.31');
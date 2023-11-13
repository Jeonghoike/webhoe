----------------------------------------------------------------------
--                    MVC_MEMBER    DAO                      --
----------------------------------------------------------------------

-- 1. 회원mid 중복체크
SELECT * FROM MVC_MEMBER WHERE MID = 'gayun';

-- 2. 회원email 중복체크
SELECT * FROM MVC_MEMBER WHERE MEMAIL = 'aaa@aaa.com';

-- 3. 회원가입
INSERT INTO MVC_MEMBER (mID, mPW, mNAME, mEMAIL, mPHOTO, mBIRTH, mADDRESS)
    VALUES ('aaa', '1', '이름에이', 'jsj@jsj.com', 'NOIMG.JPG', '1991-06-11', '서울');

-- 4. 로그인
SELECT * FROM MVC_MEMBER WHERE MID = 'aaa' AND MPW = '1';

-- 5. MID로 DTO가져오기
SELECT * FROM MVC_MEMBER WHERE MID = 'aaa';

-- 6. 수정 
UPDATE MVC_MEMBER 
    SET mPW = '111',
        mNAME = 'aa',
        mEMAIL = 'aaa@aaa.com',
        mPHOTO = 'NOIMG.JPG',
        mBIRTH = '1991-06-07',
        mADDRESS = '경기도'
    WHERE MID = 'aaa';

-- 7. 회원리스트
SELECT * FROM (SELECT ROWNUM RN, A.* FROM (SELECT * FROM MVC_MEMBER ORDER BY mRDATE DESC) A)
    WHERE RN BETWEEN 4 AND 6;

-- 8. 회원수
SELECT COUNT(*) CNT FROM MVC_MEMBER;

-- 9. 회원탈퇴
COMMIT;
DELETE FROM MVC_MEMBER WHERE MID = 'aaa';
ROLLBACK;

----------------------------------------------------------------------
--                   FILEBOARD DAO                          --
----------------------------------------------------------------------
-- 1. 글목록
SELECT *
    FROM (SELECT ROWNUM RN, A.* 
        FROM (SELECT F.*, mNAME, mEMAIL FROM FILEBOARD F, MVC_MEMBER M 
                WHERE F.mID=M.mID ORDER BY fGROUP DESC, fSTEP)A)
    WHERE RN BETWEEN 1 AND 4;

-- 2. 글갯수
SELECT COUNT(*) CNT FROM FILEBOARD;

-- 3. 글쓰기
INSERT INTO FILEBOARD (FID, MID, FTITLE, FCONTENT, FFILENAME, FGROUP, FSTEP, FINDENT, FIP)
  VALUES (FILEBOARD_SEQ.NEXTVAL, 'son','토트넘','난 공격수', 'a.docx', FILEBOARD_SEQ.CURRVAL, 0,0, '192.168.0.31'); 

-- 4. hit 1회 올리기  
UPDATE FILEBOARD SET FHIT = FHIT +1 WHERE FID=1;
-- 5. 글번호(fid)로 글전체 내용(BoardDto) 가져오기
SELECT F.*, MNAME
  FROM FILEBOARD F, MVC_MEMBER M WHERE F.MID=M.MID AND FID=1;
-- 6. 글 수정하기(fid, ftitle, fcontent, ffilename, frdate(SYSDATE), fip 수정)
UPDATE FILEBOARD
    SET fTITLE = '바뀐제목',
        FCONTENT = '바뀐본문',
        fFILENAME = NULL,
        FIP = '192.168.151.10',
        FRDATE = SYSDATE
    WHERE FID = 1;
-- 7. 글 삭제하기
DELETE FROM FILEBOARD WHERE FID=3;
-- 8. 답변글 쓰기 전 단계(원글의 fgroup과 같고, 원글의 fstep보다 크면 fstep을 하나 증가하기)
UPDATE FILEBOARD SET FSTEP = FSTEP + 1 WHERE FGROUP=5 AND FSTEP>0;
-- 9. 답변글 쓰기
INSERT INTO FILEBOARD (FID, MID, FTITLE, FCONTENT, FFILENAME, FGROUP, FSTEP, FINDENT, FIP)
  VALUES (FILEBOARD_SEQ.NEXTVAL, 'son','박지성 아님', '잘한다', null, 5, 1, 1, '194.161.13.11');
-- 10. 회원탈퇴시 탈퇴하는 회원(mid)이 쓴 글 모두 삭제하기
DELETE FROM FILEBOARD WHERE MID='son';
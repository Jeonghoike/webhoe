-- 테이블 삭제
DROP TABLE MVC_MEMBER;

-- 테이블 생성
CREATE TABLE MVC_MEMBER(
    mID VARCHAR2(30) PRIMARY KEY,
    mPW VARCHAR2(30) NOT NULL,
    mNAME VARCHAR2(30) NOT NULL,
    mEMAIL VARCHAR2(30),
    mADDRESS VARCHAR2(300),
    mRDATE DATE DEFAULT SYSDATE NOT NULL
);

-- Dao에 들어갈query

-- 1. mid 중복체크
SELECT * FROM MVC_MEMBER WHERE mID = 'aaa';
-- 2. 회원가입(mid, mpw, mname, memail, mbirth, maddress)
INSERT INTO MVC_MEMBER (mID, mPW, mNAME, mEMAIL, mADDRESS)
    VALUES ('aaa', '1', '홍길동', 'hong@naver.com', '서울시');
-- 3. 로그인 체크 (mid, mpw)
SELECT * FROM MVC_MEMBER WHERE mID='aaa' AND mPW = '1';
-- 4. 로그인 성공시 session에 넣을 dto(mid로 dto가져오기)
SELECT * FROM MVC_MEMBER WHERE mID='aaa';
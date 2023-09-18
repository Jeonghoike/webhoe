-- TABLE DROP & CREATE
DROP TABLE MEMBER CASCADE CONSTRAINTS;
CREATE TABLE MEMBER(
    ID VARCHAR2(30) PRIMARY KEY,
    PW VARCHAR2(30) NOT NULL,
    NAME VARCHAR2(30) NOT NULL,
    PHONE1 VARCHAR2(5),
    PHONE2 VARCHAR2(5),
    PHONE3 VARCHAR2(5),
    GENDER VARCHAR2(1),
    EMAIL VARCHAR2(30),
    BIRTH DATE,
    ADDRESS VARCHAR2(200),
    RDATE DATE NOT NULL -- 가입일
);
SELECT * FROM MEMBER;
-- 1. 회원가입시 ID 중복체크 : public int confirmID(String id)
SELECT * FROM MEMBER WHERE ID='aaa';

-- 2. 회원가입 INSERT : public int joinMember(MemberDto dto)
INSERT INTO MEMBER (ID, PW, NAME, PHONE1, PHONE2, PHONE3, GENDER, EMAIL, BIRTH, ADDRESS, RDATE) 
    VALUES ('aaa','1','홍길동', '010', '9999', '9999','M','hong@hong.com', '1999-12-12','서울',SYSDATE);
    
-- 3. 로그인 : public int loginCheck(String id, String pw)
SELECT * FROM MEMBER WHERE ID='aaa';

-- 4. 로그인 성공시 session에 setAttribute할 회원 정보(id로 dto가져오기) : public MemberDto getMember(String id)
SELECT * FROM MEMBER WHERE ID='aaa';

-- 5. 회원정보 수정 : public int modifyMember(MemberDto dto)
UPDATE MEMBER 
    SET PW = '111',
        NAME = '신길동',
        PHONE1 = '010',
        PHONE2 = '7777',
        PHONE3 = '7777',
        GENDER = 'm',
        EMAIL = 'shin@hong.com',
        BIRTH = '1999-01-01',
        ADDRESS = '서울'
    WHERE ID='aaa';
    
SELECT * FROM MEMBER;
COMMIT;

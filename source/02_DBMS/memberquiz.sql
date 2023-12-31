DROP TABLE MEMBER;
DROP TABLE MEMBER_LEVEL;
DROP SEQUENCE MEMBER_MNO_SQ;

CREATE TABLE MEMBER_LEVEL(
    LEVELNO NUMBER(1) PRIMARY KEY NOT NULL,
    LEVELNAME VARCHAR(10) NOT NULL
);

CREATE SEQUENCE MEMBER_MNO_SQ
    MAXVALUE 999
    NOCACHE
    NOCYCLE;
CREATE TABLE MEMBER(
    mNO NUMBER(3) PRIMARY KEY,
    mNAME VARCHAR2(30) NOT NULL,
    mPW VARCHAR2(8), -- 
    mEMAIL VARCHAR2(255) UNIQUE,
    mPOINT NUMBER(10) CHECK(mPOINT>=0),
    mRDATE VARCHAR2(30) DEFAULT SYSDATE,
    LEVELNO NUMBER(1) REFERENCES MEMBER_LEVEL(LEVELNO)  
);
INSERT INTO MEMBER_LEVEL (LEVELNO, LEVELNAME)
    VALUES (-1, 'BLACK');
INSERT INTO MEMBER_LEVEL VALUES(0, '�Ϲ�');
INSERT INTO MEMBER_LEVEL VALUES(1, '�ǹ�');
INSERT INTO MEMBER_LEVEL VALUES(2, '���');
SELECT * FROM MEMBER_LEVEL;

INSERT INTO MEMBER (mNO, mNAME, mPW, mEMAIL, mPOINT, mRDATE, LEVELNO)
        VALUES (MEMBER_MNO_SQ.NEXTVAL, 'ȫ�浿', 'aa', 'hong@hong.com', 0, '22/03/10', 0);
INSERT INTO MEMBER 
        VALUES (MEMBER_MNO_SQ.NEXTVAL, '�ű浿', 'bb', 'sin@sin.com', 1000, '22/04/01', 1);
SELECT * FROM MEMBER;
SELECT M.mNO "mNO", M.mNAME "mNAME", mRDATE "mRDATE", mEMAIL "mMAIL", mPOINT "point", LEVELNAME||'����' "levelname"
    FROM MEMBER M, MEMBER_LEVEL ML
    WHERE M.LEVELNO=ML.LEVELNO;


        
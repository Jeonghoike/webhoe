DROP TABLE MEMBER;
DROP TABLE ORDERDT;
DROP TABLE ORDERS;
DROP TABLE CART;
DROP TABLE PRODUCT;
DROP SEQUENCE ORDERDT_odNO_SQ;
DROP SEQUENCE ORDERS_oNO_SQ;
DROP SEQUENCE CART_cNO_SQ;

CREATE TABLE MEMBER(
    mID VARCHAR2(20) PRIMARY KEY,
    mNAME VARCHAR2(30),
    mADDR VARCHAR2(255),
    mTEL VARCHAR2(20),
    mEMAIL VARCHAR2(255) UNIQUE
);
CREATE TABLE PRODUCT(
    pCODE VARCHAR2(10) PRIMARY KEY,
    pNAME VARCHAR2(30),
    PRICE NUMBER(10) CHECK(PRICE>0),
    STOCK NUMBER(10)
);

CREATE SEQUENCE CART_cNO_SQ
    MAXVALUE 999
    NOCACHE
    NOCYCLE;
CREATE TABLE CART(
    cNO NUMBER(3) PRIMARY KEY,
    mID VARCHAR2(20) REFERENCES MEMBER(mID),
    pCODE VARCHAR2(10) REFERENCES PRODUCT(pCODE),
    QTY NUMBER(10) CHECK(QTY>0),
    COST NUMBER(20) CHECK(COST>0)
);

CREATE SEQUENCE ORDERS_oNO_SQ
    MAXVALUE 9999999999
    NOCACHE
    NOCYCLE;
CREATE TABLE ORDERS(
    oNO NUMBER(10) PRIMARY KEY,
    oNAME VARCHAR2(30),
    oADDR VARCHAR2(255),
    oTEL VARCHAR2(20),
    oDATE VARCHAR2(255) DEFAULT SYSDATE,
    mID VARCHAR2(20) REFERENCES MEMBER(mID)
);

CREATE SEQUENCE ORDERDT_odNO_SQ
    MAXVALUE 999
    NOCACHE
    NOCYCLE;
CREATE TABLE ORDERDT(
    odNO NUMBER(3) PRIMARY KEY,
    oNO NUMBER(10) REFERENCES ORDERS(oNO),
    pCODE VARCHAR2(10) REFERENCES PRODUCT(pCODE),
    QTY NUMBER(10) CHECK(QTY>0),
    COST NUMBER(20) CHECK(COST>0)
);
-- MEMBER
INSERT INTO MEMBER (mID, mNAME, mADDR, mTEL, mEMAIL)
    VALUES ('abc', 'ȫ�浿', '���� ���빮�� ������', '010-9999-9999', 'hong@hong.com');
INSERT INTO MEMBER (mID, mNAME, mADDR, mTEL, mEMAIL)
    VALUES ('def', '��赿', '��⵵ ������', '010-8888-8888', 'KIM@KIM.COM');
    
-- PRODUCT
INSERT INTO PRODUCT (pCODE, pNAME, PRICE, STOCK)
    VALUES ('A1', '����', 3000, 200);
INSERT INTO PRODUCT VALUES ('A2', '����ũ', 200, 500);
INSERT INTO PRODUCT VALUES ('B1', '����', 3000, 200);
INSERT INTO PRODUCT VALUES ('B2', '��¡��', 5000, 200);
INSERT INTO PRODUCT VALUES ('C1', '�ҵ���', 7000, 200);

-- CART
INSERT INTO CART (cNO, mID, pCODE, QTY, COST) 
    VALUES (CART_cNO_SQ.NEXTVAL, 'abc', 'A1', 3, 9000); 
INSERT INTO CART (cNO, mID, pCODE, QTY, COST) 
    VALUES (CART_cNO_SQ.NEXTVAL, 'abc', 'B1', 1, 3000);


-- ORDERS
INSERT INTO ORDERS (oNO, oNAME, oADDR, oTEL, mID)
    VALUES (TO_CHAR(SYSDATE, 'RRMMDD') || TRIM(TO_CHAR(ORDERS_oNO_SQ.NEXTVAL, '000')),
            'ȫ�浿', '����� ���빮�� ������', '010-9999-9999', 'abc');
            
    
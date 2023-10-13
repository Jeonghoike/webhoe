SELECT * FROM CUSTOMER;
-- 회원가입시 ID중복체크 : public int confirmID(String id)
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


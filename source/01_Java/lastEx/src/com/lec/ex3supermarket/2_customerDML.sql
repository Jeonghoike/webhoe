-- 프로그램에 필요한 QUERY
-- 1. 회원가입(고객전화와 고객이름은 입력받아 INSERT)
    -- public int insertCustomer (String ctel, String cname)
    -- public int insertCustomer (CustomerDto dto)
INSERT INTO CUSTOMER (CID, CTEL, CNAME)
    VALUES (CUSTOMER_CID_SEQ.NEXTVAL, '010-6666-6666', '유길동');
ROLLBACK;


-- 2. 폰뒤4자리(풀번호) 검색 (searchTel를 받아 CID, CTEL, CNAME, CAMOUNT, LEVELNAME, forLEVELUp)
    --public ArrayList<CustomerDto> ctelGetCustomers(String searchTel)
SELECT CID, CTEL, CNAME, CPOINT, CAMOUNT, LEVELNAME, HIGH+1-CAMOUNT forLevelUp
    FROM CUSTOMER C, CUS_LEVEL L 
    WHERE C.LEVELNO=L.LEVELNO; -- 최고레벨 경우는 잘못 나와
    
SELECT CID, CTEL, CNAME, CPOINT, CAMOUNT, LEVELNAME,
        (SELECT HIGH+1-CAMOUNT FROM CUSTOMER WHERE LEVELNO!=5 AND CID=C.CID) forLevelUp
    FROM CUSTOMER C, CUS_LEVEL L
    WHERE C.LEVELNO=L.LEVELNO AND CTEL LIKE '%'||'9999'
    ORDER BY CAMOUNT DESC, CID; -- DAO에 들어갈 QUERY
    
-- 3. 물품구매
    -- (CID, PRICE를 받아, 구매액의 5%를 CPOINTM 누적, 구매액을 CAMOUNT에 따라 LEVELNO 수정)
    -- public int buy(int cid, int price)
    -- 1단계 : CPOINT와 CAMOUNT 누적
    UPDATE CUSTOMER
        SET CPOINT = CPOINT + (1000000*0.05), 
            CAMOUNT = CAMOUNT + 1000000
        WHERE CID=1;
    SELECT * FROM CUSTOMER;
    -- 2단계 : 바뀐 CAMOUNT에 따라 LEVELNO 조정
    SELECT CNAME, CAMOUNT, C.LEVELNO 현재레벨, L.LEVELNO 바뀔레벨, LOW, HIGH
        FROM CUSTOMER C, CUS_LEVEL L
        WHERE CAMOUNT BETWEEN LOW AND HIGH AND CID=1;
    SELECT L.LEVELNO
        FROM CUSTOMER C, CUS_LEVEL L
        WHERE CAMOUNT BETWEEN LOW AND HIGH AND CID=1; -- UPDATE안의 SUBQUERY로 들어갈 부분
    
    UPDATE CUSTOMER
        SET LEVELNO = (SELECT L.LEVELNO
                        FROM CUSTOMER C, CUS_LEVEL L
                        WHERE CAMOUNT BETWEEN LOW AND HIGH AND CID=1)
        WHERE CID=1;
    SELECT * FROM CUSTOMER WHERE CID=1;
    ROLLBACK;
    -- DAO에 들어갈 QUERY (1단계 + 2단계)
    UPDATE CUSTOMER 
        SET CPOINT = CPOINT + (1000000*0.05),
            CAMOUNT = CAMOUNT + 1000000,
            LEVELNO = (SELECT L.LEVELNO
                            FROM CUSTOMER C, CUS_LEVEL L
                            WHERE CAMOUNT + 1000000 BETWEEN LOW AND HIGH AND CID =1)
        WHERE CID=1;
    SELECT * FROM CUSTOMER WHERE CID=1;
-- 3번 물품구매 후 고객정보를 출력(CID, CTEL, CNAME, CPOINT, CAMOUNT, LEVELNAME, forLevelUp)
    -- public CustomerDto getCustomer(int cid)
    SELECT CID, CTEL, CNAME, CPOINT, CAMOUNT, LEVELNAME,
            (SELECT HIGH+1-CAMOUNT FROM CUSTOMER WHERE LEVELNO!=5 AND CID=C.CID) forLevelUp
        FROM CUSTOMER C, CUS_LEVEL L
        WHERE C.LEVELNO=L.LEVELNO AND CID=1;

-- 4번 전 고객등급별 추출
    -- public ArrayList<String> getLevelnames()
SELECT LEVELNAME FROM CUS_LEVEL;
-- 4번 고객등급별(등급이름) 출력 : levelName 입력받아 CID, CTEL, CNAME, CPOINT, CAMOUNT, LEVELNAME, forLevelUp
    -- public ArrayList<CustomerDto> levelNameGetCustomers(String levelName)
SELECT CID, CTEL, CNAME, CPOINT, CAMOUNT, LEVELNAME,
    (SELECT HIGH+1-CAMOUNT FROM CUSTOMER WHERE LEVELNO!=5 AND CID=C.CID) forLevelUp
    FROM CUSTOMER C, CUS_LEVEL L 
    WHERE C.LEVELNO=L.LEVELNO AND LEVELNAME = UPPER('silver')
    ORDER BY CAMOUNT DESC, CID;
    
-- 5번 고객 전체 출력 : levelName 입력받아 CID, CTEL, CNAME, CPOINT, CAMOUNT, LEVELNAME, forLevelUp
    -- public ArrayList<CustomerDto> GetCustomers()
SELECT CID, CTEL, CNAME, CPOINT, CAMOUNT, LEVELNAME,
    (SELECT HIGH+1-CAMOUNT FROM CUSTOMER WHERE LEVELNO!=5 AND CID=C.CID) forLevelUp
    FROM CUSTOMER C, CUS_LEVEL L 
    WHERE C.LEVELNO=L.LEVELNO 
    ORDER BY CAMOUNT DESC, CID;
    
-- 6번 회원탈퇴 : ctel 받아 delete
    -- public int deleteCustomer(String ctel)
DELETE FROM CUSTOMER WHERE CTEL = '010-6666-6666';
COMMIT;
SELECT * FROM CUSTOMER;
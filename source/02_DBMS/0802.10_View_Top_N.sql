-- [X] View, In-Line View, ★TOP-N★
DROP TABLE EMP1;
CREATE TABLE EMP1 AS SELECT EMPNO, ENAME, JOB, MGR, HIREDATE, DEPTNO FROM EMP;
SELECT * FROM EMP1; -- 타부서에서 권한을 줄 테이블(타부서에서는 검색, 추가, 삭제, 수정)
SELECT * FROM USER_TABLES WHERE TABLE_NAME LIKE 'EMP%';
INSERT INTO EMP1 (EMPNO, ENAME, DEPTNO) VALUES (1111, '홍', 30);
SELECT * FROM EMP1; -- 홍 검색
SELECT * FROM EMP; 
DROP TABLE EMP1;
-- 1. VIEW : 가상의 테이블 (1)단순뷰 (2)복합뷰 
-- (1)단순뷰 : 하나의 테이블을 이용해서 만든 뷰(가상의 테이블 : 물리적인 저장공간과 데이터가 따로 없음)
CREATE OR REPLACE VIEW EMPv0 
    AS SELECT EMPNO, ENAME, JOB, MGR, HIREDATE, DEPTNO FROM EMP; -- EMP 테이블에서 특정 필드만 VIEW로 생성
SELECT * FROM EMPv0;
SELECT * FROM EMP;
SELECT * FROM USER_TABLES WHERE TABLE_NAME LIKE 'EMP%';
SELECT * FROM USER_VIEWS;
INSERT INTO EMPv0 VALUES (1111, '홍', 'MANAGER', NULL, SYSDATE, 40); -- 뷰에 INSERT
ROLLBACK;

CREATE OR REPLACE VIEW EMPv0
    AS SELECT * FROM EMP WHERE DEPTNO=30; -- EMP 테이블에서 특정 행(ROW)만 뷰로 생성
SELECT * FROM EMPv0;
INSERT INTO EMPv0 VALUES (1111, '홍', 'MANAGER', NULL, SYSDATE, NULL, NULL,30);
SELECT * FROM EMPv0;
SELECT * FROM EMP;
SELECT * FROM EMP WHERE EMPNO<2000;
INSERT INTO EMPv0 (EMPNO, ENAME, DEPTNO) VALUES (1112, '박', 40); -- VIEW에 40번 부서 직원 입력
SELECT * FROM EMPv0; -- 입력한 1112는 보이지 않음
SELECT * FROM EMP WHERE EMPNO<2000;

-- VIEW의 제한조건
    -- WITH CHECK OPTION 추가 : 뷰의 조건에 해당되는 데이터만 삽입, 수정, 삭제
    -- WITH READ ONLY 추가 : 읽기 전용 뷰
    
CREATE OR REPLACE VIEW EMPv0
    AS SELECT * FROM EMP WHERE DEPTNO=30
    WITH CHECK OPTION;
INSERT INTO EMPv0 (EMPNO, ENAME, DEPTNO) VALUES (1113, '이', 30);
INSERT INTO EMPv0 (EMPNO, ENAME, DEPTNO) VALUES (1114, '이', 40); -- 제한조건에 의해 오류
DELETE FROM  EMPv0 WHERE DEPTNO=20; -- 지워지지 않음
SELECT * FROM EMP;

-- 읽기전용 뷰(WITH READ ONLY 추가, WITH READ ONLY추가하지 않은 경우)
CREATE OR REPLACE VIEW EMPv0
    AS SELECT * FROM EMP
    WITH READ ONLY;
SELECT * FROM EMPv0;
DELETE FROM EMPv0 WHERE EMPNO<2000; -- 읽기 전용뷰라서 오류
DELETE FROM EMP WHERE EMPNO<2000;
COMMIT;

CREATE OR REPLACE VIEW EMPv0 -- 단순뷰에서도 INSERT 불가한 경우 : 뷰생성시 NOT NULL필드가 미포함된 경우
    AS SELECT ENAME, JOB FROM EMP;
SELECT * FROM EMPv0;
INSERT INTO EMPv0 VALUES ('홍길', 'MANAGER'); -- EMP테이블의 EMPNO(PK)는 NOT NULL이라서 오류

-- (2) 복합뷰 : 2개 이상의 테이블로 구성한 뷰, 1개의 테이블로 가상의 필드를 이용한 뷰, DML문을 제한적으로 사용
-- ① 2개 이상의 테이블로 구성한 뷰
CREATE OR REPLACE VIEW EMPv0
    AS SELECT EMPNO, ENAME, JOB, DNAME FROM EMP E, DEPT D WHERE E.DEPTNO=D.DEPTNO;
SELECT * FROM EMPv0;
INSERT INTO EMPv0 VALUES (1111, '홍', 'MANAGER', 'XXX'); -- 복합뷰에서는 SELECT만 사용

-- ② 1개의 테이블로 가상의 필드를 이용한 뷰(컬럼에 별칭을 사용)
CREATE OR REPLACE VIEW EMPv0
    AS SELECT EMPNO, ENAME, SAL, SAL*12 YEAR_SAL FROM EMP;
INSERT INTO EMPv0 VALUES (1111, '홍', 100, 1200); -- 복합뷰에서는 SELECT만 사용

CREATE OR REPLACE VIEW EMPv0 (EMPNO, ENAME, SAL, YEAR_SAL) -- 별칭만 따로
    AS SELECT EMPNO, ENAME, SAL, SAL*12 FROM EMP;
SELECT * FROM EMPv0;

CREATE OR REPLACE VIEW EMPv0 (DEPTNO, AVG)
    AS SELECT DEPTNO, ROUND(AVG(SAL)) FROM EMP GROUP BY DEPTNO;
    
-- 2. INLINE-VIEW : FROM절의 서브쿼리를 INLINE VIEW라 하며, FROM절에 오는 서브쿼리는 VIEW처럼 작용
    -- ex. 급여가 2000을 초과하는 사원의 쳥균 급여
    SELECT AVG(SAL) FROM EMP WHERE SAL>2000;
    SELECT AVG(SAL) FROM (SELECT SAL FROM EMP WHERE SAL>2000);
    -- ex. 부서 평균 급여보다 급여가 높은 사원의 사번, 이름, 급여, 부서번호, 해당부서의 평균급여(반올림)을 출력
    SELECT EMPNO, ENAME, SAL, DEPTNO FROM EMP; -- ⓐ
    SELECT DEPTNO, AVG(SAL) AVGSAL FROM EMP GROUP BY DEPTNO; -- ⓑ
    -- ⓐ와 ⓑ EQUI JOIN
    SELECT EMPNO, ENAME, SAL, A.DEPTNO, ROUND(AVGSAL)
        FROM EMP A, (SELECT DEPTNO, AVG(SAL) AVGSAL FROM EMP GROUP BY DEPTNO) B
        WHERE A.DEPTNO=B.DEPTNO AND SAL>AVGSAL;
        
-- 3. TOP-N구문 (TOP 1~10등, 11~20등, ...) 
    -- ROWNUM(테이블로부터 가져온 순서)과 INLINE-VIEW를 이용한 TOP-N구문
    SELECT ROWNUM, EMPNO, ENAME FROM EMP; -- SCOTT(7788)의 ROWNUM이 8
    SELECT ROWNUM, EMPNO ,ENAME FROM EMP WHERE DEPTNO=20; -- SCOTT(7788)의 ROWNM이 3
    
SELECT ROWNUM, ENAME, SAL FROM EMP;
SELECT ROWNUM, ENAME, SAL -- 2
    FROM EMP -- 1
    ORDER BY SAL; -- 3
-- 1등 ~ 꼴찌 등수, 이름, 급여
SELECT ROWNUM RN, ENAME, SAL
    FROM (SELECT ENAME, SAL FROM EMP ORDER BY SAL);
    
-- SAL을 기준으로 1등~5등
SELECT ROWNUM, ENAME, SAL
    FROM (SELECT * FROM EMP ORDER BY SAL)
    WHERE ROWNUM BETWEEN 1 AND 5;
-- SAL을 기준으로 6등~10등
SELECT ROWNUM, ENAME, SAL
    FROM (SELECT ENAME, SAL FROM EMP ORDER BY SAL)
    WHERE ROWNUM BETWEEN 6 AND 10;
    
-- TOP-N
SELECT ENAME, SAL FROM EMP ORDER BY SAL; -- 1단계
SELECT ROWNUM RN, ENAME, SAL
    FROM (SELECT ENAME, SAL FROM EMP ORDER BY SAL); -- 2단계
SELECT ROWNUM RN, ENAME, SAL
    FROM (SELECT ROWNUM RN, ENAME, SAL
            FROM (SELECT ENAME, SAL FROM EMP ORDER BY SAL))
    WHERE RN BETWEEN 6 AND 10; -- 3단계
    
-- ex. 이름순(abc순)으로 6번째 부터 10번쨰까지 사원의 모든 정보 출력
SELECT * FROM EMP ORDER BY ENAME; -- 1단계
SELECT ROWNUM RN, A.*
    FROM(SELECT * FROM EMP ORDER BY ENAME) A; -- 2단계 : 1등~꼴찌
SELECT *
    FROM (SELECT ROWNUM RN, A.*
            FROM(SELECT * FROM EMP ORDER BY ENAME) A)
    WHERE RN BETWEEN 6 AND 10; -- 3단계 : TOP-N


-- ★ ★ ★ <총 연습문제> ★ ★ ★

-- 1. 부서명과 사원명을 출력하는 용도의 뷰, DNAME_ENAME_VU 를 작성하시오
CREATE OR REPLACE VIEW DNAME_ENAME_VU
    AS SELECT DNAME, E.ENAME 
        FROM EMP E, DEPT D
    WHERE E.DEPTNO=D.DEPTNO;
SELECT * FROM DNAME_ENAME_VU;

-- 2. 사원명과 직속상관명을 출력하는 용도의 뷰,  WORKER_MANAGER_VU를 작성하시오
CREATE OR REPLACE VIEW WORKER_MANAGER_VU (WORKER, MANAGER)
    AS SELECT W.ENAME, M.ENAME
        FROM EMP W, EMP M
        WHERE W.MGR=M.EMPNO;
SELECT * FROM WORKER_MANAGER_VU;

-- 3. 부서별 급여합계 등수를 출력하시오(부서번호, 급여합계, 등수). -- 학생 질문
SELECT ROWNUM RANK, DEPTNO, SUM
    FROM (SELECT DEPTNO, SUM(SAL) SUM FROM EMP GROUP BY DEPTNO ORDER BY SUM DESC);
    

-- 3-1. 부서별 급여합계 등수가 2~3등인 부서번호, 급여합계, 등수를 출력하시오.
SELECT *
    FROM (SELECT ROWNUM RN, DEPTNO, SUM
            FROM (SELECT DEPTNO, SUM(SAL) SUM FROM EMP GROUP BY DEPTNO ORDER BY SUM))
    WHERE RN BETWEEN 2 AND 3;

-- 4. 사원테이블에서 사번, 사원명, 입사일을 입사일이 최신에서 오래된 사원 순으로 정렬하시오
SELECT EMPNO, ENAME, HIREDATE FROM EMP ORDER BY HIREDATE DESC;

-- 5. 사원테이블에서 사번, 사원명, 입사일을 입사일이 최신에서 오래된 사원 5명을 출력하시오
SELECT ROWNUM, A.*  
    FROM (SELECT EMPNO, ENAME, HIREDATE
            FROM EMP ORDER BY HIREDATE DESC) A
    WHERE ROWNUM<=5;

-- 6. 사원 테이블에서 사번, 사원명, 입사일을 최신부터 오래된 순으로 6번째로 늦은 사원부터 10번째 사원까지 출력
SELECT *
    FROM (SELECT ROWNUM RN, A.*
            FROM (SELECT EMPNO, ENAME, HIREDATE FROM EMP ORDER BY HIREDATE DESC) A)
    WHERE RN BETWEEN 6 AND 10; 
    

   

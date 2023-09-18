-- ex1
SELECT * FROM EMP; -- 실행할 sql을 블럭 잡고 alt + x
-- ex2와 ex3
SELECT * FROM DEPT;
-- 입력받은 파라미터 값의 직원을 출력 (10->10번부서 직원/ 0->모든부서직원)
SELECT * FROM EMP WHERE DEPTNO LIKE '%'||'0';
-- ex3
SELECT E.*, DNAME
    FROM EMP E, DEPT D 
    WHERE E.DEPTNO=D.DEPTNO AND E.DEPTNO LIKE '%'||'10';

DELETE FROM DEPT WHERE DEPTNO > 40;

-- example
SELECT E.*, DNAME 
    FROM EMP E, DEPT D
    WHERE E.DEPTNO=D.DEPTNO AND E.ENAME LIKE '%'||TRIM(UPPER('   s   '))||'%';
    
    
    

    
    

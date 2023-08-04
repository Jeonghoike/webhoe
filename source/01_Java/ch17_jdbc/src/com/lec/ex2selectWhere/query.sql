-- Ex1. 사용자로부터 부서번호 받아 부서정보 출력
SELECT * FROM DEPT WHERE DEPTNO=40;


-- Ex2. 부서정보, (사번, 이름, 급여, 상사이름)출력
SELECT * FROM DEPT WHERE DEPTNO=40;
SELECT W.EMPNO, W.ENAME, W.SAL, NVL(M.ENAME, ' ') MANAGER
    FROM EMP W, EMP M
    WHERE W.MGR=M.EMPNO(+) AND W.DEPTNO=10;
    
    
-- Ex3. 사용자로부터 부서명을 받아 부서정보 출력
SELECT * FROM DEPT WHERE DNAME =upper('ACCOUNTING'); -- upper 대문자로 바꿔줌
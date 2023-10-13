-- EmpDao에 들어갈 query
INSERT INTO EMP VALUES (9000, 'HONG', 'CLERK',7902, SYSDATE, 9000, 1000, 40);
COMMIT;
-- 전체 리스트 : public ArrayList<EmpDto> getListEmp()
SELECT * FROM EMP;
-- 이름과 job으로 검색한 리스트 : public ArrayList<EmpDto> getListEmp(String schName, String schJob)
SELECT * FROM EMP
  WHERE ENAME LIKE '%'||TRIM(UPPER('  h '))||'%'
    AND JOB LIKE '%'||UPPER(TRIM('  c  '))||'%';
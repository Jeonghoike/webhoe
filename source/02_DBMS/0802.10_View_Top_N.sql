-- [X] View, In-Line View, ��TOP-N��
DROP TABLE EMP1;
CREATE TABLE EMP1 AS SELECT EMPNO, ENAME, JOB, MGR, HIREDATE, DEPTNO FROM EMP;
SELECT * FROM EMP1; -- Ÿ�μ����� ������ �� ���̺�(Ÿ�μ������� �˻�, �߰�, ����, ����)
SELECT * FROM USER_TABLES WHERE TABLE_NAME LIKE 'EMP%';
INSERT INTO EMP1 (EMPNO, ENAME, DEPTNO) VALUES (1111, 'ȫ', 30);
SELECT * FROM EMP1; -- ȫ �˻�
SELECT * FROM EMP; 
DROP TABLE EMP1;
-- 1. VIEW : ������ ���̺� (1)�ܼ��� (2)���պ� 
-- (1)�ܼ��� : �ϳ��� ���̺��� �̿��ؼ� ���� ��(������ ���̺� : �������� ��������� �����Ͱ� ���� ����)
CREATE OR REPLACE VIEW EMPv0 
    AS SELECT EMPNO, ENAME, JOB, MGR, HIREDATE, DEPTNO FROM EMP; -- EMP ���̺����� Ư�� �ʵ常 VIEW�� ����
SELECT * FROM EMPv0;
SELECT * FROM EMP;
SELECT * FROM USER_TABLES WHERE TABLE_NAME LIKE 'EMP%';
SELECT * FROM USER_VIEWS;
INSERT INTO EMPv0 VALUES (1111, 'ȫ', 'MANAGER', NULL, SYSDATE, 40); -- �信 INSERT
ROLLBACK;

CREATE OR REPLACE VIEW EMPv0
    AS SELECT * FROM EMP WHERE DEPTNO=30; -- EMP ���̺����� Ư�� ��(ROW)�� ��� ����
SELECT * FROM EMPv0;
INSERT INTO EMPv0 VALUES (1111, 'ȫ', 'MANAGER', NULL, SYSDATE, NULL, NULL,30);
SELECT * FROM EMPv0;
SELECT * FROM EMP;
SELECT * FROM EMP WHERE EMPNO<2000;
INSERT INTO EMPv0 (EMPNO, ENAME, DEPTNO) VALUES (1112, '��', 40); -- VIEW�� 40�� �μ� ���� �Է�
SELECT * FROM EMPv0; -- �Է��� 1112�� ������ ����
SELECT * FROM EMP WHERE EMPNO<2000;

-- VIEW�� ��������
    -- WITH CHECK OPTION �߰� : ���� ���ǿ� �ش�Ǵ� �����͸� ����, ����, ����
    -- WITH READ ONLY �߰� : �б� ���� ��
    
CREATE OR REPLACE VIEW EMPv0
    AS SELECT * FROM EMP WHERE DEPTNO=30
    WITH CHECK OPTION;
INSERT INTO EMPv0 (EMPNO, ENAME, DEPTNO) VALUES (1113, '��', 30);
INSERT INTO EMPv0 (EMPNO, ENAME, DEPTNO) VALUES (1114, '��', 40); -- �������ǿ� ���� ����
DELETE FROM  EMPv0 WHERE DEPTNO=20; -- �������� ����
SELECT * FROM EMP;

-- �б����� ��(WITH READ ONLY �߰�, WITH READ ONLY�߰����� ���� ���)
CREATE OR REPLACE VIEW EMPv0
    AS SELECT * FROM EMP
    WITH READ ONLY;
SELECT * FROM EMPv0;
DELETE FROM EMPv0 WHERE EMPNO<2000; -- �б� ������ ����
DELETE FROM EMP WHERE EMPNO<2000;
COMMIT;

CREATE OR REPLACE VIEW EMPv0 -- �ܼ��信���� INSERT �Ұ��� ��� : ������� NOT NULL�ʵ尡 �����Ե� ���
    AS SELECT ENAME, JOB FROM EMP;
SELECT * FROM EMPv0;
INSERT INTO EMPv0 VALUES ('ȫ��', 'MANAGER'); -- EMP���̺��� EMPNO(PK)�� NOT NULL�̶� ����

-- (2) ���պ� : 2�� �̻��� ���̺��� ������ ��, 1���� ���̺��� ������ �ʵ带 �̿��� ��, DML���� ���������� ���
-- �� 2�� �̻��� ���̺��� ������ ��
CREATE OR REPLACE VIEW EMPv0
    AS SELECT EMPNO, ENAME, JOB, DNAME FROM EMP E, DEPT D WHERE E.DEPTNO=D.DEPTNO;
SELECT * FROM EMPv0;
INSERT INTO EMPv0 VALUES (1111, 'ȫ', 'MANAGER', 'XXX'); -- ���պ信���� SELECT�� ���

-- �� 1���� ���̺��� ������ �ʵ带 �̿��� ��(�÷��� ��Ī�� ���)
CREATE OR REPLACE VIEW EMPv0
    AS SELECT EMPNO, ENAME, SAL, SAL*12 YEAR_SAL FROM EMP;
INSERT INTO EMPv0 VALUES (1111, 'ȫ', 100, 1200); -- ���պ信���� SELECT�� ���

CREATE OR REPLACE VIEW EMPv0 (EMPNO, ENAME, SAL, YEAR_SAL) -- ��Ī�� ����
    AS SELECT EMPNO, ENAME, SAL, SAL*12 FROM EMP;
SELECT * FROM EMPv0;

CREATE OR REPLACE VIEW EMPv0 (DEPTNO, AVG)
    AS SELECT DEPTNO, ROUND(AVG(SAL)) FROM EMP GROUP BY DEPTNO;
    
-- 2. INLINE-VIEW : FROM���� ���������� INLINE VIEW�� �ϸ�, FROM���� ���� ���������� VIEWó�� �ۿ�
    -- ex. �޿��� 2000�� �ʰ��ϴ� ����� ���� �޿�
    SELECT AVG(SAL) FROM EMP WHERE SAL>2000;
    SELECT AVG(SAL) FROM (SELECT SAL FROM EMP WHERE SAL>2000);
    -- ex. �μ� ��� �޿����� �޿��� ���� ����� ���, �̸�, �޿�, �μ���ȣ, �ش�μ��� ��ձ޿�(�ݿø�)�� ���
    SELECT EMPNO, ENAME, SAL, DEPTNO FROM EMP; -- ��
    SELECT DEPTNO, AVG(SAL) AVGSAL FROM EMP GROUP BY DEPTNO; -- ��
    -- �Ϳ� �� EQUI JOIN
    SELECT EMPNO, ENAME, SAL, A.DEPTNO, ROUND(AVGSAL)
        FROM EMP A, (SELECT DEPTNO, AVG(SAL) AVGSAL FROM EMP GROUP BY DEPTNO) B
        WHERE A.DEPTNO=B.DEPTNO AND SAL>AVGSAL;
        
-- 3. TOP-N���� (TOP 1~10��, 11~20��, ...) 
    -- ROWNUM(���̺��κ��� ������ ����)�� INLINE-VIEW�� �̿��� TOP-N����
    SELECT ROWNUM, EMPNO, ENAME FROM EMP; -- SCOTT(7788)�� ROWNUM�� 8
    SELECT ROWNUM, EMPNO ,ENAME FROM EMP WHERE DEPTNO=20; -- SCOTT(7788)�� ROWNM�� 3
    
SELECT ROWNUM, ENAME, SAL FROM EMP;
SELECT ROWNUM, ENAME, SAL -- 2
    FROM EMP -- 1
    ORDER BY SAL; -- 3
-- 1�� ~ ���� ���, �̸�, �޿�
SELECT ROWNUM RN, ENAME, SAL
    FROM (SELECT ENAME, SAL FROM EMP ORDER BY SAL);
    
-- SAL�� �������� 1��~5��
SELECT ROWNUM, ENAME, SAL
    FROM (SELECT * FROM EMP ORDER BY SAL)
    WHERE ROWNUM BETWEEN 1 AND 5;
-- SAL�� �������� 6��~10��
SELECT ROWNUM, ENAME, SAL
    FROM (SELECT ENAME, SAL FROM EMP ORDER BY SAL)
    WHERE ROWNUM BETWEEN 6 AND 10;
    
-- TOP-N
SELECT ENAME, SAL FROM EMP ORDER BY SAL; -- 1�ܰ�
SELECT ROWNUM RN, ENAME, SAL
    FROM (SELECT ENAME, SAL FROM EMP ORDER BY SAL); -- 2�ܰ�
SELECT ROWNUM RN, ENAME, SAL
    FROM (SELECT ROWNUM RN, ENAME, SAL
            FROM (SELECT ENAME, SAL FROM EMP ORDER BY SAL))
    WHERE RN BETWEEN 6 AND 10; -- 3�ܰ�
    
-- ex. �̸���(abc��)���� 6��° ���� 10�������� ����� ��� ���� ���
SELECT * FROM EMP ORDER BY ENAME; -- 1�ܰ�
SELECT ROWNUM RN, A.*
    FROM(SELECT * FROM EMP ORDER BY ENAME) A; -- 2�ܰ� : 1��~����
SELECT *
    FROM (SELECT ROWNUM RN, A.*
            FROM(SELECT * FROM EMP ORDER BY ENAME) A)
    WHERE RN BETWEEN 6 AND 10; -- 3�ܰ� : TOP-N


-- �� �� �� <�� ��������> �� �� ��

-- 1. �μ����� ������� ����ϴ� �뵵�� ��, DNAME_ENAME_VU �� �ۼ��Ͻÿ�
CREATE OR REPLACE VIEW DNAME_ENAME_VU
    AS SELECT DNAME, E.ENAME 
        FROM EMP E, DEPT D
    WHERE E.DEPTNO=D.DEPTNO;
SELECT * FROM DNAME_ENAME_VU;

-- 2. ������� ���ӻ������ ����ϴ� �뵵�� ��,  WORKER_MANAGER_VU�� �ۼ��Ͻÿ�
CREATE OR REPLACE VIEW WORKER_MANAGER_VU (WORKER, MANAGER)
    AS SELECT W.ENAME, M.ENAME
        FROM EMP W, EMP M
        WHERE W.MGR=M.EMPNO;
SELECT * FROM WORKER_MANAGER_VU;

-- 3. �μ��� �޿��հ� ����� ����Ͻÿ�(�μ���ȣ, �޿��հ�, ���). -- �л� ����
SELECT ROWNUM RANK, DEPTNO, SUM
    FROM (SELECT DEPTNO, SUM(SAL) SUM FROM EMP GROUP BY DEPTNO ORDER BY SUM DESC);
    

-- 3-1. �μ��� �޿��հ� ����� 2~3���� �μ���ȣ, �޿��հ�, ����� ����Ͻÿ�.
SELECT *
    FROM (SELECT ROWNUM RN, DEPTNO, SUM
            FROM (SELECT DEPTNO, SUM(SAL) SUM FROM EMP GROUP BY DEPTNO ORDER BY SUM))
    WHERE RN BETWEEN 2 AND 3;

-- 4. ������̺����� ���, �����, �Ի����� �Ի����� �ֽſ��� ������ ��� ������ �����Ͻÿ�
SELECT EMPNO, ENAME, HIREDATE FROM EMP ORDER BY HIREDATE DESC;

-- 5. ������̺����� ���, �����, �Ի����� �Ի����� �ֽſ��� ������ ��� 5���� ����Ͻÿ�
SELECT ROWNUM, A.*  
    FROM (SELECT EMPNO, ENAME, HIREDATE
            FROM EMP ORDER BY HIREDATE DESC) A
    WHERE ROWNUM<=5;

-- 6. ��� ���̺����� ���, �����, �Ի����� �ֽź��� ������ ������ 6��°�� ���� ������� 10��° ������� ���
SELECT *
    FROM (SELECT ROWNUM RN, A.*
            FROM (SELECT EMPNO, ENAME, HIREDATE FROM EMP ORDER BY HIREDATE DESC) A)
    WHERE RN BETWEEN 6 AND 10; 
    

   
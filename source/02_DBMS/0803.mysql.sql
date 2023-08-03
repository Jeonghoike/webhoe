-- DCL(계정생성, 권한부여, 권한박탈, 계정삭제)
-- DDL(FK 제약조건, 시퀀스없음)
-- DML(outer join, and;&&, or:||, 일부단일함수, ROWNUM이 없어 TOP-N구문이 다름)
-- Java 시간에 쓸 데이터 넣고 연습해 보기
show databases; -- database 리스트

-- ★ ★ ★
create user scott identified by 'tiger'; -- 계정생성
grant all on *.* to scott; -- 권한부여
flush privileges;
revoke all on *.* from scott; -- 권한 박탈
drop user scott ;
-- 특정 데이터 베이스로 들어감
show databases; -- 데이터 베이스들 리스트
use world; -- world 데이터 베이스로 들어감
select database(); -- 현재 들어와 있는 데이터 베이스
show tables; -- 현재 데이터 베이스안의 테이블들
create database kimdb; -- 새로운 데이터 베이스 생성
use kimdb;
select database();
show tables; 

-- ★ ★ ★ DDL
create table emp(
	empno numeric(4) primary key,
    ename varchar(20) not null,
    nickname varchar(20) unique,
    sal numeric(7,2) check(sal>0),
    comm numeric(7,2) default 0
);
desc emp;
drop table if exists emp;
create table emp(
	empno numeric(4),
    ename varchar(20) not null,
    nickname varchar(20),
    sal numeric(7,2),
    comm numeric(7,2) default 0,
    primary key(empno),
    unique(nickname),
    check(sal>0)
);
insert into emp values (1111, '홍길동', '동해번쩍', 900, null);
insert into emp values (1112, '홍길동', '동해번쩍', 900, null); -- 에러(unique) 
select * from emp;

-- 08.03 수업 내용 
use kimdb;
select database();
-- MAJOR테이블 : mCode-PK학과번호(순차번호) / mName-학과명 / mOffice-학과사무실
-- STUDENT 테이블 : sNo-pk학번 / sName-이름 / score-성정 / mCode-FK학과번호
drop table if exists student;
drop table if exists major;
create table major(
	mCode int primary key auto_increment, -- auto_increment 필드의 경우 int 타입
    mName varchar(30) unique,
    mOffice varchar(30) not null
);
insert into major (mName, mOffice) values ('컴퓨터공학','202호'); -- 1번 학과
insert into major (mName, mOffice) values ('빅데이터','203호'); -- 2번 학과
insert into major (mName, mOffice) values ('중국어','402호'); -- 3번 학과
insert into major (mName, mOffice) values ('중국어','501호'); -- unique 오류
select * from major;
-- STUDENT 테이블 : sNo-PK학번 / sName-이름 / score-성정 / mCode-FK학과번호
drop table student;
create table student(
	sNo numeric(4) primary key,
    sName varchar(30) not null,
    score numeric(3) check(score>=0 && score<=100), -- && 대신 and 라고 사용가능
    mCode int,
    foreign key(mCode) references major(mCode) -- 제약조건 중 foreign key 제약조건은 반드시 아래에 명시
);
insert into student values (1000,'홍길동',-2,1);-- check 오류
insert into student values (1000,'홍길동',100,1);
insert into student values (1001,'신길동',90,3);
insert into student values (1002,'김길동',80,4); -- 오류 나지 않음 
select * from student;

-- 학번, 이름, 점수, 학과번호, 학과명, 학과사무실 (MySQL과 Oracle은 equi join, non equijoin, self join 방법은 동일)
select sNo, sName, score, s.mCode, mName, mOffice
	from student s, major m
    where s.mCode=m.mCode;
-- 학번, 이름, 점수, 학과번호, 학과명, 학과사무실 (학생이 없는 학과도 출력)
select sNo, sName, score, s.mCode, mName, mOffice
	from student s right outer join major m
    on s.mCode=m.mCode;
select ifnull(sNo,'-')  "sNo", if(sName is null,'-',sName) sName, ifnull(score,'-') score, m.mCode, mName, mOffice
	from major m left outer join student s
    on m.mCode=s.mCode;
    
-- ★ ★ ★ ★ ★ 자바(JDBC) 수업시간에 쓸 테이블 데이터 ★ ★ ★ ★ ★
drop table if exists personal; -- cf.emp
drop table if exists division; -- ef.dept

create table division(
	dno int, -- 부서번호
    dname varchar(20) not null, -- 부서명
    phone varchar(20) unique, -- 부서전화
    position varchar(20), -- 부서위치
    primary key(dno)
);
create table personal(
	pno int primary key,        -- 사번
    pname varchar(20) not null, -- 사원명
    job varchar(20) not null,   -- 직책
    manager int,                -- 상사의 사번
    startdate date,             -- 입사일 date는 날짜만 저장
    pay int,                    -- 급여
    bonus int,                  -- 상여
    dno int,                     -- 부서번호
    foreign key(dno) references division(dno) -- FK제약조건은 반드시 밑에 명시
);
select*from division;
select*from personal;

insert into division values (10,'finance','02-393-4321','서대문');
insert into division values (20,'research','02-555-5555','강남');
insert into division values (30,'sales','02-717-5555','마포');
insert into division values (40,'cs','031-444-4444','안양');

insert into personal values (1111,'smith','manager', 1001, '1990-12-17', 1000, null, 10);
insert into personal values (1112,'ally','salesman',1116,'1991-02-20',1600,500,30);
insert into personal values (1113,'word','salesman',1116,'1992-02-24',1450,300,30);
insert into personal values (1114,'james','manager',1001,'1990-04-12',3975,null,20);
insert into personal values (1001,'bill','president',null,'1989-01-10',7000,null,10);
insert into personal values (1116,'johnson','manager',1001,'1991-05-01',3550,null,30);
insert into personal values (1118,'martin','analyst',1111,'1991-09-09',3450,null,10);
insert into personal values (1121,'kim','clerk',1114,'1990-12-08',4000,null,20);
insert into personal values (1123,'lee','salesman',1116,'1991-09-23',1200,0,30);
insert into personal values (1226,'park','analyst',1111,'1990-01-03',2500,null,10);
select * from personal;
select count(*) cnt from personal;

-- ★ ★ ★ DML (outer join, and &&, or ||, 단일행함수, nvl함수 대신 ifnull사용) ★ ★ ★
use kimdb;
select database();

-- 1. 사번, 이름, 급여를 출력
select pno, pname, pay
	from personal;

-- 2. 급여가 2000~5000 사이 모든 직원의 모든 필드
select * 
	from personal
    where pay between 2000 and 5000;
    
-- 3. 부서번호가 10또는 20인 사원의 사번, 이름, 부서번호
select pno, pname, dno
	from personal
    where dno=10 || dno=20;

-- 4. 보너스가 null인 사원의 사번, 이름, 급여 급여 큰 순정렬
select pno, pname, pay
	from personal
    where bonus is null
    order by pay desc;

-- 5. 사번, 이름, 부서번호, 급여. 부서코드 순 정렬 같으면 PAY 큰순
select pno, pname, dno, pay
	from personal
    order by dno, pay desc;
    
-- 6. 사번, 이름, 부서명
select p.pno, p.pname, m.dname
	from personal p right outer join division m
    on p.dno=m.dno;
    
-- 7. 사번, 이름, 상사이름
select w.pno, w.pname, m.pname manager
	from personal w left outer join personal m
    on w.manager=m.pno;

-- 8. 사번, 이름, 상사이름(상사가 없는 사람도 출력하되 상사가 없는 경우 ★CEO★로 출력) – 우선
select w.pno, w.pname, ifnull(m.pname, '★CEO★') manager
	from personal w left outer join personal m
    on w.manager= m.pno;
select*from personal; 

-- 9. 이름이 s로 시작하는 사원 이름 (like 이용, substr함수이용, instr함수 이용등 다양하게 사용 가능)
select pname
	from personal
    where pname like 's%';
    
-- 10. 사번, 이름, 급여, 부서명, 상사이름
select w.pno, w.pname, w.pay, d.dname, m.pname manager
	from personal w, personal m, division d
    where w.dno=d.dno and w.manager=m.pno;
    
-- 11. 부서코드, 급여합계, 최대급여
select dno, sum(pay), max(pay)
	from personal
    group by dno;
select * from personal;    
    
-- 12. 부서명, 급여평균, 인원수
select dname, round(avg(pay)) avgpay, count(*)
	from personal w, division d
    where w.dno=d.dno
    group by dname;

-- 13. 부서코드, 급여합계, 인원수 인원수가 4명 이상인 부서만 출력
select w.dno, sum(pay), count(*)
	from personal w, division d
    where w.dno=d.dno
    group by dno
    having count(*)>=4;

-- 14. 사번, 이름, 급여 회사에서 제일 급여를 많이 받는 사람
select pno, pname, pay
	from personal
    where pay in (select max(pay) from personal);
    

-- 15. 회사 평균보다 급여를 많이 받는 사람 이름, 급여, 부서번호
select pname, pay, d.dno
	from personal a, (select dno, avg(pay) avgpay from personal group by dno) d
    where a.dno=d.dno and pay>avgpay;

-- 16. 회사 평균 급여보다 많이 받는 사원의 사번, 이름, 급여, 부서명을 출력(부서명순 정열 같으면 급여 큰순 정렬)
select pno, pname, pay, dname
	from personal a, (select dno, avg(pay) avgpay from personal group by dno) b, division d
    where a.dno=b.dno and a.dno=d.dno and pay>avgpay
    order by dname, pay desc;

-- 17. 자신이 속한 부서의 평균보다 많인 받는 사람의 이름, 급여, 부서번호, 반올림한 해당부서평균 (where절의 subQuery를 이용하거나 inline view를 이용)
select pname, pay, d.dno, round(avgpay)
	from personal a, (select dno, avg(pay) avgpay from personal group by dno) d
    where a.dno=d.dno and pay>avgpay;
    
-- 18. 입사가 가장 빠른 사람의 이름, 급여, 부서명
 select pname, pay, dname
	from personal w, division d
    where w.dno=d.dno and startdate = (select min(startdate) from personal);
    
-- 19. 이름, 급여, 해당부서평균(select절의 subQuery를 이용하거나 inline view를 이용)
select pname, pay, avgpay
	from personal a, (select dno, avg(pay) avgpay from personal group by dno) d
    where a.dno=d.dno;
    
-- 20. 이름, 급여, 부서명, 해당부서평균(select절의 subQuery를 이용하거나 inline view를 이용)
select pname, pay, dname, avgpay
	from personal p, division d, (select dno, avg(pay) avgpay from personal group by dno) b
    where p.dno=d.dno and p.dno=b.dno;
    
-- ★ Oracle에서의 단일행함수(컬럼함수)와 다른 부분
select curdate(); -- 현재 날짜
select * from personal;
insert into personal values (1000,'홍길동','manager',1001,curdate(),null,null,40);
select * from personal where pno =1000;
set sql_safe_updates=0;
delete from personal where pno=1000;

-- ex. '이름은 job이다'
select concat(pname,'은',job,'이다') msg from personal;
select round(35.5678,2); -- from절 없이도 실행 가능

-- 시스템으로부터 현재시점(datetime), 현재날짜(date), 현재시간(time)
select sysdate(),now(); -- 현재시점
select current_date(), curdate(); -- 현재 날짜
select current_time(), curtime(); -- 현재 시간

select year(sysdate()) year, month(now()) month, day(now()) day, hour(now()) hour,
		minute(now()) minute, second(now());
select monthname(now()); -- 달 이름
select dayname(startdate) from personal; -- 요일 (Tuesday, monday, ....)
select case weekday(now())
		when '0' then '월요일'
        when '1' then '화요일'
        when '2' then '수요일'
        when '3' then '목요일'
        when '4' then '금요일'
        when '5' then '토요일'
        when '6' then '일요일' end dayofweek;
        
-- date_format(날짜, 포맷) : 날짜->문자로 date_format(now(), '%Y/%m/%d')
-- date_format(문자, 포맷) : 문자->날짜로 date_format('2023-07-31', '%Y-%m-%d')
	-- 포맷 : %Y(년도 4자리 2023) %y(년도 2자리 23)
		  -- %m(01,02...) %c(1,2,3,...) %M(January)
          -- %d(01,02...) %e(1,2,3,4...) 
          -- %H(24시간) %h(12시간) %p(오전, 오후) %i(분) %s(초)
select date_format(now(),'%Y년 %c월 %e일 %p %h시 %i분') now;

-- format(숫자데이터, 소수점자리수) : 소수점자리수 까지 소수점이 출력되고, 세자리마다(,)
select pname, format (pay,2) from personal; -- 소수점2자리까지 오고, 세자리마다,

-- 이름, 급여, 급여가 3000이상인지 여부
select pname, pay, if(pay>=3000,'이상','이하') from personal;

-- ★ ★ ★ ★ ★ Top-N구문 ★ ★ ★ ★ ★
	-- limit n(1번째~n번째)
    -- limit n1, n2(n1번째부터 n2개. 첫번쨰 0번째)
select pname, pay from personal order by pay desc;
select pname, pay from personal order by pay desc limit 5; -- 1번째~5번째
select pname, pay from personal order by pay desc limit 5, 5; -- (=6번째~10번째)
select pname, pay from personal order by pay desc limit 0, 3; -- 1번째~3번째
select pname, pay from personal order by pay desc limit 3, 3; -- 4번째~6번째
select pname, pay from personal order by pay desc limit 6, 3; -- 7번째~9번쨰
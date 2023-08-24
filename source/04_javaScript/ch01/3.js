/* 변수 선언시 var(전역변수), let(지역변수), const(상수) */
let sum = 0;
for(var i=1 ; i<=10 ; i++){
    sum += i;
    console.log("i=" + i + "일 때까지 누적합은 " + sum);
}
console.log("for문 끝");
console.log("for문 수행 후 i값은 " + i);
console.log("1~10까지 누적합은 " + sum);
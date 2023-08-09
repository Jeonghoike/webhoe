/* 2.js : 동적인 부분(DB연결 안됨) = 자바스크립트(jQuery, react) 문법 */
var name = prompt("이름은 ?", "홍길동"); // 취소를 클립하면 'null' 리턴
if (name != "null" && name != "") {
    document.write(name + "반갑습니다<br>");
}
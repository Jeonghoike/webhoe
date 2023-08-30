let superObj = {name : '손웅정'};
// let subObj = {age : 32};
// subObj.__proto__ = superObj; // superObj의 name 속성이 subObj로 상속
let subObj = Object.create(superObj); // 객체끼리 상속
subObj.age = 32;

console.log('superObj.name', superObj.name);

console.log('subObj.name', subObj.name);
console.log('suvObj.__proto__.name : ', subObj.__proto__.name);
console.log('subObj.age : ', subObj.age);
debugger; // 브라우저에서 일시중지하면서 객체 상태를 모니터링
subObj.name = '손흥민';
console.log('subObj.name : ', subObj.name);
console.log('suvObj.__proto__.name : ', subObj.__proto__.name);
console.log('subObj.age : ', subObj.age);
debugger; // 일시 중지
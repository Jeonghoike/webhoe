"usr strict";
var memberArray = ['hong', 'park', 'kim'];
// var copyArray = [...memberArray]; // 객체의 깊은 복사
var copyArray = Array.from(memberArray); // 배열의 깊은복사
copyArray[0] = "홍길동"; copyArray[1] = '박길동'; copyArray[2] = '김길동';
console.group('memberArray for-loop');
for(let i=0 ; i<memberArray.length ; i++){
    console.log(i, '번째:', memberArray[i]);
}
console.groupEnd('memberArray for-loop');
console.group('copyArray for-loop');
for(let i=0 ; i<copyArray.length ; i++){
    console.log(i, '번째:', copyArray[i]);
}
console.groupEnd('copyArray for-loop');

var memberObject = {name : 'hong', age : 20};
// var copyObject = {...mamberObject}; // 객체의 깊은 복사
// var copyObject = Object.assign({}, memberObject); // 객체의 깊은 복사
var copyObject = Object.assign({id:1}, memberObject) // {id:1, name: 'hong', age:20}
copyObject.name = '홍길동'; copyObject['age'] = 30;
console.group('memberObject for-in문');
for(var key in  memberObject){
    console.log(key, ':', memberObject[key]);
}
console.groupEnd('memberObject for-in문');
console.group('copyObject for-in문');
for(var key in  copyObject){
    console.log(key, ':', copyObject[key]);
}
console.groupEnd('copyObject for-in문');
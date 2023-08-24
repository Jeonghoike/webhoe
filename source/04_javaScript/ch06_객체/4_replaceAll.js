// var str = '안녕00방가00좋은 수요일00내일은 목요일'; // oldStr(00) -> newStr(X) 교체
// console.log('원본 : ', str);
// var splitStr = str.split('00'); // ['안녕', '방가', '좋은 수요일', '내일은 목요일']
// console.log('분할된 str : ', splitStr);
// var joinStr = splitStr.join('X');
// console.log('join된 str : ', joinStr);
function replaceAll(str, oldStr, newStr){ // str안에 oldStr을 newStr로 교체한 문자 return
    // let splitStr = str.split(oldStr);
    // let joinResult = splitStr.join(newStr);
    // return joinResult;
    return str.split(oldStr).join(newStr);
}
var replaceStr = replaceAll('안녕xx방가xx잘가xx', 'xx', ', '); // 사용되면 안될 문자를 바꾸는데 유용
console.log(replaceStr);
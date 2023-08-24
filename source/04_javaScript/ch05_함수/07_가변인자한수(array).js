/* array함수 :
 *     매개변수 0개일 때 : length가 0인 배열을 return
 *     매개변수 1개일 때 : length가 매개변수만큼의 크기를 가지는 배열 return
 *     매개변수 2개 이상일 때는 매개변수로 배열을 생성하여 return
 */
var arr1 = array();
var arr2 = array(3);
var arr3 = array(273, 2, 'hello');
var arr4 = array(273, 2, 2, 4, 'hi');
console.log('arr1(빈배열) = ', arr1);
console.log('arr2 = ', arr2);
console.log('arr3 = ', arr3);
console.log('arr4 = ', arr4);

function array(){ // arguments 배열에 실행시의 매개변수 들어옴
  let result = [];
  if(arguments.length == 1){ // length가 arguments[0]인 배열 : array(4)
    for(let cnt=1 ; cnt<=arguments[0] ; cnt++){
      result.push(null);
    }
  }else if(arguments.length >= 2){ // arguments[0], arguments[1]....을 배열:array(1,2)
    // arguments는 시스템이 자동 생성한 배열 : 일반for, for-in문, forEach()불가
    for(let idx=0 ; idx<arguments.length ; idx++){
      result.push(arguments[idx]);
    }
  }
  return result;
}
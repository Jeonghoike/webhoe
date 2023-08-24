// 08_sumAll.js
const sumAll = function(){ // 익명함수
  var result=0;
  if(arguments.length==0){
    result = -999;
  }else{
    // for(let idx=0 ; idx<arguments.length ; idx++){
    //   result += arguments[idx];
    // }
    for(var idx in arguments){
      result += arguments[idx];
    }
  }
  return result;
}
console.log(sumAll());
console.log(sumAll(1));
console.log(sumAll(1,2,3,4,5));
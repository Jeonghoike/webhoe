function Person(name, first, second){ // 생성자함수는 대문자
    this.name = name;
    this.first = first;
    this.second = second;
}
Person.prototype.sum = function(){
    return this.first + this.second;
};
var kim = new Person('kim', 10, 10);
var lee = new Person('lee', 30, 40);
console.log(kim.name, ',', kim.first, ',', kim.second, ',', kim.sum());
console.log(lee.name, ',', lee.first, ',', lee.second, ',', lee.sum());
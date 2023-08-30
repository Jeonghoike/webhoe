class Person{
    constructor(name, first, second){ // 생성자 함수의 이름은 무조건 constructor
        this.name = name;
        this.first = first;
        this.second = second;
    }
    sum(){
        return this.first + this.second;
    }
}// class

class PersonPlus extends Person{
    constructor(name, first, second, third){
        super(name, first, second); // super() : 부모클래스 생성자 함수
        this.third = third;
    }
    sum(){
        return super.sum() + this.third; // super.sum : 부모클래스의 sum()
    }
    avg(){
        return this.sum()/3;
    }
}
var hong = new Person("홍길동", 100, 90);
console.log('hong의 sum : ' + hong.sum());
var son = new PersonPlus('손흥민', 100, 100, 100);
console.log('손 sum : ' + son.sum());
console.log('손 avg : ' + son.avg());
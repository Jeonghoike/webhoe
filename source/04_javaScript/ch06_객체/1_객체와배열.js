/*
class Person {
    private String name;
    private String age;
    public Person(String name, String age){
        this.name=name; this.age=age;
    }
    public void setName(String name){
        this.name = name;
    }
}
Person person = new Person("홍길동", 20);
person.setName = ("김길동");

*/
const arr = ['홍길동', 20]; // const arr = {0,:'홍길동', 1:20} 0번에는 홍길동 1번에는 20
arr[0];
const person = {name:'홍길동', age:20};
person.name = '김길동'; 
console.log(person.name, ' / ', person.age);
console.log(person['name'], ' / ' , person['age']);
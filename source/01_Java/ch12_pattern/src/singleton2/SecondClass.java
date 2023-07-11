package singleton2;

public class SecondClass {
	public SecondClass() {
		System.out.println("SecondClass 생성자 실행중★★★★★★★★★★★★★");
		SingletonClass singtonObject = SingletonClass.getInstance();
		System.out.println("싱클통 객체의 i값은" + singtonObject.getI());
		System.out.println("SecondClass 생성자 실행 끝★★★★★★★★★★★★★");
	}
}

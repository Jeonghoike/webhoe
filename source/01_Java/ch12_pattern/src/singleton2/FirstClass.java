package singleton2;

public class FirstClass {
	public FirstClass() {
		System.out.println("FirstClass 생성자 실행 중");
		SingletonClass singletonObject = SingletonClass.getInstance();
		System.out.println("상글톤 샛체의 i 값 :" + singletonObject.getI());
		singletonObject.setI(999);
		System.out.println("싱글톤 객체의 i 값(수정후) :" + singletonObject.getI());
		System.out.println("FirstClass 생성과 실행 끝----------------------");
	}
}

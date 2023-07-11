package singleton2;

public class TestMain {
	public static void main(String[] args) {
		FirstClass firstObj = new FirstClass();
		SecondClass secondObj = new SecondClass();
		SingletonClass singObj = SingletonClass.getInstance();
		System.out.println("mainÇÔ¼ö¿¡¼­ÀÇ ½ÌÅ¬Åæ °´Ã¼ i°ª :" + singObj.getI());
	}
}

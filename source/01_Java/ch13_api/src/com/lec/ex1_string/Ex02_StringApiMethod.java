package com.lec.ex1_string;

public class Ex02_StringApiMethod {
	public static void main(String[] args) {
		String str1 = "abcXabc";
		String str4 = new String("abcXabc");
		String str2 = "             Ja va            ";
		System.out.println("1." + str1.concat("AAA")); // 1.abcXabcAAA (문자열 연결)
		System.out.println("2." + str1.substring(3)); // 2. Xabc (3번째부터 끝까지 글자 추출)
		System.out.println("3." + str1.substring(3, 5)); // 3. Xa (3번째부터 5번째앞까지 추출)
		System.out.println("4." + str1.length()); // 4. 7 (문자열의 길이)
		System.out.println("5." + str1.toUpperCase()); // 5. ABCXABC (대문자로)
		System.out.println("6." + str1.toLowerCase()); // 6. abcxabc (소문자로)
		System.out.println("7." + str1.charAt(3)); // 7. X (3번째 글자)
		System.out.println("8." + str1.indexOf("b")); // 8. 1(처음 나오는 "b"문자의 인덱스)
		System.out.println("9." + str1.lastIndexOf("b")); // 9. 5(마지막에 나오는 "b"문자의 인덱스)
		System.out.println("10." + str1.indexOf("@")); // 10. -1 (없으면 -1, 있으면 문자의 인덱스)
		System.out.println("11." + str1.indexOf("Xabc")); // 11. 3 (처음나오는 "Xabc"시작 인덱스)
		String str3 = "abcXabcXabc";
		System.out.println("12." + str3.indexOf('b', 2)); // 12. 5 (2번째인덱스부터 처음나오는 'b'의 인덱스)
		System.out.println("13." + str3.indexOf("bc", 2)); // 13. 5 (2번째인덱스부터 처음나오는 "bc"의 인덱스)
		System.out.println("14." + str1.equals(str4)); // 14. true (같은 스트링이면 true, 아니면 false)
		System.out.println("15." + str1.equalsIgnoreCase("ABCXABC")); // 15. true(대소문자구분없이비교)
		System.out.println("16." + str2.trim()); // 16. Ja    va (앞뒤 space 제거)
		System.out.println("17." + str3.replace("abc", "바꿔")); // 17. 바꿔X바꿔X바꿔 (abc를 바꿔로 대체)
		System.out.println("str1 = " + str1);
		System.out.println("str2= " + str2);
		System.out.println("str3 = " + str3);
	}
}

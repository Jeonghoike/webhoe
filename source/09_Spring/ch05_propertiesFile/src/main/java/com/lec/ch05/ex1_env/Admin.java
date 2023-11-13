package com.lec.ch05.ex1_env;
import org.springframework.context.EnvironmentAware;
import org.springframework.core.env.Environment;
import lombok.Data;
@Data
public class Admin implements EnvironmentAware{
	private String adminId;
	private String adminPw;
	private Environment env;
	@Override
	public void setEnvironment(Environment environment) {
		System.out.println("빈 객체 생성하자마자 환경변수의 admin.id와 admin.pw가져오기");
		env = environment;
		adminId = env.getProperty("admin.id");
		adminPw = env.getProperty("admin.pw");
	}
}











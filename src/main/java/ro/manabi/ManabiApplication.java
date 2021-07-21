package ro.manabi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class ManabiApplication extends SpringBootServletInitializer{
//public class ManabiApplication extends SpringBootServletInitializer{

	public static void main(String[] args) {
		SpringApplication.run(ManabiApplication.class, args);
	}
	
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
		return builder.sources(ManabiApplication.class);
	}
}

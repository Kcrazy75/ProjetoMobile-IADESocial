package pt.iade.IADE_Social;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class IadeSocialApplication {

	public static void main(String[] args) {
		SpringApplication.run(IadeSocialApplication.class, args);
		System.out.println("\nServer is Running!\n");
	}
}
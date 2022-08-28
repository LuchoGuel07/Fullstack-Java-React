package net.projectjava.backendjava;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class BackendjavaApplication {

	public static void main(String[] args) {
		SpringApplication.run(BackendjavaApplication.class, args);
		System.out.println("Hola a todos");
	}

	

	/**
	 * Crea una nueva instancia de BCryptPasswordEncoder.
	 * 
	 * @return Una nueva instancia de BCryptPasswordEncoder.
	 */
	@Bean
	public BCryptPasswordEncoder bCryptPasswordEncoder() {
		return new BCryptPasswordEncoder();
	}


}

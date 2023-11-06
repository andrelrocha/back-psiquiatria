package jr.acens.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiApplication.class, args);

		String credentialsPath = "/src/main/resources/dbConfig/credentials.json";
		System.setProperty("GOOGLE_APPLICATION_CREDENTIALS", credentialsPath);
	}
}
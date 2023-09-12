package amacrel.it_training;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ItTrainingApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(ItTrainingApplication.class,args);
	}

	public void run(String[] args) throws Exception {
		System.out.println("Server Test Successfully Started");
	}

}

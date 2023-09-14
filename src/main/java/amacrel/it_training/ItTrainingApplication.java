package amacrel.it_training;

import amacrel.it_training.repository._UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ItTrainingApplication implements CommandLineRunner {
	 @Autowired
	_UserRepository _userRepository;

	public static void main(String[] args) {
		SpringApplication.run(ItTrainingApplication.class,args);
	}

	public void run(String[] args) throws Exception {
	}

}

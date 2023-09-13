package amacrel.it_training.entity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

    @Component
public class PwdGenerator {
    @Autowired
    PasswordEncoder passwordEncoder;

    public void main(String[] args) {
        System.out.println(this.passwordEncoder.encode("123456"));

    }
}

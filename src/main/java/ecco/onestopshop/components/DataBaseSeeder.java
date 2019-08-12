package ecco.onestopshop.components;

import ecco.onestopshop.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataBaseSeeder implements CommandLineRunner {

//    private UserRepository userRepository;
//
//    @Autowired
//    public DataBaseSeeder(UserRepository userRepository) {
//        this.userRepository = userRepository;
//    }

    @Override
    public void run(String... args) throws Exception {
//        userRepository.save(new User("w", "w", "w"));
    }
}

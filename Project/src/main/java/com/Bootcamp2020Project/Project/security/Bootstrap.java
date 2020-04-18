package com.Bootcamp2020Project.Project.security;


import com.Bootcamp2020Project.Project.Entities.User.Admin;
import com.Bootcamp2020Project.Project.Entities.User.Customer;
import com.Bootcamp2020Project.Project.Entities.User.Role;
import com.Bootcamp2020Project.Project.Entities.User.Seller;
import com.Bootcamp2020Project.Project.Repositories.RoleRepository;
import com.Bootcamp2020Project.Project.Repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class Bootstrap implements ApplicationRunner {

    @Autowired
    UserRepository userRepository;
    @Autowired
    RoleRepository roleRepository;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        if (userRepository.count() < 1) {
            PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
            Role admin = new Role(1L, "ROLE_ADMIN");
            Role seller = new Role(2L, "ROLE_SELLER");
            Role customer = new Role(3L, "ROLE_CUSTOMER");

            roleRepository.save(admin);
            roleRepository.save(seller);
            roleRepository.save(customer);

            Admin admin1 = new Admin("aman007sharma500@gmail.com", "Aman", "", "Sharma");
            admin1.setPassword(passwordEncoder.encode("pass"));

            admin1.addRole(admin);
            admin1.addRole(seller);
            admin1.setActive(true);

            Customer customer1 = new Customer("chiraggupta@gmai.com", "Chirag", "",
                    "Gupta","9876543210" );

            customer1.setPassword(passwordEncoder.encode("pass"));

            Seller seller1 = new Seller("shiryankkumar@gmail.com", "Shiryank", ""
                    , "Kumar", "25", "ToTheNew",
                    "12345678");

            seller1.setPassword(passwordEncoder.encode("pass"));
        userRepository.save(seller1);
        userRepository.save(admin1);
        userRepository.save(customer1);

            System.out.println("Total users saved::" + userRepository.count());

        }
    }
}

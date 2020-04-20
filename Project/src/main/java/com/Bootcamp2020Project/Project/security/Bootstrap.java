package com.Bootcamp2020Project.Project.security;
import com.Bootcamp2020Project.Project.Entities.User.*;
import com.Bootcamp2020Project.Project.Repositories.AddressRepository;
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
    @Autowired
    AddressRepository addressRepository;

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

            Admin admin1 = new Admin("amansharmawork@gmail.com", "Aman", "", "Sharma");
            admin1.setPassword(passwordEncoder.encode("pass"));

            admin1.addRole(admin);
            admin1.addRole(seller);
            admin1.addRole(customer);
            admin1.setActive(true);



            Customer customer1 = new Customer("customer1@gmai.com", "customer", "",
                    "1",987654322 );

            customer1.setPassword(passwordEncoder.encode("pass"));
            Customer customer2 = new Customer("customer2@gmai.com", "customer", "",
                    "2",9876522 );

            customer2.setPassword(passwordEncoder.encode("pass"));

            Seller seller1 = new Seller("seller1@gmail.com", "seller", ""
                    , "1", "25", "ToTheNew",
                    12345678l);
            seller1.setPassword(passwordEncoder.encode("pass"));

            Seller seller2 = new Seller("seller2@gmail.com", "seller", ""
                    , "2", "25", "ToTheNew",
                    123478l);


            seller2.setPassword(passwordEncoder.encode("pass"));
        userRepository.save(seller1);
        userRepository.save(admin1);
        userRepository.save(customer1);
            userRepository.save(seller2);
            userRepository.save(admin1);
            userRepository.save(customer2);

            Address address1 = new Address();
            address1.setCity("New Delhi");
            address1.setState("Delhi");
            address1.setZipCode("110092");
            address1.setCountry("India");
            address1.setLabel("Ground Floor");
            Address address2 = new Address();
            address2.setCity("Dwarka");
            address2.setState("Delhi");
            address2.setZipCode("110094");
            address2.setCountry("India");
            address2.setLabel("First Floor");
            Address address3 = new Address();
            address3.setCity("Rohini");
            address3.setState("Delhi");
            address3.setZipCode("110064");
            address3.setCountry("India");
            address3.setLabel("Ground Floor");
            address1.setCustomer(customer1);
            addressRepository.save(address1);
            addressRepository.save(address2);
            addressRepository.save(address3);
            address2.setCustomer(customer1);
            address3.setCustomer(customer2);
            Address address4=new Address();
            address4.setCity("New Delhi");
            address4.setState("Delhi");
            address4.setZipCode("110092");
            address4.setCountry("India");
            address4.setLabel("Ground Floor");
            address4.setSeller(seller1);
            addressRepository.save(address4);

            System.out.println("Total users saved::" + userRepository.count());

        }
    }
}

package com.Bootcamp2020Project.Project.Services;

import com.Bootcamp2020Project.Project.Dto.UserDto;
import com.Bootcamp2020Project.Project.Entities.User.Role;
import com.Bootcamp2020Project.Project.Entities.User.Users;
import com.Bootcamp2020Project.Project.Exceptions.ConfirmPasswordException;
import com.Bootcamp2020Project.Project.Exceptions.EmailAlreadyExistsException;
import com.Bootcamp2020Project.Project.Repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;
    PasswordEncoder passwordEncoder;
    @Autowired
    EmailService emailService;

public List<UserDto> getAllUsers() {

    List<Users> list = userRepository.getAllUsers();
    List<UserDto> list1=new ArrayList<UserDto>();
    for (Users user: list) {
        UserDto user1=new UserDto();
        user1.setId(user.getId());
        user1.setFirstName(user.getFirstName());
        user1.setMiddleName(user.getMiddleName());
        user1.setLastName(user.getLastName());
        user1.setEmail(user.getEmail());
        user1.setPassword(user.getPassword());
        user1.setActive(user.isActive());
        user1.setDeleted(user.getDeleted());

        list1.add(user1);
    }
    return list1;
}

    public void addUser(Users user) {
        System.out.println(user.getPassword());
        String password=user.getPassword();
        if (userRepository.findByUsername(user.getEmail())==null){
            String confirmPassword=user.getConfirmPassword();
            if(password.equals(confirmPassword)) {
                user.setPassword(passwordEncoder.encode(password));
                System.out.println(user.getPassword());
                user.addRole(new Role(1l,"ROLE_ADMIN"));
                userRepository.save(user);
            }
            else
                throw  new ConfirmPasswordException("Password & Confirm-Password doesn't match");
        }
        else
            throw new EmailAlreadyExistsException("Email "+user.getEmail()+" is already registered");
    }
    @Transactional
    public String activateUser(String email) {
        Users user= userRepository.findByUsername(email);
        userRepository.activateUser(user.getId());
        emailService.sendEmail("SUCCESSFULLY Registered", "Hii \n Your account have been activated," +
                " now you can logged in using http://localhost:8080/oauth/token",user.getEmail());
        return "User account has been activated";
    }

    public String deActivateUser(String email) {
        Users user= userRepository.findByUsername(email);
        userRepository.deActivateUser(user.getId());
        emailService.sendEmail("MALICIOUS ACTION FOUND", "Hii \n We have found some malicious action performed through account" +
                " As a result, your account has been temporarily de-activated.",user.getEmail());
        return "User account has been de-activated";
    }

}

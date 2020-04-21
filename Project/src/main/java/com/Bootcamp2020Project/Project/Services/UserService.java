package com.Bootcamp2020Project.Project.Services;

import com.Bootcamp2020Project.Project.Dto.UserDto;
import com.Bootcamp2020Project.Project.Entities.User.Users;
import com.Bootcamp2020Project.Project.Exceptions.ConfirmPasswordException;
import com.Bootcamp2020Project.Project.Exceptions.EmailAlreadyExistsException;
import com.Bootcamp2020Project.Project.Repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Component
public class UserService {

    @Autowired
    UserRepository userRepository;

    PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    @Autowired
    EmailService emailService;

    public List<UserDto> getAllUsers() {

        List<Users> list = userRepository.getAllUsers();
        List<UserDto> list1=new ArrayList<UserDto>();
        for (Users user: list) {
            UserDto userDto=new UserDto();
            userDto.setUserid(user.getId());
            userDto.setFirstname(user.getFirstName());
            userDto.setMiddlename(user.getMiddleName());
            userDto.setLastname(user.getLastName());
            userDto.setEmail(user.getEmail());
            userDto.setPassword(user.getPassword());
            userDto.setIs_active(user.isActive());
            userDto.setIs_deleted(user.getDeleted());

            list1.add(userDto);
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
        emailService.sendEmail("Account De-Activated", "Hii \n" +
                "Your account has been temporarily de-activated.",user.getEmail());
        return "User account has been de-activated";
    }
}

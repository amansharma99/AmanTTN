package com.Bootcamp2020Project.Project.Controller;

import com.Bootcamp2020Project.Project.Dto.PasswordDto;
import com.Bootcamp2020Project.Project.Dto.UserRegistrationDto;
import com.Bootcamp2020Project.Project.Entities.User.Users;
import com.Bootcamp2020Project.Project.Services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController

public class ForgetPasswordController
{

    @Autowired
    ForgotPasswordService forgotPasswordService;

    @PostMapping(path="/forgotpassword")
    public String forgotPassword(@RequestBody UserRegistrationDto user){
        return forgotPasswordService.forgotPassword(user.getEmail());
    }

    @PostMapping(path="resetpassword/{token}")
    public String resetPassword(@Valid @RequestBody PasswordDto passwordDto, @PathVariable String token){
        return forgotPasswordService.resetPassword(passwordDto,token);
    }
}

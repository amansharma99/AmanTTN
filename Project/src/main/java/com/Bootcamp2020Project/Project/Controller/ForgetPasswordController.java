package com.Bootcamp2020Project.Project.Controller;

import com.Bootcamp2020Project.Project.Dto.PasswordDto;
import com.Bootcamp2020Project.Project.Dto.UserDto;
import com.Bootcamp2020Project.Project.Services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
//Done
public class ForgetPasswordController
{

    @Autowired
    ForgotPasswordService forgotPasswordService;

    @PostMapping(path="/forgotpassword")
    public String forgotPassword(@RequestBody UserDto user){
        return forgotPasswordService.forgotPassword(user.getEmail());
    }

    @PostMapping(path="resetpassword/{token}")
    public String resetPassword(@Valid @RequestBody PasswordDto passwordDto, @PathVariable String token){
        return forgotPasswordService.resetPassword(passwordDto,token);
    }
}

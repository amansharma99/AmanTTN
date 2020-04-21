package com.Bootcamp2020Project.Project.Controller;

import com.Bootcamp2020Project.Project.Dto.UserDto;
import com.Bootcamp2020Project.Project.Entities.User.Users;
import com.Bootcamp2020Project.Project.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
public class AdminController {

    @Autowired
    UserService userService;

    @Autowired
    private TokenStore tokenStore;

    @GetMapping("/admin/home")
    public String adminHome()
    {return "Admin's Home"; }
    @GetMapping("/getUsers")
    public List<UserDto> getAllUsers() {
        return userService.getAllUsers();
    }


    @PostMapping("/admin/register")
    public String addUser(@RequestBody Users user) {
        userService.addUser(user);
        return "User added successfully.";
    }

//Done
    @GetMapping("/doLogout")
    public String logout(HttpServletRequest request) {
        String authHeader = request.getHeader("Authorization");
        if (authHeader != null) {
            String tokenValue = authHeader.replace("Bearer", "").trim();
            OAuth2AccessToken accessToken = tokenStore.readAccessToken(tokenValue);
            tokenStore.removeAccessToken(accessToken);
        }
        return "Logged out successfully";
    }

    @GetMapping("/activateUser/{email}")
    public String activateUser(@PathVariable String email) {
        String message = userService.activateUser(email);
        return message;
    }

    @GetMapping("/deActivateUser/{email}")
    public String deActivateUser(@PathVariable String email) {
        String message = userService.deActivateUser(email);
        return message;
    }
}
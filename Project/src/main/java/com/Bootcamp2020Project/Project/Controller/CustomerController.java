package com.Bootcamp2020Project.Project.Controller;

import com.Bootcamp2020Project.Project.Dto.CustomerDto;
import com.Bootcamp2020Project.Project.Dto.PasswordDto;
import com.Bootcamp2020Project.Project.Entities.User.Customer;
import com.Bootcamp2020Project.Project.Repositories.UserRepository;
import com.Bootcamp2020Project.Project.Services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class CustomerController {

    @Autowired
    CustomerService customerService;

    @Autowired
    UserRepository userRepository;

    @GetMapping("/Customer/Home")
    public String home()
    {return "Customer's Home";}

    @PostMapping("/Customer/Register")
    public String addCustomer(@Valid @RequestBody Customer user) {
        String message = customerService.addCustomer(user);
        return message;
    }

    @GetMapping("/getCustomers")
    public List<Customer> getAllCustomers() {
        return customerService.listAllCustomers();

    }

    @GetMapping("/ActivateCustomerAccount/{token}")
    public String activateCustomer(@PathVariable String token){
        String message = customerService.activateCustomer(token);
        return message;
    }

    @GetMapping("/ReSendLink/{email}")
    public String reSentLink(@PathVariable String email) {
        String message = customerService.reSentLink(email);
        return message;
    }

    @PutMapping("/Customer/UpdateProfile")
    public String editCustomer(@RequestBody CustomerDto customer){
        customerService.editCustomer(customer);
        return "Customer updated...";
    }

    @PutMapping("Customer/UpdatePassword")
    public String updatePassword(@RequestBody PasswordDto passwordDto){
        customerService.updateCustomerPassword(passwordDto);
        return "Password updated...";
    }

    @GetMapping("/Customer/Profile")
    public CustomerDto myProfile(){
        return customerService.myProfile();
    }
}

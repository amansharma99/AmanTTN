package com.Bootcamp2020Project.Project.Controller;

import com.Bootcamp2020Project.Project.Dto.AdminCustomerDto;
import com.Bootcamp2020Project.Project.Dto.AdminSellerDto;
import com.Bootcamp2020Project.Project.Services.CustomerService;
import com.Bootcamp2020Project.Project.Services.SellerService;
import com.Bootcamp2020Project.Project.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;

import java.util.Arrays;
import java.util.List;

@RestController
public class AdminController {
    @Autowired
    CustomerService customerService;
    @Autowired
    SellerService sellerService;
    @Autowired
    UserService userService;


    @GetMapping("/User/Customers")
    public List<AdminCustomerDto> getAllCustomers(@RequestParam(defaultValue = "0") String offset,
                                                  @RequestParam(defaultValue = "10") String size,
                                                  @RequestParam(defaultValue = "id") String sortByField,
                                                  @RequestParam(required = false) String email) {
        if (email != null)
            return Arrays.asList(customerService.getCustomerByEmail(email));

        return customerService.getAllCustomers(offset, size, sortByField);
    }

    @GetMapping("/User/Sellers")
    public List<AdminSellerDto> getAllSellers(@RequestParam(defaultValue = "0") String offset,
                                              @RequestParam(defaultValue = "10") String size,
                                              @RequestParam(defaultValue = "id") String sortByField,
                                              @RequestParam(required = false) String email) {
        if (email != null)
            return Arrays.asList(sellerService.getSellerByEmail(email));
        return sellerService.getAllSeller(offset, size, sortByField);
    }

    @PutMapping("/ActivateUser/{id}")
    public ResponseEntity activateUser(@PathVariable Long id, WebRequest webRequest) {
        return userService.activateById(id, webRequest);
    }

    @PutMapping("Deactivate/{id}")
    public ResponseEntity deActivateUser(@PathVariable Long id, WebRequest webRequest) {
        return userService.deActivateById(id, webRequest);
    }

}
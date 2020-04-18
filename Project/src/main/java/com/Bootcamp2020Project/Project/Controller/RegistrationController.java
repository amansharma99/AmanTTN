package com.Bootcamp2020Project.Project.Controller;

import com.Bootcamp2020Project.Project.Dto.CustomerRegistrationDto;
import com.Bootcamp2020Project.Project.Dto.SellerRegistrationDto;
import com.Bootcamp2020Project.Project.Entities.User.Customer;
import com.Bootcamp2020Project.Project.Entities.User.Seller;
import com.Bootcamp2020Project.Project.Exceptions.EmailAlreadyExistsException;
import com.Bootcamp2020Project.Project.Repositories.CustomerRepository;
import com.Bootcamp2020Project.Project.Repositories.SellerRepository;
import com.Bootcamp2020Project.Project.Services.CustomerService;
import com.Bootcamp2020Project.Project.Services.SellerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;

import javax.validation.Valid;

@RestController
public class RegistrationController {
    @Autowired
    CustomerService customerService;
    @Autowired
    CustomerRepository customerRepository;
    @Autowired
    SellerService sellerService;
    @Autowired
    SellerRepository sellerRepository;

    @PostMapping("/Register/Customer")
    public String registerCustomer(@Valid @RequestBody CustomerRegistrationDto customerRegistrationDto,
                                   WebRequest request) {

        Customer customer = customerRepository.findByEmail(customerRegistrationDto.getEmail());

        if (customer != null)
            throw new EmailAlreadyExistsException("This Email id already exists");

        else {
            Customer newCustomer = customerService.toCustomer(customerRegistrationDto);
            Customer savedCustomer = customerRepository.save(newCustomer);
            return "Customer Registerd Successfully";
        }
    }
    @PostMapping("/Register/Seller")
    public String registerSeller(@Valid @RequestBody SellerRegistrationDto sellerRegistrationDto,
                                 WebRequest webRequest) {

        Seller seller = sellerRepository.findByEmail(sellerRegistrationDto.getEmail());

        if (seller != null)
            throw new EmailAlreadyExistsException("This Email id already exists");

        else {
            Seller newSeller = sellerService.toSeller(sellerRegistrationDto);
            Seller savedSeller = sellerRepository.save(newSeller);
            return "Seller Registered Successfully";
        }
    }
}
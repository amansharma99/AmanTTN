package com.Bootcamp2020Project.Project.Controller;

import com.Bootcamp2020Project.Project.Entities.User.Address;
import com.Bootcamp2020Project.Project.Services.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Set;

@RestController
public class AddressController {

    @Autowired
    AddressService addressService;

    @GetMapping("/Customer/GetAddress")
    public Set<Address> viewCustomerAddresses(){
        return  addressService.viewCustomerAddress();
    }

    @PostMapping("/Customer/AddAddress")
    public String addCustomerAddress(@RequestBody Address address){
        addressService.addCustomerAddress(address);
        return "Customer Address is added successfully";
    }

    @PutMapping("/Customer/UpdateAddress/{AddressId}")
    public void updateCustomerAddress(@Valid @RequestBody Address address, @PathVariable Long AddressId){
        addressService.updateCustomerAddress(address,AddressId);
    }

    @DeleteMapping("/Customer/DeleteAddress/{AddressId}")
    public String deleteCustomerAddress(@Valid @PathVariable Long AddressId){
        return addressService.deleteCustomerAddress(AddressId);
    }

    @PutMapping("/Seller/UpdateAddress/{AddressId}")
    public String updateSellerAddress(@PathVariable Long addId, @RequestBody Address address){
        addressService.updateSellerAddress(address,addId);
        return "Address Updated.";
    }
}

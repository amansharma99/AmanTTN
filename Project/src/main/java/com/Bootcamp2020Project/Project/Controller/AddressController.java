package com.Bootcamp2020Project.Project.Controller;

import com.Bootcamp2020Project.Project.Entities.User.Address;
import com.Bootcamp2020Project.Project.Services.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Set;

@RestController
@RequestMapping("/customer")
public class AddressController {

    @Autowired
    AddressService addressService;

    @GetMapping("/getAddress")
    public Set<Address> viewCustomerAddresses(){
        return  addressService.viewCustomerAddress();
    }

    @PostMapping("/customer/addAddress")
    public String addCustomerAddress(@RequestBody Address address){
        addressService.addCustomerAddress(address);
        return "Customer Address is added successfully";
    }

    @PutMapping("/customer/updateAddress/{AddressId}")
    public void updateCustomerAddress(@Valid @RequestBody Address address, @PathVariable Long addressId){
        addressService.updateCustomerAddress(address,addressId);
    }

    @DeleteMapping("/deleteAddress/{AddressId}")
    public String deleteCustomerAddress(@Valid @PathVariable Long addressId){
        return addressService.deleteCustomerAddress(addressId);
    }

    @PutMapping("/seller/updateAddress/{addressId}")
    public String updateSellerAddress(@PathVariable Long addressId, @RequestBody Address address){
        addressService.updateSellerAddress(address,addressId);
        return "Address Updated.";
    }
}

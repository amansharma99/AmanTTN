package com.Bootcamp2020Project.Project.Controller;


import com.Bootcamp2020Project.Project.Dto.PasswordDto;
import com.Bootcamp2020Project.Project.Dto.SellerDto;
import com.Bootcamp2020Project.Project.Dto.SellerProfileDto;
import com.Bootcamp2020Project.Project.Entities.User.Seller;
import com.Bootcamp2020Project.Project.Services.AddressService;
import com.Bootcamp2020Project.Project.Services.SellerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class SellerController {

    @Autowired
    SellerService sellerService;

    @Autowired
    AddressService addressService;
    @GetMapping("/Seller/Home")
    public String home(){return "Seller's Home";}
    @PostMapping("/seller/registration")
    public String addSeller(@RequestBody Seller seller) {
        String message = sellerService.addseller(seller);
        return message;
    }

    @GetMapping("/getSellers")
    public List<Seller> getAllSellers() {
        return sellerService.listAllSeller();
    }

    @PutMapping("/seller/update/profile")
    public String editSeller(@RequestBody SellerDto seller){
//        System.out.println(">>"+seller.getEmail());
        sellerService.editSeller(seller);
        return "Seller updated...";
    }

    @PutMapping("/seller/update/password")
    public String updatePassword(@RequestBody PasswordDto passwordDto){
        sellerService.updatePassword(passwordDto);
        return "Customer updated...";
    }

    @GetMapping("/seller/myProfile")
    public SellerProfileDto myProfile() {
        return sellerService.myProfile();
    }

}
package com.Bootcamp2020Project.Project.Services;


import com.Bootcamp2020Project.Project.Entities.User.Address;
import com.Bootcamp2020Project.Project.Entities.User.Customer;
import com.Bootcamp2020Project.Project.Entities.User.Seller;
import com.Bootcamp2020Project.Project.Repositories.AddressRepository;
import com.Bootcamp2020Project.Project.Repositories.CustomerRepository;
import com.Bootcamp2020Project.Project.Repositories.SellerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Set;

@Service
public class AddressService {


    @Autowired
    AddressRepository addressRepository;

    @Autowired
    CustomerService customerService;

    @Autowired
    CustomerRepository customerRepository;

    @Autowired
    SellerService sellerService;

    @Autowired
    SellerRepository sellerRepository;

    public Set<Address> viewCustomerAddress() {
        Customer customer = customerService.getLoggedInCustomer();
        Long id = customer.getId();
        return addressRepository.findAllAddressByCustomer(id);
    }

    public void addCustomerAddress(Address address) {
        Customer customer = customerService.getLoggedInCustomer();
            address.setCustomer(customer);
            addressRepository.save(address);
    }

    @Transactional
    public String updateCustomerAddress(Address address, Long addressId) {
        Customer customer=customerService.getLoggedInCustomer();
        Address address1 = addressRepository.findByUserIdAndAddressId(addressId,customer.getId());
        if(address1.getId()!=null){
            address.setId(addressId);
            address.setCustomer(customer);
            addressRepository.save(address);
            return "Address Updated";
        }
        else
            return "Address with AddressId "+addressId+" is not associated with user "+customer.getFirstName();
    }

    @Transactional
    public String deleteCustomerAddress(Long addressId) {
        Customer customer=customerService.getLoggedInCustomer();
        Address address1 = addressRepository.findByUserIdAndAddressId(addressId,customer.getId());
        if(address1.getId()!=null){
            addressRepository.deleteById(addressId);
            return "Address deleted successfully";
        }
        else
            return "You can not delete Address with AddressId "+addressId+" because it is not associated with user "+customer.getFirstName();
    }

    @Transactional
    public String updateSellerAddress(Address address, Long addressId) {
        Seller seller=sellerService.getLoggedInSeller();
        Address address1 = addressRepository.findBySellerIdAndAddressId(addressId,seller.getId());
        if(address1.getId()!=null){
            address.setId(addressId);
            address.setSeller(seller);
            addressRepository.save(address);
            return "Address Updated";
        }
        else
            return "Address with AddressId "+addressId+" is not associated with user "+seller.getFirstName();
    }
}

package com.Bootcamp2020Project.Project.Services;

import com.Bootcamp2020Project.Project.Dto.ProductDto;
import com.Bootcamp2020Project.Project.Entities.Product.Product;
import com.Bootcamp2020Project.Project.Entities.User.Seller;
import com.Bootcamp2020Project.Project.Exceptions.ProductNotFoundException;
import com.Bootcamp2020Project.Project.Repositories.ProductRepository;

import com.Bootcamp2020Project.Project.Repositories.SellerRepository;
import com.Bootcamp2020Project.Project.security.AppUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.Set;


@Component
public class ProductService {
    
    @Autowired
    ProductRepository productRepository;

    @Autowired
    SellerRepository sellerRepository;

    @Autowired
    EmailService emailService;


    public Seller getLoggedInSeller() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        AppUser userDetail = (AppUser) authentication.getPrincipal();
        String username = userDetail.getUsername();
        Seller seller = sellerRepository.findByUsername(username);
        return seller;
    }

    public String addProduct(Product product) {
        Seller seller = getLoggedInSeller();
        product.setSeller(seller);
        try {
            emailService.sendEmail("REGARDING PRODUCT ACTIVATION", "Hii Admin, \n There is a pending task for you. Seller "+seller.getFirstName()+
                    " added a product '" + product.getName() +"', Could you please verify and active the product added by seller : ",seller.getEmail());
            productRepository.save(product);
        } catch (Exception ex) {
            return "Mail Not Sent";
        }
        return "Product added successfully";
    }

    public Optional<Product> viewProductAsSeller(Long productId) {
        Seller seller=getLoggedInSeller();
        Optional<Product> product = productRepository.findByIdAndSellerId(seller.getId(),productId);
        try{
            Product product1= product.get();
        }
        catch (Exception ex){
            throw new ProductNotFoundException("Product Not Found");
        }
        return product;
    }

    public List<Product> viewAllProductAsSeller() {
        Seller seller=getLoggedInSeller();
        return productRepository.findAllBySeller(seller.getId());
    }

    @Transactional
    public void deleteProduct(Long productId) {
        Seller seller = getLoggedInSeller();
        Product product = productRepository.findByUserIdAndSellerId(productId, seller.getId());
        if (product.getId() != null) {
            productRepository.deleteByIdAndSellerId(productId,seller.getId());
        }
        else
            throw new ProductNotFoundException("Cann't delete unavailable product");
    }

    public void updateProduct(Long productId, ProductDto productDto) {
        Seller seller = getLoggedInSeller();
        Product product = productRepository.findByUserIdAndSellerId(productId, seller.getId());
        if (product.getBrand() != null) {
            if(productDto.getBrand()!=null)
                product.setBrand(productDto.getBrand());
            if(productDto.getDescription()!=null)
                product.setDescription(productDto.getDescription());
            if(productDto.getProductName()!=null)
                product.setName(productDto.getProductName());
            if(productDto.isCancellable())
                product.setCancellable(productDto.isCancellable());
            if(productDto.isReturnable())
                product.setReturnable(productDto.isReturnable());
            productRepository.save(product);
        }
    }

    public Optional<Product> viewAProductAsCustomer(Long productId) {
       Optional<Product> product = productRepository.findById(productId);
       try{
           Product product1=product.get();
       }
       catch (Exception ex){
           throw new ProductNotFoundException("Product Not Found");
       }
       return product;
    }


    public Optional<Product> viewAProductAsAdmin(Long productId) {
            Optional<Product> product = productRepository.findById(productId);
            try{
                Product product1=product.get();
            }
            catch (Exception ex){
                throw new ProductNotFoundException("Product Not Found");
            }
            return product;
        }



    public String deactivateProduct(Long productId) {
        Optional<Product> product=productRepository.findById(productId);
        if(product.get().isActive()){
            try {

                productRepository.deActivateProduct(product.get().getId(),false);
            }
            catch (Exception ex) {
                return "Mail Not Sent";
            }
            return "Product de-activated";
        }
        else
            return "Product is already de-activated";
    }

    public String activateProduct(Long productId) {
        Optional<Product> product=productRepository.findById(productId);
        if(!product.get().isActive()){
        try {
            emailService.sendEmail("REGARDING PRODUCT ACTIVATION", "Hii, \n Your product "+product.get().getName()
                    , product.get().getSeller().getEmail());
            productRepository.activateProduct(product.get().getId(),true);
        }
        catch (Exception ex) {
            return "Mail Not Send";
        }
            return "Product Activated";
    }
        else
            return "Product is already Activated";
    }


}

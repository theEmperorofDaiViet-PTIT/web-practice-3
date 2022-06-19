package ProductMaintenance.controller;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import ProductMaintenance.data.ProductRepository;
import ProductMaintenance.entity.*;

@Controller
@RequestMapping("/ProductMaintenance/addProduct")
public class AddController {
	
	private final ProductRepository productRepo;
	
	public AddController(ProductRepository productRepo) {
		this.productRepo = productRepo;
	}
	
	@GetMapping
	public String updateProductRequest(@RequestParam("productCode") String code, Model model) {

		Product editProduct = productRepo.findByProductCode(code);
		
		model.addAttribute("editProduct", editProduct);
		return "addProduct";
	}
	
	@PostMapping
	public String updateProduct(@RequestParam("code") String code,
								@RequestParam("description") String description,
								@RequestParam("price") String p,
								Model model) {
		String message = null;
        double price = 0;
        Product userInput = new Product();
        if(code.isEmpty() || code == null){
            message = "You must enter a code for the product.";
            model.addAttribute("message", message);              
            return "addProduct";                
        }
        //Validate productDescription nguoi dung nhap vao
        if(description.isEmpty() || description == null){
            message = "You must enter a description for the product.";
            model.addAttribute("message", message);                
            return "addProduct";               
        }
        //Validate price nguoi dung nhap vao
        if(p.isEmpty() || p == null){
            message = "You must enter a price for the product.";
            model.addAttribute("message", message);
            return "addProduct";              
        }
        //Kiem tra price la so
        try{
            price = Double.parseDouble(p);
        }
        catch(NumberFormatException e){
            userInput = new Product(code, description, price);
            model.addAttribute("userInput", userInput);
            message = "Please enter a number!";
            model.addAttribute("message", message);
            return "addProduct";
        }
		Product product = new Product(code, description, price);
		productRepo.save(product);

		return "redirect:/ProductMaintenance/displayProducts";
	}
}

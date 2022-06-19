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
@RequestMapping("/ProductMaintenance/deleteProduct")
public class DeleteController {

	private final ProductRepository productRepo;
	private String productCode;
	
	public DeleteController(ProductRepository productRepo) {
		this.productRepo = productRepo;
	}
	
	@GetMapping
	public String updateProductRequest(@RequestParam("productCode") String code, Model model) {

		Product editProduct = productRepo.findByProductCode(code);
		this.productCode = code;
		
		model.addAttribute("delProduct", editProduct);
		return "deleteProduct";
	}
	
	@PostMapping
	public String updateProduct(@RequestParam("action") String action,
								Model model) {
		if(action.equals("Yes")) {
			productRepo.deleteById(this.productCode);
		}

		return "redirect:/ProductMaintenance/displayProducts";
	}
}

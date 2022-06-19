package ProductMaintenance.controller;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import ProductMaintenance.data.ProductRepository;
import ProductMaintenance.data.SQLUtility;
import ProductMaintenance.entity.*;

@Controller
@RequestMapping("/ProductMaintenance/displayProducts")
public class DisplayController {
	
	private final ProductRepository productRepo;
	
	public DisplayController(ProductRepository productRepo) {
		this.productRepo = productRepo;
	}
	
	@ModelAttribute
	public void addIngredientsToModel(Model model) {
		List<Product> products = (ArrayList<Product>) productRepo.findAll();
		  
		model.addAttribute(products);
			
	}

	@GetMapping
	public String displayProducts(Model model) {
		ArrayList<Product> products = (ArrayList<Product>) productRepo.findAll();
		String displayProducts = "";
		try {
			displayProducts = SQLUtility.getHTMLTable(products);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		model.addAttribute("displayProducts", displayProducts);
		return "display";
	}
}

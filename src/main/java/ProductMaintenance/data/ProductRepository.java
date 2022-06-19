package ProductMaintenance.data;

import org.springframework.data.repository.CrudRepository;
import ProductMaintenance.entity.Product;

public interface ProductRepository extends CrudRepository <Product, String>{
	 
	Product findByProductCode(String code);
}
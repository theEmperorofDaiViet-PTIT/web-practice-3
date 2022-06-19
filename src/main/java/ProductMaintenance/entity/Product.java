package ProductMaintenance.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "Products")
public class Product implements Serializable {
    
	private static final long serialVersionUID = 1L;

	@Id
	private String productCode;
    
	@NotNull
    private String productDescription;

	@NotNull
    private double price;
    
    public Product() {

    }

    public Product(String value1, String value2, Double value3) {
        productCode = value1;
        productDescription = value2;
        price = value3;
    }
    
    public String getProductCode() {
        return productCode;
    }

    public String getProductDescription() {
        return productDescription;
    }

    public Double getPrice() {
        return price;
    }
    
    public void setProductCode(String value) {
        productCode = value;
    }
    
    public void setProductDescription(String value) {
        productDescription = value;
    }

    public void setPrice(Double value) {
        price = value;
    }
    
}

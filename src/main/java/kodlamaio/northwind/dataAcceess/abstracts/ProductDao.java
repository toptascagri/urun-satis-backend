package kodlamaio.northwind.dataAcceess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Component;

import kodlamaio.northwind.entities.concretes.Product;
import kodlamaio.northwind.entities.dtos.ProductWithCategoryDto;

//interface interface'i extend eder.
//hangi tabloya hangi veri tipiyle sorguların yazılması gerektiği kısmı

//primary key integer olduğu için integer veridi
@Component
public interface ProductDao extends JpaRepository<Product, Integer> {
	
	//getby gördüğü an kendisi tablolara bakıyor
	Product getByProductName(String productName);
	
	Product getByProductNameAndCategory_CategoryId(String productName,int categoryId);
	
	List<Product> getByProductNameOrCategory_CategoryId(String productName,int categoryId);
	
	List<Product> getByCategoryIn(List<Integer>categories);
	
	List<Product> getByProductNameContains(String productName);
	
	List<Product> getByProductNameStartsWith(String productName);
	
	@Query("From Product where productName=:productName and category.categoryId=:categoryId")
	List<Product> getByNameAndCategory(String productName,int categoryId);
	
	//@Query("Select new kodlamaio.northwind.entities.dtos.ProductWithCategoryDto (p.id, p.productName, c.categoryName) From Category c Inner Join c.products p")
	@Query(value ="Select new kodlamaio.northwind.entities.dtos.ProductWithCategoryDto (p.id, p.productName, c.categoryName) From Category c Inner Join c.products p",nativeQuery = true)
	List<ProductWithCategoryDto> getProductWithCategoryDetails();
	
}

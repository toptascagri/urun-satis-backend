package kodlamaio.northwind.entities.concretes;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor; 

@Entity
//spring class nerede olacağını bu anotasyon ile anlar
//Sen bir veri tabanı nesnesisin demek

@Table(name="products")
// products isimli tabloya karşılık gelir.


@Data
//lombok getter-setter erişimi
@AllArgsConstructor
//Tüm argümanları kullanıp const. yap
@NoArgsConstructor
//Argüman olmadan const. yap


public class Product {
	
	@Id
	//Sorgular bu id ye göre yapılacağından id verilir.
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	//id birer birer artacak demek
	@Column(name="product_id")
	//Hangi kolona denk geldiğini yazdık
	private int id;
	
	//Alta eklenen kısım burayı gereksiz kıldı
	//@Column(name="category_id")
	//private int categoryId;
	
	@Column(name="product_name")
	private String productName;
	
	@Column(name="unit_price")
	private double unitPrice;
	
	@Column(name="units_in_stock")
	private short unitsInstock;
	
	@Column(name="quantity_per_unit")
	private String quantityPerUnit;
	
	
	@ManyToOne()
	@JoinColumn(name="category_id")
	private Category category;
	

	

}

package khalil.springbootstarter.Product;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import khalil.springbootstarter.Category.Category;

@Entity
public class Product {

	@Id
	private Long id;
	private String name;
	private String description;

	@ManyToOne
	private Category category;

	public Product() {
	}

	public Product(long id, String name, String description,Long ctgId) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.category = new Category(ctgId,"","");
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}
}

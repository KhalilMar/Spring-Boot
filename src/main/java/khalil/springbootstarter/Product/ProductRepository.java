package khalil.springbootstarter.Product;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface ProductRepository extends CrudRepository<Product,Long> {
	
	public List<Product> findByCategoryId(Long id);

}

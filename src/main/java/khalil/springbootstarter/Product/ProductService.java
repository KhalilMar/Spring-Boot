package khalil.springbootstarter.Product;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

	@Autowired
	private ProductRepository prdRepository;


	public List<Product> getProductsByCtgId(Long id) {
		List<Product> prods = new ArrayList<Product>();
		prdRepository.findByCategoryId(id).forEach(prods::add);
		return prods;
	}

	public Product getProduct(Long id) {

		return prdRepository.findById(id).orElse(new Product());

	}

	public void addProduct(Product prd) {

		prdRepository.save(prd);

	}

	public void deleteProduct(Long id) {

		prdRepository.deleteById(id);
	}

	public void updateProduct(Product prd) {

		prdRepository.save(prd);
	}

}

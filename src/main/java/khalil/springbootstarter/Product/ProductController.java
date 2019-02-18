package khalil.springbootstarter.Product;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import khalil.springbootstarter.Category.Category;

@RestController
public class ProductController {

	@Autowired
	private ProductService productService;
	
	@RequestMapping("/Categories/{ctgId}/Products")
	public List<Product> getProducts(@PathVariable("ctgId") Long id) {

		return productService.getProductsByCtgId(id);
	}
	
	@RequestMapping("/Categories/{ctgId}/Products/{id}")
	public Product getProduct(@PathVariable("id") Long id) {

		return productService.getProduct(id);
	}

	@RequestMapping(method=RequestMethod.POST,value ="/Categories/{ctgId}/Products")
	public void addProduct (@RequestBody Product prd,@PathVariable("ctgId") Long ctgId) {
		
		Category cat = new Category(ctgId,"","");
		prd.setCategory(cat);
		productService.addProduct(prd);
	}
	
	@RequestMapping(method=RequestMethod.PUT,value ="/Categories/{ctgId}/Products/{id}")
	public void updateProduct (@RequestBody Product prd ,@PathVariable("ctgId") Long ctgId) {
		Category cat = new Category(ctgId,"","");
		prd.setCategory(cat);
		productService.updateProduct(prd);
		
	}
	
	@RequestMapping(method=RequestMethod.DELETE,value ="/Categories/{ctgId}/Products/{id}")
	public String deleteProduct (@PathVariable("id") Long id) {
		
		productService.deleteProduct(id);
		
		return "Product deleted";
	}
}

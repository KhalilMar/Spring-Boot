package khalil.springbootstarter.Category;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CategoryController {

	@Autowired
	private CategoryService categoryService;
	
	@RequestMapping("/Categories")
	public List<Category> getCategories() {

		return categoryService.getAllCategories();
	}
	
	@RequestMapping("/Categories/{id}")
	public Category getCategory(@PathVariable("id") Long id) {

		return categoryService.getCategory(id);
	}

	@RequestMapping(method=RequestMethod.POST,value ="/Categories")
	public void addCategory (@RequestBody Category ctgr) {
		categoryService.addCategory(ctgr);
	}
	
	@RequestMapping(method=RequestMethod.PUT,value ="/Categories/{id}")
	public void updateCategory (@PathVariable("id") Long id,@RequestBody Category ctgr) {
		
		categoryService.updateCategory(ctgr);
		
	}
	
	@RequestMapping(method=RequestMethod.DELETE,value ="/Categories/{id}")
	public String deleteCategory (@PathVariable("id") Long id) {
		
		categoryService.deleteCategory(id);
		
		return "Category deleted";
	}
}

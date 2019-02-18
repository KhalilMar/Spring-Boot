package khalil.springbootstarter.Category;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoryService {

	@Autowired
	private CategoryRepository ctgRepository;


	public List<Category> getAllCategories() {
		List<Category> ctgrs = new ArrayList<Category>();
		ctgRepository.findAll().forEach(ctgrs::add);
		return ctgrs;
	}

	public Category getCategory(Long id) {

		return ctgRepository.findById(id).orElse(new Category());

	}

	public void addCategory(Category ctgr) {

		ctgRepository.save(ctgr);

	}

	public void deleteCategory(Long id) {

		ctgRepository.deleteById(id);
	}

	public void updateCategory(Category ctgr) {

		ctgRepository.save(ctgr);
	}

}

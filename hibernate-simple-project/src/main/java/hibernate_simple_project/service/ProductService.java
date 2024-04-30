package hibernate_simple_project.service;

import java.util.List;

import hibernate_simple_project.dao.ProductDao;
import hibernate_simple_project.dto.Product;

public class ProductService {
	ProductDao dao = new ProductDao();

	public Product insertData(Product p) {
		return dao.insert(p);
	}

	public Product updateData(Product p) {
		return dao.update(p);
	}

	public void deleteData(int id) {
		dao.delete(id);
	}

	public Product getOneProduct(int id) {
		return dao.getProductById(id);
	}
	
	public List<Product> getAllProduct(){
		return dao.getAll();
	}

}

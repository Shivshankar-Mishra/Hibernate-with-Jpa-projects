package hibernate_simple_project.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import hibernate_simple_project.dto.Product;

/**
 * @author Shivshankar Mishra
 */
public class ProductDao {
	EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("hibernateSimpleProject");
	EntityManager entityManager = entityManagerFactory.createEntityManager();
	EntityTransaction entityTransaction = entityManager.getTransaction();

	/**
	 * method for insert data into database
	 * 
	 * @param p
	 * @return
	 */
	public Product insert(Product p) {
		entityTransaction.begin();
		entityManager.persist(p);
		entityTransaction.commit();
		return p;
	}

	/**
	 * method for updating data
	 * 
	 * @param p
	 * @return
	 */
	public Product update(Product p) {
		Product pd = getProductById(p.getId());
		pd.setName(p.getName());
		pd.setColor(p.getColor());
		pd.setPrice(p.getPrice());
		entityTransaction.begin();
		Product product = entityManager.merge(pd);
		entityTransaction.commit();
		return product;
	}

	/**
	 * method for deleting data
	 * 
	 * @param id
	 */
	public void delete(int id) {
		entityTransaction.begin();
		entityManager.remove(getProductById(id));
		entityTransaction.commit();
	}

	/**
	 * method for display one data using id
	 * 
	 * @param id
	 * @return
	 */
	public Product getProductById(int id) {
		Product product = entityManager.find(Product.class, id);
		return product;
	}
	
	public List<Product> getAll(){
		return entityManager.createQuery("from Product", Product.class).getResultList();

	}

}

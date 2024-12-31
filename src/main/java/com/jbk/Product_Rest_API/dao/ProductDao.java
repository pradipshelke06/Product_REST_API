package com.jbk.Product_Rest_API.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.jbk.Product_Rest_API.entity.Product;

@Repository
public class ProductDao {
	@Autowired
	private SessionFactory sessionFactory;
	
//	List<Product>products = new ArrayList<Product>();
//	public ProductDao() {
//		products.add(new Product(1, "TV", 10, 15000));
//		products.add(new Product(2, "AC", 18, 10000));
//		products.add(new Product(3, "FAN", 100, 5000));
//	}
	public String addProduct(Product product) {
		//products.add(product);
		Session session = sessionFactory.openSession();
		session.save(product);
		session.beginTransaction().commit();
		return "Product Added Successfully....";
		
	}
	
public List<Product> viewallProducts() {
		Session session = sessionFactory.openSession();
		Criteria criteria = session.createCriteria(Product.class);
		List list = criteria.list();
		return list;
		
	}

public Product getProductById(int id){
	Session session = sessionFactory.openSession();
	Product product = session.get(Product.class, id);
	return product;
	
}
public int deleteProductById(int id) {
	//String msg=null;
	Session session = sessionFactory.openSession();
	Product product = session.get(Product.class, id);
	session.delete(product);
	session.beginTransaction().commit();
	//msg="Product Deleted Successfully...";
	return 1;
	
}
public int updateproduct(int id, Product product) {
	
	Session session = sessionFactory.openSession();
	int status=deleteProductById(id);
	
	if (status==1) {
		session.saveOrUpdate(product);
		session.beginTransaction().commit();
		
		return 1;
		
	}else {
		return 0;
	}	
	
}


}

package com.jbk.Product_Rest_API.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jbk.Product_Rest_API.dao.ProductDao;
import com.jbk.Product_Rest_API.entity.Product;

@Service
public class ProductService {
	@Autowired
	private ProductDao productDao;
	public String addProduct(Product product) {
		String msg = productDao.addProduct(product);
		return msg;
		
	}
	
public List<Product> viewallProducts() {
		List<Product> viewallProducts = productDao.viewallProducts();
		return viewallProducts;
		
	}
public Product getProductById(int id) {
	Product productById = productDao.getProductById(id);
	return productById;
	
}
public String deleteProductById(int id) {
	int status = productDao.deleteProductById(id);
	if (status==0) {
		return "Product Not Found...";
	}else {
		return "Product Deleted...";
	}
	
	
}
public String updateProduct(int id, Product product) {
	int status = productDao.updateproduct(id, product);
	if (status==1) {
		return "Product Updated Successfully...";
	}else {
		return "Product Not Found To Update...";
	}
	
	
}


}

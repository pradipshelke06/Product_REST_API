package com.jbk.Product_Rest_API.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jbk.Product_Rest_API.entity.Product;
import com.jbk.Product_Rest_API.service.ProductService;
@RestController
@RequestMapping("/api/product")
public class ProductController {

	@Autowired
	private ProductService productService;
	
	
	@PostMapping("/addproduct")
	
	public String addProduct(@RequestBody Product product) {
		
		String msg = productService.addProduct(product);
		return msg;
		
	}
	@GetMapping("/allproducts")
	public List<Product> viewallProducts() {
		List<Product> viewallProducts = productService.viewallProducts();
		int c=6/0;
		System.out.println(c);
		return viewallProducts;
		
	}
	@GetMapping("/product")
	public Product getProductById(@RequestParam int id){
		Product productById = productService.getProductById(id);
		return productById;
		
	}
	@DeleteMapping("/product/{id}")
	public String deleteProductById(@PathVariable int id) {
		return  productService.deleteProductById(id);
	
	}
	@PutMapping("/updateproduct/{id}")
	public String updateProduct(@RequestBody Product product, @PathVariable int id) {
		String msg = productService.updateProduct(id, product);
		return msg;
		
	}
	
	
}

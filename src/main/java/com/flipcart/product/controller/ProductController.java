package com.flipcart.product.controller;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.flipcart.product.model.Product;
import com.flipcart.product.service.ProductService;


@RestController
@RequestMapping("/product")
public class ProductController 
{
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private ProductService productService; 
	
	@GetMapping("/get-allproducts")
	public Object getAllProducts()
	{
		return productService.getAllProducts();
		
	}
	
	@GetMapping("/get-bycategory")
	public Object getAllProductsByCategory(@RequestParam String category)
	{
		return productService.getAllProductsByCategory(category);
	}
	
	
	@GetMapping("/get-byprice")
	public Object getAllProductsByPrice(@RequestParam int price)
	{
		return productService.getAllProductsByPrice(price);
	}
	
	
	@GetMapping("/get-byRange")
	public Object getAllProductsByPriceRange(@RequestParam  int minPrice,int maxPrice)
	{
		return productService.getAllProductsByPriceRange(minPrice,maxPrice);
	}
	
	@GetMapping("/get-byRangeAndCategory")
	public Object getAllProductsByPriceRangeCategory(@RequestParam  int minPrice,int maxPrice,String category)
	{
		return productService.getAllProductsByPriceRangeCategory(minPrice,maxPrice,category);
	}
	
	
	@PostMapping("/add-product")
	public Object addProduct(@RequestBody Product product)
	{
		logger.info(product.toString());
		return productService.addProduct(product);
	
	}
	
	@PutMapping("/update-product")
	public Object updateProduct(@RequestBody Product product )
	{
		logger.info("product details:"+product.toString());
		return productService.updateProduct(product);
	}
	
	@DeleteMapping("/delete-product")
	 public Object deleteProduct(@RequestParam  int productId)
	 {
		logger.info("product Id :"+productId);
		 return productService.deleteProduct(productId);
	 }
		
}

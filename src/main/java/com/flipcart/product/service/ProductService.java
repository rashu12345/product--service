package com.flipcart.product.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.flipcart.product.model.Product;


@Service
public class ProductService
{
    List<Product> productList = new ArrayList<>();
  
    public Object getAllProducts() 
	{
		if(productList.isEmpty())
		{
			return "There is No Product in List ";
		}
		
		return productList;
		  //return productList = productList.stream().collect(Collectors.toList());
	}

	public Object getAllProductsByCategory(String category) 
	{
		if(productList.isEmpty())
		{
			return "there is no product";
		}
		  List<Product> categoryList = new ArrayList<>();
		  
		  for(Product prod : productList)
		{
			if(prod.getProductCategory().equalsIgnoreCase(category))
			{
				categoryList.add(prod);
			}
		}
		 
			
/* categoryList = productList.stream()
				.filter(c->c.getProductCategory().equalsIgnoreCase(category))
				.collect(Collectors.toList());
	*/			
				
		if(categoryList.isEmpty())
		{
			return "No Product found ";
		}
		
		return categoryList;
	}

	public Object getAllProductsByPrice(int price) 
	{
		if(productList.isEmpty())
		{
			return "there is no product";
		}
		List<Product> priceList = new ArrayList<>();
		
	  for(Product prod1 : productList)
		{
			if(prod1.getProductPrice() == price)
			{
				priceList.add(prod1);
			}
		}
	
	  /*	priceList = productList.stream().
					filter(p->p.getProductPrice() == price).
					collect(Collectors.toList());
*/	
		if(priceList.isEmpty())
		{
			return "No Product found ";
		}
		return priceList;
	}

	
	public Object getAllProductsByPriceRange(int minPrice, int maxPrice)
	{
		if(productList.isEmpty())
		{
			return "There is no product";
		}
		
		List<Product> rangeList = new ArrayList<>();
		
			for(Product prod2 : productList)
		{
			if(prod2.getProductPrice() >= minPrice && prod2.getProductPrice() <= maxPrice )
			{
				rangeList.add(prod2);
			}
		}
			
/*	rangeList = productList.stream().
				filter(r->r.getProductPrice() >= minPrice && r.getProductPrice() <= maxPrice).
				collect(Collectors.toList());
	*/		
		
		if(rangeList.isEmpty())
		{
			return "There is no product";
		}
		return rangeList;
		
	}

	public Object getAllProductsByPriceRangeCategory(int minPrice, int maxPrice, String category)
	{
		if(productList.isEmpty())
		{
			return "There is no product in List";
		}
		
		
		List<Product> prcList = new ArrayList<>();
		
		for(Product prod3 : productList)
		{
			if(prod3.getProductPrice() >= minPrice &&
			   prod3.getProductPrice() <= maxPrice &&  
			   prod3.getProductCategory().equalsIgnoreCase(category))
			{
				prcList.add(prod3);
			}
		}
		/*		
		prcList = productList.stream().
		     filter(c-> c.getProductPrice() >= minPrice &&
		        	    c.getProductPrice() <= maxPrice &&  
		        	    c.getProductCategory().equalsIgnoreCase(category)).
			collect(Collectors.toList());
		*/		
		if(prcList.isEmpty())
		{
			return "There is no product";
		}
		return prcList;
	}

	
	public Object addProduct(Product product) 
	{
		productList.add(product);
			
		return "Product Added Successfully";
	}
	
	
	public Object updateProduct(Product product)
	{
		boolean flag = false;
		if(productList.isEmpty())
		{
			return "There is no product";
		}
		
		for(Product myobj :productList)
		{
			if(myobj.getProductId() == product.getProductId())
			{
				productList.remove(myobj);
				productList.add(product);
				flag=true;
				break;
			}
		}
		if(flag == false)
		{
			return "Product is not available for Updation";
		}
		else
		{
			return "Product updated successfully";
		}
	}
	

	public Object deleteProduct(int productId) 
	{
		boolean flag = false;
		
		if(productList.isEmpty())
		{
			return "there is no product";
		}
		for(Product obj:productList)
		{
			if(obj.getProductId() == productId)
			{
				productList.remove(obj);
				flag=true;
				break;
			}
		}
		if(flag == false)
		{
			return "Product is not Available in List";
		}
		else
		{
			return "Product deleted successfully";
		}
	}
	
}

	
	
	
	
	
	  
	

         



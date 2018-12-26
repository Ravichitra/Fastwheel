package com.fastwheel.fastwheelbackend.DALayer;

import java.util.List;

import com.fastwheel.fastwheelbackend.model.Product;

public interface ProductDAO {
	boolean CreateProduct(Product product);
	boolean UpdateProduct(Product product);
	boolean DeleteProduct(Product product);
	Product SelectProduct(String product_Name);
	List<Product>SelectAllProduct();
	List<Product>SelectCatProduct(String cat_name);


}

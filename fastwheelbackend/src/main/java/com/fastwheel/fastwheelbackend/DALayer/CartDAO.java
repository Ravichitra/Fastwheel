package com.fastwheel.fastwheelbackend.DALayer;

import java.util.List;

import com.fastwheel.fastwheelbackend.model.Cart;

public interface CartDAO {

	public boolean CreateCart(Cart cart);
	public boolean UpdateCart(Cart cart);
	public boolean DeleteCart(int noid);
	List<Cart> ViewAllProduct(int cart_id);
	public Cart ShowOneProduct(int noid);
	
	
}

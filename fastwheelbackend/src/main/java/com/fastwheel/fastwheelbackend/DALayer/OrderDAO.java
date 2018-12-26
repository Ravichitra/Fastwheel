package com.fastwheel.fastwheelbackend.DALayer;

import java.util.List;


import com.fastwheel.fastwheelbackend.model.OrderDetails;

public interface OrderDAO {
	boolean Placeorder(OrderDetails order);
	List<OrderDetails> ViewOrder(int cartid);	
	OrderDetails Showorder(String orderid);
	
	

}

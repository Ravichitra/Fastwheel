package com.fastwheel.fastwheelbackend.DALayer;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


import com.fastwheel.fastwheelbackend.model.OrderDetails;


@Repository("OrderDAO")
@Transactional

public class OrderDAOImpl implements OrderDAO {

	@Autowired
	SessionFactory sf;

	public boolean Placeorder(OrderDetails order) {
		try 
		{
			sf.getCurrentSession().saveOrUpdate(order);
									
			
			return true;
		}
			catch (Exception e) {
				return false;
			}
	}

	public List<OrderDetails> ViewOrder(int id) {
		try {
			return sf.getCurrentSession()
					.createQuery("from OrderDetails where cartid="+id
							).list();
		}

		catch (Exception e) {
			return new ArrayList<OrderDetails>();
		}	
	}

	public OrderDetails Showorder(String orderid) {
		try
		{
			OrderDetails order=(OrderDetails)sf.getCurrentSession().createQuery("from OrderDetails where orderid='"+orderid+"'").uniqueResult();
		return order;
		}
		catch (Exception e) {
			return null; 		}
	}

}
	
	


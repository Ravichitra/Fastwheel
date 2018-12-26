package com.fastwheel.fastwheelbackend.DALayer;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.fastwheel.fastwheelbackend.model.Cart;
@Repository("CartDAO")
@Transactional
public class CartDAOImpl implements CartDAO 
{
	@Autowired
	SessionFactory sf;
	
	
	public boolean CreateCart(Cart cart) {
		
		try {
			sf.getCurrentSession().saveOrUpdate(cart);
			return true;
		}
		catch(Exception e)
		{
			return false;
		}
		
		
	}

	
	public boolean UpdateCart(Cart cart) {

		try {
			sf.getCurrentSession().update(cart);
			return true;
		}
		catch(Exception e)
		{
			return false;
		}
	}

	public boolean DeleteCart(int noid) {
		try
		{
			Cart cart=(Cart)sf.getCurrentSession().createQuery("from Cart where noid="+noid).uniqueResult();
		sf.getCurrentSession().delete(cart);
					return true;
		}
		catch(Exception e)
		{
			return false;
		}
		
		
	}
	
	

	
	public List<Cart> ViewAllProduct(int cart_id) {
		try {
			return sf.getCurrentSession()
					.createQuery("from Cart where cart_id="+cart_id
							).list();
		}

		catch (Exception e) {
			return new ArrayList<Cart>();
		}	
		}	

	
	
	public Cart ShowOneProduct(int noid)
	{
		try
		{
		Cart cart=(Cart)sf.getCurrentSession().createQuery("from Cart where noid="+noid).uniqueResult();
		return cart;
		}
		catch (Exception e) {
			return null; 		}
	}

}


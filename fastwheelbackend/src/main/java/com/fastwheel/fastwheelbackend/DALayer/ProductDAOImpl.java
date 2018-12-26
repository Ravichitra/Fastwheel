package com.fastwheel.fastwheelbackend.DALayer;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.fastwheel.fastwheelbackend.model.MyCategory;
import com.fastwheel.fastwheelbackend.model.Product;
@Repository("ProductDAO")
@Transactional
public class ProductDAOImpl implements ProductDAO {
	@Autowired
	SessionFactory sf;

	public boolean CreateProduct(Product product) {
		try
		{
			sf.getCurrentSession().save(product);
			return true;
		}
		catch (Exception e) {
			return false;
		}
		
		
	}

	public boolean UpdateProduct(Product product) {
		try
		{
			sf.getCurrentSession().update(product);
		return true;
		}
		catch (Exception e) {
			return false;
		}
		

	}

	public boolean DeleteProduct(Product product) {
		try
		{
			sf.getCurrentSession().delete(product);
		return true;
		}
		catch (Exception e) {
			return false;
		}
		
		
	}

	public Product SelectProduct(String product_Name) {
		try {
			return (Product)sf.getCurrentSession()
					.createQuery("from Product where product_Name='" + product_Name+"'").uniqueResult();
		}

		catch (Exception e) {
			return null;
		}

		
	}

	public List<Product> SelectAllProduct() {
		try {
			return sf.getCurrentSession().createQuery("from Product").list();
			
			}
		catch (Exception e) {
			
			return null;
		}
	
	}

	public List<Product> SelectCatProduct(String cat_name) {
		try {
			MyCategory c=(MyCategory)sf.getCurrentSession().createQuery("from  MyCategory where category_Name='"+cat_name+"'").uniqueResult();
			return sf.getCurrentSession()
					.createQuery("from Product where category_category_id="+c.getCategory_id()).list();
	
	}
		
		catch (Exception e) {
			return null;
		}


}
}

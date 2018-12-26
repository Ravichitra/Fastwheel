/*package com.fastwheel.fastwheelbackend;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.fastwheel.fastwheelbackend.DALayer.CategoryDAO;
import com.fastwheel.fastwheelbackend.DALayer.ProductDAO;
import com.fastwheel.fastwheelbackend.model.Category;
import com.fastwheel.fastwheelbackend.model.Product;



@RunWith(SpringJUnit4ClassRunner.class)
@SpringJUnitConfig(classes=dbconfig.class)
public class ProductTest
{
	@Autowired
	ProductDAO  ProductDAO;
	
	
	Product p;
	//Category c;

	@Before
	public void setUp() throws Exception {
		//c=new Category();
		 //c.setCategory_Name("casual");
		 //c.setCategoryDesc("low cost");
		 
		// categoryDAOImpl.CreateCategory(c);
		p=new Product();
		p.setProduct_Name("Eye liner");
	p.setProductDesc("new");
	p.setQuantity(1);
		p.setPrice(100);
		
	}

	@After
	public void tearDown() throws Exception {
		ProductDAO.DeleteProduct(p);
		//categoryDAOImpl.DeleteCategory("Eyes");
		
	}

	@Test
	public void test() 
	{
		assertEquals("success", true,ProductDAO.CreateProduct(p));
		
	}
 

		
}

*/
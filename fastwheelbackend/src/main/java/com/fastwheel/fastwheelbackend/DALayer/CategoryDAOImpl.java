package com.fastwheel.fastwheelbackend.DALayer;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.fastwheel.fastwheelbackend.model.MyCategory;

@Repository("CategoryDAO")
@Transactional
public class CategoryDAOImpl implements CategoryDAO{

	@Autowired
	SessionFactory sf;
		
		public boolean CreateCategory(MyCategory category) {
			try
			{
				sf.getCurrentSession().saveOrUpdate(category);
				return true;
			}
			catch (Exception e) {
				return false;
			}
			
		
		
		}

		public boolean UpdateCategory(MyCategory category) {
			try
			{
				sf.getCurrentSession().update(category);
				return true;
			}
			catch (Exception e) {
				return false;
			}
			
		
		}

		public boolean DeleteCategory(String Category_Name) {
			try
			{
				
				sf.getCurrentSession().delete(ViewOneCategory(Category_Name));
				return true;
			}
			catch (Exception e) {
				return false;
			}

		
		}

		public List<MyCategory> ViewAllCategory() {
			try {
				return sf.getCurrentSession().createQuery("from MyCategory").list();
			}

			catch (Exception e) {
				return null;

		}
			
		}

		public MyCategory ViewOneCategory(String CategoryName) {
			try {
				return (MyCategory)sf.getCurrentSession().createQuery("from MyCategory where category_Name='"+CategoryName+"'").uniqueResult();
			}
			catch (Exception e) {
				return null;

		}

		}

		
	}



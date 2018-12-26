package com.fastwheel.fastwheelbackend.DALayer;
import javax.transaction.Transactional;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.fastwheel.fastwheelbackend.model.UserCred;
import com.fastwheel.fastwheelbackend.model.UserDetails;
@Repository("UserDetailsDAO")
@Transactional
public class UserDetailsDAOImpl implements UserDetailsDAO {
	@Autowired
SessionFactory sf;

	public boolean CreateUserDetails(UserDetails userdetails) {
		try {
		UserCred c=new UserCred();
		c.setEmailid(userdetails.getEmailId());
		c.setUser_password(userdetails.getUser_Password());
		c.setStatus("True");
		c.setRole("ROLE_USER");
		sf.getCurrentSession().save(userdetails);		
		sf.getCurrentSession().save(c);
		return true;
		}
		catch (Exception e) {
			return false;
		}
		
	}

	public boolean UpdateUserDetails(UserDetails userdetails) {
		
		try {
		sf.getCurrentSession().update(userdetails);
		return true;
		}
		catch(Exception e)
		{
		return false;
		}
	}

	public boolean DeleteUserDetails(UserDetails userdetails) {
		try {
		sf.getCurrentSession().delete(userdetails);
		return true;
		}
		catch (Exception e) {
			return false;
		}
	}

	public UserDetails SelectUser(String emailID) {
		
		try {
			return (UserDetails) sf.getCurrentSession().createQuery("from UserDetails where Emailid='" +emailID+ "'").uniqueResult();
		
		}

		catch (Exception e) {
			return null;
						
						
						
			}
		}
		
	}


